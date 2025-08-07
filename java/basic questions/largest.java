import java.util.Scanner;

public class largest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int n1 = in.nextInt();
        System.out.print("Enter the second number: ");
        int n2 = in.nextInt();
        System.out.print("Enter the third number: ");
        int n3 = in.nextInt();

        if (n1>n2)
        {
            if(n1>n3)
            {
                System.out.println("Largest number is " + n1);
            }
        }
        
        else if (n2>n1)
        {
            if (n2>n3) 
            {
                System.out.println("Largest number is " + n2);

            }
        }
        else
        {
            System.out.println("Largest number is " + n3);
        }

        in.close();


    }
    
}
