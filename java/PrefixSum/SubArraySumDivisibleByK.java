import java.util.HashMap;

public class SubArraySumDivisibleByK {
 
    public static void main(String[] args) {
        int nums[] = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }
/*
------------------------------------------------------------
✅ APPROACH 2 (Prefix Sum + Modulo + Frequency Map Logic)
------------------------------------------------------------

🎯 Goal:
Count subarrays whose sum is divisible by k.

------------------------------------------------------------
🧠 Core Logic (Thought Process)

1️⃣ Maintain a running prefix sum while traversing the array.

2️⃣ Instead of storing prefix sums, store:
       prefixSum % k  (called remainder)

   Why?
   If two prefix sums give the SAME remainder when divided by k,
   then the subarray between them has sum divisible by k.

   Example:
       prefix1 % k = 3
       prefix2 % k = 3
       → (prefix2 - prefix1) % k = 0 ✅ divisible

3️⃣ Use a HashMap to store frequency of each remainder seen so far.

4️⃣ Every time the current remainder has appeared before:
       it means that many subarrays ending at current index
       have sum divisible by k.
       So add that count to answer.

5️⃣ Handle negative remainders by converting:
       rem = (rem + k) % k

6️⃣ Update the remainder frequency in the map.

------------------------------------------------------------
🧮 Why map.put(0,1)?

Before processing any element,
we assume one prefix sum = 0 exists.

This allows subarrays starting from index 0
to be counted correctly when their sum % k == 0.

------------------------------------------------------------
✅ Time Complexity: O(n)
✅ Space Complexity: O(k) or O(n) worst case

------------------------------------------------------------
🚀 Summary:
- Running sum
- Compute remainder
- Count matching previous remainders
- Update map
------------------------------------------------------------
*/


public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            sum+= nums[i];
            int rem = sum%k;
            if(rem < 0)
            {
                rem = rem+k;
            }
            if(map.containsKey(rem))
            {
                ans += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}
