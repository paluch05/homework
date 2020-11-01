package pl.orzechsoft.paluch.tasks.Task11;

import java.util.Scanner;

public class PeselLength {

    public static boolean checkPESEL(String pesel) {
        int[] weigth = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        if (pesel.length() != 11) return false;
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum += Integer.parseInt(pesel.substring(i, i + 1)) * weigth[i];
        int control = Integer.parseInt(pesel.substring(10, 11));
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;
        return (sum == control);
    }

    public static String checkList(String sell) {
        String item = "";
        if (BlackList.BLACK_LIST.contains(sell)) {
            item = "Sorry, we don't deal with this stuff";
        } else {
            item = "We can give you $4.20 for it, take it or leave it";
        }
        return item;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your PESEL here: ");
        String pesel = sc.nextLine();
        IfMature im = new IfMature();
        String dupa = im.mature(pesel);
        System.out.println(((checkPESEL(pesel)) ? dupa : "You tried to trick me you cheeky bastard!"));
        String sell = sc.nextLine();
        System.out.println(checkList(sell));
    }
}