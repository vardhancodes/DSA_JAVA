import java.util.ArrayList;
import java.util.HashMap;

public class FindKSumSubArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 7, 5};
        int target = 12;
        ArrayList<Integer> list = findKSum(arr, target);
        System.out.println(list);


    }

// APPROACH:
//
// // Prefix Sum + HashMap Technique
//
// // 1. Maintain a running prefix sum while traversing the array.
// // 2. Store each prefix sum in a HashMap with its index (only the first occurrence).
// // 3. For every index i:
// //        - Compute rem = prefixSum - target.
// //        - If 'rem' exists in the map, it means the subarray between
// //          map.get(rem)+1 and i forms a sum equal to 'target'.
// // 4. The map helps us check in O(1) whether a valid prefix exists that leads to
// //    the required target sum.
// // 5. The moment such a subarray is found, record its starting and ending indices.
// // 6. This method ensures an O(n) time complexity because each element is processed once.

public static ArrayList<Integer> findKSum(int arr[] , int target)
{
    ArrayList<Integer> list = new ArrayList<>();
    list.add(-1);
    int sum = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,-1);
    for(int i = 0 ; i < arr.length ; i++)
    {
        sum += arr[i];
        int rem = sum-target;
        if(map.containsKey(rem))
        {
            list.set(0,map.get(rem)+2);
            list.add(i+1);
            break;
        }
        if(!map.containsKey(sum))
        {
            map.put(sum,i);
        }
    }
    
    return list;
} 
}
