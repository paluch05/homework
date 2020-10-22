package pl.orzechsoft.homework6.task6;

public class Task6 {
    public static void main(String args[]){
        int whichFibonacciNumber = 5;
        System.out.println(fib(whichFibonacciNumber));
    }

    public static int fib(int whichFibonacciNumber){
        int a = 0, b = 1, c;
        if (whichFibonacciNumber == 0) {
            return a;
        }
        for (int i = 2; i <= whichFibonacciNumber; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}