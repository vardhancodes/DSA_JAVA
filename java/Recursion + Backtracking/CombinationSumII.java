import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSumII {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> sublist = new ArrayList<Integer>();
        int arr[] = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(arr);
        recur(arr,target,0,list,sublist);
        System.out.println(list);
    }

    /*
Approach:
---------
- This is a backtracking solution (like Combination Sum II).
- Start with an empty sublist and the target value.
- From the current index, try each element one by one:
    - Skip duplicates (to avoid repeating the same combination).
    - If arr[i] <= target:
        - Include arr[i] in the sublist.
        - Recurse with target reduced by arr[i] and index moved forward (i+1).
        - Backtrack by removing arr[i] after recursion.
- If target becomes 0, add the current sublist as a valid combination.
- If target < 0 or no elements left, stop recursion.

Example Trace (arr = [1,2,3], target = 3):
-------------------------------------------

Start: target=3, sublist=[]
        |
       /|\
      / | \ 
     /  |  \
    1   2   3
    |   |    \
   / \   \     ✅ [3]
  2   3   3
  |   |   |
 ✅[1,2] -1  -2 (stops)

✅ Solutions: [1,2], [3]
*/


    public static void recur (int[] arr , int target , int ind , List<List<Integer>> list , List<Integer> sublist)
    {
        int n = arr.length;

        if(target == 0)
        {
            list.add(new ArrayList<Integer>(sublist));
            return;

        }

            for(int i = ind ; i < n ; i ++)
            {
                if((i == ind || arr[i] != arr[i-1])&& arr[i] <= target)
                {
                    sublist.add(arr[i]);
                    recur(arr, target-arr[i], i+1, list, sublist);
                    sublist.remove(sublist.size()-1);
                }
            }
    }
}
