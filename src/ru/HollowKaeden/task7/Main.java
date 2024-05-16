package ru.HollowKaeden.task7;

public class Main {
    public static void main(String[] args) {
        System.out.println("Компоновщик:");
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);
        composite.operation();
        System.out.println("Декоратор:");
        Component component = new ConcreteComponent();
        Component decoratedComponentA = new ConcreteDecoratorA(component);
        decoratedComponentA.operation();
        Component decoratedComponentB = new ConcreteDecoratorB(component);
        decoratedComponentB.operation();
    }
}
