package pl.orzechsoft.paluch.tasks;

import java.util.ArrayList;
import java.util.List;

public class Task9 {

    public static void main(String[] args) {
        haveSameElements(getArray(), getList());
        printResult(true);
    }

    private static String[] getArray() {
        String[] myArray = new String[3];
        myArray[0] = "a";
        myArray[1] = "b";
        myArray[2] = "c";
        return myArray;
    }

    private static List<String> getList() {
        List<String> myList = new ArrayList<>();
        myList.add("a");
        myList.add("b");
        return myList;
    }

    private static boolean haveSameElements(String[] myArray, List<String> myList) {
        boolean areEqual = true;
        for (int i = 0; i < myArray.length && i < myList.size(); i++) {
            if (!myArray[i].equals(myList.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static void printResult(boolean areEqual) {
        System.out.println(areEqual);
    }
}