package problems;

public class Fibonacci {

    public int helperFibonacci(int n) {
        int[] memo = new int[n + 1];
        return getFibocacci(n, memo);
    }

    public int getFibocacci(int i, int[] memo) {
        System.out.println("Finding fobonacci for " + i);
        if (i == 1 || i == 0) {
            System.out.println("i is " + i + " so returning 1");
            return 1;
        }

        if (memo[i] == 0) {
            System.out.println("memo[i] is 0 so calculating lower trees.");
            memo[i] = getFibocacci(i - 1, memo) + getFibocacci(i - 2, memo);
            System.out.println("memo[" + i + "] is calculated=" + memo[i]);
        }
        System.out.println("memo[i] returning=" + memo[i]);
        return memo[i];
    }

    public static void main(String[] ar) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.helperFibonacci(5));
    }
}
