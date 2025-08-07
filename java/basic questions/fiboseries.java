import java.util.Scanner;

public class fiboseries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the nth number : ");
        int n = in.nextInt();
        int a = 0;
        int b = 1;
        int count = 2;
        System.out.print("0 " + "1 ");


        while(count <= n)
        {
            int temp = b;
            b = b + a;
            a = temp;
            count++;
            System.out.print(b+" ");
        }


        in.close();
    }
    
}
