import java.util.*;
public class Leetcode3211{
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        List<String> list1 = new ArrayList<String>();
        recur(list,"",3);
        System.out.println(list);
        recur2(list1, "", 3);
        System.out.println(list1);
    }

//Brute force approach
/*
Approach:
----------
1. Generate all possible binary strings of length n using recursion.
2. For each position, you have 2 choices: '0' or '1'.
3. Recursively build the string until its length == n.
4. Once a string is complete, check if it is valid (no consecutive '0's).
5. If valid, add it to the result list.

⚙️ Type: Brute Force (Generate & Test)
   - Generates 2^n strings
   - Filters invalid ones using isValid()

Time Complexity: O(n * 2^n)
Space Complexity: O(n)  (recursion depth)
*/

/*
Recursion Tree for n = 3
-------------------------

                 ""                 <-- start
                /  \
              "0"  "1"
             / \    / \
         "00" "01" "10" "11"
          |     |    |    |
        "000" "001" "010" "011"
        "100" "101" "110" "111"

Each level adds one character ('0' or '1')
Total leaves = 2^n = 8 (for n=3)

Then 'isValid()' filters out strings with consecutive '0's.
Valid outputs for n=3: ["010", "011", "101", "110", "111"]
*/


    public static boolean isValid(String s)
    {
        for(int i = 0 ; i < s.length()-1 ; i++)
        {
            if(s.charAt(i) == '0' && s.charAt(i+1) == '0')
            {
                return false;
            }
        }
        return true;
    }
    public static void recur(List<String> list, String s, int n  )
    {
        if(s.length() == n)
        {
            if(isValid(s))
            {
                list.add(s);
            }
            return;
        }

        recur(list, s+"0", n);
        recur(list, s+"1", n);

    }





//Optimal Approach 
/*
Approach:
----------
1. This is an OPTIMIZED backtracking approach.
2. Build the binary string only with valid choices:
     - Always allowed to add '1'
     - Add '0' only if the previous char is not '0'
3. This avoids generating invalid strings (no consecutive '0's),
   so we never need to call isValid().

⚙️ Type: Backtracking (Pruned Search)
   - Only explores valid branches
   - Avoids extra computation from invalid paths

Time Complexity: ~O(φ^n) (smaller than 2^n due to pruning)
Space Complexity: O(n) (recursion depth)
*/

/*
Recursion Tree for n = 3
-------------------------

                 ""                  <-- start
                /  \
             +1/    \+0 (not allowed, empty so allowed)
              /      \
            "1"      "0"
           /  \        \
        +1/    \+0     +1 (0->1 allowed)
         /      \        \
       "11"     "10"     "01"
       /  \      |        |
   +1/    \+0   +1       +1
    /      \     |        |
  "111"   "110" "101"    "011"

❌ "00" never appears — those branches are pruned early.

✅ Valid outputs for n=3:
   ["111", "110", "101", "011", "010"]
*/

public static void recur2(List<String> list, String s, int n  )
    {
        if(s.length() == n)
        {
            list.add(s);
            return;
        }

        recur(list, s+"1", n);
        if(s.length() == 0 || s.charAt(s.length()-1) == '1')
        {
            recur(list, s+"0", n);
        }

    }

    
}