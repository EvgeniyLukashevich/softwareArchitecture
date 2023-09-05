package ru.geekbrains.seminar2.models;

public class Ninja extends Fighter {

    protected Ninja(String name, int level) {
        this.name = name;
        this.level = level;
        this.health = 10 + level;
        this.type = "Ниндзя";
        leveling(level);
    }

    @Override
    protected void dealingDamage(Fighter enemy) {
        int heroAttackPoint = random.nextInt(this.agility + 1);
        int enemyDefensePoint = random.nextInt(enemy.defense + 1);
        int damage = 0;
        if (heroAttackPoint <= enemyDefensePoint)
            System.out.printf("%s не пробил защиту.\n", this.name);
        else if (enemyDefensePoint == 0) {
            damage = heroAttackPoint + random.nextInt(this.power + 1);
            enemy.takingDamage(damage);
            System.out.printf("%s нанёс критический удар.\n", this.name);
        } else {
            damage = heroAttackPoint - enemyDefensePoint;
            enemy.takingDamage(damage);
            System.out.printf("%s нанёс удар.\n", this.name);
        }
    }


    @Override
    protected void leveling(int level) {
        this.power = this.levelPoints * level;
        this.agility = this.levelPoints * level + this.bonusPoints;
        this.defense = this.levelPoints * level;
    }

}
