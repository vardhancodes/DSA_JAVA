import java.util.Stack;
public class Validparen{
     
    public static void main(String[] args) {
        
    }

//Valid Parenthesis 

//Question : 
//The "Valid Parentheses" LeetCode problem asks you to determine if a given string containing only '(', ')', '{', '}', '[', and ']' has properly matched and nested brackets.
//A valid string must close every open bracket in the correct order.

//Conditions : 

//1. Since for the parentheses to be in a valid order , the string's length must be even so that there exist a pair of each bracket.
//2. Close parenthesis shouldn't come before Open one.

//Approach : 
//Initialize a Stack to keep track of opening brackets ((, {, [).
//Traverse the string character by character:
//  a. Push opening brackets onto the stack.
//  b. For closing brackets, check if the stack is empty or the top doesn't match—if so, return false.
//Pop the top of the stack if it correctly matches the closing bracket.
//After the loop, return true only if the stack is empty (i.e., all brackets were matched).

public static boolean isValid(String s)
{
    if(s.length()%2 != 0)
    {
        return false;
    } 

    Stack<Character> stack = new Stack<>();

    for(int i = 0 ; i < s.length() ; i++)
    {
        char ch = s.charAt(i);
        if(ch == '{' || ch == '(' || ch == '[')
        {
            stack.push(ch);
        }

        else
        {
            if(stack.isEmpty())
            {
                return false;
            }
            
            char top = stack.peek(); 

            if(ch == '}' && top != '{')
            {
                return false;
            }

            if(ch == ']' && top != '[')
            {
                return false;
            }

            if(ch == ')' && top != '(')
            {
                return false;
            }

            else
            {
                stack.pop();
            }

        }

        

    }
    return stack.isEmpty();



}
    
}