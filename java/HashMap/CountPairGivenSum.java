import java.util.HashMap;
public class CountPairGivenSum {
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, -1, 5};
        int target = 6;
        int ans1 = countPairs(arr, target);
        int ans2 = countPairs2(arr, target);
        System.out.println(ans1 + " " + ans2);
    }

//Brute force
// Approach:
//
// 1. Build a frequency map for all numbers in the array.
//    This lets us quickly check how many times a number appears.
//
// 2. For each element arr[i], calculate the required value:
//        secondVal = target - arr[i]
//    This is the number needed to form a valid pair.
//
// 3. Before checking for a pair, decrease the frequency of arr[i]
//    to ensure we don't pair the same element with itself.
//
// 4. If secondVal exists in the map with a positive frequency,
//    then all those occurrences form valid pairs with arr[i].
//    Add that frequency to the answer.
//
// 5. After processing all elements, return the total count
//    of valid pairs whose sum equals the target.

public static int countPairs(int arr[], int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(int i = 0 ; i < arr.length ; i++)
        {
            int secondVal = target - arr[i];
            map.put(arr[i],map.get(arr[i])-1);
            if(map.getOrDefault(secondVal,0)>0)
            {
                ans += map.get(secondVal);
            }

        }
        return ans;

    }


//Optimised Approach
// Create a HashMap to keep track of how many times each number has appeared so far.

// Initialize ans to store the total count of valid pairs.

// Loop through each element of the array.
// For every element, compute the value needed to reach the target.

// If the required value (secondVal) is already present in the map,
// it means all its occurrences form valid pairs with the current element.
// Add that count to ans.

// Add the current element to the map (or increase its frequency),
// so it can be used as a pair for upcoming elements.

// Finally, return the total number of valid pairs.

public static int countPairs2(int arr[], int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            int secondVal = target - arr[i];
            if(map.containsKey(secondVal))
            {
                ans+=map.get(secondVal);
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);

        }
        return ans;

    }
}

