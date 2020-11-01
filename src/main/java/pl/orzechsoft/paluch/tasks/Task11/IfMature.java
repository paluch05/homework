package pl.orzechsoft.paluch.tasks.Task11;

import java.util.Calendar;

public class IfMature {
    public static String mature(String pesel) {
        int age = 18;
        int range = Integer.parseInt(pesel.substring(2, 3));
        int year = Integer.parseInt(pesel.substring(0, 2));
        Calendar cal = Calendar.getInstance();
        int currentYear = Integer.parseInt(String.valueOf(cal.get(Calendar.YEAR)).substring(2, 4));
        String selling = "";
        if (range != 8 && range != 0) {
            if (range == 2 && (currentYear - year) >= age) {
                selling = "What do you want to sell?";
            } else {
                int young = age - (currentYear - year);
                selling = "Sorry, come back in " + young;
            }
        } else {
            selling = "What do you want to sell?";
        }
        return selling;
    }
}