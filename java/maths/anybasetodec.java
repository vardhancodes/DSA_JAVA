public class anybasetodec {

    public static void main(String[] args) {
        anybasetodecimal(67676, 8);

        
    }

    static void anybasetodecimal(int n1 , int base)
    {
        int result = 0;
        int power = 0;

        while(n1>0)
        {
            int unit = n1%10;
            result+= unit*Math.pow(base, power);
            power++;
            n1/=10;
        }

        System.out.println(result);

    }
    
}
