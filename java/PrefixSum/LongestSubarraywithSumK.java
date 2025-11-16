import java.util.HashMap;

public class LongestSubarraywithSumK {
    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }


// APPROACH:
//
// // Longest Subarray with Sum K using Prefix Sum + HashMap
//
// // 1. Maintain a running prefix sum while iterating through the array.
// // 2. Use a HashMap to store the FIRST index at which each prefix sum appears.
// //       - Initialize map with prefixSum = 0 at index -1 to allow subarrays starting at 0.
// //
// // 3. At each index i:
// //        - Update prefix sum.
// //        - Compute rem = prefixSum - k.
// //        - If 'rem' exists in the map, then the subarray from
// //              map.get(rem) + 1  to  i
// //          has sum = k.
// //        - Calculate the length and update the maximum.
// //
// // 4. WHY DO WE STORE ONLY THE FIRST OCCURRENCE OF A PREFIX SUM?
// //        - Because storing the earliest index gives the LONGEST possible subarray.
// //        - If we overwrite it with a later index, the distance (i - index)
// //          would become smaller → shorter subarray.
// //        - So to maximize length, we lock the first position where that prefix sum appears.
// //
// // 5. Insert the current prefix sum into the map only if it does not exist.
// // 6. This method works in O(n) time because each element is processed once.
// //
// // 7. Return the maximum subarray length found.


public static int longestSubarray(int[] arr, int k) {
    int ans = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    int sum = 0;
    map.put(0,-1);
    for(int i = 0 ; i < arr.length; i++)
    {
        sum+=arr[i];
        int rem = sum-k;
        if(map.containsKey(rem))
        {
            int size = i-(map.get(rem));
            ans = Math.max(ans,size);
        }
        if(!map.containsKey(sum))
        {
            map.put(sum,i);
        }
    }
    return ans;
}
}
