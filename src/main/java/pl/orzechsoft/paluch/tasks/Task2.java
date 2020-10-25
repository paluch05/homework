package pl.orzechsoft.paluch.tasks;

public class Task2 {
    public static void main(String[] args) {
        int a = getA();
        int b = getB();
        boolean isAdding = isAdding();
        boolean subtract = subtract();

        isAdding(a, b, isAdding, " plus ", a + b);
        subtract(a, b, subtract, " minus ", a - b);
    }

    private static int getA() {
        return 55;
    }

    private static int getB() {
        return 10;
    }

    private static boolean isAdding() {
        return true;
    }

    private static boolean subtract() {
        return true;
    }

    private static void isAdding(int a, int b, boolean isAdding, String s, int i) {
        if (isAdding) {
            System.out.println(a + s + b + " is " + (i));
        }
    }

    private static void subtract(int a, int b, boolean subtract, String s, int i) {
        if (subtract) {
            System.out.println(a + s + b + " is " + (i));
        }
    }
}