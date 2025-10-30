public class MergeSortedArrays{
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        mergeArrays(nums1, nums2, m, n);
        printarray(nums1);
    }

    public static void mergeArrays(int[] arr1 , int[] arr2 , int m , int n )
    {
        int i = m-1;
        int j = n-1;
        int index = m+n-1;
        while(j>=0 && i>=0)
        {
            if(arr1[i] > arr2[j])
            {
                arr1[index] = arr1[i];
                i--;
                index--;

            }
            else
            {
                arr1[index] = arr2[j];
                j--;
                index--;
            }
        }
    }

    public static void printarray(int[] arr)
    {
        for(int i = 0 ; i < arr.length ; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}