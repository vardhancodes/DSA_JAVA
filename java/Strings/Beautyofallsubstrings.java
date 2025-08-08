public class Beautyofallsubstrings {
    public static void main(String[] args) {
        int ans = beautySum("aabcb");
        System.out.println(ans);
        
    }

//Sum of beauty of all substrings

// Logic : Beauty = Maximum frequency of any character - Minimum frequency of any character (excluding characters with 0 frequency)

// Approach : Loop through all starting indices of substrings.
//            For each start, keep a frequency count of characters.
//            Extend the substring by moving the end index forward.
//            Update character frequency.
//            Find max and min (non-zero) frequency in the current substring.
//            Add (max - min) to total sum.
//            Repeat for all substrings.
//            Return the total beauty sum.



public static int beautySum(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] arr = new int[26];

            for (int j = i; j < s.length(); j++) {
                arr[s.charAt(j) - 97] += 1;

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (arr[k] > 0) {
                        if (arr[k] > max) max = arr[k];
                        if (arr[k] < min) min = arr[k];
                    }
                }

                ans += (max - min);
            }
        }

        return ans;
    }
}
