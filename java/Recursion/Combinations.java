import java.util.*;
public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> sublist = new ArrayList<Integer>();
        recur(list,sublist,2,0,4);
        System.out.println(list);

        
    }

    /*
Approach:
----------
1. This is a standard BACKTRACKING approach to generate all combinations (n choose k).
2. 'sublist' holds the current combination being built.
3. We start from index 'ind', and for each number i:
      - Add i to 'sublist'
      - Recursively continue building from i (to avoid duplicates)
      - Remove last element to backtrack and try next number
4. When sublist.size() == k, we add a copy to the result list.
5. Ensures combinations are in increasing order and no repetition occurs.

⚙️ Type: Backtracking (Generate Combinations)
   - Each recursive path represents a growing combination.
   - Backtracking ensures we explore all possibilities without repetition.

Time Complexity: O(C(n, k) * k)
Space Complexity: O(k)   (recursion depth)
*/

/*
Recursion Tree Example for n = 4, k = 2
---------------------------------------

Start: sublist = []

                []                         <-- start
              /   |   |   \
            +1    +2  +3   +4
           /       |    \
        [1]       [2]   [3]
       / | \       |     |
   +2/ +3/ +4/   +3|   +4|
    /   /   /     |     |
 [1,2][1,3][1,4] [2,3] [3,4]

✅ Valid combinations (k=2):
   [1,2], [1,3], [1,4], [2,3], [2,4], [3,4]

Each path from root → leaf of size k forms one combination.
Backtracking removes the last element and tries the next one.
*/


    public static void recur(List<List<Integer>> list , List<Integer> sublist , int k ,int ind,int n)
    {
        if(sublist.size() == k)
        {
            list.add(new ArrayList<Integer>(sublist));
        }

        for(int i = ind+1 ; i <= n ; i++)
        {
            sublist.add(i);
            recur(list, sublist, k, i, n);
            sublist.remove(sublist.size()-1);

        }
    }
}
