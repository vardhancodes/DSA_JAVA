import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int [] newInterval = {2,5};
        int ans[][] = insert(intervals,newInterval);
        for(int i = 0 ; i < ans.length ; i++)
        {
            for(int j = 0 ; j < ans[i].length ; j++)
            {
                System.out.print(ans[i][j]+" ");
            }
        }
    }
/*
-----------------------------------------
APPROACH 2 — MERGE WHILE INSERTING
-----------------------------------------

// ⭐ Goal:
// Insert a new interval into a sorted list of non-overlapping intervals
// and merge only when required.

// ⭐ Intuition:
// We divide the work into 3 phases:
//
// 1) BEFORE OVERLAP PHASE:
//    - Add all intervals that end before the new interval starts.
//    - These can never overlap.
//
// 2) MERGING PHASE:
//    - As long as intervals overlap with the new interval,
//      merge them by expanding newInterval's start & end.
//
//    Overlap rule:
//    intervals[i][0] <= newInterval[1]
//    (i.e., interval starts before newInterval ends)
//
// 3) AFTER MERGE PHASE:
//    - Add all remaining intervals after new interval is placed.
//
// ⭐ Why this works:
// Because intervals are already sorted by start,
// so all non-overlapping intervals appear before/after consecutively.
//
// ⭐ Time Complexity:
// O(n), single scan.
//
// ⭐ Space Complexity:
// O(n) for result list.
// Constant extra work otherwise.
//
// ⭐ Edge cases handled:
// - new interval before all
// - new interval after all
// - new interval merging multiple intervals
// - empty input
// - complete overlap of entire list
-----------------------------------------
*/


     public static int[][] insert(int[][] intervals, int[] newInterval) {
        int s2 = newInterval[0];
        int e2 = newInterval[1];
        int StartRange = Integer.MAX_VALUE;
        int EndRange = -1;
        List<int[]> list = new ArrayList<>();
        int i = 0 ;
        int n = intervals.length;
        //before merging
        while( i < n && intervals[i][1] < newInterval[0])
        {
            list.add(intervals[i]);
            i++;
        }
        //overlapping
        while(i<n && newInterval[1] >= intervals[i][0])
        {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while(i < n)
        {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
