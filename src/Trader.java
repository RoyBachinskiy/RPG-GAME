public class Trader {
    public String sell(Goods good){
        String result = "";
        if(good == Goods.POTION)
            return result = "Potion";
        else return result;
    }

    public enum Goods{
        POTION
    }
}
