package main.restaurant;

import main.menu.IMenu;
import main.persons.Client;

import java.util.ArrayList;
import java.util.Objects;

public class Order {
    private static int orderId = 1;
    private int orderNumber;
    private Client client;
    private ArrayList<IMenu> listOfFoodAndDrinks;

    public Order(Client client){
        this.client = client;
        this.orderNumber = orderId++;
        listOfFoodAndDrinks = new ArrayList<>();
    }

    public void addFoodOrDrink(IMenu item){
        listOfFoodAndDrinks.add(item);
    }
    public double calculatePrice(){
        double orderPrice = 0;
        for(IMenu item: listOfFoodAndDrinks){
            orderPrice+=item.getPrice();
        }
        return orderPrice;
    }

    public ArrayList<IMenu> getListOfFoodAndDrinks() {
        return listOfFoodAndDrinks;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber);
    }
}
