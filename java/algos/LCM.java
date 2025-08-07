public class LCM {

    public static void main(String[] args) {
        lcm(5,4);
    }

    public static int ealgo(int num1, int num2)
    {
        while(num1!=0 && num2 !=0)
        {
            if(num1 > num2)
            {
                num1 %= num2;
            }
            else 
            {
                num2 %= num1;
            }

        }
        int res = num1;
        if(num1 == 0)
        {
            res = num2;
        }
        return res;
    }

    public static void lcm(int num1, int num2)
    {
        int answer = (num1*num2)/ealgo(num1,num2);
        System.out.println(answer);

    }


    
}
