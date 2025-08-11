import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


//Online Stock span problem : 

/*
Approach for StockSpanner:

1. Maintain:
   - A stack to store indices of prices in a decreasing order (top always has latest greater price index).
   - A list to store all the stock prices for index-based access.

2. For each new price:
   a) Add the current price to the list.
   
   b) While the stack is not empty AND the price at stack’s top index is <= current price:
      → Pop the index from the stack (those days are included in the current span).

   c) If the stack is empty:
      → This means there is no greater price to the left, so set previousGreaterIndex = -1.
      Else:
      → Set previousGreaterIndex = index at stack’s top.
      
   d) Find currentIndex = last index in the list.
   e) Span = currentIndex - previousGreaterIndex.
   f) Push currentIndex onto the stack (for future comparisons).
   g) Return the span.

3. Why this works:
   - The stack always keeps track of the nearest greater price to the left.
   - By popping all smaller/equal prices, we directly find the previous greater day.
   - Each index is pushed and popped at most once → O(1) amortized per call.

4. Complexity:
   - Time Complexity: O(1) amortized for each next() call.
   - Space Complexity: O(n) for storing prices and stack indices.
*/

class StockSpanner{

    Stack<Integer>stack;
    ArrayList<Integer>list;

    public StockSpanner(){

        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        while(!stack.isEmpty() && list.get(stack.peek()) <= price)
        {
            stack.pop();
        }
        int previosuGreaterIndex = (stack.isEmpty())?-1:stack.peek();
        int currentIndex = list.size()-1;
        int ans = currentIndex - previosuGreaterIndex;
        stack.push(currentIndex);


        return ans;

    }
    
}

public class MonotonicStack {

    public static void main(String[] args) {

        StockSpanner spanner = new StockSpanner();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of stock prices:");
        int n = sc.nextInt();

        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) 
        {
            int price = sc.nextInt();
            int span = spanner.next(price);
            System.out.println("Stock span for " + price + " = " + span);
        }

        sc.close();
        
    }

}




