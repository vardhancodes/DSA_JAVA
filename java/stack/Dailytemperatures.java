import java.util.Stack;

public class Dailytemperatures {
    public static void main(String[] args) {
        int[]arr = {73,74,75,71,69,72,76,73};
        int ans[] = dailyTemperatures(arr);
        for(int i = 0 ; i < ans.length ; i++)
        {
            System.out.print(ans[i] + " ");
        }
    }

//Daily Temperatures

/*
Approach: Monotonic Stack

/*
Approach:

1. We want to know how many days later a warmer temperature comes for each day.

2. Use a stack to keep indices of days (monotonic decreasing stack).

3. Traverse from right to left:
   - Pop from stack while top has temperature <= current temperature.
   - If stack is empty → no warmer day → answer = 0.
   - Else → next warmer day index is stack.peek() → answer = (stack.peek() - i).
   - Push current index onto the stack.

4. Return the answer array.
*/


public static int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int n = temperatures.length;
    int ans[] = new int[n];
    for(int i = n-1 ; i >= 0 ; i--)
    {
        while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
        {
            stack.pop();
        }
        if(stack.isEmpty())
        {
            ans[i] = 0;
        }
        else
        {
            ans[i] = stack.peek()-i;
        }
        stack.push(i);
    }
    return ans;
}
}

