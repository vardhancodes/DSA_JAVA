public class ReverseAnInteger {
    public static void main(String[] args) {
        int x = 123444;
        System.out.println(rec(x,0));
    }


//Reverse an Integer

public static int rec(int num , int res)
    {
        if(num == 0)
        {
            return res;
        }
        if(res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10)
        {
            return 0;
        }
        res = res*10 + num%10;
        return rec(num/10 , res);
    }
}
