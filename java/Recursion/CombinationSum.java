import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> sublist = new ArrayList<Integer>();
        int arr[] = {2,3};
        recur(arr, 7, 0, list, sublist);
        System.out.println(list);

    }



/*
Approach:

We are trying to find all combinations of numbers from the array that sum up to a given target.
This is solved using recursion + backtracking.

1. Base Case:
   - If 'ind == n' (we’ve reached the end of the array):
       - If target == 0, then the current subsequence (sublist) is a valid combination.
         Add a copy of it to the result list.
       - Return to stop further recursion.

2. Recursive Steps:
   - Choice 1: Include current element arr[ind] (only if arr[ind] <= target).
       - Add arr[ind] to sublist.
       - Call recursion again with reduced target (target - arr[ind]).
       - Note: We pass the same index `ind` because we are allowed to reuse the same element.
       - After recursion returns, remove the element (backtracking).
   - Choice 2: Exclude current element.
       - Call recursion with the next index (ind + 1), target unchanged.

3. Backtracking:
   - Ensure we remove the last included element after the recursive call 
     so the sublist remains correct for other paths.

4. Time Complexity:
   - Exponential in nature (O(2^n) worst case), but pruned by the `arr[ind] <= target` condition.

Summary:
- The recursion explores two possibilities at each step: include or exclude the element.
- Valid combinations are collected when the target becomes 0.
*/


// ------------------------------------------------------------
// Example Recursion Tree for arr = [2,3,6,7], target = 7
// ------------------------------------------------------------

/*
Start: [] target=7 ind=0

                                     [] (7,0)
                                   /          \
                      include 2 /              \ exclude 2
                               /                  \
                        [2] (5,0)                 [] (7,1)
                       /        \                /       \
          include 2 /            \ exclude 2   /          \ exclude 3
                   /              \            /            \
             [2,2](3,0)           [2](5,1)  [3](4,1)        [] (7,2)
             /     \              /     \    /     \          /     \
 [2,2,2](1,0) [2,2](3,1) [2,3](2,1) [2](5,2) [3,3](1,1) [3](4,2) [6](1,2) [] (7,3)
       /  \          ...           ...         ...        ...       ...
[2,2,2,2](-1,0) [2,2,2](1,1)

Valid combinations (target == 0):
- [2,2,3]
- [7]
*/



public static void recur(int []arr , int target , int ind , List<List<Integer>> list , List<Integer> sublist)
{
    int n = arr.length;
    if(ind == n)
    {
        if(target == 0)
        {
            list.add(new ArrayList<Integer>(sublist));
        }
        return;
    }

    if(arr[ind] <= target)
    {
        sublist.add(arr[ind]);
        recur(arr, target-arr[ind], ind, list, sublist);
        sublist.remove(sublist.size()-1);
    }
    
    recur(arr, target, ind+1, list, sublist);
}
}
