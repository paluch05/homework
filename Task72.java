package pl.orzechsoft.homework72.taks72;

public class Task72 {
public static int intOne(){
    return 55;
}
public static int intTwo(){
    return 10;
}
public static boolean isAdding(){
    return true;
}

    public static void main(String[] args) {
        if (isAdding()) {
            System.out.println(intOne() + " plus " + intTwo() + " is " + (intOne() + intTwo()));
        } else {
            System.out.println(intOne() + " minus " + intTwo() + " is " + (intOne() - intTwo()));
    }}}
