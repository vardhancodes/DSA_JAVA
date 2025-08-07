public class armstrong {
    public static void main(String[] args) {
        
        boolean answer = isarm(1632);
        System.out.println(answer);
    }

    static boolean isarm(int num)

    {
        int result = 0;
        int temp = num;        
        int count = (int)Math.log10(num) + 1;
        while(num>0)
        {
            int rem = num%10;
            result = result +(int)Math.pow(rem,count);
            num = num/10;

        }
        if(result == temp)
        {
            return true;
        }
        else 
        {
            return false;

        }


    }
}
