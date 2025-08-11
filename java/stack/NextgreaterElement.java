import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextgreaterElement {
    public static void main(String[] args) {

        int arr[] = {1, 3, 2, 4};
        ArrayList<Integer> list1 = nextLargerElement(arr);
        System.out.println(list1);
    }


//Next greater element

//Logic :  Start checking from the last element of the array and move towards the first.
// Use a stack to keep track of elements that might be the next larger ones for earlier elements.
// For the current element, remove all elements from the stack that are smaller or equal to it,
// because they cannot be the next larger element.
// If the stack becomes empty, it means there is no larger element on the right.
// If the stack has elements, the top of the stack is the next larger element for the current number.
// Add the current element to the stack so it can be considered for elements on the left.
// After processing all elements, reverse the result list because we started from the right side.


// Approach:
// 1. Create an empty stack to store potential next larger elements.
// 2. Create a list to store the result for each element.
// 3. Traverse the array from right to left (reverse order).
// 4. For each element:
//    a. Pop elements from the stack while the stack is not empty 
//       and the top of the stack is less than or equal to the current element.
//    b. If the stack becomes empty, it means there is no greater element to the right,
//       so add -1 to the result list.
//    c. Otherwise, the top of the stack is the next greater element, so add it to the result list.
//    d. Push the current element onto the stack for future comparisons.
// 5. Reverse the result list because we traversed the array from right to left.
// 6. Return the final list containing the next larger element for each position.


public static ArrayList<Integer> nextLargerElement(int[] arr)
{
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> list = new ArrayList<>();

    for(int i = arr.length-1 ; i>= 0 ; i--)
    {
        while(!stack.isEmpty() && stack.peek()<=arr[i])
        {
            stack.pop();

        }
        if(stack.isEmpty())
        {
            list.add(-1);
        }
        else
        {
            list.add(stack.peek());
        }
        stack.push(arr[i]);

    }
    Collections.reverse(list);

    return list;
}
}
