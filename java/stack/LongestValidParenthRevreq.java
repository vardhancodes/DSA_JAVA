import java.util.ArrayList;
import java.util.Stack;

public class LongestValidParenthRevreq{
    public static void main(String[] args) {
        String s = "(()";
        int ans =  longestValidParentheses(s);
        System.out.println(ans);
        
    }



/*
Approach -1 for Longest Valid Parentheses Problem:

1. Problem Understanding:
   - We need the length of the longest valid substring made of '(' and ')'.
   - A valid substring must have properly matched parentheses.

2. Idea:
   - Invalid indices (where parentheses don't match) act like "barriers".
   - Between two invalid indices, there can exist valid substrings.
   - If we know the positions of all invalid indices, we can find the longest gap.

3. Step 1: Identify invalid parentheses using a stack
   - Traverse the string:
       • If character is '(', push its index.
       • If character is ')':
            - If stack is empty → mark it invalid (push index).
            - If stack top is ')', push index (invalid).
            - Else pop stack (valid match found).
   - After traversal, stack holds indices of all unmatched parentheses.

4. Step 2: Create boundary markers
   - To easily calculate gaps, build a list:
       • Add -1 (imaginary left boundary).
       • Add all invalid indices from stack (sorted since we pop in order).
       • Add string length (imaginary right boundary).

5. Step 3: Compute maximum valid length
   - Iterate through consecutive indices in the list:
       • For each pair (list[i-1], list[i]), 
         calculate length = list[i] - list[i-1] - 1.
       • Update max length.

6. Step 4: Return the max
   - This value represents the longest valid substring length.
*/


public static int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    removeValid(s , stack);

    if(stack.isEmpty())
    {
        return s.length();
    }
    ArrayList<Integer> list = new ArrayList<>();
    formArraylist(s,stack,list);
    
    int max = 0;
    for(int i = 1 ; i < list.size() ; i++)
    {
        int len = list.get(i) - list.get(i-1) -1;
        max = Math.max(max , len);
    }

    return max;
}

public static void removeValid(String s , Stack<Integer> stack)
{
    for(int i = 0 ; i < s.length() ; i++)
    {
        char ch = s.charAt(i);

        if(ch == '(')
        {
            stack.push(i);
        }
        else
        {
            if(stack.isEmpty() || s.charAt(stack.peek()) == ')')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();
            }
        }
    }
}

public static void formArraylist(String s , Stack<Integer> stack, ArrayList<Integer> list)
{
    list.add(0,s.length());
    while(!stack.isEmpty())
    {
        list.add(0,stack.pop());
    }
    list.add(0,-1);
    }

//Optimises Solution
/*
Approach:

1. Use an integer array as a stack (faster than Java's built-in Stack).
   - Store indices of characters instead of characters themselves.

2. Initialize:
   - Push -1 into the stack as a base index (helps measure valid lengths).

3. Traverse the string:
   - If current char is '(', push its index onto the stack.
   - If current char is ')':
       • Pop from the stack.
       • If stack becomes empty after popping:
            - Push the current index as a new base marker.
       • Else:
            - Compute length = current_index - stack[top].
            - Update max length if needed.

4. Return the maximum length found.

Why this works:
- Stack always holds the last unmatched index.
- Difference between current index and top of stack gives length
  of the latest valid substring.
- Resetting base index ensures we count only valid substrings.

Complexity:
- Time: O(n), single pass over string.
- Space: O(n), stack array usage.
*/

public static int longestValidParentheses2(String s) {

//  Stack<Integer> stack = new Stack<>();
    int stack[] = new int[s.length()+1];
    int index=-1;
    int max = 0;
    stack[++index] = -1;
//  stack.push(-1);
    for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(ch == '(') {
            stack[++index] = i;
        //  stack.push(i); // index
        } else {
            index--;
        //  stack.pop();
            if(index==-1) {
                stack[++index] = i;
            } else {
            max = Math.max(max, i - stack[index]);
            }
        //  if(stack.isEmpty()) {
        //      stack.push(i);
        //  } else {
        //     max = Math.max(max, i - stack.peek());
        //  }
            
        }
    }
    return max;
}
}




       
    
