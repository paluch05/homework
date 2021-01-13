package pl.orzechsoft.paluch.tasks.Task25;

import java.util.Random;
import java.util.Scanner;

public class Task25 {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        String pw;
        String choices = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUWXYZ1234567890";
        StringBuilder guess = new StringBuilder();
        long tries = 0;
        int j, length;

        System.out.println("Enter a password: ");
        pw = "" + scan.nextLine();
        length = pw.length();

        System.out.println("Your pw is: " + pw);
        System.out.println("The length of your pw is: " + length);
        System.out.println("for TEST- Guess: " + guess + "pw: " + pw);

            if (!guess.toString().equals(pw)) {
                while  (!guess.toString().equals(pw)) {
                    j = 0;
                    guess = new StringBuilder();
                    while ( j < length ) {
                        guess.append(choices.charAt(rand.nextInt(choices.length())));
                        j = j + 1;
                        if (guess.toString().equals(pw)) {
                            System.out.println("Match found, ending loop..");
                            break;
                        }
                    }
                    System.out.println("2 Guess: " + guess + " pw: " + pw);
                    tries = tries + 1;
                }
            }
            System.out.println("Here is your password: " + guess);
            System.out.println("It took " + tries + " tries to guess it.");
    }
}
