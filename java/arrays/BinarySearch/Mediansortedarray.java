public class Mediansortedarray {

//Median : middle element
//even no. of elements = n/2 & n/2-1
//odd no. of elements = n/2

//Median of Two sorted arrays

//         L1     R2
//arr1 = {2,4, | 9,12}

//         L2     R2
//arr2 = {5,6, | 8,13}

//              L3        R3
//new arr = {2,4,5,6 | ,8,9,12,13}

//elements of L1+L2 = L3 || R1+R2 = R3

//median :
//for even : (largest element of left half + smallest element of right half)/2
// -> LHS = max(L1,L2) + RHS->min(R1,R2) / 2 
//for odd : min(R1,R2)


//Approach:
//1. Since two arrays would be given , Binary search would be applied on the smaller one for cut 1.
//2. Find cut 2 -> (n1+n2)/2 - cut 1
//3. Condition for cut : 
//   L1 <= R2 && L2 <= R1
//4. If invalid (L1 > R2) --> end - mid-1;
//5. else --> start + 1
//6. If L1/L1 is invalid --> Min_Value
//7. If R1/R2 is invalid --> Max_Value

public static void main(String[] args) {
int[] nums1 = {1,4,6,8,9};
int[] nums2 = {2,5,7};
double result = findmediansortedarray(nums1 , nums2);
System.out.println(result);
    
}


static double findmediansortedarray(int nums1[], int nums2[])
{//make num1 as min length array
//call same function , and the change the parameters
//if nums1 was greater and nums2 was smaller
//it would be swapped 
    if(nums1.length > nums2.length)
    {
        return findmediansortedarray(nums2 , nums1);
    }
    int n1 = nums1.length;
    int start = 0 ; 
    int n2 = nums2.length;
    int end = n1;

    while(start <= end )
    {
        //mid is cut1
        int cut1 = start+(end-start)/2;
        int cut2 = n1+n2/2 - cut1;
        //L1, R1 , L2 ,R2
        int R1 = (cut1==n1)?Integer.MAX_VALUE:nums1[cut1];
        int R2 = (cut2==n2)?Integer.MAX_VALUE:nums2[cut2];
        int L1 = (cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
        int L2 = (cut1==0)?Integer.MIN_VALUE:nums2[cut2-1];

        //check if cut is valid 
        if (L1 <= R2 && L2 <= R1)
        {
            //if N is odd , 1
            //else if N is even , 2
            if((n1+n2)%2 != 0)
            {
                return Math.min(R1, R2);
            }
            else
            {
                return (Math.max(L1, L2) + Math.min(R1, R2))/2;

            }
        } else if(L1 > R1)
        {
            end = cut1-1;
        }
        else 
        {
            start = cut1+1;
        }

    }
    return 0.0;



}
}
