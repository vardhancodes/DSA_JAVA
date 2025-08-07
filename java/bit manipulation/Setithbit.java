public class Setithbit {

    public static void main(String[] args) {
        printbits(32);
        System.out.println();
        int result =setithbit(32,4);
        printbits(result);
    }

    public static int setithbit(int num,int bit)
    {
        return num|(1<<bit);
        
        

    }

    public static void printbits(int num)
    {
        for(int i = 7 ; i>=0 ; i--)
        {
            System.out.print((num>>i)&1);
        }
    }
    
}
