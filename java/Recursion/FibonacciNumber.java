public class FibonacciNumber {
    public static void main(String[] args) {
        
    int ans = fib(7);
    System.out.println(ans);
    }



//Fibonacci Number:

    public static int fib(int n) {
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return 1;
        }
        int res = fib(n-1) + fib(n-2);
        return res;
    }
}

