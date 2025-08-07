public class Reversword3 {
    public static void main(String[] args) {
        

    }

//Reverse words in a string 3 

//Question : Reverse each word in a sentence without changing the order of words.

//Example Input: "hello world"
//Expected Output: "olleh dlrow"

//Approach : 1. We will follow a similar approach to Reverse words in a string 1 but without implementing the split function.
//           2. Instead we will convert the string to char array 
//           3. Initialise two pointers startIndex=0 and endIndex=0.
//           4. Initiate a for loop and since endIndex is going to iterate through the string use it as the loop variable
//              i.e (for endIndex = 0 ; endIndex <= arr.length ; endIndex++) {<= is necessary because The last word may not end with a space.}

//           5. Whenever the end or space is found: Reverse the word from startIndex to endIndex - 1 using a helper function.
//           6. Return the updated array as a new string.

public static String reversewords(String s)
{
    char arr[] = s.toCharArray();
    int startIndex = 0;
    
    for(int endIndex = 0 ; endIndex <= arr.length ; endIndex++)
    {
        if(endIndex == arr.length || endIndex == ' ')
        {
            reverse(arr , startIndex , endIndex-1);
            startIndex = endIndex + 1;

        }


    }

 
    return new String(arr);

}

//helper function
//Because arrays are passed by reference in Java, not by value.
//So even if you use a "void" function, any changes made to the array inside the function will directly change the original array in memory.

public static void reverse(char arr[] , int startIndex , int endIndex)
{
    while(startIndex < endIndex)
    {
        char temp = arr[startIndex];
        arr[startIndex] = arr[endIndex];
        arr[endIndex] = temp;
        startIndex++;
        endIndex--;
    }
}



//Reverse words in a string 3 (Using String Builder)






}
