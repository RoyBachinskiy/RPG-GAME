import java.util.Random;

public class Creature {
    private String name;
    private int health;
    private int gold;
    private int agility;
    private int exp;
    private int strength;

    public Creature(String name, int health, int gold, int agility, int exp, int strength) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.agility = agility;
        this.exp = exp;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int attack(){
        if(agility * 3 > getRandomNumber(100)) return strength;
        else return 0;
    }

    private int getRandomNumber(int roof) {
        return new Random().nextInt(roof + 1);
    }

    @Override
    public String toString(){
        return String.format("%s health: %d", name, health);
    }
}
