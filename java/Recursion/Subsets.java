import java.util.*;
public class Subsets{
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> sublist = new ArrayList<Integer>();
        int []nums = {1,2,3};
        recur(nums, 0, list, sublist);
        System.out.println(list);

        
    }


/*
Approach:
-----------
1. Goal: Generate all subsets (the power set) of the given array.

2. Use recursion with backtracking:
   - At each index, we have two choices:
       a) Include the current element in the subset.
       b) Exclude the current element from the subset.

3. Base Case:
   - When index == nums.length, we have formed one complete subset.
   - Add a copy of the current subset to the result list.

4. Recursive Steps:
   - Add nums[ind] to the subset, recurse to the next index.
   - Backtrack: remove the last element, then recurse again without including nums[ind].

5. This ensures all possible 2^n subsets are generated.

----------------------------------------------------
Recursion Tree Example for nums = [1, 2]
----------------------------------------------------

Start: ind = 0, sublist = []

                []
              /    \
             /      \
         [1]          []
        /   \        /   \
    [1,2]   [1]    [2]   []

Explanation of branches:
- Left branch = "include nums[ind]"
- Right branch = "exclude nums[ind]"
- Leaves represent the final subsets.

Final Output: [ [1,2], [1], [2], [] ]
*/


    public static void recur(int[] nums , int ind , List<List<Integer>> list , List<Integer> sublist)
    {
        int n = nums.length;
        if(ind == n)
        {
            list.add(new ArrayList<Integer>(sublist));
            return;
        }
        sublist.add(nums[ind]);
        recur(nums, ind+1, list, sublist);
        sublist.remove(sublist.size()-1);
        recur(nums, ind+1, list, sublist);

    }
}