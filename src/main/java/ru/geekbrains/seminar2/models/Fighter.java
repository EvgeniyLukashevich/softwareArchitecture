package ru.geekbrains.seminar2.models;

import java.util.Random;

/**
 * Базовый абстрактный класс
 */
public abstract class Fighter {
    protected String name;
    protected String type;
    protected int health;
    protected int level;
    protected int levelPoints = 3;
    protected int bonusPoints = 2;
    protected int power;
    protected int agility;
    protected int defense;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getPower() {
        return power;
    }

    public int getAgility() {
        return agility;
    }

    public int getDefense() {
        return defense;
    }

    protected Random random = new Random();

    /**
     * Метод нанесения урона
     * @param enemy объект одного из подклассов класса Fighter
     */
    protected abstract void dealingDamage(Fighter enemy);

    /**
     * Метод получения урона
     * @param damage - количество нанесенного урона
     */
    protected void takingDamage(int damage) {
        this.health = this.health - damage;
    };

    /**
     * Метод распределения характеристики, исходя из указанного уровня
     * @param level уровень персонажа
     */
    protected abstract void leveling(int level);

    /**
     * Метод проведения аттаки
     * @param enemy объект одного из подклассов класса Fighter
     */
    public void attack(Fighter enemy) {
        if (random.nextInt(this.agility+1) < random.nextInt(enemy.agility+1))
            System.out.printf("%s промахнулся\n", this.name);
        else
            dealingDamage(enemy);
    }

}
