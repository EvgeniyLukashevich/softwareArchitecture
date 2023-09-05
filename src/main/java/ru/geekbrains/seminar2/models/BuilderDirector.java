package ru.geekbrains.seminar2.models;

/**
 * Директор, руководящий Билдером при сборке нужного класса
 */
public class BuilderDirector {
    private FighterBuilder builder;

    public BuilderDirector(FighterBuilder builder) {
        this.builder = builder;
    }

    public Fighter createFighter (String name, int level) {
        return this.builder.setName(name).setLevel(level).build();
    }
}
