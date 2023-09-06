package ru.geekbrains.seminar2;

import ru.geekbrains.seminar2.models.*;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Random random = new Random();

        // С помощью Builder и Director создадим персонажа и финального босса.
        // Также создадим заготовку для рядовыч соперников, которых необходимо победить,
        // чтобы добраться до босса.

        int heroLevel = 10;
        int bossLevel = 15;

        FighterBuilder builder1 = new NinjaBuilder();
        BuilderDirector director1 = new BuilderDirector(builder1);
        Fighter hero = director1.createFighter("Жан-Клод", heroLevel);

        FighterBuilder builder2 = new SamuraiBuilder();
        BuilderDirector director2 = new BuilderDirector(builder2);
        Fighter finalBoss = director2.createFighter("Сильвестр", bossLevel);

        FighterBuilder builder3;
        BuilderDirector director3;
        Fighter enemy;


        // Установим количество схваток, в которых нужно одержать победу, чтобы открыть доступ к финальной схватке

        int numberOfRounds = 3;
        boolean lose = false;


        // Предварительный турнир (с установленным ранее количеством схваток).
        // В каждой схватке будет генерироваться соперник с уровнем в диапазоне:
        // [уровень нашего персонажа - 3, уровень нашего персонажа + 1].

        for (int i = 0; i < numberOfRounds; i++) {

            int enemyLevel = random.nextInt(heroLevel - 3, heroLevel + 2);

            if (random.nextInt(2) == 1)
                builder3 = new SamuraiBuilder();
            else
                builder3 = new NinjaBuilder();

            director3 = new BuilderDirector(builder3);
            enemy = director3.createFighter("Соперник" + (i + 1), enemyLevel);

            // В случае поражения нашего персонажа, турнир заканчивается и,
            // соответственно, становится недоступен финальный босс.

            System.out.printf("### СХВАТКА %d ###\n", i + 1);
            System.out.printf("%s vs %s\n\n", hero.getName(), enemy.getName());
            while (true) {
                hero.attack(enemy);
                if (enemy.getHealth() <= 0) {
                    System.out.printf("%s победил!\n\n", hero.getName());
                    break;
                }
                enemy.attack(hero);
                if (hero.getHealth() <= 0) {
                    System.out.printf("%s проиграл!\n\n", hero.getName());
                    lose = true;
                    break;
                }
            }

            hero.relax();

            if (lose) {
                System.out.printf("%s не смог добраться до босса.\n", hero.getName());
                break;
            }
        }

        // Если же предварительный турнир успешно пройден, начинается финальная схватка

        if (!lose) {
            System.out.println("### ФИНАЛЬНАЯ СХВАТКА ###");
            System.out.printf("%s vs %s\n\n", hero.getName(), finalBoss.getName());
            while (true) {
                hero.attack(finalBoss);
                if (finalBoss.getHealth() <= 0) {
                    System.out.printf("%s победил!\n\n", hero.getName());
                    break;
                }
                finalBoss.attack(hero);
                if (hero.getHealth() <= 0) {
                    System.out.printf("%s проиграл!\n\n", hero.getName());
                    break;
                }
            }
        }
    }
}
