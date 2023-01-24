import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br;
    private static Creature player = null;
    private static Battle battlefield = null;
    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battlefield = new Battle();
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
            case "2": {
                System.out.println("Торговец еще не вышел на работу.");
                command(br.readLine());
            }
                break;
            case "3":
                System.exit(1);
            case "да":
                command("1");
                break;
            case "нет":{
                printNavigationMenu();
                command(br.readLine());
            }
            case "1":
                startFight();
        }

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
                System.out.println("Вы проиграли, не отчаивайтесь.");
            }
        });
    }

    private static Creature createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0){
            return new Skeleton("Скелет", 100, 400, 15, 500, 12);
        } else return new Goblin("Гоблин", 100, 800, 20, 600, 14);
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