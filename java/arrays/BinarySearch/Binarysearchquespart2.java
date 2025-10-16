
public class Binarysearchquespart2 {
    public static void main(String[] args) {
        int arr[] = {1,3,4,5,6,8,9,22,67,78,99,100,230,567,4344};
        findMinimumAbsolutedifference(arr, 17);
        int []range = findrangeinInfinitesortedarray(arr, 6);
        System.out.println(range[0] +" "+ range[1]);
        binarysearchinrange(arr, 6, range);
        

    }

    // Find the minimum absolute difference of the target with the elements of the array.
    
    // Logic : The minimum difference would have three cases:
    // 1. if the target is present in the array
    // 2. target minus ceiling value or target minus floor value if either of them is absent.
    // 3. minimum of both (target - ceiling value or target -  floor value) 
    
    //Approach : applying binary search -> finding ceiling and floor values -> comparing the difference -> answer
    // when start crosses end , start -> ceil and end -> floor
    // edge case for start = size of array or edge case for end = -1 meaning if these conditions are true then either ceil or floor are not present.
        

    static void findMinimumAbsolutedifference(int arr[], int target)
    {
        if(arr.length == 0)
        {
            return;
        }
        int ans = -1;
        int start = 0;
        int end = arr.length-1; 

        while(start <= end)
        {
            int mid = (start + (end-start)/2);
            if(arr[mid] == target)
            {
                ans = target;
                break;
            }
            else if (target > arr[mid])
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;

            }

        }
        //target not found in the array
        int res = 0;
        if(ans == -1)
        {
            if(end == -1)
            {
                res = Math.abs(target - arr[start]);

            }
            else if (start == arr.length)
            {
                res = Math.abs(target - arr[end]);
            }
            else 
            {
               int ans1 = Math.abs(target - arr[start]);
               int ans2 = Math.abs(target - arr[end]);

               res = (ans1<ans2)?ans1:ans2;
            }
            
        }
        System.out.println("Minmimum Absolute difference is : "+res);
    }


    //Finding range in infinite sorted array.
    
    //Logic: the end of the range would always be equal to or less than the target.
    
    //Approach : we can place the start pointer at the 0th index and the end pointer at the 1st index ,
    //then move end by end*2 and start to the previous position of end.
    //i.e. end = end*2 and start = end.

    static int[] findrangeinInfinitesortedarray(int arr[] , int target)
    {
        int []range = new int[2];
        int start = arr[0];
        int end = arr[1];

        while(arr[end] < target)
        {
            start = end;
            end = end*2;

        }
        range[0] = start;
        range[1] = end;

        return range;

        
    }


    //Binary search in a range.
    static void binarysearchinrange(int arr[] , int target , int range[])
    {
        int start = range[0];
        int end = range[1];
        int ans = -1;
        while(start <= end)
        {
            int mid = (start+(end-start)/2);
            if(target == arr[mid])
            {
                ans = mid;
                break;
            }
            else if (target>mid)
            {
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
            System.out.println("Element found at "+ ans + " index");
        }
    }
    
}
