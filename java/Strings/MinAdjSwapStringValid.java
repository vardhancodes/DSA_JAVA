public class MinAdjSwapStringValid{

    public static void main(String[] args) {
        int ans = minSwap("[]][][");
        System.out.println(ans);
    }

//Minimum adjacent swaps for bracketbalancing

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