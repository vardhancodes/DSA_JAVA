import java.util.Stack;

public class Minswapstringvalid {

    public static void main(String[] args) {
        int ans = minSwaps("]]][[[");
        System.out.println(ans);
        int ans2 = minSwaps2("]]][[[");
        System.out.println(ans2);
    }
    
//Minimum Number of Swaps to Make the String Balanced

//Approach : Same as Count reversals problem.
//           Each pair of unmatched brackets (like ][) requires 1 swap to fix. 
//           So the minimum swaps needed = ceil(open / 2)

public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);
            if(ch == '[')
            {
                stack.push(ch);
            }
            else
            {
                if(stack.isEmpty() || stack.peek() == ']')
                {
                    stack.push(ch);
                }
                else
                {
                    stack.pop();
                }
            }
        }
        int ans = stack.size()/2;
        

        return (ans+1)/2;
    }



//Faster Approach : 

public static int minSwaps2(String s) {
        int open = 0 , close = 0;

        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);
            if(ch == '[')
            {
                open++;
            }
            else
            {
                if(open<=0)
                {
                    close++;
                }
                else
                {
                    open--;
                }
            }
        }

        return (close+1)/2;

    
    }
}

