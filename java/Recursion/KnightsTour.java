public class KnightsTour {
    public static void main(String[] args) {
        int grid[][] = {{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        int n = grid.length;
        if(grid[0][0] != 0)
        {
            System.out.println("false");
        }
        System.out.println(recur(grid,0,0,n,0));
        

    }

    /*
Approach: Check Valid Knight's Tour Grid using DFS

1. The grid is n x n where each cell contains the move number (0 to n*n-1).
2. First, check if the starting cell (0,0) is 0. If not, return false.
3. Use a recursive function `recur` to validate the knight's moves:
   - Input: current position (i, j), grid size n, and the current move number.
4. Base Case:
   - If current move number == n*n - 1, return true (all moves valid).
5. For each cell, try all 8 possible knight moves:
   - (2,1), (2,-1), (-2,1), (-2,-1), (1,2), (-1,2), (1,-2), (-1,-2)
   - Calculate next position (nextI, nextJ) and next move number.
6. Check if the next move is valid:
   - Next position is within grid boundaries.
   - The value in grid[nextI][nextJ] == nextMove.
7. If valid, recursively call `recur` for the next move.
   - If recursion returns true, propagate true upwards.
8. If no valid moves lead to success, return false.

Time Complexity: O(8^(n*n)) in worst-case recursion (DFS all possible paths)
Space Complexity: O(n*n) recursion stack depth

--------------------------------------------------------------------------------
Recursive Tree Visualization (Knight Moves):

Example: 3x3 Grid, starting at move 0

recur(0,0)  // starting point
/  |  \  ...
(2,1) (1,2) (-1,?) ... (all 8 knight moves)
/\
(4,2) -> next valid move
(3,3) -> next valid move
...
(recurse continues for each valid move until move == n*n-1)

/\
Each branch represents one knight move from the current cell.
- Only valid moves are explored.
- Invalid moves (out of bounds or wrong move number) terminate that branch.
- When a branch reaches move == n*n-1, return true to confirm valid tour.
*/


    public static boolean recur(int[][] grid , int i , int j, int n, int moves)
    {
        if(n*n-1 == moves)
        {
            return true;
        }

        int di[] = {2,2,-2,-2,1,-1,-1,1};
        int dj[] = {-1,1,1,-1,2,2,-2,-2};

        for(int ind = 0 ; ind < 8 ; ind++)
        {
            int nextI = i+di[ind];
            int nextJ = j+dj[ind];
            int nextMove = moves+1;
            if(isValid(grid,nextI,nextJ,nextMove,n))
            {
                if(recur(grid, nextI, nextJ, n, moves+1))
                {
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean isValid(int[][] grid , int i , int j , int moves, int n)
    {
        if(i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != moves)
        {
            return false;
        }
        return true;
    }
}
