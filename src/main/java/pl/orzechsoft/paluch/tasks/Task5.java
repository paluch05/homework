package pl.orzechsoft.paluch.tasks;

public class Task5 {
    public static void main(String[] args) {
        halfEqual(getString(), getSecondString(), true, true);
        print(true || true);
    }

    private static String getString() {
        return "abcdef";
    }

    private static String getSecondString() {
        return "kbhdjf";
    }

    private static boolean halfEqual(String s1, String s2, boolean areEvenEqual, boolean areOddEqual) {
        for (int i = 1; i <= s1.length() && i < s2.length(); i = i + 2) {
            areEvenEqual = s1.charAt(i - 1) == s2.charAt(i - 1) && areEvenEqual;
            areOddEqual = s1.charAt(i) == s2.charAt(i) && areOddEqual;
        }
        return areEvenEqual || areOddEqual;
    }

    private static void print(boolean result) {
        if (result) {
            System.out.println("Half are equal!");
        }
    }
}