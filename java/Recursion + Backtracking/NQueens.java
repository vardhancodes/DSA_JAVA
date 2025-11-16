import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 6;
        List<List<String>> list = new ArrayList<List<String>>();
        List<List<String>> board = new ArrayList<List<String>>();
        for(int i = 0 ; i < n ; i++)
        {
            List<String> sublist = new ArrayList<String>();
            for(int j = 0 ; j < n ; j++)
            {
                sublist.add(".");
            }
            board.add(sublist);
        }
        recur(n,list,0,board);
        System.out.println(list);

    }

    /*
N-Queens Problem – Logic and Recursion Explanation

Goal:
Place n queens on an n x n chessboard so that no two queens attack each other.
- Queens attack horizontally, vertically, and diagonally.
- Each solution is a configuration of the board with exactly one queen per column.

Logic / Approach:

1. **Board Representation**:
   - Use a 2D List `board` where '.' represents an empty cell and 'Q' represents a queen.

2. **Column-wise Placement**:
   - Place queens **column by column**.
   - This guarantees that no two queens are in the same column.

3. **Safety Check (`isPossible`)**:
   - For placing a queen at (row, col), check:
     a. **Horizontal Check**: Ensure no queen exists to the left in the same row.
     b. **Upper Diagonal Check**: Ensure no queen exists in the upper-left diagonal.
     c. **Lower Diagonal Check**: Ensure no queen exists in the lower-left diagonal.
   - If all checks pass, the cell is safe for a queen.

4. **Recursive Placement (`recur`)**:
   - Base Case: If `column >= n`, all queens are placed successfully:
       - Convert the current board to a list of strings and add it to the solutions list.
   - Recursive Step:
       - Try placing a queen in every row of the current column.
       - If placing is safe:
           - Place the queen.
           - Recursively call `recur` for the next column.
           - Backtrack: Remove the queen to explore other possibilities.

5. **Backtracking**:
   - If placing a queen leads to no solution in further columns, backtrack.
   - This ensures we explore **all possible valid configurations**.

6. **Result**:
   - After exploring all columns, the `list` contains all valid N-Queens board configurations.

Time Complexity: O(N!) – Each column tries up to n rows, pruning unsafe positions reduces possibilities  
Space Complexity: O(N^2) – Board storage + recursion stack

--------------------------------------------------------------------------------
Recursive Tree Visualization (Column-wise branching):

Level 0 (Column 0):
recur(j=0)
/    |    |    |
row0 row1 row2 row3

Level 1 (Column 1):
- For each valid row in column 0, try all safe rows in column 1
row0 -> recur(j=1)
        /    |   \
    row1 row2 row3
row1 -> recur(j=1)
        /    |   \
    row0 row2 row3

Level 2 (Column 2):
- Repeat recursively for each valid placement
- Continue until column = n (solution found)

Notes:
- Each level = one column
- Each branch = placing a queen in a valid row for that column
- Backtracking prunes invalid branches
- Leaf nodes at column = n represent valid solutions
*/



    public static boolean isPossible(List<List<String>> board,int n , int i , int j)
    {
        //horizontal check
        for(int col = 0 ; col < j ; col++)
        {
            if(board.get(i).get(col).equals("Q"))
            {
                return false;
            }
        }
        //upper diagnol
        for(int row = i-1 , col = j-1 ; row>=0 && col>=0 ; row-- , col--)
        {
            if(board.get(row).get(col).equals("Q"))
            {
                return false;
            }
        }
        //Lower Diagnol
        for(int row = i+1 , col = j-1 ; row<n && col>=0 ; row++ , col--)
        {
            if(board.get(row).get(col).equals("Q"))
            {
                return false;
            }
        }
        return true;

    }
    public static void recur(int n , List<List<String>> list ,int j, List<List<String>> board)
    {
        if(j >= n)
        {
            List<String> sublist = new ArrayList<String>();
            for(int i = 0 ; i < n ; i++)
            {
                String s = "";
                for(int col = 0 ; col < n ; col++)
                {
                    s = s + board.get(i).get(col);
                }
                sublist.add(s);
            }
            list.add(sublist);
            return;
        }

        for(int row = 0 ; row < n ; row++)
        {
            if(isPossible(board,n,row,j))
            {
                board.get(row).set(j,"Q");
                recur(n,list,j+1,board);
                board.get(row).set(j,".");

            }

        }
    }
}
