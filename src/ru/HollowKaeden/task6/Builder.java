package ru.HollowKaeden.task6;

class BuildProduct {
    private String part1;
    private String part2;

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public void show() {
        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}

interface Builder {
    void buildPart1();
    void buildPart2();
    BuildProduct getResult();
}

class ConcreteBuilder implements Builder {
    private BuildProduct product = new BuildProduct();

    @Override
    public void buildPart1() {
        product.setPart1("Part 1 built");
    }

    @Override
    public void buildPart2() {
        product.setPart2("Part 2 built");
    }

    @Override
    public BuildProduct getResult() {
        return product;
    }
}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public BuildProduct construct() {
        builder.buildPart1();
        builder.buildPart2();
        return builder.getResult();
    }
}