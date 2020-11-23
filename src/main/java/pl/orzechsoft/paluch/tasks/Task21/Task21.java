package pl.orzechsoft.paluch.tasks.Task21;

import java.util.*;
import java.util.stream.Collectors;

public class Task21 {

    public static void main(String[] args) {
        List<String> names = List.of("Marcin", "Adam", "Agata", "Anna", "Mateusz", "Wojtek", "Kasia", "Tomek", "Kamil",
                        "Maria", "Arkadiusz", "Przemysław", "Horacy", "Zofia", "Genowefa", "Serafin");
        Random random = new Random();
        List<Person> persons = names.stream().map(name -> new Person(name, random.nextInt(23 - 15) + 15)).collect(Collectors.toList());
        Set<Person> adults = persons.stream().filter(person -> (person.getAge() >= 18)).collect(Collectors.toSet());
        adults.forEach(adult -> {
                    System.out.println(adult.getName() + " is " + adult.getAge() + " years old.");
                });
    }
}
