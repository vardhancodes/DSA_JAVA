import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {
    {1, 0, 0, 0},
    {1, 1, 0, 1},
    {1, 1, 0, 0},
    {0, 1, 1, 1}
};
        int n = maze.length;
        ArrayList<String> list = new ArrayList<String>();
        solve(maze, 0, 0, n, "", list);
        System.out.println(list);
    }

    /*
Rat in a Maze – Approach and Recursion Logic

Goal:
- Given a n x n maze with cells containing 1 (open path) and 0 (blocked path), 
  find all possible paths from the top-left corner (0,0) to the bottom-right corner (n-1,n-1).
- The rat can move in four directions: Down (D), Left (L), Right (R), Up (U).
- Each path is represented as a string of moves.

--------------------------------------------------------------------------------
Approach:

1. **Backtracking DFS**:
   - Start at cell (0,0) with an empty path.
   - If the current cell is blocked (0) or already visited (marked), return.

2. **Base Case**:
   - If the current cell is the destination (n-1,n-1), add the current path to the result list and return.

3. **Recursive Step**:
   - Mark the current cell as visited to avoid revisiting.
   - Explore all 4 directions recursively:
       a. Down → i+1, j → append 'D' to path
       b. Left → i, j-1 → append 'L' to path
       c. Right → i, j+1 → append 'R' to path
       d. Up → i-1, j → append 'U' to path
   - After exploring all directions, backtrack by restoring the original cell value.

4. **Return Result**:
   - After the recursion finishes, the result list contains all valid paths.

Time Complexity:
- O(4^(n^2)) in the worst case because each cell may explore 4 directions.
- Backtracking prunes invalid paths, reducing unnecessary exploration.

Space Complexity:
- O(n^2) for recursion stack in the worst case.

--------------------------------------------------------------------------------
Recursive Tree Visualization:

Example Maze:

1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1

Start at (0,0) with empty path:

recur(0,0) -> ''
/      |       |       \
Down   Left    Right    Up
|
recur(1,0) -> 'D'
   /      |       |       \
Down   Left    Right    Up
   ...
recur(2,0) -> 'DD'
   /      |       |       \
Down   Left    Right    Up
   ...
(recurse continues exploring all directions, marking visited cells, 
backtracking when dead-ends are reached, and adding paths upon reaching the destination)

Notes:
- Each level represents a move in one direction.
- Each branch represents a possible movement from the current cell.
- Dead ends or visited cells terminate that branch.
- Leaf nodes at (n-1,n-1) represent valid paths from start to destination.
- Backtracking restores the board to allow exploring other paths.
*/


    public static void solve(int mat[][], int i, int j, int n, String path, ArrayList<String> res){
        
        
        // dead ends
        if(i<0 || i >= n || j <0 || j>=n || mat[i][j] == 0 || mat[i][j] == 2){
            return;
        }
        
        
        //base case
        if(i == n-1 && j == n-1){
            res.add(path);
            return;
        }
                
        // all operations
        // visit
        int orig =  mat[i][j];
         mat[i][j] = 2;
        // 4 options
       
        solve(mat, i+1, j, n, path + "D", res);
        solve(mat, i , j-1, n, path + "L", res);
        solve(mat, i, j+1, n, path + "R", res);
        solve(mat, i-1, j, n, path + "U", res);
        mat[i][j] = orig;
    }
}
