public class RotateArrayByDplaces {
    
    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotatearray(nums, k);
        for(int i = 0 ; i < nums.length ; i++)
        {
            System.out.print(nums[i] + " ");
        }
    }

//Rotate Array By D places

// Approach:
// 1. The goal is to rotate the array to the right by k steps.
// 2. Since rotating the array n times (where n = length of array) 
//    brings it back to the original order, any rotation more than n 
//    is redundant. So, we reduce k by doing k = k % n.
//    Example: For n = 5, rotating by k = 12 steps 
//    is the same as rotating by k = 12 % 5 = 2 steps.
// 3. Reverse the entire array.
// 4. Reverse the first k elements to restore their original relative order.
// 5. Reverse the remaining n-k elements to restore their order as well.
// 6. The array is now rotated in-place without using extra space.


public static int[] rotatearray(int nums[] , int k)
{
    int n = nums.length;
    k = k%n;
    rev(nums,0,n-1);
    rev(nums,0,k-1);
    rev(nums,k,n-1);

    return nums;
    

}

public static void rev(int nums[], int start , int end)
{
    while(start < end)
    {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
}
