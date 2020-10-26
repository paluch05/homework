package pl.orzechsoft.paluch.tasks;

public class Task2 {
    public static void main(String[] args) {
        int a = getA();
        int b = getB();
        boolean isAdding = getIsAdding();
        printResult(a, b, isAdding);
    }

    private static int getA() {
        return 55;
    }

    private static int getB() {
        return 10;
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static void printResult(int a, int b, boolean isAdding) {
        if (isAdding) {
            System.out.println(a + " plus " + b + " is " + add(a, b));
        } else {
            System.out.println(a + " minus " + b + " is " + subtract(a, b));
        }

    }

    private static boolean getIsAdding() {
        return true;
    }
}