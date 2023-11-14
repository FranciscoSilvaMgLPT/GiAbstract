package Game;

public class Hamburguer extends Food{

    public Hamburguer(String name, int foodLvlGain, double price) {
        super(name, foodLvlGain, price);
    }

    @Override
    public int getCalories() {
        return 10;
    }
}
