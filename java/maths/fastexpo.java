public class fastexpo {

    public static void main(String[] args) {
        double answer =fastexpoen(2,7);
        System.out.println(answer);
    }

    static double fastexpoen(int num , int power)
    {
        double result = 1;
        
        while(power>0)
        {
            if(power%2!=0)
            {
                result = result * num;

            }
            power = power/2;
            num = num * num;

        }

        return result;


        
    }
}
