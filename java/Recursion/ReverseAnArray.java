public class ReverseAnArray {
    public static void main(String[] args) {
        String str = "PALINDROME";
        char arr[] = str.toCharArray();
        recur(arr,0);
        for(int i = 0 ; i < arr.length ; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    public static void recur(char []s, int index)
    {
        if(index == s.length/2)
        {
            return;
        }
        recur(s,index+1);
        swap(s,index,s.length-1-index);
    }
    public static void swap(char []s , int startind , int endind)
    {
        char temp = s[startind];
        s[startind] = s[endind];
        s[endind] = temp;
    }
}
