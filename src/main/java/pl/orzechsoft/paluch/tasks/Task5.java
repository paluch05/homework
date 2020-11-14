package pl.orzechsoft.paluch.tasks;

public class Task5 {
    public static void main(String[] args) {
        boolean halfEqual = halfEqual("abcdef", "kbhdjf");
        print(halfEqual);
    }

    public static boolean halfEqual(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Any of Strings can't be null");
        }
        boolean areEvenEqual = true;
        boolean areOddEqual = true;
        for (int i = 1; i <= s1.length() && i < s2.length(); i = i + 2) {
            areEvenEqual = s1.charAt(i - 1) == s2.charAt(i - 1) && areEvenEqual;
            areOddEqual = s1.charAt(i) == s2.charAt(i) && areOddEqual;
        }
        return areEvenEqual || areOddEqual;
    }

    public static void print(boolean result) {
        if (result) {
            System.out.println("Half are equal!");
        }
    }
}