public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

/*
    🧠 Moore’s Voting Algorithm – Explanation

    Goal:
    --------
    Find the majority element in an array — 
    the element that appears more than n/2 times.

    Approach / Logic:
    -----------------
    1. Candidate Selection:
       - Start by choosing the first element as a potential majority candidate (Melement).
       - Initialize count = 1.

    2. Iterate through the array:
       - If the current element matches the candidate → increment count (count++).
       - If it’s different → decrement count (count--).
       - If count becomes 0:
           → It means the previous candidate is “balanced out” by other elements.
           → Select the current element as the new candidate and reset count = 1.

    3. Final Majority:
       - After one complete traversal, the element stored in Melement 
         will be the majority candidate.
       - Since the problem guarantees a majority element, 
         we can directly return Melement without further verification.

    Intuition:
    -----------
    Think of it like a voting process:
    - The majority element gains more votes.
    - Every different element cancels out one vote.
    - The element that survives till the end is the true majority.

    Complexity:
    ------------
    Time Complexity: O(n)    → single pass through the array
    Space Complexity: O(1)   → only a few variables used
*/
public static int majorityElement(int[] nums) {
        int count = 1;
        int Melement = nums[0];

        for(int i = 1 ; i < nums.length ; i++)
        {
            if(count == 0)
            {
                Melement = nums[i];
                count = 1;
            }
            else 
            {
                if(Melement == nums[i])
                {
                    count++;
                }
                else
                {
                    count--;
                }
            }
           
        }
        return Melement;
    }
}
