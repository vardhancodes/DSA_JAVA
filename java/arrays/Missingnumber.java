public class Missingnumber {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        int result =  missingNumber(nums);
        System.out.println(result);
        
    }
    

// Missing Number : 
// Question : 
// One number is missing from the array , we have to find it.


// Approach:
// eg : A = {0, 3 , 1} --> Sum = 4
// and the array should be A1 = {0, 1 , 2 , 3} --> Sum1 = 6
// Sum1-Sum = 2 

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2; 
        int sum1 = 0;
        for(int i = 0 ; i< n ; i ++)
        {
            sum1+=nums[i];
        }
        return sum-sum1;
            
    }

}
