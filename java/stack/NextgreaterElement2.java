import java.util.Stack;

public class NextgreaterElement2 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] ans = nextgreat(nums);
        for(int i = 0 ; i < ans.length ; i++)
        {
            System.out.print(ans[i]+" ");
        }

        
    }

//Next greater Element - 2

// A circular array means after the last element, the sequence continues from the first element again.
// We use a stack to store elements in a way that makes it efficient to find the next greater element.

//Approach:

// Step 1: Create a stack to keep track of elements we’ve seen in reverse order.
//         The stack will always maintain elements in decreasing order from top to bottom.
//         This helps us find the next greater element in O(1) time when we check the top.

// Step 2: Store the array length in `n` for easy reference.

// Step 3: Prepare a `result` array of size `n` to store the answers for each position.
//         result[i] will contain the next greater element for arr[i], or -1 if none exists.

// Step 4: We loop from `i = 2 * n - 1` down to `0` instead of just `n - 1`.
//         Why? Because in a circular array, elements after the last position can still be "next greater" 
//         for elements at the start. Iterating twice (2 * n times) ensures that each element gets 
//         the chance to compare with all elements after it, even across the end of the array.

// Step 5: In each iteration, we use `i % n` to wrap around the array index when we pass the end.
//         This means when `i` is beyond `n - 1`, we’re still accessing valid positions from the start of the array.

// Step 6: While the stack is not empty and the top of the stack is less than or equal to the current element
//         (arr[i % n]), pop from the stack. We do this because a smaller or equal element cannot be 
//         the "next greater" for the current one — it should be removed so only greater elements remain.

// Step 7: If `i < n` (meaning we are in the actual first pass over original array indices):
//         - If the stack is empty, there is no next greater element, so result[i] = -1.
//         - Otherwise, the top of the stack is the next greater element for arr[i].

// Step 8: Push the current element arr[i % n] onto the stack so it can be used as a "future" next greater element
//         for elements we process before it in the backward loop.

// Step 9: After the loop ends, return the result array.



public static int[] nextgreat(int[] arr)
{
    Stack<Integer> stack = new Stack<>();
    int n = arr.length;
    int[] result = new int[n];
    for(int i = 2*n-1 ; i>=0 ; i--)
    {
        while(!stack.isEmpty() && stack.peek()<=arr[i%n])
        {
            stack.pop();
        }
        if(i<n)
        {
            if(stack.isEmpty())
            {
                result[i] = -1;
            }
            else
            {
                result[i] = stack.peek();
            }
        }
        stack.push(arr[i%n]);
    }

    return result;

}

}
