package ru.HollowKaeden.task6;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        System.out.println("Фабричный метод:");
        Creator creator = new ConcreteCreator();
        creator.anOperation();

        System.out.println("Абстрактная фабрика:");
        AbstractFactory factory = new ConcreteFactory();
        AbstractProductA productA = factory.createProductA();
        AbstractProductB productB = factory.createProductB();
        productA.operationA();
        productB.operationB();

        System.out.println("Строитель:");
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        BuildProduct product = director.construct();
        product.show();

        System.out.println("Прототип:");
        Prototype prototype = new Prototype();
        Prototype clonedPrototype = (Prototype) prototype.clone();
        prototype.operation();
        clonedPrototype.operation();
    }
}