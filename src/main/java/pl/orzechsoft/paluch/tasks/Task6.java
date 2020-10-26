package pl.orzechsoft.paluch.tasks;

public class Task6 {
    public static void main(String args[]) {
        int whichFibonacciNumber = getWhichFibonacciNumber();
        int fibonacciNumber = getFibonacciNumber(whichFibonacciNumber);
        printResult(fibonacciNumber);
    }

    private static int getWhichFibonacciNumber() {
        return 5;
    }

    private static int getFibonacciNumber(int whichFibonacciNumber) {
        int a = 0, b = 1;
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

    private static void printResult(int number) {

        System.out.println(number);
    }
}