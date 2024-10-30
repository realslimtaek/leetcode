class Solution {
    static int[] fib = new int[46];
    
    public int climbStairs(int n) {
        Arrays.fill(fib,-1);
        fib[0] = 0;
        fib[1] = 1;
        fibonacci(n);

        return fib[n] + fib[n - 1];
    }

    public int fibonacci(int n) {
        if(fib[n] != -1 ) return fib[n];

        else return fib[n] = fibonacci(n - 1) + fibonacci(n - 2);

    }
    
}