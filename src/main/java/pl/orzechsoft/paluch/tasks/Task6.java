package pl.orzechsoft.paluch.tasks;

public class Task6 {
    public static void main(String args[]) {
        int a = 0, b = 1, c;
        int whichFibonacciNumber = 5;
        getPrintln(whichFibonacciNumber);
    }

    public static int fib(int whichFibonacciNumber) {
        int c;
        return calc(whichFibonacciNumber, 0, 1);
    }

    private static int calc(int whichFibonacciNumber, int a, int b) {
        int c;
        if (whichFibonacciNumber == 0) {
            return a;
        }
        for (int i = 2; i <= whichFibonacciNumber; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    private static void getPrintln(int whichFibonacciNumber) {
        System.out.println(fib(whichFibonacciNumber));
    }
}