package pl.orzechsoft.homework5.task5;

public class Task5 {
    public static void main(String[] args) {
        String s1 = "aaaabb";
        String s2 = "ccccbb";
        boolean areOddEqual = true;
        boolean areEvenEqual = true;
        for (int i = 1; i <=s1.length(); i = i + 2){
            areEvenEqual = s1.charAt(i - 1) == s2.charAt(i - 1);
            areOddEqual = s1.charAt(i) == s2.charAt(i);
        System.out.println( areEvenEqual && areOddEqual);
    }
        for ( int i = 0; i < s1.length(); i = i +2){
            areEvenEqual = s1.charAt(i) == s2.charAt(i);
            System.out.println(areEvenEqual && areOddEqual);
        }

}}