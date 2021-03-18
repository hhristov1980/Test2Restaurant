package main.persons;

import main.menu.IGangster;
import main.menu.IMenu;
import main.menu.Menu;
import main.restaurant.Restaurant;
import main.util.Constants;

public class Gangster extends Client{

    public Gangster(String name, Restaurant restaurant) {
        super(name, restaurant);
    }

    @Override
    public IMenu checkRemainingCourses(IMenu item) {
        IGangster item1 = null;
        if(item.getKind().equals(Menu.MenuItemKind.MAIN_COURSE)|| item.getKind().equals(Menu.MenuItemKind.ALCOHOL)){
            item1 = (IGangster) item;
        }
        return item1;
    }

    @Override
    int getMaxItems() {
        return Constants.MAX_ORDERS_PER_GANGSTER;
    }

    @Override
    double validateMoney() {
        return 50;
    }

}
