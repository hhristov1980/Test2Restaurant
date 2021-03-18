package main.menu;

public class Desert extends Food{
    public Desert(String name, int weight) {
        super(name, weight);
    }

    @Override
    int validateWeight(int weight) {
        if(weight>=200&&weight<=300){
            return weight;
        }
        else {
            return 200;
        }
    }

    @Override
    double validatePrice() {
        return 4;
    }

    @Override
    MenuItemKind validateKind() {
        return MenuItemKind.DESERT;
    }


}
