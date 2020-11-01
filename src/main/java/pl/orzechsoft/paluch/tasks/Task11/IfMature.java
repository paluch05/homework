package pl.orzechsoft.paluch.tasks.Task11;

import java.util.Calendar;

public class IfMature {
    public static String mature(String pesel) {
        int age = 18;
        int range = Integer.parseInt(pesel.substring(2, 3));
        int year = Integer.parseInt(pesel.substring(0, 2));
        Calendar cal = Calendar.getInstance();
        int currentYear = Integer.parseInt(String.valueOf(cal.get(Calendar.YEAR)).substring(2, 4));
        String cokolwiek = "";
        if (range != 8 && range != 0) {
            if (range == 2 && (currentYear - year) >= age) {
                cokolwiek = "What do you want to sell?";
            } else {
                int young = age - (currentYear - year);
                cokolwiek = "Sorry, come back in " + young;
            }
        } else {
            cokolwiek = "What do you want to sell?";
        }
        return cokolwiek;
    }

}
