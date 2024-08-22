package problems;

public class Factorial {
    
    public int getFactorial (int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        return getFactorial(num - 1) * num;
    }


    public static void main ( String [] ar) {
        Factorial f = new Factorial();
        System.out.println(f.getFactorial(5));
    }
}
