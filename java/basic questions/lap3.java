import java.util.Scanner;

public class lap3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int n1 = in.nextInt();
        System.out.print("Enter the second number: ");
        int n2 = in.nextInt();
        System.out.print("Enter the third number: ");
        int n3 = in.nextInt();

        int max = (Math.max(n3,Math.max(n1, n2)));

        System.out.println(max);

        in.close();
    }
    
}
