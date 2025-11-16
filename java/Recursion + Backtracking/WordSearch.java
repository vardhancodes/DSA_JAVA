public class WordSearch {
    public static void main(String[] args) {
        String word = "ABCCED";
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        boolean found = exist(board, word);
        System.out.println(found); // prints true or false
    }

    /*
Word Search Problem – Approach and Recursion Logic

Goal:
- Given a 2D board of characters and a word, determine if the word exists in the board.
- The word can be constructed from letters of sequentially adjacent cells (horizontally or vertically).
- Each cell may be used only once per search.

--------------------------------------------------------------------------------
Approach:

1. **Iterate Over the Board**:
   - Traverse each cell in the 2D board.
   - Whenever a cell matches the first character of the word, start a DFS (Depth-First Search) from that cell.

2. **DFS Function (recursion)**:
   - Input: current cell coordinates (i, j) and current index in the word (il).
   - Base Case:
       a. Out of bounds (i < 0, i >= rows, j < 0, j >= cols)
       b. Cell character does not match word[il]
       c. Cell has already been visited
       d. If `il` is the last character in the word → return true (word matched)
   - Recursive Step:
       - Temporarily mark the current cell as visited.
       - Explore all 4 directions: up, down, left, right.
       - For each direction:
           - Recursively call DFS for the next character (`il + 1`).
           - If recursion returns true, propagate true upward.
       - Backtrack: restore the original character to allow other paths to use it.

3. **Return Result**:
   - If any starting cell leads to a successful match of the entire word → return true.
   - Otherwise → return false.

Time Complexity:
- Worst-case O(m * n * 4^L), where m = rows, n = columns, L = length of the word.
- Each cell can start a DFS and explore up to 4 directions recursively for each character.

Space Complexity:
- O(L) for recursion stack (maximum depth = length of the word).

--------------------------------------------------------------------------------
Recursive Tree Visualization:

Example: board = [['A','B','C','E'],
                  ['S','F','C','S'],
                  ['A','D','E','E']], word = "ABCCED"

Start DFS from cell (0,0) matching 'A':

recur(0,0) -> 'A'
/      |       |       \
down   left    right    up
|
recur(1,0) -> 'S' -> mismatch -> return false
recur(0,-1) -> out of bounds -> return false
recur(0,1) -> 'B'
   /      |      |      \
down     left    right    up
|
recur(1,1) -> 'F' -> mismatch
recur(0,0) -> already visited
recur(0,2) -> 'C'
   ...
(recurse continues for each valid move until the last character 'D' is matched)

Notes:
- Each level of the tree represents the next character in the word.
- Each branch represents moving in one of the four directions.
- Backtracking occurs when a branch cannot continue matching → restores the board for other paths.
- Leaf nodes that match the last character of the word return true.
*/


     public static boolean exist(char[][] board, String word) {
        int il = 0;
       for(int i = 0 ; i < board.length ; i++)
       {
            for(int j = 0 ; j < board[i].length ; j++)
            {
                if(board[i][j] == word.charAt(il))
                {
                    if(recur(board,word,i,j,il))
                    {
                        return true;
                    }
                }
            }
       }
       return false;
        
    }
    public static boolean recur(char[][] board , String word , int i , int j, int il)
    {  
        if( i < 0 || i >= board.length ||  j < 0 || j >= board[i].length || board[i][j] != word.charAt(il) || board[i][j] == '0' ){
            return false;
        }

        //basecase
        if(il == word.length()-1)
        {
            return true;
        }

        int di[] = {1,0,0,-1};
        int dj[] = {0,-1,1,0};
        char orig = board[i][j];
        board[i][j] = '0';
        for(int ind = 0 ; ind < 4 ; ind++)
        { 
           
            if(recur(board,word,i+di[ind],j+dj[ind],il+1))
            {
                board[i][j] = orig;
                return true;
            }
        }
        board[i][j] = orig;
        return false;
        
    }
}
