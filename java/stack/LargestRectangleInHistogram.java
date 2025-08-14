import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int ans = largestRectangleArea(heights);
        System.out.println(ans);
        int ans2 = largestRectangleArea2(heights);
        System.out.println(ans2);
        
    }

//Largest Rectangle In Histogram
//Approach -1 : 
// 1. We need to find the largest rectangular area in a histogram given the heights array.
//
// 2. For each bar, we determine:
//    - The index of the "Next Smaller Element" to the right (nsmall[]).
//    - The index of the "Previous Smaller Element" to the left (psmall[]).
//    These help define how far this bar can extend without hitting a shorter bar.
//
// 3. To find the Next Smaller Element:
//    - Traverse the array from right to left.
//    - Use a stack to store indices of bars in increasing order of height.
//    - Pop indices from the stack while the top's height is >= current height.
//    - If the stack is empty after popping, it means no smaller element exists to the right,
//      so set nsmall[i] = n (array length).
//    - Otherwise, set nsmall[i] = stack's top index.
//    - Push the current index into the stack.
//
// 4. Clear the stack before finding the Previous Smaller Element.
//
// 5. To find the Previous Smaller Element:
//    - Traverse the array from left to right.
//    - Use a stack to store indices of bars in increasing order of height.
//    - Pop indices from the stack while the top's height is >= current height.
//    - If the stack is empty after popping, it means no smaller element exists to the left,
//      so set psmall[i] = -1.
//    - Otherwise, set psmall[i] = stack's top index.
//    - Push the current index into the stack.
//
// 6. Calculate the maximum rectangular area:
//    - For each index i, width = nsmall[i] - psmall[i] - 1.
//    - Area = heights[i] * width.
//    - Keep track of the maximum area found.
//
// 7. Return the maximum area after processing all bars.

public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsmall = new int[n];
        int[] psmall = new int[n];
        Stack<Integer> stack = new Stack<>();

        //For next smaller:
        for(int i = n-1 ; i >= 0 ; i --)
        {
            while(!stack.isEmpty() && heights[stack.peek()]>= heights[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                nsmall[i] = n;
            }
            else
            {
                nsmall[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        //For previous smaller:
        for(int i = 0 ; i < n ; i ++)
        {
            while(!stack.isEmpty() && heights[stack.peek()]>= heights[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                psmall[i] = -1;
            }
            else
            {
                psmall[i] = stack.peek();
            }
            stack.push(i);
        }

        //For max:
        int max = Integer.MIN_VALUE;
        int area = 0;
        for(int i = 0 ; i < n ; i ++)
        {
            area = heights[i] * (nsmall[i] - psmall[i] - 1);
            if(area > max)
            {
                max = area;
            }
        }

        return max;
    }


//Approach -2 : 
// This code calculates the largest rectangle area in a histogram using a monotonic stack approach.

// Step 1: Create a stack to store indices of histogram bars.
//         The stack will store indices in increasing order of their heights.
//         This helps efficiently find the width of the largest rectangle for each bar.

// Step 2: Store the number of bars `n` and initialize `max` to track the largest area found so far.

// Step 3: Loop from i = 0 to i = n (inclusive):
//         - We go to `i = n` to process all remaining bars in the stack by using a height of 0 at the end.
//           This acts as a sentinel to flush out all rectangles still in the stack.

// Step 4: For the current position `i`:
//         - If `i == n`, we set element = 0 (sentinel bar).
//         - Otherwise, element = heights[i].

// Step 5: While the stack is not empty AND the current element is smaller than
//         the bar at the index on top of the stack:
//         - This means the bar at the stack’s top is ending here, so we calculate its area.
//         - Pop the top index from the stack to get the height `h`.
//         - Find the previous smaller index (ps):
//               - If the stack is empty after popping, ps = -1 (means no smaller element on the left).
//               - Otherwise, ps = stack.peek().
//         - Calculate the width `w` as (i - ps - 1).
//         - Update max area: max = Math.max(max, h * w).

// Step 6: Push the current index `i` into the stack for future area calculations.

// Step 7: After the loop, `max` contains the largest rectangle area found.
//         If no area was computed (max == Integer.MIN_VALUE), return 0, else return max.

public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i <=n ; i ++)
        {
            int element = (i == n)?0:heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>element)
            {
                int h = heights[stack.pop()];
                int ps = (stack.isEmpty())?-1:stack.peek();
                int w = i - ps -1;
                max = Math.max(max,h*w);
            }
            stack.push(i);
        }

        return (max==Integer.MIN_VALUE)?0:max;
    }
}
