import java.util.HashMap;

public class ArraySubset {


    /*
Approach:
1. Use a HashMap to store the frequency of each element in the first array (a1).
   - Traverse a1 and update the frequency of each element in the map.
2. Traverse the second array (a2):
   - For each element in a2, check if it exists in the map and its frequency is greater than 0.
   - If yes, decrement its frequency in the map (to handle duplicates correctly).
   - If not found or frequency becomes 0 before usage, print "No" and exit — meaning a2 is not a subset of a1.
3. If the entire loop completes successfully, print "yes", meaning all elements of a2 are present in a1 with enough occurrences.
4. This ensures duplicates are also considered properly while checking for subset validity.

Time Complexity: O(n + m)   // traversing both arrays once
Space Complexity: O(n)      // storing frequencies of elements from a1
*/

    public static void main(String[] args) {
        int a1[] = {11, 7, 1, 13, 21, 3, 7, 3};
        int a2[] = {11, 3, 7, 1, 7};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < a1.length ; i++)
        {
            map.put(a1[i],map.getOrDefault(a1[i],0)+1);
        }

        for(int i = 0 ; i < a2.length ; i++)
        {
            if(map.containsKey(a2[i]) && map.get(a2[i])>0)
            {
                map.put(a2[i],map.get(a2[i])-1);
            }
            else{
                System.out.println("No");
                return ;
            }
        }
        System.out.println("yes");



    }
}
