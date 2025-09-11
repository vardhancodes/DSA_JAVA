import java.util.Stack;
public class Pattern132 {
    public static void main(String[] args) {
        int nums[] = {1,4,5,3,7};
        System.out.println(find(nums));
    }

//Approach : 

// This code determines if an increasing triplet subsequence exists in an array.
// An increasing triplet is a sequence of three numbers `nums[i] < nums[j] < nums[k]` where `i < j < k`.
// The algorithm uses a stack to efficiently find the necessary sequence.

// **Core Logic:**
// 1. **Initialization:**
//    - `secondMax` is initialized to the smallest possible integer value. This variable will store a potential middle element (`j`) of the triplet.
//    - A stack is used to store elements that can potentially act as the third element (`k`) of the triplet.

// 2. **Iteration:**
//    - The loop iterates through the array **from right to left**. This allows us to find a smaller number (`i`) that comes before a larger number (`j`).

// 3. **Finding the Triplet:**
//    - **`if (nums[i] < secondMax)`:** This is the key check. If the current number (`nums[i]`) is smaller than `secondMax`, we have found all three elements of an increasing triplet:
//      - `nums[i]` is the first element (`i`).
//      - `secondMax` is the second element (`j`).
//      - The number that was popped from the stack to become `secondMax` is the third element (`k`).
//      - A triplet has been found, so the function returns `true`.

// 4. **Updating `secondMax` and the Stack:**
//    - **`while (!stack.isEmpty() && stack.peek() < nums[i])`:** This loop is used to find a new `secondMax`.
//    - It pops elements from the stack that are smaller than the current number (`nums[i]`).
//    - The popped element is assigned to `secondMax`. This means we are finding a `j` that is smaller than our potential `k` (`nums[i]`).
//    - After the while loop, `secondMax` holds the largest number that is still smaller than `nums[i]`.

// 5. **Pushing to Stack:**
//    - **`stack.push(nums[i])`:** The current number is pushed onto the stack. This number becomes a candidate for the third element (`k`) of a future triplet.

// 6. **Final Result:**
//    - If the loop finishes without finding a triplet, it means no such subsequence exists, and the function returns `false`.

    public static boolean find(int nums[])
    {
        int n = nums.length;
        Stack<Integer>stack = new Stack<>();
        int secondMax = Integer.MIN_VALUE;
        for(int i = n-1 ; i >= 0 ; i--)
        {
            if(nums[i] < secondMax)
            {
                return true;
            }
            while(!stack.isEmpty() && stack.peek()<nums[i])
            {
                secondMax = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;

    }
}
