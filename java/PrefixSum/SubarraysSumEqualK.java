import java.util.HashMap;

public class SubarraysSumEqualK {
    public static void main(String[] args) {
        int nums[] = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));
    }

// APPROACH:
//
// // Count Subarrays with Sum = K using Prefix Sum + Frequency Map
//
// // 1. Maintain a running prefix sum while iterating through the array.
// //
// // 2. Use a HashMap that stores:
// //        prefixSum → how many times this prefixSum has appeared so far
// //
// //    Instead of storing the first index (like in longest-subarray problems),
// //    we store the COUNT because:
// //      - Every previous occurrence of (prefixSum - k) forms a valid subarray
// //        ending at the current index.
// //
// // 3. At each index i:
// //        - Update prefix sum.
// //        - Compute rem = prefixSum - k.
// //        - If 'rem' exists in the map, it means ALL its occurrences represent
// //          different subarrays that end at i with sum = k.
// //          Example: if rem appears 3 times, then 3 valid subarrays end at i.
// //        - Add map.get(rem) to the answer.
// //
// // 4. WHY WE STORE FREQUENCIES INSTEAD OF FIRST OCCURRENCE?
// //        - Because we are COUNTING all subarrays, not finding the longest.
// //        - A prefix sum may appear multiple times due to negative numbers,
// //          positives, or zeros.
// //        - Each repeated occurrence creates a new valid subarray.
// //        - So we increment frequency instead of locking the first appearance.
// //
// // 5. Insert/update the current prefix sum in the map:
// //        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1)
// //
// // 6. This ensures that each time we check 'rem', we know exactly how many
// //    subarrays end at the current index with sum = k.
// //
// // 7. Time complexity: O(n) because every element is processed once.
// //    Space complexity: O(n) for storing frequencies of prefix sums.

public static int subarraySum(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    int sum = 0;
    map.put(0,1);
    int ans = 0;
    for(int i = 0 ; i < nums.length ; i++)
    {
        sum+=nums[i];
        int rem = sum-k;
        if(map.containsKey(rem))
        {
            ans+=map.get(rem);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
    }
    return ans;
}
}
