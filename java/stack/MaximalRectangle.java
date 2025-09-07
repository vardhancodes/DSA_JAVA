import java.util.Stack;

public class MaximalRectangle {

    public static void main(String[] args) {
        char arr[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int ans = maximalRectangle(arr);
        System.out.println(ans);
    }

//Maximal Rectangle 
/* 
Approach for maximalRectangle():

1. The problem is to find the largest rectangle of '1's in a binary matrix.
2. Think of each row as the base of a histogram:
   - For every cell, maintain a "heights" array where each index stores
     the height of consecutive '1's in that column up to the current row.
   - If matrix[i][j] == '1', increment heights[j].
   - If matrix[i][j] == '0', reset heights[j] to 0.
3. For every updated row (histogram), calculate the largest rectangle area
   using the helper function.
4. Keep track of the maximum area encountered across all rows.
5. Return the maximum rectangle area found.


Approach for helper function (largestRectangleArea2):

1. Problem reduces to "Largest Rectangle in Histogram".
2. Use a monotonic stack to store indices of increasing heights.
3. Traverse the array from left to right (with an extra step using a
   sentinel height = 0 at the end to flush the stack).
4. For each index:
   - While the current height is less than the height at the stack’s top:
       a) Pop the stack (gives height of a rectangle).
       b) Find the width using the current index and the previous smaller element.
       c) Update max area.
   - Push the current index onto the stack.
5. At the end, the maximum area stored is the answer.
*/


    public static int maximalRectangle(char[][] matrix) {
        int heights[] = new int[matrix[0].length];

        if(matrix.length == 0)
        {
            return 0;
        }
        int largest = 0;
        for(int i = 0 ; i < matrix.length ; i ++)
        {
            for(int j = 0 ; j < matrix[i].length ; j++)
            {
                int val = (matrix[i][j]-'0');

                if(val == 0)
                {
                    heights[j] = 0;
                }
                else
                {
                    heights[j]+= val;
                }
            }
            int max = largestRectangleArea2(heights);
            if(max > largest)
            {
                largest = max ;
            }
        }
        return largest;
        
    }

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
