import java.util.Scanner;
public class alphacheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an alphabet: ");
        char alpha = in.next().trim().charAt(0);

        if(alpha >= 'a' && alpha <= 'z')
        {
            System.out.println("Lowercase");

        }
        else
        {
            System.out.println("Uppercase");
        }

        in.close();
    }

    
    
}
