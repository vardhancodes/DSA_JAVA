public class CountUnguardedcellsinthegrid {
    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int [][]guards = {{0,0},{1,1},{2,3}};
        int [][]walls = {{0,1},{2,2},{1,4}};
        int ans = countUnguarded(m, n, guards, walls);
        System.out.println(ans);

    }

// Approach:
// 1. Initialize an m x n grid with all values as 0, representing empty cells.
//    -> We'll use different numbers to mark specific types of cells:
//       0 = empty cell
//       1 = guard cell
//       2 = wall cell
//       3 = cell visible to at least one guard (guarded cell)
//
// 2. Place all guards and walls in the grid using the given coordinates.
//    -> For each guard in the "guards" array, mark grid[r][c] = 1
//    -> For each wall in the "walls" array, mark grid[r][c] = 2
//
// 3. For each guard, check its line of sight in all four directions:
//    - UP: move row index upwards (r - 1) until you hit a wall or another guard
//    - DOWN: move row index downwards (r + 1) until a wall or another guard
//    - LEFT: move column index leftwards (c - 1) until a wall or another guard
//    - RIGHT: move column index rightwards (c + 1) until a wall or another guard
//
// 4. While moving in a direction, if the current cell is empty (0),
//    mark it as 3 to show that it’s being watched by a guard.
//
// 5. Stop moving in a direction as soon as you hit:
//    - A wall (2), since it blocks visibility
//    - Another guard (1), since guards can’t see through each other
//
// 6. After processing all guards, traverse the entire grid again.
//    Count all the cells that are still marked as 0 — these are the unguarded cells.
//
// 7. Return the total count of unguarded cells as the result.
//
// Time Complexity: O(m * n) in the worst case, since each cell can be visited multiple times.
// Space Complexity: O(m * n) for the grid used to store markings.

    public static int countUnguarded(int m , int n , int[][]guards , int[][] walls)
    {
        int grid[][] = new int[m][n];
        for(int i = 0 ; i < guards.length ; i++)
        {
            int r = guards[i][0];
            int c = guards[i][1];
            grid[r][c] = 1;
        }

        for(int i = 0 ; i < walls.length ; i++)
        {
            int r = walls[i][0];
            int c = walls[i][1];
            grid[r][c] = 2;
        }

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,1,-1};


        for(int i = 0 ; i < guards.length ; i++)
        {
            int r = guards[i][0];
            int c = guards[i][1];

            for(int ind = 0 ; ind < 4 ; ind ++)
            {
                int newr = r+dr[ind];
                int newc = c+dc[ind];

                while(newr >=0 && newr < m && newc >=0 && newc < n && grid[newr][newc] != 2 && grid[newr][newc] != 1)
                {
                    if(grid[newr][newc] == 0)
                    {
                        grid[newr][newc] = 3;
                    }
                    newr+=dr[ind];
                    newc+=dc[ind];
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(grid[i][j] == 0)
                {
                    ans++;
                }
            }
        }
        return ans;

    }


}
