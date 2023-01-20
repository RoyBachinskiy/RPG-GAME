public class Battle {
    public void fight(Creature attacker, Creature defender, Main.FightCallBack fightCallBack){
        Runnable runnable = () -> {
            int turn = 1;
            boolean isFightEnded = false;
            while (!isFightEnded){
                System.out.println("----Ход " + turn + " -------");
                if (turn++ % 2 == 0){
                    isFightEnded = makeHit(attacker, defender, fightCallBack);
                } else {
                    isFightEnded = makeHit(defender, attacker, fightCallBack);
                }
                try{
                    Thread.sleep(1000);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public boolean makeHit(Creature attacker, Creature defender, Main.FightCallBack fightCallBack) {
        int hit = attacker.attack();
        int defenderHealth = defender.getHealth() - hit;
        if(hit != 0){
            System.out.println(String.format("%s нанес урон в %d единиц", attacker.getName(), hit));
            System.out.println(String.format("У %s осталось %d единиц здоровья", defender.getName(), defenderHealth));
        } else{
            System.out.println(String.format("%s промахнулся", attacker.getName()));
        }
        if(defenderHealth <= 0 && defender instanceof Hero){
            System.out.println("К сожалению, вы проиграли...");
            fightCallBack.fightLost();
            return true;
        } else if (defenderHealth <= 0) {
            System.out.println(String.format("Монстр повержен! Вы получаете %d единиц опыта и %d золота", defender.getExp(), defender.getGold()));
            attacker.setExp(attacker.getExp() + defender.getExp());
            attacker.setGold(attacker.getGold() + defender.getGold());
            fightCallBack.fightWin();
            return true;
        } else {
            defender.setHealth(defenderHealth);
            return false;
        }
    }
}
