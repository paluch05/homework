package pl.orzechsoft.paluch.tasks;

public class Task5 {
    public static void main(String[] args) {
        String s1 = getString();
        String s2 = getSecondString();
        halfEqual(s1, s2);
    }

    private static String getString() {
        return "abcdef";
    }

    private static String getSecondString() {
        return "kbhdjf";
    }

    private static void halfEqual(String s1, String s2) {
        boolean areOddEqual = true;
        boolean areEvenEqual = true;
        for (int i = 1; i <= s1.length() && i < s2.length(); i = i + 2) {
            areEvenEqual = s1.charAt(i - 1) == s2.charAt(i - 1) && areEvenEqual;
            areOddEqual = s1.charAt(i) == s2.charAt(i) && areOddEqual;
        }
        if (areEvenEqual || areOddEqual) {
            System.out.println("Half are equal!");
        }
    }
}