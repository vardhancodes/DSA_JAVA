import java.util.HashMap;
public class MostFreqElement {

    /*
Approach:
1. Use a HashMap to count the frequency of each element in the array.
2. Maintain two variables:
   - 'maxF' to store the maximum frequency found so far.
   - 'ans' to store the element corresponding to that maximum frequency.
3. Traverse the array:
   - For each element, update its frequency in the HashMap.
   - If its frequency becomes greater than 'maxF', update both 'maxF' and 'ans'.
   - If its frequency equals 'maxF', choose the element with the larger value.
4. After the loop, 'ans' will hold the element that has the highest frequency.
   - In case of a tie, the larger element is chosen.
5. Print 'ans' as the final answer.

Time Complexity: O(n)   // single traversal of array
Space Complexity: O(n)  // for storing frequencies in HashMap
*/

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 4, 1};
        int ans = -1;
        int maxF = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < arr.length ; i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i]) > maxF)
            {
                ans = arr[i];
                maxF = map.get(arr[i]);
            }
            else if(map.get(arr[i]) == maxF)
            {
                ans = Math.max(arr[i],ans);
            }
        }
        System.out.println(ans);

        



    }
}
