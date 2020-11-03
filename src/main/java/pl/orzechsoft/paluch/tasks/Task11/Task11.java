package pl.orzechsoft.paluch.tasks.Task11;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Task11 {

    private static String pesel;
    private static final List<String> BLACK_LIST = List.of("Zakazany przedmiot 1", "Glock", "Marijuana");
    private static final int AGE = 18;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your PESEL here: ");
        pesel = sc.nextLine();
        String check = mature(pesel, 18);
        System.out.println(((checkPESEL()) ? check : "You tried to trick me you cheeky bastard!"));
        String sell = sc.nextLine();
        System.out.println(checkList(sell));
    }

    public static boolean checkPESEL() {
        int[] weigth = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        if (pesel.length() != 11) return false;
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum += Integer.parseInt(pesel.substring(i, i + 1)) * weigth[i];
        int control = Integer.parseInt(pesel.substring(10, 11));
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;
        return sum == control;
    }

    private static String mature(String pesel, int AGE) {
        AGE = 18;
        int range = Integer.parseInt(pesel.substring(2, 3));
        int year = Integer.parseInt(pesel.substring(0, 2));
        Calendar cal = Calendar.getInstance();
        int currentYear = Integer.parseInt(String.valueOf(cal.get(Calendar.YEAR)).substring(2, 4));
        String matureOrNot = "";
        if (range != 8 && range != 0 && range != 1) {
            if ((range == 2 || range == 4 || range == 6) && (currentYear - year) >= AGE) {
                matureOrNot = "What do you want to sell?";
            } else {
                int difference = AGE - (currentYear - year);
                matureOrNot = "Sorry, come back in " + difference + " years!";
            }
        } else {
            matureOrNot = "What do you want to sell?";
        }
        return matureOrNot;
    }

    public static String checkList(String sell) {
        if (BLACK_LIST.contains(sell)) {
            return "Sorry, we don't deal with this stuff";
        } else {
            return "We can give you $4.20 for it, take it or leave it";
        }
    }
}