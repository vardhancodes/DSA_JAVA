
import java.util.Stack;

public class MinAddtomakeParenthValid{

    public static void main(String[] args) {
       int ans = minAdd("(((");
       System.out.println(ans);
       int ans2 = minAdd2("(((");
       System.out.println(ans2);
    }

//Minimum add to make parentheses valid 

//Approach : Same logic as the count reversal question
//           The answer at the last would be the number of unbalanced brackets left in the stack i.e size of stack after balancing.

public static int minAdd(String s)
{
    Stack<Character> stack = new Stack<>();

    for(int i = 0 ; i < s.length() ; i++)
    {
        char ch = s.charAt(i);

        if(ch == '(')
        {
            stack.push(ch);

        }
        else
        {
            if(stack.isEmpty() || stack.peek() == ')')
            {
                stack.push(ch);
            }
            else
            {
                stack.pop();
            }
        }
    }

    return stack.size();

}

//Faster Approach: 

public static int minAdd2(String s)
{
    int open = 0 , close = 0;

    for(int i = 0 ; i < s.length() ; i++)
    {
        char ch = s.charAt(i);

        if(ch == '(')
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

    return open+close;

}
}