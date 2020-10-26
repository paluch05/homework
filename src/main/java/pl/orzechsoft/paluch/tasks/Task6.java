package pl.orzechsoft.paluch.tasks;

public class Task6 {
    public static void main(String args[]) {
        int whichFibonacciNumber = 5;
        System.out.println(fib(whichFibonacciNumber));
    }

    private static int getA() {
        return 0;
    }

    private static int getB() {
        return 1;
    }

    private static void getC() {
        int c;
    }

    public static int fib(int whichFibonacciNumber) {
        int a = getA();
        int b = getB();
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
}