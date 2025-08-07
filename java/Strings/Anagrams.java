
import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        boolean ans = anagrams("abcda" , "dcaba");
        System.out.println(ans);
        boolean ans2 = anagrams2("geekssdsdsd", "dsskesdsge");
        System.out.println(ans2);
        

    }

//Anagrams are two strings which have the same set of characters but these characters may be arranged in different orders.
//Eg: A = "ABCD" and B = "DBAC" are two anagrams.


//Check two strings are anagrams or not (Brute force).
//Approach : We can convert the strings to char array and then sort them 
//After sorting we can check each letter of the string matches each other or not.

public static boolean anagrams(String s1 , String s2)
{
    if(s1.length() != s2.length())
    {
        return false;
    }
    char arr1[] = s1.toCharArray();
    char arr2[] = s2.toCharArray();
    
    Arrays.sort(arr1);
    Arrays.sort(arr2);



    for(int i = 0 ; i < arr1.length ; i ++)
    {
        if(arr1[i] != arr2[i])
        {
            return false;
        }
    }
    return true;

}

//Check two strings are anagrams or not (better approach)
//ASCII value of A = 65 and a = 97  

//Approach : 1. If the length of both the strings are not same it means they are not anagrams.
//           2. We will make a frequency array which will contain the frequency of the characters.
//           3. Initialise two indexes indexA and indexB for string s1 and s2 respectively.
//           4. The position of the characters on the array will be determined by subtracting the their ascii vaue to 97 (ascii value of a).
//           5. For eg: b-97 = 1 so 'b' will be placed at the 1st index.
//           6. Increment the value of the index for the corresponding character when iterating over string a.
//           7. Decrement the value of the index for the corresponding character when iterating over string b.
//           8. If the resultant value of all the indexes are 0 then the strings are anagrams. 


public static boolean anagrams2(String s1 , String s2)
{
   if(s1.length() != s2.length())
        {
            return false;
        }
        
        int []freq = new int[26];
        
        for(int i = 0 ; i < s1.length() ; i++)
        {
            freq[s1.charAt(i)-97] += 1;
            
            freq[s2.charAt(i)-97] -= 1;
        }
        
        for(int i = 0 ; i < freq.length ; i++)
        {
            if(freq[i] != 0)
            {
                return false;
                
            }
        }
        
        return true;

   
}

}

