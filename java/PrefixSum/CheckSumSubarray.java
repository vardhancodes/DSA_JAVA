import java.util.HashSet;
public class CheckSumSubarray {
    public static void main(String[] args) {
        int []arr = {2,8,2,6,6,3,2};
        System.out.println(checkSum(arr, 5));
    }
    
// APPROACH + LOGIC (VS Code style, no code)

// • Goal: Check if there exists a subarray whose sum equals k.

// • Concept used: Prefix Sum + HashSet

// • Prefix sum idea:
//   - Let prefixSum(i) = sum of elements from index 0 to i.
//   - A subarray (l → r) has sum k if:
//         prefixSum(r) - prefixSum(l-1) = k
//     → prefixSum(l-1) = prefixSum(r) - k

// • How the algorithm works:
//   - Maintain a running sum = prefixSum(r).
//   - For each index r:
//       > Compute rem = sum - k.
//       > If 'rem' exists in the HashSet,
//         it means some previous prefix sum equals rem,
//         so the subarray between that point and r has sum k.
//         → Return true.

// • Why HashSet?
//   - To quickly check if a needed prefix sum has appeared before.
//   - Store every prefix sum we get while moving forward.

// • Why insert 0 initially?
//   - This handles the case where a subarray starting at index 0
//     directly sums to k.
//   - Example: if sum == k at some point, then sum - k = 0,
//     so checking for prefix = 0 works correctly.

// • Final logic:
//   - If at any point, a valid prefixSum(l-1) exists,
//     we have found a subarray with sum = k.
//   - If loop ends and no match found → return false.

public static boolean checkSum(int arr[] , int k)
{
    int sum = 0;
    HashSet<Integer> set = new HashSet<>();
    set.add(0);
    for(int i = 0 ; i < arr.length ; i++)
    {
        sum+=arr[i];
        int rem = sum-k;
        if(set.contains(rem))
        {
            return true;
        }
        set.add(sum);
    }
    return false;
}

}
