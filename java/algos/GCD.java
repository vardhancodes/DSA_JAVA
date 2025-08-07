public class GCD {
    public static void main(String[] args) {
        
        int answer = gcd(0,36);
        System.out.println(answer);

    }

    public static int gcd(int num1, int num2){

        int min = num1<=num2?num1:num2;
        while(min > 0)
        {
            if(num1%min ==0 && num2%min==0)
            {
                return min;
                

            }
            min--;

        }

        return 0;


    }

    
}
