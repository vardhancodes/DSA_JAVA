public class Leetcode2125{
    public static void main(String[] args) {
        String[] bank = {"011001","000000","010100","001000"};
        int ans = numberOfBeams(bank);
        System.out.println(ans);
    }
    /*
1️⃣  Problem Understanding:
    - Each row in the `bank` represents a floor with security devices marked as '1'.
    - A laser beam is formed between every pair of devices in two *different rows*
      — BUT only if both rows contain at least one device.
    - No beam passes through a row with 0 devices.

2️⃣  Example:
    Input: ["011001", "000000", "010100", "001000"]
    - Row 0 has 3 devices
    - Row 1 has 0 devices → ignored
    - Row 2 has 2 devices
    - Row 3 has 1 device
    => Beams = (3*2) + (2*1) = 8

3️⃣  Approach:
    - Count devices ('1') in each row.
    - Maintain a variable `prevcount` for the previous row’s device count.
    - For each row:
         • Count the number of '1's (call it `countdev`).
         • If `countdev == 0`, skip it (since lasers can’t pass through).
         • Otherwise, total beams added = `prevcount * countdev`.
         • Then update `prevcount = countdev` for the next iteration.

4️⃣  Time Complexity:
    - O(m * n), where m = number of rows, n = number of columns.

5️⃣  Space Complexity:
    - O(1), using only counters.
*/

public static int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        int ans = 0;
        int prevcount = 0;
        for(int i = 0 ; i < n ; i++)
        {
            char ch = bank[0].charAt(i);
            if(ch == '1')
            {
                prevcount++;
            }
        }
        for(int i = 1; i < m ; i++)
        {
            int countdev = 0;
            for(int j = 0 ; j < n ; j++)
            {
                char ch = bank[i].charAt(j);
                if(ch == '1')
                {
                    countdev++;
                }
            }
            if(countdev == 0)
            {
                continue;
            }
            if(prevcount != 0)
            {
                ans+=prevcount*countdev; 
            }
            prevcount = countdev;
            
        }
        return ans;
    }

}