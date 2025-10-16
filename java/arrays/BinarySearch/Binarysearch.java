


public class Binarysearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,4,4,5,33,67,78};
        int arr1[] = {87,67,73,23,10,9,8,7,1};
        binarysearch(arr, 33);
        binarysearch4decord(arr1,7);
        binaryorderagnostic(arr1,34);
        
    }

    //binary search for ascending order
    public static void binarysearch(int arr[],int target)
    {
        
        int ans = -1;
        int start = 0;
        int end = arr.length-1;
        while(start<=end)
        {
            int mid = start + ((end - start)/2);
            if(arr[mid] == target)
            {
                ans = mid;
                break;

            }
            else if(target > arr[mid]){

                start = mid+1;


            }
            else
            {
                end = mid-1;
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
    
    //binary search for descending order array
    public static void binarysearch4decord(int arr[], int target)
    {
        int ans = -1;
        int start = 0;
        int end = arr.length-1;
        while(start<=end)
        {
            int mid = start+((end-start)/2);
            if(arr[mid] == target)
            {
                ans = mid;
                break;

            }
            else if(target > arr[mid])
            {
                end = mid-1;

            }
            else 
            {
                start = mid+1;

            }
           
        }
        if(ans == -1)
        {
            System.out.println("Element not found");
        }
        else
        {
            System.out.println("Element "+target+" found at "+ans);
        }

    }

    //order agnostic binary search in which the order of the sorted array is not given 
    public static void binaryorderagnostic(int arr[],int target)
    {
        if(arr[0]>arr[arr.length-1])
        {
            binarysearch4decord(arr , target);
        }
        else
        {
            binarysearch(arr, target);
        }
    }
}