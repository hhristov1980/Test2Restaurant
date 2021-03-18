package main.menu;

public abstract class Food extends Menu{
    private int weight;
    public Food(String name, int weight) {
        super(name);
        this.weight = validateWeight(weight);

    }


    @Override
    MenuItemType validateType() {
        return MenuItemType.FOODS;
    }

    abstract int validateWeight(int weight);
}
