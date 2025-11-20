import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
       System.out.println(merge(intervals)); 
    }
    /*
------------------------------------
APPROACH & LOGIC (approach2 format)
------------------------------------

1. Sort the intervals by their starting point.
   - Sorting ensures that overlapping intervals will appear next to each other.

2. Initialize two variables:
   - StartRange = start of the first interval
   - EndRange   = end of the first interval

3. Traverse the sorted intervals from index 1 onwards.

4. During traversal:
   - If the current interval’s start lies within the previous merged interval range,
     it means the intervals overlap.
       → Extend EndRange using max(EndRange, current_end)

   - Else (no overlap):
       → Add the previous merged interval [StartRange, EndRange] to the answer.
       → Reset StartRange and EndRange to current interval values.

5. After finishing the loop, add the last tracked interval to the answer
   because it won't be added inside the loop.

6. Return the list of merged intervals.
*/

    public static List<List<Integer>> merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> list = new ArrayList<>();
        int index = 0;
        int n = intervals.length;
        int StartRange = intervals[0][0];
        int EndRange = intervals[0][1];
        for(int i = 1 ; i < n ; i++)
        {
            if(EndRange >= intervals[i][0])
            {
                EndRange = Math.max(intervals[i][1],EndRange);
            }
            else
            {
                List<Integer> sublist = new ArrayList<>();
                sublist.add(StartRange);
                sublist.add(EndRange);
                list.add(sublist);
                StartRange = intervals[i][0];
                EndRange = intervals[i][1];
            }
        }
        List<Integer> sublist = new ArrayList<>();
        sublist.add(StartRange);
        sublist.add(EndRange);
        list.add(sublist);
        return list; 
    }
}
