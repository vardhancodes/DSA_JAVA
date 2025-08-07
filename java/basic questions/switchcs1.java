import java.util.Scanner;

public class switchcs1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of a fruit: ");
        String fruit = in.next();

        switch (fruit) {
            case "Mango":
                System.out.println("King of fruits");
                break;
            case "Apple":
                System.out.println("A red fruit");
                break;
            case "Grape":
                System.out.println("Green colored fruit");
        
            default:
                System.out.println("Invalid Fruit");
                break;
        }
        in.close();

    }
}
