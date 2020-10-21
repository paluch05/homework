package pl.orzechsoft.justchecking.task71;

public class Task71 {
        public static String getString(){
            return "Ania";
        }
        public static int intLength() {
            return "Ania".length();
        }
        public static int moduloString() {
            return intLength() % 2;
        }
        public static void main(String[] args) {
            if ( intLength() % 2 != 0) {
                System.out.println(getString() + " has not an even number of characters");
            } else {
                System.out.println(getString() + " has an even number of characters");
            }}}