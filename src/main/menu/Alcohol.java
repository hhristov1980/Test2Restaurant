package main.menu;

public class Alcohol extends Drinks implements IMenu,IGangster{
    public Alcohol(String name) {
        super(name);
    }

    @Override
    double validatePrice() {
        return 4;
    }

    @Override
    MenuItemKind validateKind() {
        return MenuItemKind.ALCOHOL;
    }


}
