package main.menu;

public abstract class Menu implements IMenu{
    private String name;
    private MenuItemType type;
    private MenuItemKind kind;
    private double price;

    public Menu(String name){
        if(name.length()>0){
            this.name = name;
        }
        this.type = validateType();
        this.kind = validateKind();
        this.price = validatePrice();
    }

    abstract MenuItemType validateType();
    abstract double validatePrice();
    abstract MenuItemKind validateKind();


    public double getPrice() {
        return price;
    }

    @Override
    public MenuItemType getType() {
        return type;
    }

    @Override
    public MenuItemKind getKind() {
        return kind;
    }

    @Override
    public String getName() {
        return name;
    }

    public enum MenuItemType {
        DRINKS, FOODS
    }

    public enum MenuItemKind {
        SALAD, MAIN_COURSE, DESERT, SOFT_DRINK, ALCOHOL
    }
}
