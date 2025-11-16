
import java.util.ArrayList;

public class SubsequencesWithSumEqualK {
   public static void main(String[] args) {
    int[] input = {3,7,8,9,9,10};
    int target = 18;
    ArrayList<Integer> list = new ArrayList<>();
    recur(input, 0, target,0, list);
   } 

   /*
Approach:

This is a recursive solution to find all subsequences of an array whose sum equals a given target.

1. Base Case:
   - If the current index 'ind' reaches the end of the array (ind == n):
       - Check if the current sum equals the target.
           - If yes, print the current subsequence (stored in 'list').
       - Return to stop further recursion along this path.

2. Recursive Steps:
   - Include the current element:
       - Add input[ind] to the current list.
       - Add input[ind] to the sum.
       - Recursively call the function with the next index (ind+1).
   - Backtrack after including the element:
       - Remove the last added element from the list.
       - Subtract input[ind] from the sum.
   - Exclude the current element:
       - Recursively call the function with the next index (ind+1) without including input[ind].

3. Backtracking:
   - The use of `list.remove(list.size()-1)` ensures that after exploring one path with an element included, 
     the element is removed before exploring the path where it is excluded. This avoids using extra space for copies.

4. Time Complexity:
   - O(2^n) in the worst case because for each element we have two choices: include or exclude.

5. Space Complexity:
   - O(n) for the recursion stack and temporary list storage.

Summary:
- This function generates all possible subsequences of the array.
- It checks the sum of each subsequence.
- If a subsequence sum equals the target, it is printed.
*/


/*
Recursion Tree (input = [1,2,3], target = 3):

Start with ind=0, sum=0, list=[]

                                  [] (sum=0, ind=0)
                                 /                 \
                  [1] (sum=1, ind=1)                 [] (sum=0, ind=1)
                 /              \                   /               \
       [1,2] (3,2)          [1] (1,2)          [2] (2,2)           [] (0,2)
       /        \            /      \           /      \            /      \
[1,2,3](6,3) [1,2](3,3) [1,3](4,3) [1](1,3) [2,3](5,3) [2](2,3) [3](3,3) [] (0,3)

Check sum == target (3):
- [1,2] ✅
- [3] ✅

Legend:
- `/` : include current element
- `\` : exclude current element
- Node format: [current list] (sum, current index)
*/



   public static void recur(int[] input , int ind , int target, int sum , ArrayList<Integer> list)
   {
        int n = input.length;
        if(ind == n)
        {
            if(sum == target)
            {
                System.out.print(list+" ");
            }
            return;
        }

            list.add(input[ind]);
            sum+= input[ind];
            recur(input, ind+1, target, sum, list);

            sum-= input[ind];
            list.remove(list.size()-1);
            recur(input, ind+1, target, sum, list);

      

   }
}
