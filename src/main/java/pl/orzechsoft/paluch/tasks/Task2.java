package pl.orzechsoft.paluch.tasks;

public class Task2 {
    public static void main(String[] args) {
        int a = getA();
        int b = getB();
        isAdding(a, b);
    }

    private static int getA() {
        return 55;
    }

    private static int getB() {
        return 10;
    }

    private static int add(int a, int b) {
        return (a + b);
    }

    private static int subtract(int a, int b) {
        return (a - b);
    }

    private static void isAdding(int a, int b) {
        boolean isAdding = true;
        if (isAdding) {
            System.out.println(a + " plus " + b + " is " + add(a, b));
        } else {
            System.out.println(a + " minus " + b + " is " + subtract(a, b));
        }

    }
}