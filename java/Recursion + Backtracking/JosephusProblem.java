import java.util.ArrayList;

public class JosephusProblem {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1 ; i <= n ; i++)
        {
            list.add(i);
        }
        System.out.println(recur(list,k,0));

        
    }
    /*
🧩 Problem: Josephus Problem
---------------------------------
Given n people standing in a circle (numbered 1 to n),
every k-th person is eliminated until only one survives.
Find the position of the survivor.

🎯 Example:
Input: n = 5, k = 2
People = [1, 2, 3, 4, 5]
Elimination order → 2, 4, 1, 5 → Survivor = 3


🧠 Approach:
-------------
1. Represent the people using an ArrayList (1 to n).
2. Use recursion to eliminate one person in each step:
     - Compute the index of the next person to remove:
           ind = (ind + (k - 1)) % list.size()
     - Remove that person from the circle.
     - Recurse on the reduced list with the updated index.
3. Base Case:
     - When only one person remains → return that person.

This effectively simulates the circular counting process.

⚙️ Time Complexity: O(n)
   - Each recursive call removes one element → n-1 removals
   - Each removal (ArrayList.remove) takes O(n) internally,
     but for conceptual understanding we consider O(n) overall.

💾 Space Complexity: O(n)
   - Due to recursion depth and the list storage.

---------------------------------
Recursion Visualization (n=5, k=2)
---------------------------------

Initial list: [1, 2, 3, 4, 5]
ind = 0

          recur([1,2,3,4,5],2,0)
                   |
                   v
     remove( (0+(2-1))%5 = 1 ) → remove 2
     list → [1,3,4,5]
                   |
                   v
          recur([1,3,4,5],2,1)
                   |
                   v
     remove( (1+(2-1))%4 = 2 ) → remove 4
     list → [1,3,5]
                   |
                   v
          recur([1,3,5],2,2)
                   |
                   v
     remove( (2+(2-1))%3 = 0 ) → remove 1
     list → [3,5]
                   |
                   v
          recur([3,5],2,0)
                   |
                   v
     remove( (0+(2-1))%2 = 1 ) → remove 5
     list → [3] ✅ Survivor found!

Answer → 3

/\ Recursive elimination continues until one remains.
*/



    public static int recur(ArrayList<Integer> list , int k , int ind)
    {
        if(list.size() == 1)
        {
            return list.get(0);
        }
        
        ind = (ind+(k-1))%list.size();
        list.remove(ind);
        
        return recur(list,k,ind);
    }
}

