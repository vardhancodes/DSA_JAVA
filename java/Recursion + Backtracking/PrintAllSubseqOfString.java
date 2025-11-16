public class PrintAllSubseqOfString {
    public static void main(String[] args) {
        String s = "ab";
        recur(s, 0, "");
    }

/*
Approach:
-----------
1. We are asked to generate all subsequences of a string.
   - A subsequence is formed by choosing to either include or exclude each character.

2. Use recursion (backtracking idea):
   - At each index, we have two choices:
       a) Include the current character in the output string.
       b) Exclude the current character and move to the next.

3. Base Case:
   - When the index reaches the length of the string (end of string),
     we print (or store) the current output string as one subsequence.

4. Recursive Steps:
   - Call the function by including the current character.
   - Call the function by excluding the current character.

5. This way, for a string of length n, we generate 2^n subsequences,
   since each character has 2 choices (include or exclude).
*/
/* Recursive Tree for "ab":
------------------------
Start: s = "ab", ind = 0, out = ""

                ""
              /    \
             /      \
         "a"          ""
        /   \        /   \
     "ab"   "a"    "b"   ""
*/

    public static void recur(String s , int ind , String out)
    {
        int n = s.length();
        if(ind == n)
        {
            System.out.print(out+" ");
            return;

        }
        recur(s, ind+1, out+s.charAt(ind));
        recur(s, ind+1, out);
    }
}
