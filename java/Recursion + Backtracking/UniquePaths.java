public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println(ways(m, n, 0, 0));
    }

// Problem: Count unique paths from (0,0) to (m-1,n-1) in a grid.
// You can only move RIGHT or DOWN at each step.

// Approach (Recursive):
// 1. Start at (0,0).
// 2. At each cell, you have 2 choices:
//      - Move DOWN (row+1, col)
//      - Move RIGHT (row, col+1)
// 3. Base case:
//      - If you reach last row OR last column, only 1 path is possible.
// 4. Recursive relation:
//      ways(row, col) = ways(row+1, col) + ways(row, col+1)
// 5. Time complexity is O(2^(m+n)) because every cell branches into 2 calls.
// 6. Space complexity is O(m+n) due to recursion stack depth.



/*
Recursive Tree for uniquePaths(3,3):

                 ways(0,0)
                 /      \
           ways(1,0)   ways(0,1)
            /   \        /    \
     ways(2,0) ways(1,1) ways(1,1) ways(0,2)
        |       /   \      /   \       |
        1  ways(2,1) ways(1,2) ways(2,1) ways(1,2)  1
              |        |       |        |
              1        1       1        1

Leaf nodes (value = 1) represent base cases.
Total paths = sum of all leaves = 6
*/



    public static int ways(int m , int n , int row , int column)
    {
        if(row == m-1 || column == n-1)
        {
            return 1;
        }
        return ways(m, n, row+1, column)+ways(m, n, row, column+1);
    }

}
