import java.util.HashMap;

public class TwoSum {

// Approach:
// Use a HashMap to store the value→index mapping while iterating.
// For each element nums[i], compute complement = target - nums[i].
// Before inserting nums[i] into the map, check if complement already exists.
// If complement exists in the map, we have found the pair of indices.
// Return the current index and the index stored for complement in the map.
// This works in one pass and gives O(n) time complexity.


// Logic:
// We check every element only once.
// HashMap gives O(1) lookup for checking the complement.
// Insert the current number after checking so that we don’t use the same index twice.
// As soon as complement is found, the problem is solved.

public static void maitn(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        int ans[] = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            int secondVal = target-nums[i];
            if(map.containsKey(secondVal))
            {
                ans[0] = i;
                ans[1] = map.get(secondVal);
            }
            map.put(nums[i],i);

        }
        System.out.print(ans[0]+" "+ans[1]);
    }
}

