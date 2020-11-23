package pl.orzechsoft.paluch.tasks.Task18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task18 {

    public static final String DATABASE_FILE = "file.txt";
    public static final char DELIMITER = ':';

    public static void main(String[] args) throws IOException {
        System.out.println(getById(4));
        System.out.println(find("Innego"));
    }

    private static String getById(long id) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(DATABASE_FILE))) {
            return lines.filter(line -> Long.parseLong(getId(line)) == id).map(line -> getContent(line)).findFirst().get();
        }
    }

    private static String find(String word) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(DATABASE_FILE))) {
            return lines.map(line -> getContent(line)).filter(line -> line.toLowerCase().contains(word.toLowerCase())).findFirst().get();
        }
    }

    private static String getContent(String entry){
        return entry.substring(entry.indexOf(DELIMITER) + 1);
    }

    private static String getId(String entry){
        return entry.substring(0, entry.indexOf(DELIMITER));
    }
}