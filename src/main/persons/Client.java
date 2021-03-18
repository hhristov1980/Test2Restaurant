package main.persons;


import main.menu.IMenu;
import main.menu.Menu;
import main.restaurant.Order;
import main.restaurant.Restaurant;
import main.util.Randomizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class Client extends Person{
    protected Waiter waiter;
    private double money;
    private Restaurant restaurant;
    public Client(String name, Restaurant restaurant) {
        super(name);
        this.money = validateMoney();
        this.restaurant = restaurant;

    }
    abstract double validateMoney();;
    abstract IMenu checkRemainingCourses(IMenu item);
    abstract int getMaxItems();
    public double askForBill() {
        return waiter.makeBill(this);
    }
    //Иска сметката, плаща я и евентуално дава бакшиш
    public void payBill() {
        if(waiter!=null){
            double billToPay = askForBill();
            restaurant.receiveMoney(billToPay);
            money-=billToPay;
            System.out.println(getName()+" paid "+ billToPay+ " leva bill!.");
            if(Randomizer.getRandomInt(0,100)<=80){
                double tip = billToPay*Randomizer.getRandomInt(5,10)/100;
                if(tip<=money){
                    money-=tip;
                    System.out.println(getName()+" paid "+ tip+ " leva tip to "+waiter.getName());
                    waiter.takeTip(tip);
                }
            }
        }
    }

    public double getMoney() {
        return money;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public Waiter getWaiter() {
        return waiter;
    }
    public void makeOrder(){
        ArrayList<IMenu> items = new ArrayList<>();
        for(Map.Entry<Menu.MenuItemType, HashMap<Menu.MenuItemKind, LinkedList<IMenu>>> m: getRestaurant().getFullMenu().entrySet()){
            for (Map.Entry<Menu.MenuItemKind, LinkedList<IMenu>> i: m.getValue().entrySet()){
                for(IMenu iMenu: i.getValue()){
                    if(checkRemainingCourses(iMenu)!=null){
                        items.add(checkRemainingCourses(iMenu));
                    }
                }
            }
        }
        if(items.isEmpty()){
            System.out.println("Sorry. No more drinks and food in the restaurant.");
        }
        else {
            double moneyToSpend = getMoney()*0.9;
            Order order = new Order(this);
            int counter = 0;
            while (true){
                if(counter== getMaxItems()){
                    break;
                }
                if(items.isEmpty()){
                    System.out.println("Sorry. No more drinks and food in the restaurant.");
                    break;
                }
                int choice = Randomizer.getRandomInt(0,items.size()-1);
                if(moneyToSpend<2){
                    System.out.println("Sorry. No more money to spend.");
                    break;
                }
                if(items.get(choice).getPrice()<=moneyToSpend){
                    order.addFoodOrDrink(items.get(choice));
                    System.out.println(getName()+" ordered "+items.get(choice).getName()+" for "+items.get(choice).getPrice()+ " leva.");
                    moneyToSpend-=items.get(choice).getPrice();
                    items.remove(choice);
                    counter++;
                }

            }
            ArrayList<Waiter> waiters = new ArrayList<>();
            waiters.addAll(getRestaurant().getWaiters());
            waiter = waiters.get(Randomizer.getRandomInt(0,waiters.size()-1));
            waiter.takeClient(this,order);
        }
    }
}
