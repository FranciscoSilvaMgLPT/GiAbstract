package Game;

import java.util.Random;

public class Person {
    final String name;
    int foodLvl = 50;
    double cash;

    final int maxFoodLvl = 100;
    final int minFoodLvl = 0;

    public Person(String name, int cash) {
        this.name = name;
        this.cash = cash;
    }

    protected void goToWork() throws InterruptedException {
        Random rnd = new Random();
        int random = rnd.nextInt(10) + 1;
        System.out.println("WORKING");
        Thread.sleep(200);
        System.out.println("WORKING .");
        Thread.sleep(200);
        System.out.println("WORKING . .");
        Thread.sleep(200);
        System.out.println("WORKING . . .");
        Thread.sleep(200);
        System.out.println("Half a day has past. You got paid " + random + "€!");
        this.cash = this.cash + random;
        System.out.println("You now have " + this.cash + "€!");
        halfDayPass();
    }

    protected String seeInfo() {

        return this.name + ", " + this.foodLvl + " foodLvl, " + this.cash + "€";
    }

    protected void eat(Food food) {
        System.out.println("Hmmm you ate" + food.name + "! It has costed you " + food.price + "€!");
        this.foodLvl = this.foodLvl + food.foodLvlGain;
        if (this.foodLvl > 100) {
            System.out.println("🤮 Seems like you ate too much... You throw up(-10 foodLvl), and paid 10€ for the cleanance");
            this.foodLvl = this.foodLvl - 10;
            if (die()) {
                System.out.println("Welcome to heaven!");
            }
        }
    }


    protected void halfDayPass() {
        Random rnd = new Random();
        int random = rnd.nextInt(15) + 5;
        this.foodLvl = this.foodLvl - random;
        if (die()) {
            System.out.println("Hi! Welcome to heaven!");
            Game.persons.remove(this);
        }
    }

    private boolean die() {
        if (foodLvl < minFoodLvl) {
            return true;
        }
        return false;
    }

    protected String getName() {
        return name;
    }

    protected int getFoodLvl() {
        return foodLvl;
    }

    private void setFoodLvl(int foodLvl) {
        this.foodLvl = foodLvl;
    }

    private double getCash() {
        return cash;
    }

    private void setCash(double cash) {
        this.cash = cash;
    }
}
