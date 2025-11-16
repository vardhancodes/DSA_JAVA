import java.util.*;
public class Permutations{
    public static void main(String[] args)
    {
        int nums[] = {1,2,3};
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        recur(nums,0,list);
        System.out.println(list);

    }
/*
-------------------------------------------
🔹 Approach: Backtracking for Permutations
-------------------------------------------

1. We use **recursion + swapping** to generate all permutations.
   - At each recursion level, we fix one position (index `ind`).
   - We swap each element from `ind → n-1` into the `ind` position.
   - Then recursively permute the remaining elements.
   - After recursion, we swap back (backtracking) to restore the original state.

2. Base Case:
   - When `ind == n-1`, all positions are fixed.
   - We copy the current array into the result list as one valid permutation.

3. Backtracking:
   - Ensures we "undo" swaps after recursion, so the next iteration starts with a clean state.
   - Without backtracking, the array would be permanently modified and corrupt future results.

-------------------------------------------
🔹 Example Recursion Tree (nums = [1,2,3])
-------------------------------------------

Level 0: ind = 0
    [1,2,3] → fix 1 → recurse
    [2,1,3] → fix 2 → recurse
    [3,2,1] → fix 3 → recurse

Level 1: ind = 1
    [1,2,3] → fix 2 → recurse → [1,2,3]
    [1,3,2] → fix 3 → recurse → [1,3,2]
    [2,1,3] → fix 1 → recurse → [2,1,3]
    [2,3,1] → fix 3 → recurse → [2,3,1]
    [3,2,1] → fix 2 → recurse → [3,2,1]
    [3,1,2] → fix 1 → recurse → [3,1,2]

Level 2: ind = 2 (base case reached)
    Collect permutation into result list.

Result = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,2,1],[3,1,2]]

-------------------------------------------
🔹 Pruning
-------------------------------------------

- Pruning means "cutting off unnecessary recursive paths."
- In permutation problems with **unique elements**, no pruning is needed because every branch is valid.
- In problems with **duplicate elements** (like [1,1,2]):
   - We must prune duplicate swaps to avoid repeated permutations.
   - Typically, we achieve pruning by:
     - Sorting the array first.
     - Skipping a swap if nums[i] == nums[ind] and i != ind.
   - This avoids generating the same permutation multiple times.

-------------------------------------------
✅ Time Complexity: O(n * n!)
   - n! permutations, each taking O(n) to copy into the result.
✅ Space Complexity: O(n) recursion depth + O(n) temporary list.
-------------------------------------------
*/




/*
Recursion Tree for nums = [1,2,3]

Level 0 (ind=0)
                [1,2,3]
             /      |      \
            /       |       \
           /        |        \
      swap(0,0) swap(0,1) swap(0,2)
         |         |          |
         v         v          v

Level 1 (ind=1)
       [1,2,3]   [2,1,3]    [3,2,1]
        /   \     /   \      /    \
       /     \   /     \    /      \
swap(1,1) swap(1,2) swap(1,1) swap(1,2) swap(1,1) swap(1,2)
     |       |     |       |      |        |
     v       v     v       v      v        v

Level 2 (ind=2, base case → collect permutation)
   [1,2,3] [1,3,2] [2,1,3] [2,3,1] [3,2,1] [3,1,2]

Result:
[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,2,1],[3,1,2]]
*/

public static void recur(int[] nums ,int ind , List<List<Integer>> list)
{
    int n = nums.length;
    if(ind == n-1)
    {
        List<Integer> sublist = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; i++)
        {
            sublist.add(nums[i]);

        }
        list.add(new ArrayList<>(sublist));
        return; 
    }

    for(int i = ind ; i < n ; i ++)
    {
        swap(nums,i,ind);
        recur(nums, ind+1, list);
        swap(nums,i,ind);
    }
}
public static void swap(int[] nums , int i , int ind)
{
    int temp = nums[i];
    nums[i] = nums[ind];
    nums[ind] = temp;
}
}