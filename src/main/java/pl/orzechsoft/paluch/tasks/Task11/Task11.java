package pl.orzechsoft.paluch.tasks.Task11;

import java.util.Calendar;
import java.util.Scanner;

import static pl.orzechsoft.paluch.tasks.Task11.BlackList.BLACK_LIST;

public class Task11 {

    private static String pesel;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your PESEL here: ");
        pesel = sc.nextLine();
        String check = mature(pesel, Integer.parseInt(args[0]));
        System.out.println(checkPESEL() ? check : "You tried to trick me you cheeky bastard!");
        String sell = sc.nextLine();
        System.out.println(checkList(sell));
    }

    public static boolean checkPESEL() {
        int[] weigths = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        if (pesel.length() != 11) return false;
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum += Integer.parseInt(pesel.substring(i, i + 1)) * weigths[i];
        int control = Integer.parseInt(pesel.substring(10, 11));
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;
        return sum == control;
    }

    private static String mature(String pesel, int age) {
        int range = Integer.parseInt(pesel.substring(2, 3));
        int year = Integer.parseInt(pesel.substring(0, 2));
        Calendar cal = Calendar.getInstance();
        int currentYear = Integer.parseInt(String.valueOf(cal.get(Calendar.YEAR)).substring(2, 4));
        String message = "";
        if (range != 8 && range != 0 && range != 1) {
            if ((range == 2 || range == 4 || range == 6) && (currentYear - year) >= age) {
                message = "What do you want to sell?";
            } else {
                int difference = age - (currentYear - year);
                message = "Sorry, come back in " + difference + " years!";
            }
        } else {
            message = "What do you want to sell?";
        }
        return message;
    }

    public static String checkList(String sell) {
        if (BLACK_LIST.contains(sell)) {
            return "Sorry, we don't deal with this stuff";
        } else {
            return "We can give you $4.20 for it, take it or leave it";
        }
    }
}