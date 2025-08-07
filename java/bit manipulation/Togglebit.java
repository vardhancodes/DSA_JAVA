public class Togglebit {
    public static void main(String[] args) {
        printbits(33);
       int result = togglebit(33,4);
       System.out.println();
       printbits(result);
        
    }
    
   

    public static void printbits(int num)
    {
        for(int i = 7 ; i>=0 ; i--)
        {
            System.out.print((num>>i)&1);
        }
    }

    public static int togglebit(int num, int bit)
    {
        return num^(1<<bit);
    }


}


