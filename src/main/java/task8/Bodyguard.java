package task8;

public class Bodyguard {
    public static void main(String[] args) {
        String password = "PawianyWchodzaNaSciany";
        int iq = 160;
        if (check(password, iq)) {
            System.out.println("Zapraszam");
        }
    }

    private static boolean check(String password, int iq) {
        boolean isEqual = PasswordChecker.checkPassword(password);
        if (isEqual && iq > 130) {
            return true;
        } else {
            return false;
        }
    }
}
