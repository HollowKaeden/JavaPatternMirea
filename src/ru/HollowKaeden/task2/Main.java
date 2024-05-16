package ru.HollowKaeden.task2;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Human> list = new ArrayList<>();
        list.add(new Human(40,
                "Ivan",
                "Ivanov",
                LocalDate.of(1984, 8, 12),
                79));
        list.add(new Human(15,
                "Aleksey",
                "Artamonov",
                LocalDate.of(2009, 4, 27),
                85));
        list.add(new Human(22,
                "Elena",
                "Gochniy",
                LocalDate.of(2002, 12, 24),
                55));

        Stream<Human> stream;
        stream = list.stream();
        System.out.println("Список, отсортированный в обратном порядке по весу:");
        stream.sorted(Comparator.comparingInt(Human::getWeight).reversed()).forEach(System.out::println);


        stream = list.stream();
        System.out.println("Список, отфильтрованный по фамилии не Иванов:");
        stream.filter(human -> !human.getLastName().equals("Ivanov")).forEach(System.out::println);

        stream = list.stream();
        System.out.println("Список, отсортированный по возрасту:");
        stream.sorted(Comparator.comparingInt(Human::getAge)).forEach(System.out::println);

        stream = list.stream();
        System.out.print("Произведение всех возрастов: ");
        System.out.println(stream.mapToInt(Human::getAge).reduce((a, b) -> a * b).getAsInt());
    }
}
