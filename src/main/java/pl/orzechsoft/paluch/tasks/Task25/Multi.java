package pl.orzechsoft.paluch.tasks.Task25;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multi {
    private static final char[] ALPHABET = "aeorisn1tl2md0cp3hbuk45g9687yfwjvzxqASERBTMLNPOIDCHGKFJUWYVZQX"
            .toCharArray();
    private static final char[] FIRST_CHAR_ALPHABET = "s1mpabctdrlfhgkjnw2ei0ov3q45796z8yuxSMPBACDTJRLFGHKNEWVIOZUQYX"
            .toCharArray();
    private static char[] pw;
    private static long start;

    public static void main(String[] args) {
        pw = args[0].toCharArray();
        start = System.nanoTime();
        concurrentBruteForce(pw.length);
    }

    public static void concurrentBruteForce(int length){
        int amountOfCores = Runtime.getRuntime().availableProcessors();
        ExecutorService e = Executors.newFixedThreadPool(amountOfCores);
        for(int i = 0; i < amountOfCores; i++){
            final int start = i * amountOfCores;
            final int end = Math.min((i + 1) * amountOfCores, ALPHABET.length);

            Thread t = new Thread(() -> {
                String found = firstPush(new char[length], start, length, end);
                if(!found.equals("")) {
                    found(found);
                    e.shutdownNow();
                }
            });
            e.execute(t);
        }
    }

    public static String firstPush(char[] b, int start, int length, int end){
        String result = "";
        for(int i = start; i < end; i++){
            b[0] = FIRST_CHAR_ALPHABET[i];
            result = push(b, 1, length);
            if (!result.equals("")) return result;
        }
        return result;
    }

    public static String push(char[] b, int index, int length){
        String result = "";
        for (char c : ALPHABET) {
            b[index] = c;
            if (index == length - 1) {
                if (Arrays.equals(b, pw)) {
                    System.out.println(new String(b));
                    result = new String(b);
                }
            } else {
                result = push(b, index + 1, length);
            }
            if (!result.equals("")) {
                return result;
            }
        }
        return result;
    }

    public static void found(String found){
        long end = System.nanoTime();
        double elapsed = (end-start)/1000000000.0;
        System.out.println("Found password: " + found + ", in: " + elapsed + "s.");
    }
}
