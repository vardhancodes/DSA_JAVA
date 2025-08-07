import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number to be reversed: ");
        int num = in.nextInt();
        int rev = 0 ;

        for(int i = 0; num!=0 ; i++)
        {
            int rem = num%10;
            if(rev> Integer.MAX_VALUE/10 || rev< Integer.MIN_VALUE/10)
            {
                System.out.println(0);
            }
            rev = (rev*10) + rem; 
            num/=10;

        }
        System.out.println("Reversed number is "+rev);
        in.close();
    }
    
}
