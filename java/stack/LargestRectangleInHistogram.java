import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int ans = largestRectangleArea(heights);
        System.out.println(ans);
        
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
}
