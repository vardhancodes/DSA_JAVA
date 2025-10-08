
/* 
BACKTRACKING - SHORT NOTES

1. Definition:
   - Backtracking is a technique for solving problems recursively 
     by trying all possible options and abandoning solutions 
     that fail (pruning).

2. When to Use:
   - Problems with constraints and multiple possibilities:
     * Permutations / Combinations
     * N-Queens, Sudoku
     * Subset / Subsequence problems
     * Maze / Path finding

3. Steps:
   1. Choose: Pick a choice from the set of options.
   2. Explore: Recursively move forward with the choice.
   3. Un-choose (Backtrack): Undo the choice to explore other options.

4. Key Ideas:
   - Base case: Stop recursion when solution is complete or invalid.
   - Pruning: Skip branches that cannot lead to a valid solution.
   - Recursive tree: Each node represents a choice, edges represent options.

5. Tips:
   - Use a helper function with parameters representing the state.
   - Keep track of the current path / solution.
   - Undo changes after recursive calls to restore state.
   - Use arrays / sets to track availability / used elements.

6. Example Patterns:
   - Generating all subsets:
       backtrack(start, path):
           save(path)
           for i in range(start, n):
               path.add(nums[i])
               backtrack(i+1, path)
               path.remove(nums[i])
   - N-Queens:
       place queen in a row, check validity, recurse to next row, backtrack.

7. Complexity:
   - Worst case: Exponential O(k^n) where k = choices per step, n = steps
   - Optimizations reduce the search space (pruning, constraints checking)
*/
