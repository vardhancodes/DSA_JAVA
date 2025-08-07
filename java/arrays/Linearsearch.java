public class Linearsearch {
    public static void main(String[] args) {
        
        int arr[] = {2,3,4,2,6,7,2,3,4};
        int arr1[][] = {{2,4,1,5,1},
                        {6,7,3,4,2},
                        {8,1,2,2,3},
                        {5,5,5,8,4}
                    };
        linearsearch(arr, 7 , false);
        linearsearch(arr, 7 , true);
        linearsearchmultiple(arr,2);
        max(arr);
        min(arr);
        linearsearch2d(arr1 , 4 , false);
        linearsearch2d(arr1 , 4 , true);
        linearsearchmultiple2d(arr1 , 4);
        maximumsubarray(arr1);

    }

    public static void linearsearch(int arr[], int target , boolean findlast)
    {
        int ans = -1;
        for(int i =0 ; i<arr.length ; i++)
        {
            if(arr[i] == target)
            {
                ans = i;
                if(findlast == false)
                {
                    break;
                }
            }

        }
        if(ans == -1)
        {
            System.out.println("Element not present");

        }
        else{
            System.out.println("element found at " + ans + " index");


        }

    }
    public static void linearsearchmultiple(int arr[], int target)
    {
        int ans[] = new int[arr.length];
        int k = 0;
        ans[0] = -1;
        for(int i =0 ; i<arr.length ; i++)
        {
            if(arr[i] == target)
            {
                ans[k] = i;
                k++;
                
            }

        }
        if(ans[0] == -1)
        {
            System.out.println("Element not present");

        }
        else{
            System.out.println("element found at the following indexes: ");
            System.out.println();
            for(int i =0 ; i<k ; i++)
            {
                System.out.print(ans[i]);
            }
            System.out.println();

        }
        
    }
    public static void max(int arr[])
        {
            int max = arr[0];
            for(int i =0 ; i<arr.length ; i++)
            {
                if(max < arr[i])
                {
                    max = arr[i];
                }
                
            }
            System.out.println("Maximum element is: "+ max);
        }
    public static void min(int arr[])
    {
        int min = arr[0];
        for(int i=0 ; i<arr.length ; i++)
        {
            if(min > arr[i])
            {
                min = arr[i];
            }
        }
        System.out.println("Minimum element is: "+min);  
    }
    public static void linearsearch2d(int arr[][] , int target , boolean findlast)
    {
        int outerindex = -1;
        int innerindex = -1;

        for(int i =0 ; i<arr.length ; i++)
        {
            boolean found = false;
            for(int j = 0 ; j<arr[i].length ; j++)
            {
                if(arr[i][j] == target)
                {
                    outerindex = i;
                    innerindex = j;
                    if(findlast == false){
                    found = true;
                     break;
                 }
                         
                }
            }
            if(found == true)
            {
                break;
            }
        }
        if(outerindex == -1 && innerindex == -1)
        {
            System.out.println("Element not found");

        }
        else{
            System.out.println("element found at " + outerindex +" , " + innerindex);
        }

        

    }
    public static void linearsearchmultiple2d(int arr[][] , int target )
    {
        int size = 0;
        for(int i = 0 ; i<arr.length ; i++)
        {
            size = size+arr[i].length;

        }
        int ans[][] = new int[size][2];
        int k =0 ;
        
        

        for(int i =0 ; i<arr.length ; i++)
        {
            for(int j = 0 ; j<arr[i].length ; j++)
            {
                if(arr[i][j] == target)
                {
                    ans[k][0] = i;
                    ans[k][1] = j;
                    k++;
                    
                 }
                         
                }
            }
        
        if(k == 0)
        {
            System.out.println("Element not found");

        }
        else{
            for(int i =0 ;i<k ; i ++)
            {
                System.out.println("element found at " +ans[i][0]  +" , " + ans[i][1]);

            }
            
        }
    }

    public static void maximumsubarray(int arr[][])
    {
        int result = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i<arr.length ; i++)
        {
            int sum = 0;

            for(int j = 0 ; j<arr[i].length ; j++)
            {
                sum = sum + arr[i][j];


            }
            if(sum > max)
            {
                max = sum;
                result = i;

            }


        }
        System.out.println("Maximum sum of sub array is: " + max  + " of the "+ result+ " array" );

    }
}
