package main.persons;

import main.menu.IMenu;
import main.menu.IVegan;
import main.menu.Menu;
import main.restaurant.Restaurant;
import main.util.Constants;

public class Vegan extends Client{

    public Vegan(String name, Restaurant restaurant) {
        super(name, restaurant);
    }

    @Override
    public IMenu checkRemainingCourses(IMenu item) {
        IVegan item1 = null;
        if(item.getKind().equals(Menu.MenuItemKind.SALAD)|| item.getKind().equals(Menu.MenuItemKind.SOFT_DRINK)){
            item1 = (IVegan) item;
        }
        return item1;
    }

    @Override
    int getMaxItems() {
        return Constants.MAX_ORDERS_PER_VEGAN;
    }


    @Override
    double validateMoney() {
        return 30;
    }
}
