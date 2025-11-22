import java.util.HashSet;

public class LongestConsecutiveSequence{
    public static void main(String[] args) {
        int nums[] = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

    }

// ✅ Approach (Optimal O(n) using HashSet)
//
// 1. Insert all numbers into a HashSet
//    - This removes duplicates
//    - Provides O(1) lookup for checking sequence continuity
//
// 2. Iterate over EACH UNIQUE number in the set
//    - This is crucial for performance
//    - Prevents repeated work caused by duplicates in the original array
//
// 3. For every number, check if it is the START of a sequence
//    - A number is a start if (num - 1) does NOT exist in the set
//    - If (num - 1) exists, skip because this sequence will be counted when
//      its actual start is processed
//
// 4. If it IS a start:
//      - Expand forward: check (num + 1), (num + 2), ... using the set
//      - Count the length of the sequence using a while loop
//
// 5. Track the maximum sequence length found
//
// ✅ Why this is O(n)
//    - Each number is processed at most twice:
//         * once when checking if it's a start
//         * once in the forward expansion
//    - HashSet lookups are O(1)
//    - No nested repeated work from duplicates
//
// ✅ Key Insight
//    - Iterating over the array can cause O(n²) behavior due to duplicates
//    - Iterating over the HASHSET guarantees uniqueness and O(n) performance
//
// ✅ Result
//    - Time: O(n)
//    - Space: O(n)
//    - Passes LeetCode without TLE

public static int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    int ans = 1;
    if(nums.length == 0)
    {
        return 0;
    }
    for(int i = 0 ; i < nums.length ; i++)
    {
        set.add(nums[i]);   
    }
    for(int num : set)
    {
        int prev = num-1;
        if(!set.contains(prev))
        {
            int len = 1;
            int el = num;
            while(set.contains(el+1))
            {
                len++;
                el++;
            }
            ans = Math.max(len,ans);
        }
    }
    return ans;
}
}