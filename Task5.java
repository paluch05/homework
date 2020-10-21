package pl.orzechsoft.homework5.task5;

public class Task5 {
    public static void main(String[] args) {
        String s1 = "AxLwAqMdAgKota200";
        String s2 = "KxOwBqOdJg";

        for (int i = 1; i < s2.length(); i = i + 2) {
            boolean areEqual = s1.charAt(i) == s2.charAt(i);
            System.out.println(s1.charAt(i) + "" + s2.charAt(i) + " " + "Half are equal!");
        }
        for (int i = 0; i < s2.length(); i = i + 2) {
            boolean areEqual = s1.charAt(i) == s2.charAt(i);
            System.out.println(s1.charAt(i) + "" + s2.charAt(i) + " " + areEqual);
        }
    }
}