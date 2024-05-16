package ru.HollowKaeden.task8;

public class Main {
    public static void main(String[] args) {
        System.out.println("Итератор:");
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.add("Item 1");
        aggregate.add("Item 2");
        aggregate.add("Item 3");
        Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Посредник:");
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);
        mediator.addColleague(colleagueA);
        mediator.addColleague(colleagueB);
        colleagueA.send("Hello from Colleague A");
        colleagueB.send("Hi from Colleague B");
    }
}