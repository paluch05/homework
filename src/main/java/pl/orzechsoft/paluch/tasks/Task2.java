package pl.orzechsoft.paluch.tasks;

public class Task2 {
    public static void main(String[] args) {
        int a = getA();
        int b = getB();
        isAdding(getA(), getB());
        isSubtracting(getA(), getB());
    }

    private static int getA() {
        return 55;
    }

    private static int getB() {
        return 10;
    }

    private static void isAdding(int a, int b) {
        if (true) {
            System.out.println(a + " plus " + b + " is " + (a + b));
        }
    }

    private static void isSubtracting(int a, int b) {
        if (false) {
            System.out.println(a + " minus " + b + " is " + (a - b));
        }
    }
}