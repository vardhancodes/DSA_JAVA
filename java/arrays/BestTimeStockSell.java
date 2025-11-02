public class BestTimeStockSell {

//Approach:
// 1. Initialize a variable 'minCost' to store the minimum price so far (starting with prices[0]).
// 2. Initialize 'profit' as 0 to track the maximum profit obtained so far.
// 3. Loop through the prices array from index 1 to the end.
// 4. For each price:
//    - Calculate the possible profit by selling today (current price - minCost).
//    - Update 'profit' if this possible profit is greater than the current 'profit'.
//    - Update 'minCost' if the current price is smaller than the existing 'minCost'.
// 5. After the loop ends, return the maximum 'profit' found.
// 6. This ensures we buy at the lowest price before selling at the highest possible price later.
// 7. Time Complexity: O(n)
// 8. Space Complexity: O(1)

    public static void main(String[] args) {
     
        int arr[] = {7,1,5,3,6,4};

        int profit = 0;
        int minCost = arr[0];

        for(int i = 1 ; i < arr.length ; i++)
        {
            profit = Math.max(profit,arr[i]-minCost);
            minCost = Math.min(minCost,arr[i]);
        }

        System.out.println(profit);
    }
}