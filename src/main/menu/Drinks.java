package main.menu;

public abstract class Drinks extends Menu{
    public Drinks(String name) {
        super(name);
    }

    @Override
    MenuItemType validateType() {
        return MenuItemType.DRINKS;
    }
}
