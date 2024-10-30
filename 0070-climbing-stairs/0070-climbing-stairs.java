class Solution {
    static int[] fib;
    
    public int climbStairs(int n) {
        fib= new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        fibonacci(n);

        return fib[n] + fib[n - 1];
    }

    public int fibonacci(int n) {
        if (n == 0) return 0;
        if(fib[n] != 0 ) return fib[n];

        else return fib[n] = fibonacci(n - 1) + fibonacci(n - 2);

    }
    
}