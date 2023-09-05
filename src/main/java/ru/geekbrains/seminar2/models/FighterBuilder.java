package ru.geekbrains.seminar2.models;

/**
 * Базовый интерфейс Билдера для подклассов абстрактного класса Fighter
 */
public interface FighterBuilder {
    public FighterBuilder setName(String name);
    public FighterBuilder setLevel(int level);

    /**
     * Основной метод, собирающий экземпляр нужного класса с помощью установленных значений
     * @return
     */
    public Fighter build();

}
