

public class Arrays{
    public static void main(String[] args) {
        int ar1[] = new int[5];
        ar1[0] = 1;
        ar1[1] = 2;
        ar1[2] = 3;
        for(int i = 0 ; i<ar1.length ; i++)
        {
            System.out.print(ar1[i] + " ");
            
        }
        System.out.println();

       insertatbeg(ar1, 1, 3);
       delete(ar1, 2);
        



    }

    public static void insertatbeg(int arr[], int pos, int element)
    {
        int size = arr.length;
        if(pos<0 || pos>size-1)
        {
            System.out.println("Wrong position");
            return;
        }
        for(int i = size-2 ; i>=pos ; i--)
        {
            arr[i+1] = arr[i];

        }
        arr[pos] = element;

        for(int i = 0; i<arr.length ; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();


    }

    public static void delete(int arr[], int pos)
    {
        for(int i = pos ; i<=arr.length-2 ; i++)
        {
            arr[i] = arr[i+1];

        }
        arr[(arr.length-2)] = 0;
        
        for(int i = 0; i<arr.length ; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}