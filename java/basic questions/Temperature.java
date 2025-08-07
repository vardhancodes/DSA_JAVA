import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the temperature in celsius ");
        double C = input.nextDouble();
        double F = (C*9/5) + 32;
        System.out.println("The temperature in farenheit is : " + F + "F" );

        input.close();
    }
}
