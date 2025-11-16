public class NumberOfIslands {


/*
Approach: Number of Islands using DFS

1. Iterate through each cell in the grid.
2. If the current cell is '1' (land):
   - Increment the island count.
   - Perform DFS from this cell to mark all connected land cells as visited.
3. DFS function marks the current cell as visited ('2') and recursively explores 
   the four adjacent directions: up, down, left, right.
4. Base condition for DFS:
   - Stop if the cell is out of bounds, water ('0'), or already visited ('2').
5. After DFS finishes, all cells belonging to the same island are marked,
   ensuring each island is counted only once.
6. Return the total island count after scanning the entire grid.

Time Complexity: O(n * m) - each cell visited at most once
Space Complexity: O(n * m) - recursion stack in worst case
*/

/*
Recursive Tree Visualization Example:

Grid:
1 1 0
0 1 0
0 0 1

Starting DFS from (0,0):

recur(0,0)
/\
  recur(1,0) -> stops (water)
/\
  recur(0,-1) -> stops (out of bounds)
/\
  recur(0,1)
/\
    recur(1,1)
/\
        recur(2,1) -> stops (water)
/\
        recur(1,0) -> stops (visited)
/\
        recur(1,2) -> stops (water)
/\
        recur(0,1) -> stops (visited)
/\
    recur(-1,1) -> stops (out of bounds)

Next unvisited '1' at (2,2) -> new island:

recur(2,2)
/\
    recur(3,2) -> stops (out of bounds)
/\
    recur(2,1) -> stops (water)
/\
    recur(2,3) -> stops (out of bounds)
/\
    recur(1,2) -> stops (water)
*/

    public static void main(String[] args) {
        int count = 0;
        char[][] grid = {
  {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','1','0'},
  {'0','0','1','0','1'}
};
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[i].length ; j++)
            {
                if(grid[i][j] == '1')
                {
                    recur(grid,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);

        
    }


    public static void recur(char[][] grid, int i , int j )
    {
        if(i < 0 || i >= grid.length || j < 0 || j >=grid[i].length || grid[i][j] == '0' || grid[i][j] == '2')
        {
            return;
        }

        int di[] = {1,0,0,-1};
        int dj[] = {0,-1,1,0};

        grid[i][j] = '2';

        for(int ind = 0 ; ind < 4 ; ind++)
        {
            recur(grid, i+di[ind], j+dj[ind]);

        }


    }
}
