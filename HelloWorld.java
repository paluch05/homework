package pl.orzechsoft.course.helloworld;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        String name = "Ania";
        int len = name.length();
        int modulo = len % 2;
        if ( modulo == 1 ){
            System.out.println(name + " has not an even number of characters");
        } else {
            System.out.println(name + " has an even number of characters");
        }
    }
}
