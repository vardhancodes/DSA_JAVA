

public class Cyclesort {
public static void main(String[] args) {
    int[] nums = {2,3,1,5,4,0};
    cyclesort1ToN(nums);
    cyclesort0ToN(nums);
    printarray(nums);
    




}
static void printarray(int[] arr)
{
    for(int i = 0 ; i < arr.length ; i++)
    {
        System.out.print(" "+arr[i]+" ");
    }
}

public static void swap(int arr[] , int a , int b)
{
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;

}


// Cycle Sort:

// 1. If element of the array starts from 0 then -> element = index
// 2. If element of the array starts from 1 then -> element = index+1

// Approach:
// eg: 
// [2,3,4,1,5]
// 2 is present at 0 and 3 is present at so we swap 2 at 1.
// actual postion = arr[index]-1
// if arr[index] != arr[actualpos] --> then swap 

// edge cases:
// if arr[index] > n then ignore (for elements if they are not present in a serial order like 2,3,1,5 where 4 is missing) 

 public static void cyclesort1ToN(int[] nums)
 {
    int n = nums.length;
    int index =0;
    
    while(index<n)
    {
       
        int actualpos = nums[index]-1;

        if(nums[index] < n && nums[index] != nums[actualpos])
        {
            swap(nums, index, actualpos);
        }
        else
        {
            index++;

        }
    }
    
 }
 
 public static void cyclesort0ToN(int[] nums)
 {
    int n = nums.length;
    int index =0;
    
    while(index<n)
    {
       
        int actualpos = nums[index];

        if(nums[index] < n && nums[index] != nums[actualpos])
        {
            swap(nums, index, actualpos);
        }
        else
        {
            index++;

        }
    }
    
 } 

//Main Cycle Sort : 
// [1,8,3,9,10,10,2,4]
// 1. Check from 1st element , since there are no elements greater than 1 to its right , it's in the correct place.
// 2. Check 8 , there are 3 elements (3,2,4) smaller than 8 to its right so they will use index 1 , 2 , 3 hence 8 will be on index4 swapping 10.
// 3. Check 10(where 8 was placed) , there are 5 elements smaller than 10  (3,9,2,4,8) so 10 will be moved to index6 swapping 2.
// 4. Check 2(where 10 was placed which is where 8 was placed) , no element is greater than 2 to its right.

// therefore:
//(8 was kept on the index of-->10 was kept on the index of-->2 was kept on the index of-->8) hence forming a cycle, also known as cycling decomposition.

// Approach:
// 1. Cycle from 0 to n-1. n being the size of the array.
// 2. 


public static void cyclesortmain(int[] arr)
{

}

}
