package main.persons;

import main.restaurant.Order;
import java.util.HashMap;

public class Waiter extends Person{
    private HashMap<String,Order> listOfClientsOrders; //все пак клиент може да направи повече от 1 поръчка на теория
    private double tips;

    public Waiter(String name) {
        super(name);
        listOfClientsOrders = new HashMap<>();

    }

    public void takeClient(Client client, Order order){
        listOfClientsOrders.put(client.getName(),order);
    }
    public void takeTip(double money){
        if(money>0){
            tips+=money;
        }
    }

    public double makeBill(Client client){
        double bill = 0;
        if(listOfClientsOrders.get(client.getName())!=null){
            bill = listOfClientsOrders.get(client.getName()).calculatePrice();
            System.out.println(client.getName()+" bill is "+bill+" leva."); //Принципно трябва да пише Вашата сметка е ..., но за целта на прооверката е с име.
            return bill;
        }
        else {
            System.out.println("Your bill is zero as you haven't ordered anything!");
            return 0;
        }
    }

    public HashMap<String, Order> getListOfClientsOrders() {
        return listOfClientsOrders;
    }

    public double getTips() {
        return tips;
    }
}
