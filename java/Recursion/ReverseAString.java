public class ReverseAString {
    public static void main(String[] args) {
        String S = "543210";
        int index = 0;
        String res = "";
        System.out.println(rev(S,index,res));
       
    }

    //Simple Concatenation
    
    public static String rev(String S , int index , String res)
    {
        if(index == S.length())
        {
            return res;
        }
        res = S.charAt(index) + res;
        return rev(S, index+1, res);
    }


}
