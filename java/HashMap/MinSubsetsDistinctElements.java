import java.util.HashMap;
import java.util.HashSet;
public class MinSubsetsDistinctElements {
    public static void main(String[] args) {
        int arr[] = {2,1,4,1,6,5,5,5};
        System.out.println(findMinNumberOfSets(arr));
        System.out.println(findMinNumberOfSets2(arr));
    }
//Approach 1 :
// APPROACH + LOGIC (no code as requested)

// • We want to form the minimum number of sets such that
//   each set contains only UNIQUE elements (no duplicates within a set).

// • Main idea:
//   - We scan the array from left to right.
//   - For each starting position i, if that element is already taken in a previous set
//     (visited[i] == true), we skip it because it’s already used.
//   - If not visited, that means we need to START A NEW SET → increment result.

// • For every new set:
//   - Maintain a HashSet ‘set’ to track which numbers are already placed inside this set.
//   - Now scan from j = i to end:
//       > If arr[j] is already visited OR already inside 'set', skip it.
//       > Else, include arr[j] in this set and mark visited[j] = true.

// • Why this works:
//   - Because each set can only have unique values.
//   - The algorithm takes as many elements as possible into the current set
//     until it cannot take more due to duplicates.
//   - Then it starts a new set for remaining unvisited elements.

// • Final result = minimum number of such unique-element sets needed.

public static int findMinNumberOfSets(int arr[])
    {
        int res = 0;
        int n = arr.length;
        boolean visited[] = new boolean[n];
        for(int i = 0 ; i < n ; i++)
        {
            if(visited[i])
            {
                continue;
            }
            res++;
            HashSet<Integer> set = new HashSet<>();
            for(int j = i ; j < n ; j++)
            {
                
                if(visited[j] || set.contains(arr[j]))
                {
                    continue;
                }
                else
                {
                    visited[j] = true;
                    set.add(arr[j]);
                }

            }
        }
        return res;

    }

//Approach 2 :
// APPROACH + LOGIC (VS Code style, no code)

// • Goal: Find the minimum number of sets such that
//   each set contains only UNIQUE elements.

// • Key observation:
//   - If a value appears 'k' times in the array,
//     then we NEED at least 'k' different sets.
//   - Why?
//     Because you cannot place duplicates of the same value
//     into the same set (unique constraint).

// • Example:
//     arr = [1,2,2,3,3,3]
//     frequencies:
//       1 → 1 time
//       2 → 2 times
//       3 → 3 times
//     → We need at least 3 sets because '3' appears 3 times.

// • Logic used:
//   - Count frequency of every number using a HashMap.
//   - Track the maximum frequency found.
//   - That maximum frequency is the answer,
//     because it dictates the minimum number of sets required.

// • Why this works:
//   - Every element appears freq[x] times.
//   - The worst (highest) frequency element forces the minimum number of sets.
//   - All other elements can be distributed across these sets without conflict.

// • Final result = maximum frequency among all numbers.

public static int findMinNumberOfSets2(int arr[])
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            max = Math.max(max,map.get(arr[i]));
        }
        return max;

    }
}
