package pl.orzechsoft.paluch.tasks;

public class Task9 {

    public static void main(String[] args) {


        String[] strArray = new String[10];

        strArray[0] = "this is element 0";
        strArray[1] = "this is element 1";
        strArray[2] = null;
        strArray[3] = strArray[1] + strArray[2];
        strArray[4] = "this is element 1";


        System.out.println(strArray[1]);

        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
        private static String getMyString ( int i){
            return "This is element number " + i;
        }


    }
}
