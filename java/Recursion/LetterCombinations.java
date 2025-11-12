import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        String ans = "";
        String digits = "23";
        recur(list, map, 0, ans, digits);
        System.out.println(list);        
    }

/*
Approach:
1. Use recursion with backtracking to generate all possible letter combinations.
2. Each recursive call processes one digit of the input string.
3. Base case: when ind == digits.length(), add the current string 'ans' to the list.
4. For the current digit:
   - Get its corresponding string from the map.
   - For each character in that string:
        a) Append it to 'ans'
        b) Recur for the next digit
        c) Remove last char (backtrack)
5. The recursion explores all combinations by branching for each letter mapped to each digit.
*/

/*
Recursion Tree for digits = "23"

Digit mapping:
2 -> "abc"
3 -> "def"

                         ""  (ind = 0)
                    /         |         \
                  'a'         'b'         'c'
                 / | \       / | \       / | \
              ad  ae  af   bd  be  bf   cd  ce  cf

Explanation:
- Level 0: start with empty string "" (ind = 0)
- Level 1: choose one letter from "abc" (digit '2')
- Level 2: for each of those, choose one letter from "def" (digit '3')
- Base case: when ind == digits.length(), add ans to list

Result:
[ad, ae, af, bd, be, bf, cd, ce, cf]
*/


    public static void recur(List<String> list, HashMap<String,String> map, int ind, String ans, String digits)
    {
        int n = digits.length();

        if(ind == digits.length())
        {
            list.add(ans);
            return;
        }
        String s1 = map.get(String.valueOf(digits.charAt(ind)));
        for(int i = 0 ; i < s1.length() ; i++)
        {
            ans = ans + s1.charAt(i);
            recur(list,map,ind+1,ans,digits);
            ans = ans.substring(0,ans.length()-1);
        }

    }
}