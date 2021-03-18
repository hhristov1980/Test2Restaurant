package main;

import main.persons.Gangster;
import main.persons.Student;
import main.persons.Vegan;
import main.restaurant.Restaurant;
import main.util.Constants;
import main.util.Randomizer;

public class Demo {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Pesho Talanta", "Sofia 1000");
        restaurant.makeMenuForToday();
        for (int i = 0; i<15; i++){
            int typeOfClient = Randomizer.getRandomInt(1,10);
            if(typeOfClient>=1&&typeOfClient<=2){
                restaurant.openForClients(new Vegan(Constants.NAMES[Randomizer.getRandomInt(0,Constants.NAMES.length-1)]+i,restaurant));
            }
            else if(typeOfClient>=3&&typeOfClient<=5){
                restaurant.openForClients(new Student(Constants.NAMES[Randomizer.getRandomInt(0,Constants.NAMES.length-1)]+i,restaurant));
            }
            else if(typeOfClient>=6&&typeOfClient<=10){
                restaurant.openForClients(new Gangster(Constants.NAMES[Randomizer.getRandomInt(0,Constants.NAMES.length-1)]+i,restaurant));
            }
        }
        restaurant.work();


    }


}
