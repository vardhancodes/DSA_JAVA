public class decimaltobinary {

    public static void main(String[] args) {

        dectobin(56);
    }
        
        
    static void dectobin(int decimalnum)
    {
            int result = 0;
            int power = 0;

            while(decimalnum>0)
            {
                int rem = decimalnum%2;
                decimalnum /= 2;
                result+=(rem*Math.pow(10,power));
                power++;
            }

            System.out.println(result);
             
            
    
    }
}
