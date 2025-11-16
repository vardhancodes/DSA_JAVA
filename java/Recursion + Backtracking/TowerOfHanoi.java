public class TowerOfHanoi {
    public static void main(String[] args) {
        long []moves = new long[1];
        toh(3, 1, 2, 3, moves);
        System.out.println(moves[0]);

    }

// Approach for Tower of Hanoi
// --------------------------------------------------
// 1. Base Case:
//    - If there are 0 disks, just return (no moves needed).
//
// 2. Recursive Idea (Leap of Faith):
//    - Assume the function can correctly move N-1 disks.
//    - Focus only on handling the largest (Nth) disk.
//    - Trust recursion to do the smaller parts.
//
// 3. Steps to Solve:
//    a) Move N-1 disks from the source rod → auxiliary rod (using destination as helper).
//    b) Move the Nth (largest) disk from the source rod → destination rod.
//    c) Move the N-1 disks from the auxiliary rod → destination rod (using source as helper).
//
// 4. Counting Moves:
//    - Every time a disk is moved from one rod to another, increment the move counter.
//    - Total moves required = 2^N – 1.
//
// 5. Key Insight:
//    - The problem reduces into smaller subproblems.
//    - "Leap of Faith" in recursion means we don’t trace every step,
//      we just trust the recursive call to handle N-1 disks correctly.


    public static void  toh(int N, int from , int to , int aux, long[] moves)
    {
        if(N==0)
        {
            return;
        }
        moves[0]++;
        toh(N-1 , from , aux , to , moves);
        System.out.println("move disk "+N+ " from rod "+from+" to rod "+aux);
        toh(N-1 , aux , to , from , moves);
        
    }
}
