package pl.orzechsoft.homework4.task4;

public class Task4 {
    public static void main(String[] args) {
        for (int i = 1; i < 151; i++)
            if (i % 3 != 0 ) {
                System.out.print(i + " ");
                if (i % 4 == 0) {
                    System.out.print("Zio");
                }
                if (i % 5 == 0) {
                    System.out.print("mek");
                }
                System.out.println();
            }
    }
}
