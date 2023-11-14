package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
     ArrayList<Person> persons = new ArrayList<>();
     ArrayList<Food> foods = new ArrayList<>();

    public void start() throws InterruptedException {
        foods.add(new Hamburguer("Hamburguer", 15, 7.6));
        foods.add(new Hamburguer("Hamburguer", 20, 8.5));
        System.out.println("Welcome");
        menu();
    }

    public void menu() throws InterruptedException {
        Person person = null;
        Scanner sc = new Scanner(System.in);
        int option = -1;
        String text;
        int cash;
        while (option != 0) {
            sc.reset();
            System.out.print("1-Play\n" +
                    "2-Create person\n" +
                    "0-Exit\n\n" +
                    "Option:");
            try {
                option = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e + "\nTry again!");
                sc.nextInt();
                menu();
            }
            switch (option) {
                case 1:
                    play(person);
                    break;
                case 2:
                    System.out.print("Insert name:");
                    text = sc.next();
                    System.out.print("Insert cash:");
                    cash = sc.nextInt();
                    person = createPerson(text, cash);
                    persons.add(person);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Ahm? Try again!");
                    Thread.sleep(500);
                    sc.nextInt();
                    menu();
            }
        }
    }

    private void play(Person person) throws InterruptedException {
        int option;
        Scanner sc = new Scanner(System.in);
        if (persons.size() > 0) {
            System.out.println(person.seeInfo());
            System.out.print("1-Eat\n2-Go to work\n3-Pass a day\nOptioN:");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    for (int i = 0; i < foods.size(); i++) {
                        System.out.println((i + 1) + foods.get(i).name + foods.get(i).price + "€," + foods.get(i).foodLvlGain + "foodlvlgain");
                    }
                    System.out.print("Food id:");
                    option = sc.nextInt()-1;
                    person.eat(foods.get(option));
                    break;
                case 2:
                    person.goToWork();
                    break;
                case 3:
                  if(  person.halfDayPass()){
                      System.out.println("A day has past.");
                  }else{
                      persons.remove(person);
                  }
                    break;
                case 4:
                    menu();
            }
        } else {
            System.out.println("First you need to create a person!");
            Thread.sleep(500);
            menu();
        }
    }

    private Person createPerson(String name, int cash) {
        System.out.println(name + " created with " + cash + "€!");
        return new Person(name, cash);
    }




}
