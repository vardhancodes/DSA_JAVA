import java.util.*;

public class PalindromePartioning {
    public static void main(String[] args) {
        String s = "abcba";
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> sublist = new ArrayList<String>();
        recur(s, 0, sublist, list);
        System.out.println(list);
    }

    /*
Approach (Palindrome Partitioning using Backtracking):

1. Goal: Partition the string into substrings where each substring is a palindrome.

2. Use recursion + backtracking:
   - Start from index 0.
   - At each step, try all substrings from current index `ind` to `i`.
   - If substring s[ind..i] is a palindrome:
       • Add it to current path (sublist).
       • Recurse from index i+1.
       • Backtrack: remove last substring after returning from recursion.

3. Base case:
   - When ind == n (end of string), we have a complete valid partition.
   - Add a copy of the current path to the result.

4. Palindrome check:
   - Compare characters from both ends of the substring (two-pointer check).

5. Result:
   - Collect all partitions in a list of lists.
   - Example: For "aab" → [["a","a","b"], ["aa","b"]]

----------------------------------------------------
Dry Run Example for s = "aab":

Start: sublist = []

i=0 → substring "a" (palindrome)
    sublist = ["a"]
    recurse from ind=1

    i=1 → substring "a" (palindrome)
        sublist = ["a","a"]
        recurse from ind=2

        i=2 → substring "b" (palindrome)
            sublist = ["a","a","b"]
            ind=3 → base case → add ["a","a","b"]

        backtrack → sublist = ["a"]

    i=2 → substring "ab" (not palindrome) → skip
    backtrack → sublist = []

i=1 → substring "aa" (palindrome)
    sublist = ["aa"]
    recurse from ind=2

    i=2 → substring "b" (palindrome)
        sublist = ["aa","b"]
        ind=3 → base case → add ["aa","b"]

    backtrack → sublist = ["aa"]

i=2 → substring "aab" (not palindrome) → skip

----------------------------------------------------
Final Result:
[["a","a","b"], ["aa","b"]]
*/




/*
Recursion Tree for s = "aab"

Start: ind=0, sublist = []

                "" (start)
                 |
        -------------------------
       /            |             \
   "a" (0..0)   "aa" (0..1)   "aab" (0..2)
      |             |             |
   ind=1         ind=2         not palindrome
      |             |
   ----------        |
  /        \         |
"a"       "ab"      "b"
(1..1)    (1..2)    (2..2)
  |        (not)      |
ind=2                ind=3 → ["aa","b"]
  |
  ------
 /      \
"b"    end
(2..2)
  |
ind=3 → ["a","a","b"]

-------------------------------------------------
Valid partitions collected:
1. ["a","a","b"]
2. ["aa","b"]
*/



    public static void recur(String s , int ind , List<String> sublist, List<List<String>> list)
    {
        int n = s.length();
        if(ind == n)
        {
            list.add(new ArrayList<>(sublist));
            return;
        }
        for(int i = ind ; i < n ; i++)
        {
            if(isPalindrome(s,ind,i))
            {
                sublist.add(s.substring(ind,i+1));
                recur(s, i+1, sublist, list);
                sublist.remove(sublist.size()-1);
            }

        }

    }
    
    public static boolean isPalindrome(String s,int ind,int i)
    {
        while(ind < i)
        {
            if(s.charAt(ind) != s.charAt(i))
            {
                return false;
            }
            ind++;
            i--;
        }
        return true;
    }
}
