package pl.orzechsoft.paluch.tasks;

public class Task10 {

    public static void main(String[] args) {
        printArray(getArray(3, 20));
    }

    private static int[] getArray(int initialNumber, int size) {
        int[] myArray = new int[size];
        myArray[0] = initialNumber;
        for (int i = 1; i < myArray.length; i++) {
            myArray[i] = myArray[i - 1] * 2;
        }
        return myArray;
    }

    private static void printArray(int[] myArray) {
        System.out.print(myArray[0]);
        for (int i = 1; i < myArray.length; i++) {
            System.out.print(", " + myArray[i]);
        }
    }
}
