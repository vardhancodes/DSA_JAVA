public class Binarysearchques {
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,4,4,5,33,67,78};
        binaryfirstandlastoccurence(arr, 4, false);
        int first = countoccurence(arr, 9, true);
        int last = countoccurence(arr, 9, false);
        if(first == -1)
        {
            System.out.println("Element not found");     
        }
        else
        {
            System.out.println("Target is present "+ (last-first+1)+ " times in the array");
         }
        int result = binarysearchfloor(arr, 5);
        System.out.println(result);
        int result1 = binarysearchceiling(arr , 31);
        System.out.println(result1);

        
    }
    
    
    //binary search for first and last occurence 
    public static void binaryfirstandlastoccurence(int arr[] , int target , boolean isfirst)
    {
        int ans = -1;
        int start = 0;
        int end = arr.length-1;

        while(start <= end)
        {
            int mid = (start + (end-start)/2);
            if(target == arr[mid])
            {
                ans = mid;
                if(isfirst)
                {
                    end = mid-1;
                }
                else{

                    start = mid+1;
                }


            }
            else if(target < arr[mid])
            {
                end = mid-1;
            }
            else {

                start = mid+1;
            }
        }
        if(ans == -1)
        {
            System.out.println("Element not found");
        }
        else
        {
            System.out.println("Found element "+target+" at index "+ans);
        }

    }


    //counting occurences
    static int countoccurence(int arr[] , int target , boolean isfirst)
    {
        int ans = -1;
        int start = 0;
        int end = arr.length-1;

        while(start <= end)
        {
            int mid = (start + (end-start)/2);
            if(target == arr[mid])
            {
                ans = mid;
                if(isfirst)
                {
                    end = mid-1;
                }
                else{

                    start = mid+1;
                }


            }
            else if(target < arr[mid])
            {
                end = mid-1;
            }
            else {

                start = mid+1;
            }
        }
        if(ans == -1)
        {
            return -1;
        }
        else
        {
            return ans;
        }

    }
    //binary search for floor value 
    static int binarysearchfloor(int arr[], int target)
    {
        int ans = -1;
        int start = 0; 
        int end = arr.length-1;
        while(start <= end )
        {
            int mid = (start + (end-start)/2);
            if(target == arr[mid])
            {
                ans = arr[mid];
                break;
            }
            else if(target < arr[mid] )
            {
                end = mid-1;
            }
            else 
            {
                start = mid+1;
                ans = arr[mid];
            }
        }
        if(ans == -1)
        {
            return -1;
        }
        else
        {
            return ans;
        }
    }
    //binary search for ceiling value 
    public static int binarysearchceiling(int arr[],int target)
    {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if( target == arr[mid])
            {
                ans = arr[mid];
                break;
            }
            else if (target < arr[mid])
            {
                end = mid-1;
                ans = arr[mid];
            
            }
            else 
            {
                start = mid+1;
            }  
        }
        if(ans == -1)
        {
            return -1;
        }
        else
        {
            return ans;
        }
    }
}
