public class Trader {
    private boolean Armor1IsBought = false;
    private boolean Armor2IsBought = false;
    private boolean Armor3IsBought = false;
    private boolean SwordIsBought = false;
    private boolean AxeIsBought = false;
    private boolean KatanaIsBought = false;


    public void sell(Goods good, Hero hero) {
        switch (good) {
            case AXE: {
                axeSelling(good, hero);
                break;
            }
            case SWORD: {
                swordSelling(good, hero);
                break;
            }
            case KATANA: {
                katanaSelling(good, hero);
                break;
            }
            case ARMOR_LVL1: {
                armor1Selling(good, hero);
                break;
            }
            case ARMOR_LVL2: {
                armor2Selling(good, hero);
                break;
            }
            case ARMOR_LVL3: {
                armor3Selling(good, hero);
                break;
            }
            case HEALTHPOTION_LVL1: {
                potion1Selling(good, hero);
                break;
            }
            case HEALTHPOTION_LVL2: {
                potion2Selling(good, hero);
                break;
            }
            case HEALTHPOTION_LVL3: {
                potion3Selling(good, hero);
                break;
            }

        }
    }
    private int potion1Selling(Goods good, Hero hero){
        if (good == Goods.HEALTHPOTION_LVL1) {
            if (hero.getHealth() >= hero.startHealth){
                System.out.println("Вам не нужно зелье здоровье, с Вами и так все в порядке.");
                return 0;
            }
            if (hero.getGold() >= 20)
                hero.setGold(hero.getGold() - 20);
            else {
                System.out.println("Не хватает денег на зелье здоровья 1-го уровня");
                return 0;
            }
            if ((hero.getHealth() + 20) > hero.startHealth) {
                hero.setHealth(hero.startHealth);
            } else {
                hero.setHealth(hero.getHealth() + 20);
            }
            return 1;
        }
        return 1;
    }

    private int potion2Selling(Goods good, Hero hero){
        if ((good == Goods.HEALTHPOTION_LVL2) && (hero.getExp() >= 1000)) {
            if (hero.getHealth() >= hero.startHealth){
                System.out.println("Вам не нужно зелье здоровье, с Вами и так все в порядке.");
                return 0;
            }
            if (hero.getGold() >= 60)
                hero.setGold(hero.getGold() - 60);
            else {
                System.out.println("Не хватает денег на зелье здоровья 2-го уровня");
                return 0;
            }
            if ((hero.getHealth() + 50) > hero.startHealth) {
                hero.setHealth(hero.startHealth);
                return 1;
            }
            else {
                hero.setHealth(hero.getHealth() + 50);
                return 1;
            }
        }
        return 1;
    }

    private int potion3Selling(Goods good, Hero hero){
        if ((good == Goods.HEALTHPOTION_LVL3) && (hero.getExp() >= 8000)){
            if (hero.getHealth() >= hero.startHealth){
                System.out.println("Вам не нужно зелье здоровье, с Вами и так все в порядке.");
                return 0;
            }
            if (hero.getGold() >= 150)
                hero.setGold(hero.getGold() - 150);
            else {
                System.out.println("Не хватает денег на зелье здоровья 3-го уровня");
                return 0;
            }
            if ((hero.getHealth() + 90) > hero.startHealth) {
                hero.setHealth(hero.startHealth);
            }
            else hero.setHealth(hero.getHealth() + 90);
            return 1;
        }
        return 1;
    }

    private int armor1Selling(Goods good, Hero hero){
        if((good == Goods.ARMOR_LVL1) && (hero.getGold() >= 50)) {
            if(!Armor1IsBought) {
                System.out.println("Вы не можете купить броню 1-го уровня, т.к. она уже у вас есть.");
                return 0;
            }
            hero.setGold(hero.getGold() - 50);
            hero.startHealth *= 2;
            hero.setHealth(hero.getHealth() + (int) (0.5 * hero.getHealth()));
            if (hero.getHealth() > 200)
                hero.setHealth(200);
            Armor1IsBought = true;
            return 1;
        }
        else{
            System.out.println("Вы не можете купить броню 1-го уровня.");
            return 0;
        }
    }

    private int armor2Selling(Goods good, Hero hero){
        if((good == Goods.ARMOR_LVL2) && (hero.getGold() >= 200) && (hero.getExp() >= 5000)){
            if(!Armor2IsBought) {
                System.out.println("Вы не можете купить броню 2-го уровня, т.к. она уже у вас есть.");
                return 0;
            }
            hero.setGold(hero.getGold() - 200);
            hero.startHealth *= 2;
            hero.setHealth(hero.getHealth() + (int) (0.5 * hero.getHealth()));
            if (hero.getHealth() > 400)
                hero.setHealth(400);
            Armor2IsBought = true;
            return 1;
        }
        else{
            System.out.println("Вы не можете купить броню 2-го уровня");
            return 0;
        }
    }

    private int armor3Selling(Goods good, Hero hero){
        if((good == Goods.ARMOR_LVL3) && (hero.getGold() >= 500) && (hero.getExp() >= 15000)){
            if(!Armor3IsBought) {
                System.out.println("Вы не можете купить броню 3-го уровня, т.к. она уже у вас есть.");
                return 0;
            }
            hero.setGold(hero.getGold() - 500);
            hero.startHealth *= 2;
            hero.setHealth(hero.getHealth() + (int) (0.5 * hero.getHealth()));
            if (hero.getHealth() > 800)
                hero.setHealth(800);
            Armor3IsBought = true;
            return 1;
        }
        else{
            System.out.println("Вы не можете купить броню 3-го уровня");
            return 0;
        }
    }

    private int swordSelling(Goods good, Hero hero){
        if((good == Goods.SWORD) && (hero.getGold() >= 40)) {
            if(!SwordIsBought) {
                System.out.println("Вы не можете купить меч, т.к. она уже у вас есть.");
                return 0;
            }
            hero.setGold(hero.getGold() - 40);
            hero.setStrength(hero.getStrength() + 15);
            hero.setAgility(hero.getAgility() + 10);
            SwordIsBought = true;
            return 1;
        }
        else {
            System.out.println("Вы не можете купить меч");
            return 0;
        }
    }

    private int axeSelling(Goods good, Hero hero){
        if((good == Goods.AXE) && (hero.getGold() >= 240) && (hero.getExp() >= 5000)){
            if(!AxeIsBought) {
                System.out.println("Вы не можете купить топор, т.к. она уже у вас есть.");
                return 0;
            }
            hero.setGold(hero.getGold() - 120);
            hero.setStrength(hero.getStrength() + 20);
            hero.setAgility(hero.getAgility() + 15);
            AxeIsBought = true;
            return 1;
        }
        else {
            System.out.println("Вы не можете купить топор");
            return 0;
        }
    }

    private int katanaSelling(Goods good, Hero hero){
        if((good == Goods.KATANA) && (hero.getGold() >= 600) && (hero.getExp() >= 12000)){
            if(!KatanaIsBought) {
                System.out.println("Вы не можете купить катану, т.к. она уже у вас есть.");
                return 0;
            }
            hero.setGold(hero.getGold() - 300);
            hero.setStrength(hero.getStrength() + 20);
            hero.setAgility(hero.getAgility() + 15);
            KatanaIsBought = true;
            return 1;
        }
        else {
            System.out.println("Вы не можете купить катану");
            return 0;
        }
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
