package pl.orzechsoft.paluch.tasks;

public class Task6 {
    public static void main(String args[]) {
        int whichFibonacciNumber = 5;
        System.out.println(fib(whichFibonacciNumber));
    }

    public static int fib(int whichFibonacciNumber) {
        int a = 0, b = 1, c;
        if (getInteger(whichFibonacciNumber, a) != null) return getInteger(whichFibonacciNumber, a);
        return getB(whichFibonacciNumber, a, b);
    }

    private static Integer getInteger(int whichFibonacciNumber, int a) {
        if (whichFibonacciNumber == 0) {
            return a;
        }
        return null;
    }

    private static int getB(int whichFibonacciNumber, int a, int b) {
        int c;
        for (int i = 2; i <= whichFibonacciNumber; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}