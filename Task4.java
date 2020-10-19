package pl.orzechsoft.homework4.task4;

public class Task4 {
    public static void main(String[] args) {
        for (int i = 1; i < 151; i++) {
            if (i % 3 != 0 ) {
                if ( i % 4 == 0 ) {
                    if (i % 5 == 0) {
                        System.out.println(i + " mek");
                    } else {
                        System.out.println(i + " Zio");
                    }
                }
                else if (( i % 5 == 0 ) && ( i % 4 != 0 )) {
                        System.out.println(i + " mek");}
                else {
                    System.out.println(i);
                }
                }


            }
        }
        }

