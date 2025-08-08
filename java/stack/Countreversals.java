
import java.util.Stack;

public class Countreversals {
    public static void main(String[] args) {
        int ans = countreversals("}{{}}{{{");
        int ans2 = countreversals2("}{{}}{{{");
        System.out.println(ans);
        System.out.println(ans2);
    }
    

//Count the number of reversals

//Logic : Pairs are always going to be even, so the length of the string will always be even 
//        Now inside an even length string , there will exist two types:
//        Valid strings and Invalid strings (Valid have all the brackets balanced)
//        Invalid strings will have two components as well : Open bracket and Close bracket. 
//        Now no. of Open and Close brackets will either be (even and even) or (odd and odd).
//        Because even + even = even and odd + odd = even (which satisfies our most fundamental logic)

//Approach : 1. If string length is odd → return -1
//           2. Use a stack to remove balanced pairs.
//              a. Traverse the string character by character.
//              b. Push '{'' to stack.
//              c. For '}' ': If top of stack is {, pop it → it's a balanced pair.
//              d. Else, push } to stack (unbalanced).

//            3. Count number of unbalanced { and }
//            4. Pop all characters from the stack: If it's '{', increment open | If it's '}', increment close.
//            5. ans = ceil(open / 2.0) + ceil(close / 2.0) Use this formula to calculate the reversals.


 public static int countreversals(String s)
 {
    if(s.length()%2 != 0)
    {
        return -1;
    }

    Stack<Character> stack = new Stack<>();

    for(int i = 0 ; i < s.length() ; i++)
    {
        char ch = s.charAt(i);

        if(ch == '{')
        {
            stack.push(ch);
        }

        else
        {
            if(stack.isEmpty() || stack.peek() == '}')
            {
                stack.push(ch);
            }

            else
            {
                stack.pop();
            }
        }
    }

    int ans = 0 , close = 0 , open = 0;
    while(!stack.isEmpty())
    {
        char top = stack.pop();
        if(top == '{')
        {
            open++;
        }
        else
        {
            close++;
        }
    }

    ans = (int)(Math.ceil(close/2.0) + Math.ceil(open/2.0));
    return ans;
 }


//Faster approach: 

//Approach : Use two counters: open → counts unmatched { brackets.
//                             close → counts unmatched } brackets that don’t have a { to pair with.
//           If open is 0 or less, increment close (no { available to match).
//           Otherwise, decrement open (we matched it).
//           open = number of unmatched {
//           close = number of unmatched }
//           answer = ceil(open / 2) + ceil(close / 2) 



 public static int countreversals2(String s)
 {
    if(s.length()%2 != 0)
    {
        return -1;
    }
    int ans = 0 , close = 0 , open = 0;

    for(int i = 0 ; i < s.length() ; i++)
    {
        char ch = s.charAt(i);

        if(ch == '{')
        {
            open++;
        }

        else
        {
            if(open <= 0)
            {
                close++;
            }

            else
            {
                open--;
            }
        }
    }

    ans = (int)(Math.ceil(close/2.0) + Math.ceil(open/2.0));
    return ans;
 }


}
