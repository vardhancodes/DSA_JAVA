public class PowerOfThree{
    public static void main(String[] args) {
        System.out.println(recur(76));
    }

// Problem: Check if a given number n is a power of 3
//
// Approach:
//
// 1. Powers of 3 are numbers like 1, 3, 9, 27, 81, ... 
//    (i.e., numbers that can be written as 3^k for some integer k >= 0).
//
// 2. First check for invalid input:
//    - If n <= 0, immediately return false (negative numbers and zero are not powers of 3).
//
// 3. Base cases:
//    - If n == 1 → return true, because 1 = 3^0 which is a valid power of 3.
//    - If n is not divisible by 3 (n % 3 != 0) → return false, because 
//      all powers of 3 must be divisible by 3 except 1.
//
// 4. Recursive step:
//    - Keep dividing n by 3 and call the function again.
//    - If the recursion eventually reduces n to 1, return true.
//    - If at any step n is not divisible by 3, return false.
//
// 5. Example walkthroughs:
//    - n = 27 → 27 → 9 → 3 → 1 → true
//    - n = 45 → 45 → 15 → 5 (not divisible by 3) → false

    public static boolean recur(int n)
    {
        if(n==1)
        {
            return true;
        }
        if( n%3 != 0)
        {
            return false;
        }
        return recur(n/3);
    }
}