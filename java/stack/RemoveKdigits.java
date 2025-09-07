import java.util.Stack;

public class RemoveKdigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        String ans = removeKdigits(num, k);
        System.out.println(ans);
    }

//Remove K digits 

/*
Approach:

1. The goal is to remove k digits such that the resulting number is the smallest possible.

2. Use a stack to maintain digits in increasing order:
   - Traverse through each digit of the number string.
   - While the stack is not empty, k > 0, and the current digit is smaller than the stack’s top:
       → Pop the stack (removing the larger digit).
       → Decrement k.
   - Push the current digit into the stack.

3. After traversal, if k > 0, remove the remaining k digits from the top of the stack
   (since they are the largest digits left).

4. Construct the number from the stack by popping all digits and building a string in correct order.

5. Remove any leading zeros from the result string.

6. If the result is empty after removing zeros, return "0".
   Otherwise, return the result string.


Logic Behind:

- To make the smallest number, larger digits should be removed when a smaller digit comes after them.
- The stack ensures that digits are kept in increasing order as much as possible.
- Removing from the top when a smaller digit appears guarantees the number remains minimal.
- Leading zeros are removed at the end to ensure a valid smallest number representation.
- If all digits are removed, the answer must default to "0".
*/


public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < num.length() ; i++)
        {
            char ch = num.charAt(i);
            while(!stack.isEmpty() && k>0 && ch<stack.peek())
            {
                stack.pop();
                k--;   
            }
            stack.push(ch);
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty())
        {
            if(k>0)
            {
                stack.pop();
                k--;
            }
            else
            {
                str.insert(0,stack.pop());
            }
        }
        while(str.length()!=0 && str.charAt(0) == '0')
        {
            str.deleteCharAt(0);
        }
        return (str.length()==0)?"0":str.toString();
    }
}
