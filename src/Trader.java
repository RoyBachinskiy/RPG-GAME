public class Trader {
    public void sell(Goods good, Hero hero) {
        if ((good == Goods.HEALTHPOTION_LVL1) && (hero.getGold() >= 5) && (hero.getHealth() < hero.startHealth)) {
            hero.setGold(hero.getGold() - 5);
            if ((hero.getHealth() + 20) > hero.startHealth)
                hero.setHealth(hero.startHealth);
            else hero.setHealth(hero.getHealth() + 20);
        } else System.out.println("Не хватает денег на зелье здоровья 1-го уровня");

        if ((good == Goods.HEALTHPOTION_LVL2) && (hero.getGold() >= 15) && (hero.getExp() >= 1000) && (hero.getHealth() < hero.startHealth)) {
            hero.setGold(hero.getGold() - 15);
            if ((hero.getHealth() + 50) > hero.startHealth)
                hero.setHealth(hero.startHealth);
            else hero.setHealth(hero.getHealth() + 50);
        } else System.out.println("Не хватает денег или опыта на зелье здоровья 2-го уровня");

        if ((good == Goods.HEALTHPOTION_LVL3) && (hero.getGold() >= 100) && (hero.getExp() >= 8000) && (hero.getHealth() < hero.startHealth)){
            hero.setGold(hero.getGold() - 100);
            if ((hero.getHealth() + 90) > hero.startHealth)
                hero.setHealth(hero.startHealth);
            else hero.setHealth(hero.getHealth() + 90);
    }
        else System.out.println("Не хватает денег или опыта на зелье здоровья 3-го уровня");

        if((good == Goods.ARMOR_LVL1) && (hero.getGold() >= 50)) {
            hero.setGold(hero.getGold() - 50);
            hero.startHealth *= 2;
            hero.setHealth(hero.getHealth() + (int) (0.5 * hero.getHealth()));
            if (hero.getHealth() > 200)
                hero.setHealth(200);
        }
        else System.out.println("Не хватает денег на броню 1-го уровня");

        if((good == Goods.ARMOR_LVL2) && (hero.getGold() >= 200) && (hero.getExp() >= 5000)){
            hero.setGold(hero.getGold() - 200);
            hero.startHealth *= 2;
            hero.setHealth(hero.getHealth() + (int) (0.5 * hero.getHealth()));
            if (hero.getHealth() > 400)
                hero.setHealth(400);
        }
        else System.out.println("Не хватает денег на броню 2-го уровня");

        if((good == Goods.ARMOR_LVL3) && (hero.getGold() >= 500) && (hero.getExp() >= 9000)){
            hero.setGold(hero.getGold() - 500);
            hero.startHealth *= 2;
            hero.setHealth(hero.getHealth() + (int) (0.5 * hero.getHealth()));
            if (hero.getHealth() > 800)
                hero.setHealth(800);
        }
        else System.out.println("Не хватает денег на броню 3-го уровня");

        if((good == Goods.SWORD) && (hero.getGold() >= 40)) {
            hero.setGold(hero.getGold() - 40);
            hero.setStrength(hero.getStrength() + 15);
            hero.setAgility(hero.getAgility() + 10);
        }
        else System.out.println("Не хватает денег на меч");

        if((good == Goods.AXE) && (hero.getGold() >= 120) && (hero.getExp() >= 5000)){
            hero.setGold(hero.getGold() - 120);
            hero.setStrength(hero.getStrength() + 20);
            hero.setAgility(hero.getAgility() + 15);
        }
        else System.out.println("Не хватает денег на топор");

        if((good == Goods.KATANA) && (hero.getGold() >= 300) && (hero.getExp() >= 10000)){
            hero.setGold(hero.getGold() - 300);
            hero.setStrength(hero.getStrength() + 20);
            hero.setAgility(hero.getAgility() + 15);
        }
        else System.out.println("Не хватает денег на катану");
    }

    public enum Goods{
        HEALTHPOTION_LVL1,
        HEALTHPOTION_LVL2,
        HEALTHPOTION_LVL3,
        ARMOR_LVL1,
        ARMOR_LVL2,
        ARMOR_LVL3,
        SWORD,
        AXE,
        KATANA


    }
}
