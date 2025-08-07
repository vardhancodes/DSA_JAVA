public class Stringques {


    public static void main(String[] args) {
        printallsubstrings("abc");
        reversestring("Hello");
        reversestring2("Hello");
        reversestring3("Hello");
        boolean ans = isPalindrome("hello");
        System.out.println(ans);

    }

//1. Print all substrings. 

//Logic : 
//Every string has [n(n+1)/2 + 1] substrings including the empty string.    
//Two pointers will be there -> starting index and ending index 
//Starting index moves from 0 to last index 
//Ending index moves from (startindex + 1) to (lastindex + 1)  
    

    public static void printallsubstrings(String str)
    {
        for(int startIndex = 0 ; startIndex < str.length() ; startIndex++)
        {
            for(int endIndex = startIndex+1 ; endIndex <= str.length() ; endIndex++)
            {
                System.out.print(" "+str.substring(startIndex,endIndex)+" ");
                

            }



        }
        System.out.println();
    }


//2. Reversing a string (1st method)

//Logic:
//Iterate through the string and keep adding the characters to the existing extracted character.


    public static void reversestring(String str)
    {
       
       
        String ans = "";
        for(int i = 0 ; i < str.length() ; i++)
        {
            ans = str.charAt(i)+ans;
        }
        System.out.println(ans);
    

    }




    
//2nd Method (Using String Builder)

//Logic: 
//Convert the given string to stringbuilder and then iterate to half string and swap the ith character with n-1-ith character.

    public static void reversestring2(String str)
    {
        
        StringBuilder str1 = new StringBuilder(str);
        int n = str1.length();
        for(int i = 0 ; i< n/2 ; i++)
        {
            char firstchar = str1.charAt(i);
            char lastchar = str1.charAt(n-1-i);
            //setCharAt method used for setting the character at a particual index
            str1.setCharAt(i, lastchar);
            str1.setCharAt(n-1-i, firstchar);
            
        }
        System.out.println(str1);

    }


//3rd method

//Logic:
//Same as 2nd method but with the use of character array

    public static void reversestring3(String str)
    {
        
        char[] arr = str.toCharArray();
        int n = arr.length;
        for(int i = 0 ; i< n/2 ; i++)
        {
            char firstchar = arr[i];
            char lastchar = arr[n-1-i];
            arr[i] = lastchar;
            arr[n-1-i] = firstchar;
            
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+"");
        }
        System.out.println();

    }

//3. Palindrome 
//Logic: 
//Take two pointers - start and end.
//Start points to the first character , end points to the last character.
//Check if first and last characters matches, if it doesn't return false.
    
    public static boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        String s3 = s1.trim();
        String s2 = s3.replaceAll("[^a-zA-Z0-9]", "");
        int start = 0 ; 
        int end = s2.length()-1;

        while(start<end)
        {
            if(s2.charAt(start) != s2.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
        
    }


}


