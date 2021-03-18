package main.menu;

public class Salad extends Food implements IVegan{
    public Salad(String name, int weight) {
        super(name, weight);
    }

    @Override
    int validateWeight(int weight) {
        if(weight>=300 && weight<=600){
            return weight;
        }
        else {
            return 300;
        }

    }

    @Override
    double validatePrice() {
        return 5;
    }

    @Override
    MenuItemKind validateKind() {
        return MenuItemKind.SALAD;
    }
}
