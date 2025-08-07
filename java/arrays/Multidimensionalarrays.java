
import java.util.Scanner;

public class Multidimensionalarrays {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[][] = new int[2][2];

        for(int i =0; i<arr.length ; i++)
        {
            for(int j =0; j<arr[i].length ; j++)
            {
                int element = sc.nextInt();
                arr[i][j] = element;
                
            }

        }

        for(int i =0; i<arr.length ; i++)
        {
            System.out.println();
            System.out.println("elements at " + i + " index are: ");
            System.out.println();

            for(int j =0; j<arr[i].length ; j++)
    
            {
                
                System.out.print(arr[i][j]+ " ");
            }
        }
        System.out.println();

        sc.close();

        insert2d(arr, 1, 1, 36);
        deletearr(arr, 1, 0);

    
    }   

    public static void insert2d(int arr[][], int pos1 , int pos2 , int element)
        {

            
            
                for(int j = arr[pos1].length-2 ; j>=pos2 ; j--)
                {
                    arr[pos1][j+1] = arr[pos1][j];
                }
            
            arr[pos1][pos2] = element;

            for(int i =0; i<arr.length ; i++)
            {
                System.out.println();
                System.out.println("elements at " + i + " index are: ");
                System.out.println();
            
                for(int j =0; j<arr[i].length ; j++)
            
                {  
                System.out.print(arr[i][j]+ " ");
                }
                System.out.println();
            }

            
        }
    public static void deletearr(int arr[][] , int pos1 , int pos2)
    {
        
            for(int j = pos2 ; j<arr[pos1].length-1; j++)
            {
                arr[pos1][j] = arr[pos1][j+1];
            }
            arr[pos1][arr[pos1].length-1] = 0;
            for(int i =0; i<arr.length ; i++)
            {
                System.out.println();
                System.out.println("elements at " + i + " index are: ");
                System.out.println();
            
                for(int j =0; j<arr[i].length ; j++)
            
                {  
                System.out.print(arr[i][j]+ " ");
                }
                System.out.println();
            }


        
    }
}
