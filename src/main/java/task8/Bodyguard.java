package task8;

public class Bodyguard {
    public static void main(String[] args) {
        String password = "PawianyWchodzaNaSciany";
        int iq = 140;
        check(password, iq);
        PasswordChecker.checkPassword();
    }

    private static void check(String password, int iq) {
        if ((password.equals("PawianyWchodzaNaSciany")) && iq > 130) {
        } else {
            System.out.println("Wypad!");
        }
    }
}