package ru.geekbrains.seminar2.models;

public class SamuraiBuilder implements FighterBuilder {
    private String name;
    private int level;

    @Override
    public FighterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public FighterBuilder setLevel(int level) {
        this.level = level;
        return this;
    }

    @Override
    public Samurai build() {
        if (this.name == null || this.level < 1)
            throw new RuntimeException("Некорректные параметры создания персонажа.");
        else {
            System.out.printf("Самурай по имени %s успешно создан (уровень %d)\n\n", this.name, this.level);
            return new Samurai(this.name, this.level);
        }
    }


}
