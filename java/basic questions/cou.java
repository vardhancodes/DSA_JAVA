import java.util.Scanner;

public class cou {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = in.nextLong();
        System.out.print("Enter the desired number: ");
        int desnum = in.nextInt();
        int count = 0;
        for(int i = 0 ; num!=0 ; i++)
        {
            long rem = num%10;
            if(rem == desnum)
            {
                count+= 1;

            }
            num/=10;

        }
        System.out.println("The desired number occurs " + count + " times");
        in.close();

    }
    
}
