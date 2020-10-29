package pl.orzechsoft.paluch.tasks;

public class Task10 {

    public static void main(String[] args) {

        printArray(getArray());
    }

    private static int[] getArray() {
        int[] myArray = new int[10];
        int initialNumber = 2;
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
