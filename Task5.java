package pl.orzechsoft.homework5.task5;

public class Task5 {
    public static void main(String[] args) {
        String s1 = "AxLwAqMdAgKota200";
        String s2 = "KxOwBqOdJg";
        boolean areOddEqual = true;
        boolean areEvenEqual = true;
        for (int i = 1; i < s2.length() && i < s1.length(); i = i + 2) {
            areOddEqual = s1.charAt(i) == s2.charAt(i);
            areEvenEqual = s1.charAt(i - 1) == s2.charAt(i - 1);
        }
        if (areEvenEqual || areOddEqual) {
            System.out.println("Half are equal!");
        }
    }
}