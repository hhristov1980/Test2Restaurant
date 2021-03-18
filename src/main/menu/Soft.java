package main.menu;

public class Soft extends Drinks implements IVegan{
    public Soft(String name) {
        super(name);
    }

    @Override
    double validatePrice() {
        return 2;
    }

    @Override
    MenuItemKind validateKind() {
        return MenuItemKind.SOFT_DRINK;
    }


}
