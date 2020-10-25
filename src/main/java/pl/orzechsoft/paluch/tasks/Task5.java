package pl.orzechsoft.paluch.tasks;

public class Task5 {
    public static void main(String[] args) {
        String s1 = getString();
        String s2 = getSecondString();
        boolean areOddEqual = isAreOddEqual();
        boolean areEvenEqual = isAreEvenEqual();
        halfEqual(s1, s2, areOddEqual, areEvenEqual);
    }

    private static String getString() {
        return "abcdef";
    }

    private static String getSecondString() {
        return "kbhdjf";
    }

    private static boolean isAreOddEqual() {
        return true;
    }

    private static boolean isAreEvenEqual() {
        return true;
    }

    private static void halfEqual(String s1, String s2, boolean areOddEqual, boolean areEvenEqual) {
        for (int i = 1; i <= s1.length() && i < s2.length(); i = i + 2) {
            areEvenEqual = s1.charAt(i - 1) == s2.charAt(i - 1) && areEvenEqual;
            areOddEqual = s1.charAt(i) == s2.charAt(i) && areOddEqual;
        }
        if (areEvenEqual || areOddEqual) {
            System.out.println("Half are equal!");
        }
    }
}