import java.util.Scanner;

public class Jaggedarray {
    public static void main(String[] args) {
        
        int array2d[][] = new int[2][];
        Scanner sc = new Scanner(System.in);

        

        for(int i =0 ; i<array2d.length ; i++)

        {
            System.out.println("Enter the size of " + i + "th column: ");
            int customsize = sc.nextInt(); 
            array2d[i] = new int[customsize];
            for(int j = 0; j<array2d[i].length ; j++)
            {
                System.out.println("Enter the element: ");
                int element = sc.nextInt();
                array2d[i][j] = element;


            }
        }

        for(int i =0 ; i<array2d.length ; i++)
        {
                System.out.println();
                System.out.println("Elements of " + i +" index are: ");
                System.out.println();
            for(int j = 0; j<array2d[i].length ; j++)
            {
                System.out.print(array2d[i][j]+" , ");
                

            }
        }
        sc.close();
    }
    
}
