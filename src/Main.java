import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br;
    private static Hero player = null;
    private static Battle battlefield = null;
    private static Trader trader = null;
    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battlefield = new Battle();
        trader = new Trader();
        System.out.println("Enter name:");
        try{
            command(br.readLine());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void command(String word) throws IOException {
        if(player == null){
            player = new Hero(word, 100, 0, 20, 0,10);
            System.out.println(String.format("Появился герой по имени %s, готовый защищать обычных людей от монстров", word));
            printNavigationMenu();
            command(br.readLine());
        }
        switch(word){
            case "1": {
                startFight();
                break;
            }
            case "2": {
                startTrading();
                break;
            }
            case "3":
                System.exit(1);
            case "да":
                command("1");
                break;
            case "нет":{
                printNavigationMenu();
                command(br.readLine());
                break;
            }
        }

    }

    private static void startTrading() throws IOException{
        printTradingList();
        commandTrading(trader, br.readLine());
    }

    private static void commandTrading (Trader trader, String word) throws IOException {
        if (player.getExp() < 5000) {
            switch (word) {
                case "1": {
                    trader.sell(Trader.Goods.HEALTHPOTION_LVL1, player);
                    startTrading();
                    break;
                }
                case "2": {
                    trader.sell(Trader.Goods.ARMOR_LVL1, player);
                    startTrading();
                    break;
                }
                case "3": {
                    trader.sell(Trader.Goods.SWORD, player);
                    startTrading();
                    break;
                }
                case "4": {
                    printNavigationMenu();
                    command(br.readLine());
                    break;
                }
            }
        }
        else if ((player.getExp() >= 5000) && (player.getExp() < 10000)){
            switch (word) {
                case "1": {
                    trader.sell(Trader.Goods.HEALTHPOTION_LVL2, player);
                    startTrading();
                    break;
                }
                case "2": {
                    trader.sell(Trader.Goods.ARMOR_LVL2, player);
                    startTrading();
                    break;
                }
                case "3": {
                    trader.sell(Trader.Goods.AXE, player);
                    startTrading();
                    break;
                }
                case "4": {
                    printNavigationMenu();
                    command(br.readLine());
                    break;
                }
            }
        }
        else {
            switch (word) {
                case "1": {
                    trader.sell(Trader.Goods.HEALTHPOTION_LVL3, player);
                    startTrading();
                    break;
                }
                case "2": {
                    trader.sell(Trader.Goods.ARMOR_LVL3, player);
                    startTrading();
                    break;
                }
                case "3": {
                    trader.sell(Trader.Goods.KATANA, player);
                    startTrading();
                    break;
                }
                case "4": {
                    printNavigationMenu();
                    command(br.readLine());
                    break;
                }
            }
        }
    }

    private static void printTradingList() {
        System.out.printf("У вас %d/%d здоровья, %d ед. атаки, %d ед. ловкости \n", player.getHealth(), player.startHealth, player.getStrength(), player.getAgility());
        System.out.printf("%d ед. золота и %d ед. опыта\n", player.getGold(), player.getExp());
        if(player.getExp() < 5000){
            System.out.println("1. Зелье здоровье 1-го уровня (20 ед. золота) -> +20 ед. здоровья");
            System.out.println("2. Броня 1-го уровня (50 ед. золота) -> увеличение здоровья в 2 раза");
            System.out.println("3. Меч (40 ед. золота) -> +15 ед. к атаке и +10 к ловкости");
        }
        else if ((player.getExp() >= 5000) && (player.getExp() < 10000)){
            System.out.println("1. Зелье здоровье 2-го уровня (60 ед. золота, 1000 ед. опыта) -> +50 ед. здоровья");
            System.out.println("2. Броня 2-го уровня (200 ед. золота, 5000 ед. опыта) -> увеличение здоровья в 2 раза");
            System.out.println("3. Топор (240 ед. золота, 5000 ед. опыта) -> +20 ед. к атаке и +15 к ловкости");
        }
        else {
            System.out.println("1. Зелье здоровье 3-го уровня (150 ед. золота, 8000 ед. опыта) -> +90 ед. здоровья");
            System.out.println("2. Броня 3-го уровня (500 ед. золота, 15000 ед. опыта) -> увеличение здоровья в 2 раза");
            System.out.println("3. Катана (600 ед. золота, 12000 ед. опыта) -> +20 ед. к атаке и +15 к ловкости");
        }
        System.out.println("4. Выйти из лавки торговца");
    }

    private static void startFight() {
        battlefield.fight(createMonster(), player, new FightCallBack(){
            @Override
            public void fightWin(){
                System.out.println(String.format("Вы победили! Теперь у вас %d золота и %d опыта", player.getGold(), player.getExp()));
                System.out.println("Хотите продолжить поход? (да/нет)");
                try {
                    command(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost(){
                System.out.println("Конец игры.");
            }
        });
    }

    private static Creature createMonster() {
        if (player.getExp() < 5000){
            return createMonsterLvl1();
        } else if((player.getExp() >= 5000) && (player.getExp() < 10000))
            return createMonsterLvl2();
        else return createMonsterLvl3();
    }

    private static Creature createMonsterLvl1() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0){
            return new Skeleton("Скелет", 100, 50, 10, 100, 12);
        } else return new Goblin("Гоблин", 100, 75, 15, 200, 14);
    }
    private static Creature createMonsterLvl2() {
        int random = (int) (Math.random() * 10);
        if (random % 4 == 0){
            return new Skeleton("Скелет", 170, 100, 16, 500, 14);
        } else if(random % 4 == 1) return new Goblin("Гоблин", 180, 150, 17, 600, 16);
        else if (random % 4 == 2) return new Orc("Орк", 200, 125, 20, 500, 20);
        else return new Spider("Паук", 250, 150, 22, 600,22);
    }
    private static Creature createMonsterLvl3() {
        int random = (int) (Math.random() * 10);
        if (random % 4 == 0){
            return new Orc("Орк", 220, 150, 18, 600, 21);
        } else if (random % 4 == 1) return new Spider("Паук", 230, 180, 20, 700, 24);
        else if (random % 4 == 2) return new Troll("Тролль", 900, 300, 25, 1500, 40);
        else return new Urukhai("Урук-хай", 400, 250, 36, 1000, 30);
    }

    private static void printNavigationMenu() {
        System.out.println("Куда идём?");
        System.out.println("1. В лес");
        System.out.println("2. К торговцу");
        System.out.println("3. Выход из игры");
    }
    interface FightCallBack{
        void fightWin();
        void fightLost();
    }
}