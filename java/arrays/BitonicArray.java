
//bitonic array must have 3 elements at least.
//example : [2,4,5,9,11,7,2,1]

//      Peak(11)
//        /\
//       /  \
//      /    \
//     /      \
//    /        \
// Border 1(2)    Border 2(1)

public class BitonicArray {

    public static void main(String[] args) {
        int arr[] = {2,4,5,9,11,7,2,1};
        int arr1[] = {1,2,2,2,3,3,3,3,4,5,3,1};
        findminimumelementinbitonicarray(arr);
        ValidMountainarray(arr);
        findpeakinbitonicarraybrute(arr);
        peakelementinmountainarrayoptimized(arr);
        int result = findinmountainarray(3, arr1);
        System.out.println(result);
        
    }

//Find the minimum element in bitonic array.

//logic : The minimum element would be either present at border 1 or border 2.

//approach: Compare the values of both the borders and then return the minimum value.

    static void findminimumelementinbitonicarray(int arr[])
    {
        int border1 = arr[0];
        int border2 = arr[arr.length-1];
        int res = (border1<=border2)?border1:border2;
        System.out.println(res);

    }

//Valid Mountain array(strictly increasing and decreasing)

//logic : 1. the array must have 3 elements.
//        2. array must be increasing to a peak and then decreasing.

//approach: Run the loop to check if the elements are in a increasing fashion.
//          Check if the index position is at 0 or at the end meaning there is no or only increasing order.
//          Run the loop to check if the elements are in a decreasing fashion.
    
    static void ValidMountainarray(int arr[])
    {
        int index = 0;
        int size = arr.length;
        //finding increasing sequence(finding peak).
        while(index<size-1)
        {
            if(arr[index]<arr[index+1])
            {
                index++;
            }
            else
            {
                break;
            }

        }
//now the cases that are possible after this loop are:
// case 1 : index is at 0 meaning no increasing order.
// case 2 : index is at least meaning there is only increasing order.

        if(index==0 ||  index==size-1)
        {
            System.out.println("Not a valid mountain array");
        }
        else
        {
            while(index < size-1 )
            {
                if(arr[index]>arr[index+1])
                {
                    index++;
                }
                else
                {
                    System.out.println("Not a valid mountain array");
                    break;
                }

            }
            System.out.println("Valid mountain array");

        }
    }

//Find peak element.

//Logic : Element present at peak positon i.e. it should be greater than the element present at its previoud index as well as the element present at its next index.

//Approach1(Bruteforce) : By Using three pointers prev, current, next
//comparing the current with both prev and next and stopping when the current is greater than both prev and next.

    static void findpeakinbitonicarraybrute(int arr[])
    {
        if(arr.length < 3)
        {
            System.out.println("Invalid");
        }
        int ans = -1;

        for(int i = 1 ; i < arr.length-1 ; i++)
        {
            if(arr[i]> arr[i-1] && arr[i]> arr[i+1])
            {
                ans = arr[i];
                break;

            }
            
        }
        if(ans == -1)
        {
            System.out.println("peak not found");

        }
        else
        {
            System.out.println(ans);

        }
    }

//Approach2(optimized) : Using binary search find the middle element.
//Check if the middle element is first or last element because peak cannot be on either postion since then the array would only be increasing or decreasing.
//now check if the middle element is both greater than its previous or next element then the middle is peak element.
//else if the middle element is less than its next element then start = mid+1
//else the middle element is greater than its next element then end = mid-1
    
    static void peakelementinmountainarrayoptimized(int arr[])
    {
        int start = 0;
        int end = arr.length-1;
        int size = arr.length;
        int ans = -1;

        while(start <= end)
        {
            int mid = (start + (end-start)/2);
            
            if(mid != size-1 && mid != 0 &&  arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
            {
                ans = arr[mid];
                break;
            }
            else if (mid != size-1 && arr[mid] < arr[mid+1])//increasing array
            {
                start = mid+1;
            }
            else //decreasing array
            {
                end = mid-1;
            }


        }
        if(ans != -1)
        {
        System.out.println(ans);
        }
        else
        {
            System.out.println("Max element not found");
        }
    }   
    
//Finding an element in bitonic array

//Logic: Bitonic array is basically two sorted arrays, one in increasing order the other in decreasing order
//so we can apply binary search by dividing these two arrays.

//Approach : First we will find the peak element.
//apply binary search in the increasing array and then in decreasing array and then find the element.


    static int findinmountainarray(int target, int arr[])
    { 
        int start = 0;
        int size = arr.length;
        int end = size-1;
        int peak = -1;
        int ans = -1;
        
        //For Finding peak element
        while(start <= end)
        {
            int mid = (start+(end-start)/2);
            if(mid != 0 && mid != size-1 && arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1] )
            {
                peak = mid;
                if(peak == target)
                {
                    return target;
                }
                break;

            }
            else if(mid!=size-1 && arr[mid]<arr[mid+1])
            {
                start = mid+1;
            }
            else 
            {
                end = mid-1;
            }

        }

        //For increasing array

        start = 0;
        end = peak;

        while(start<=end)
        {
            int mid = (start+(end-start)/2);
            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] < target)
            {
                start = mid+1;
            }
            else 
            {
                end = mid-1;
            }
        }

        //For decreasing array

        start = peak+1;
        end = size-1;

        while(start <= end)
        {
            int mid = (start+(end-start)/2);
            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] < target)
            {
                end = mid-1;
            }
            else 
            {
                start = mid+1;
            }
        }
        return ans;







        
    }
}
