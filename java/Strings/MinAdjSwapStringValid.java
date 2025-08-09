public class MinAdjSwapStringValid{

    public static void main(String[] args) {
        int ans = minSwap("[]][][");
        System.out.println(ans);
    }

//Minimum adjacent swaps for bracketbalancing

//Logic : Count how many extra closing brackets appear before an opening bracket.
//        Each time an opening bracket comes after extra closings, it needs swaps to fix them.
//        The total of these fixes is the minimum swaps required to balance the string.

//Approach:
// 1. Initialize counters:
//                    open → counts the number of '[' (open brackets) seen so far.
//                    close → counts the number of ']' (close brackets) seen so far.
//                    ubc (unbalanced close) → number of extra close brackets that haven’t yet been matched by an open bracket.
//                    swaps → total swaps needed to balance the string.

// 2. Loop through each character in the string:
//    a) If the character is '[':
//       - Increment open
//       - If ubc > 0 (there are unmatched ']'):
//           * Add ubc to swaps (each unmatched close will need a swap)
//           * Decrement ubc (one unmatched ']' is now fixed)
//
//    b) Else (character is ']'):
//       - Increment close
//       - Update ubc = close - open (difference is how many unmatched ']' remain)
//
// 3. After traversing the string, swaps contains the minimum number
//    of swaps required to balance the brackets.
//
// 4. Return swaps

public static int minSwap(String s)
{
    int open = 0, close = 0, ubc = 0, swaps = 0;

    for(int i = 0 ; i < s.length() ; i++)
    {
        char ch = s.charAt(i);

        if(ch == '[')
        {
            open++;
            if(ubc > 0)
            {
                swaps = ubc+swaps;
                ubc--;
            }
        }
        else
        {
            close++;
            ubc = close-open;
            
        }
    }

    return swaps;
}
}