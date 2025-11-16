import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
         List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> sublist = new ArrayList<Integer>();
        int []arr = {1,2,3,4,5,6,7,8,9};
        int k = 3;
        int n = 7;
        recur(arr,k,n,list,sublist,0);
        System.out.println(list);
        
    }

    /*
Approach:
---------
- This is a backtracking solution for finding all combinations of size k 
  that sum up to the target.
- Start with an empty sublist and given target.
- If sublist size reaches k:
    - If target == 0 → add sublist to result.
    - Otherwise → return (stop exploring further).
- Otherwise, from the current index onward:
    - If arr[i] <= target:
        - Include arr[i] in the sublist.
        - Recurse with reduced target (target - arr[i]) and move index forward (i+1).
        - Backtrack by removing arr[i].
- Loop continues until all possibilities are explored.

Example Trace (arr = [1,2,3,4], k=2, target=5):
------------------------------------------------

Start: sublist=[], target=5, k=2
        |
       /| |\
      / | | \
     1  2  3  4
     |   |   |
    / \  |   |
   2   3 3   4
   |   | |   |
  ✅[1,4] ✅[2,3] stop stop

✅ Valid Solutions:
[1,4], [2,3]
*/


    public static void recur(int[] arr, int k, int target,List<List<Integer>> list ,List<Integer> sublist , int ind)
    {
        if(sublist.size() >= k)
        {
            if(target == 0)
            {
                list.add(new ArrayList<Integer>(sublist));
            }
            return;
        }

        for(int i = ind ; i < arr.length ; i++)
        {
            if(arr[i] <= target)
            {
                sublist.add(arr[i]);
                recur(arr, k, target-arr[i], list, sublist, i+1);
                sublist.remove(sublist.size()-1);
            }
        }
    }
}
