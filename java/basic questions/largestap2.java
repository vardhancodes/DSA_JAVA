import java.util.Scanner;

public class largestap2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int n1 = in.nextInt();
        System.out.print("Enter the second number: ");
        int n2 = in.nextInt();
        System.out.print("Enter the third number: ");
        int n3 = in.nextInt();
        
        int max = n1;

        if(n2>max)
        {
            max = n2;
        }

        if(n3>max)
        {
            max = n3;

        }

        System.out.println(max);

        in.close();

    }

}