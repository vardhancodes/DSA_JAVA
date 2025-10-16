
//For Example in arr[] if we place the pointer at 7 then 4567 is sorted while 7012 is unsorted.
public class BSRotatedsortedArray {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int arr1[] = {2,5,6,0,0,1,2};
        int arr2[] ={2,2,2,2,2};
        searchinrotatedsortedarrray(arr, 0);
        searchinrotatedsortedarrray2(arr1, 0);
        findmininrotatedsortedarray(arr);
        findmininrotatedsortedarray2(arr2);
        findnoofrotations(arr);
    }



//Search In rotated Sorted Array

//Logic : 1. Finding the mid element using binary search.
//2. One side of the mid element will be a sorted array while the other being the unsorted one.
//3. Find element in the sorted array if not found , then in the unsorted array.

//Approach : Finding the mid element using binary search -> find the sorted sub array by 
//comparing element at start and element at mid -> check if the element is present in sorted array or not
//-> move on to the unsorted array and check if the element is present there or not 
//-> return -1 if element not present.


static void searchinrotatedsortedarrray(int arr[] , int target)
{
    int start = 0;
    int end = arr.length - 1;
    int ans = -1;

    while(start <= end)
    {
        int mid = (start+(end-start)/2);
        if(target == arr[mid])
        {
            ans = mid;
            System.out.println(ans);
            break;
        }
        //if left side is sorted
        if(arr[start] <= arr[mid])
        {
            //can ans be found in left side?
            if(target >= arr[start] && target < arr[mid])
            {
                end = mid-1;
            }
            else
            {
                start= mid+1;
            }
        } 
        //if right side is sorted
        else{
            //can ans be found on right side?
            if(target > arr[mid] && target <=arr[end])
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }

    }
    if(ans == -1)
    {
    System.out.println(ans);
    }
}

//Search In rotated Sorted Array-2 (contains duplicates)

//Logic : 1. Finding the mid element using binary search.
//2. One side of the mid element will be a sorted array while the other being the unsorted one.
//3. Since this array contains duplicates, the mid , start and end element maybe same so for that trim the array
//i.e move the start pointer by one and the end pointer as well by one.
//4. Find element in the sorted array if not found , then in the unsorted array.

//Approach : Finding the mid element using binary search -> find the sorted sub array by 
//comparing element at start and element at mid -> if the start , end and mid element are same trim the array down by start++ and end--
//-> check if the element is present in sorted array or not
//-> move on to the unsorted array and check if the element is present there or not 
//-> return -1 if element not present.

static void searchinrotatedsortedarrray2(int[] nums, int target) {
        int start = 0 ; 
        int end = nums.length-1;
        int ans = -1;
        

        while(start <= end)
        {
            int mid = (start + (end-start)/2);
            if(nums[mid] == target)
            {
                ans = mid;
                break;
            }
            //Trim the array if the mid , start and end elements are same
            if(nums[mid] == nums[start] && nums[mid] == nums[end] )
            {
                start = start+1;
                end = end -1;
            }
            else if(nums[start] <= nums[mid])
            {
                if(target >= nums[start] && target < nums[mid])
                {
                    end = mid-1;
                }
                else
                {
                    start = mid+1;
                }
            }
            else
            {
                if(target > nums[mid] && target <= nums[end])
                {
                    start = mid+1;
                }
                else
                {
                    end = mid-1;
                }
            }
        }
        if(ans != -1)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
        
        
    }

//Find Minimum in Rotated Sorted Array (No duplicates)

//Logic : After finding the mid element using binary search , the array would be divided into sorted and unsorted part.
//The smallest element must be either the first element of the sorted part of the array 
//or it may be present in the unsorted half.

//Approach : -> Initialise the value of minimum as Integer.MAX_VALUE
//-> Find the mid element -> Compare the element at start and mid to check if the right side is the sorted array
//-> If it is then find the minimum between the element at start and the pre existing min value. -> Move on to the unsorted array 
//using start = mid+1
//-> If the left side is sorted array then find the minimum between the element at mid and the pre existing min value.
//-> Move on to the unsorted array using end = mid-1

static void findmininrotatedsortedarray(int arr[])
{
    int start = 0 ;
    int size = arr.length;
    int end = size-1;
    int minel = Integer.MAX_VALUE;

    while(start <= end)
    {
        int mid = (start+(end-start)/2);
        //Right side is sorted
        if(arr[start] <= arr[mid] )
        {
            //Storing the first element of the sorted half as a potential answer
            minel = Math.min(arr[start], minel);
            //Moving to the unsorted half
            start = mid+1;
        }
        //Left side is sorted
        else
        {
            //Storing the first element of the sorted half as a potential answer
            minel = Math.min(arr[mid],minel);
            //Moving to the unsorted half
            end = end-1;

        }
    }

    System.out.println(minel);
}

//Find Minimum in Rotated Sorted Array -2 (with duplicates)

//Logic : After finding the mid element using binary search , the array would be divided into sorted and unsorted part.
//The smallest element must be either the first element of the sorted part of the array 
//or it may be present in the unsorted half.
//Since this array contains duplicates, the mid , start and end element maybe same so for that trim the array
//i.e move the start pointer by one and the end pointer as well by one.
//Also an edge case would be there if all the values in an array are same, so for that update min after moving the pointers by one.

//Approach : -> Initialise the value of minimum as Integer.MAX_VALUE
//-> Find the mid element -> Check if the start, end and mid element are same for that update the min value and move the start and en pointer by one.
//->Compare the element at start and mid to check if the right side is the sorted array
//-> If it is then find the minimum between the element at start and the pre existing min value. -> Move on to the unsorted array 
//using start = mid+1
//-> If the left side is sorted array then find the minimum between the element at mid and the pre existing min value.
//-> Move on to the unsorted array using end = mid-1

static void findmininrotatedsortedarray2(int []arr)
{
        int start = 0 ; 
        int size = arr.length;
        int end = size-1;
        int min = Integer.MAX_VALUE;

        while(start <= end)
        {
            int mid = (start + (end-start)/2);
            if(arr[start] == arr[mid] && arr[mid] == arr[end])
            {
                min = Math.min(arr[start],min);
                start++;
                end--;
            }
            else if(arr[start] <= arr[mid])
            {
                min = Math.min(arr[start],min);
                start = mid+1;
            }
            else
            {
                min = Math.min(arr[mid] , min);
                end = mid-1;
            }

        }

        System.out.println(min);
}

//Finding Number of rotations in a rotated sorted array.

//Logic : The index at which the minimum element is present represents the number of rotations

//Approach : Find the minimum element in a rotated sorted array and store it's index.

static void findnoofrotations(int []arr)
{
    int start = 0 ; 
    int end = arr.length-1;
    int min = Integer.MAX_VALUE;
    int minindex=0;

    while(start <= end)
    {
        int mid = (start+(end-start)/2);
        if(arr[start] <= arr[mid])
        {
            if(min > arr[start])
            {
                min = arr[start];
                minindex = start;
            }
            start = mid+1;
        }
        else
        {
            if(min > arr[mid])
            {
                min = arr[mid];
                minindex = mid;
            }            
            end = end-1;
        }

    }
    System.out.println(minindex);
}
    
}



