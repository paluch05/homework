package pl.orzechsoft.homework75.task75;

public class Task75 {

public static String myStringOne(){
    return "AxLwAqMdAgKota200";
}
public static String myStringTwo(){
    return "KxOwBqOdJg";
}
public static void main(String[] args) {
        for (int i = 1; i < myStringTwo().length(); i = i + 2) {
            boolean areEqual = myStringOne().charAt(i) == myStringTwo().charAt(i);
            System.out.println(myStringOne().charAt(i) + "" + myStringTwo().charAt(i) + " " + "Half are equal!");
        }
        for (int i = 0; i < myStringTwo().length(); i = i + 2) {
            boolean areEqual = myStringOne().charAt(i) == myStringTwo().charAt(i);
            System.out.println(myStringOne().charAt(i) + "" + myStringTwo().charAt(i) + " " + areEqual);
        }
    }
    }
