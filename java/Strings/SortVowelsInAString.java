import java.util.ArrayList;
import java.util.Collections;

public class SortVowelsInAString {
    public static void main(String[] args) {
        String s = "lEetcOde";
        System.out.println(sortVowels(s));
    }

//Sort Vowels In a String

/*
Approach: Sort Vowels in a String

1. Traverse the input string and collect all vowels (both uppercase and lowercase).
2. Store these vowels in a list/array.
3. Sort the list of vowels in ascending order (based on ASCII/lexicographic order).
4. Traverse the string again:
   - If the current character is a vowel, replace it with the next vowel from the sorted list.
   - If it is not a vowel, keep it unchanged.
5. Return the final string with sorted vowels while keeping consonants and other characters in their original positions.
*/

public static String sortVowels(String s) {
    StringBuilder ans = new StringBuilder();
    ArrayList<Character>list = new ArrayList<>();
    for(int i = 0 ; i < s.length() ; i++)
    {
        char ch = s.charAt(i);
        if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U' )
        {
            list.add(ch);
        }
    }
    Collections.sort(list);
    int counter = 0;
    for(int i = 0 ; i < s.length() ; i++)
    {
        char ch = s.charAt(i);
        if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U' )
        {
            ans.append(list.get(counter));
            counter++;
        }
        else
        {
            ans.append(ch);
        }
    }
    return ans.toString();
    }
}

