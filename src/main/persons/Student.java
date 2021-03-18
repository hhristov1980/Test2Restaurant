package main.persons;

import main.menu.IMenu;
import main.restaurant.Restaurant;
import main.util.Constants;


public class Student extends Client{

    public Student(String name, Restaurant restaurant) {
        super(name, restaurant);
    }


    @Override
    public IMenu checkRemainingCourses(IMenu item) {
        return item;
    }

    @Override
    int getMaxItems() {
        return Constants.MAX_ORDERS_PER_STUDENT;
    }

    @Override
    double validateMoney() {
        return 10;
    }
}
