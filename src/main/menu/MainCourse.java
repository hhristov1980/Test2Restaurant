package main.menu;

public class MainCourse extends Food implements IGangster{
    public MainCourse(String name, int weight) {
        super(name, weight);
    }

    @Override
    int validateWeight(int weight) {
        if(weight>=400&& weight<=800){
            return weight;
        }
        else {
            return 400;
        }
    }

    @Override
    double validatePrice() {
        return 9;
    }

    @Override
    MenuItemKind validateKind() {
        return MenuItemKind.MAIN_COURSE;
    }
}
