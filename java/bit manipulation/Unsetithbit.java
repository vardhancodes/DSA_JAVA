public class Unsetithbit {
    
    public static void main(String[] args) {
        printbits(33);
        int res = unsetithbit(33, 0);
        System.out.println();
        printbits(res);




    }
    public static void printbits(int num)
    {
        for(int i = 7 ; i>=0 ; i--)
        {
            System.out.print((num>>i)&1);
        }
    }
    public static int unsetithbit(int num, int bit)
    {
        return num & ~(1<<bit);

    }
}
