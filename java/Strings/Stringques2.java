public class Stringques2 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        String ans = reverseword(s);
        System.out.println(ans);
        String ans2 = reverseword2(s);
        System.out.println(ans2);
        String ans3 = reverseword3(s);
        System.out.println(ans3);
        
    }
   
    

//Reverse Words in a String 
//Approach : 1. split words with space as the delimiter and store them in an array.
//           2. Iterate through the array and check if the words of the array has no length then skip the iteration.
//           3. Add space in between the words except the last word.

public static String reverseword(String s)
{
    
    String arr[] = s.split(" ");
    String res = "";
    for(int i = 0; i < arr.length; i++)
    {
        if(arr[i].length() == 0)
        {
            continue;
        }
        if(i == arr.length-1)
        {res = arr[i]+res;
        }
        else
        {res = " "+arr[i]+res;
        }

    }
    return res;
}



//Reverse Words in a String (Using String Builder)

public static String reverseword2(String s)
{
    String arr[] = s.split(" ");
    StringBuilder result = new StringBuilder("");
    for(int i = arr.length-1 ; i >= 0 ; i-- )
    {
        if(arr[i].length() == 0)
        {
            continue;
        }
        if(result.length() == 0)
        {
            result.append(result);
            result.append(arr[i]);
            
        }
        else
        {
            result.append(" ");
            result.append(arr[i]);
        }


    }
    return result.toString();

}

//Reverse words in a String (another approach)
//We are basically implementing the functionality of the split function.
//Let's take an example of "_ _ _ _ _ Hello _ _ _ _ World _ _ _ _"
//Split function basicially splits the words on the basis of the delimiter given, which for this case would be " ".
//So the array now contains lots of useless empty words as well. Therefore we are going to implement the function of the split function in reverse order. 


//Approach : 1. While loop iterating till the start index which is at the last of the string isn't 0;
//           2. We place the start index on the end and iterate it to the first character we can find skipping all the spaces.
//                                                SI
//                                                 |
//           Therefore _ _ _ _ _ Hello _ _ _ _ World _ _ _ _ (SI) is now pointing at d.
           
//           3. Now we assign the value of start index to end index and iterate SI to the next blank space found.

//                                           SI    EI
//                                           |     |
//           Therefore _ _ _ _ _ Hello _ _ _ _ World _ _ _ _ (SI) is now pointing at the place just before W and EI is pointing at d.

//           4. Now we can extract the word "World" using the substring function s.substring(start index+1 , end index+1)
//           5. Also add if(SI < 0) break for making sure the index doesn't get out of bounds after iterating to skip the spaces.

public static String reverseword3(String s)
{
    StringBuilder res = new StringBuilder("");
    int startindex = s.length()-1;
    while (startindex>=0)
    {
        //adding the condition of startindex>=0 is important in the while loop to prevent index out bounds.
        while (startindex>=0 && s.charAt(startindex) == ' ')
        {
            startindex--;
        }
        if(startindex < 0) 
        {
            break;
        }
        int endindex = startindex;
        while(startindex>=0 && s.charAt(startindex) != ' ')
        {
            startindex--;
        }
        if(res.length() == 0)
        {
            res.append(s.substring(startindex+1, endindex+1));
        }
        else
        {
            res.append(" ");
            res.append(s.substring(startindex+1, endindex+1));
        }
    }
    return res.toString();



}




}

