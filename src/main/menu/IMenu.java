package main.menu;

public interface IMenu {
    double getPrice();
    Menu.MenuItemType getType();
    Menu.MenuItemKind getKind();
    String getName();
}
