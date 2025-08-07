public class Powerof2 {
    
    public static void main(String[] args) {
        powerof2(9);
    }
    
    public static void powerof2(int num)
    {
        if((num & num-1) == 0)
        {
            System.out.println("number is power of 2");


        }
        else
        {
            System.err.println("number is not power of 2");
        }
    }
}
