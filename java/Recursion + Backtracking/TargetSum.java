public class TargetSum {
    public static void main(String[] args) {
    int []count = new int[1];
    int[] nums = {1,1,1,1,1};
    int target = 3;
    recur(nums,target,count,0);
    System.out.println(count[0]); 
    }

    /*
Approach:
----------
1. This is a BACKTRACKING approach to count the number of subsets
   whose sum equals the given 'target'.
2. For each element nums[ind], we have 2 choices:
      a) Include it → reduce target by nums[ind]
      b) Exclude it → keep target unchanged
3. When we reach the end (ind == n):
      - If target == 0 → one valid subset found (count++)
4. Backtracking ensures all inclusion/exclusion combinations are explored.

⚙️ Type: Brute Force (Subset Sum Count)
   - Explores all 2^n possible subsets.
   - No memoization, so overlapping subproblems are recalculated.

Time Complexity: O(2^n)
Space Complexity: O(n)   (recursion depth)
*/

/*
Recursion Tree Example
-----------------------
nums = [1, 2, 3], target = 3

                       (target=3, ind=0)
                       /              \
                 include(1)         exclude(1)
                /                     \
        (target=2, ind=1)        (target=3, ind=1)
           /       \                /       \
 include(2)  exclude(2)      include(2)  exclude(2)
   |            |               |            |
(target=0)   (target=2)     (target=1)   (target=3)
   ✅             ✖              ✖             ✖

Each path explores one subset.
✅ Paths ending with target==0 represent valid subsets.
*/


public static void recur(int[] nums , int target , int[]count , int ind)
    {
        int n = nums.length;
        if(ind == n)
        {
            if(target == 0)
            {
                count[0]++;
            }
            return;
        }

        target-=nums[ind];
        recur(nums, target, count, ind+1);
        target+=nums[ind];
        target+=nums[ind];
        recur(nums, target, count, ind+1);

    }
    
}
