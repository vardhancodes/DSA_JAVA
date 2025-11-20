import java.util.Arrays;

public class SetIntersectionSize2 {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{1,4},{2,5},{3,5}};
        System.out.print(function(arr));
        
    }
    /*
------------------------------------
APPROACH & LOGIC (approach2 format)
------------------------------------

1. Sort the intervals by their ending point.
   - If two intervals have the same end, sort by the larger start.
   - This ensures we always try to pick points as close to the end as possible,
     maximizing future coverage.

2. Maintain two markers:
   - ptr1: the first chosen point
   - ptr2: the second chosen point
   Initially both are -1 (meaning no points chosen yet).

3. Traverse all intervals one by one.

4. For each interval, check coverage:
   - If both ptr1 and ptr2 already lie inside the current interval,
     no new points are needed.

   - Else if only ptr2 lies inside the current interval,
     select exactly one more point for this interval:
       → Move ptr1 to ptr2
       → Set ptr2 to the end of the interval
       → Increment answer by 1

   - Else (none of the markers lie inside the interval),
     select two new points:
       → ptr2 = interval end
       → ptr1 = interval end - 1
       → Increment answer by 2

5. The reason for choosing the *last two points* of the interval is:
   - They maximize the chance of covering future intervals.

6. After processing all intervals, return the final count
   which represents the minimum number of elements needed
   such that every interval contains at least two selected points.
*/

    public static int function(int[][] intervals) {
         Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return Integer.compare(a[1], b[1]);
        });
       int ptr1 = -1;
       int ptr2 = -1;
       int ans = 0;
       for(int i = 0 ; i < intervals.length ; i++)
       {
           if((ptr1 >= intervals[i][0] && ptr1 <= intervals[i][1]) && (ptr2 >= intervals[i][0] && ptr2 <= intervals[i][1]))
           {
                continue;
           }
           else if(ptr2 >= intervals[i][0] && ptr2 <= intervals[i][1])
           {
                ans+=1;
                ptr1 = ptr2;
                ptr2 = intervals[i][1];
           }
           else
           {
                ans+=2;
                ptr1 = intervals[i][1]-1;
                ptr2 = intervals[i][1];
           }
       }
       return ans;

    }
}
