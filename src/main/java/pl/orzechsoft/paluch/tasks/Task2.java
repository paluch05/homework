package pl.orzechsoft.paluch.tasks;

public class Task2 {
    public static void main(String[] args) {
        int a = getA();
        int b = getB();
        boolean isAdding = isAdding();

        printResult(a, b, isAdding);
    }

    private static void printResult(int a, int b, boolean isAdding) {
        if (isAdding) {
            System.out.println(a + " plus " + b + " is " + (a + b));
        } else {
            System.out.println(a + " minus " + b + " is " + (a - b));
        }
    }

    private static boolean isAdding() {
        return true;
    }

    private static int getB() {
        return 10;
    }

    private static int getA() {
        return 55;
    }
}
