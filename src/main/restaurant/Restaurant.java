package main.restaurant;

import main.menu.*;
import main.persons.*;
import main.util.Constants;
import main.util.Randomizer;

import java.util.*;

public class Restaurant {
    private String name;
    private String address;
    private double capital;
    private HashSet<Waiter> waiters;
    private HashSet<Client>clients;
    private HashMap<Menu.MenuItemType, HashMap<Menu.MenuItemKind, LinkedList<IMenu>>> fullMenu;

    public Restaurant(String name, String address){
        if(name.length()>0){
            this.name = name;
        }
        if(address.length()>0){
            this.address = address;
        }
        this.capital = 1000.0;
        waiters = new HashSet<>();
        clients = new HashSet<>();
        fullMenu = new HashMap<>();
        for(int i = 0; i<5; i++) {
            waiters.add(new Waiter(Constants.NAMES[Randomizer.getRandomInt(0, Constants.NAMES.length - 1)]+i));
        }
    }

    public void work(){
        takeOrders();
        clientsAskToPay();
        printMoneyAtClosing();
        printWaiters();
        printRemainingItemsInTheMenu();
    }

    public void makeMenuForToday(){
        for(int i = 0; i<10; i++){
            Salad salad = new Salad("Shopska", 350);
            MainCourse mixGrill = new MainCourse("Mix Grill",600);
            Desert tiramisu = new Desert("Tiramisu", 250);
            addToMenu(salad);
            addToMenu(mixGrill);
            addToMenu(tiramisu);
        }
        for (int i = 0; i<20;i++){
            Soft coke = new Soft("Coke Cola");
            Alcohol beer = new Alcohol("Heineken");
            addToMenu(coke);
            addToMenu(beer);
        }

    }

    public void openForClients(Client client){
        clients.add(client);
    }

    public HashMap<Menu.MenuItemType, HashMap<Menu.MenuItemKind, LinkedList<IMenu>>> getFullMenu() {
        return fullMenu;
    }

    public HashSet<Waiter> getWaiters() {
        return waiters;
    }

    public void receiveMoney(double money){
        if(money>0){
            this.capital+=money;
        }
    }

    private void takeOrders(){
        for (Client c: clients){
            c.makeOrder();
            if(c.getWaiter()!=null && c.getWaiter().getListOfClientsOrders().get(c.getName()).getListOfFoodAndDrinks()!=null){
                deliverItemsToClient(c);
            }
        }
    }

    private void clientsAskToPay(){
        for(Client c: clients){
            c.payBill();
        }
    }


    //трием от менюто поръчаните неща
    private void deliverItemsToClient(Client client){
        for(IMenu item: client.getWaiter().getListOfClientsOrders().get(client.getName()).getListOfFoodAndDrinks()){
            if(item!=null){
                fullMenu.get(item.getType()).get(item.getKind()).remove(0);
            }
        }
    }

    private void printMoneyAtClosing(){
        System.out.println("-------------------------");
        System.out.println("The restaurant of "+name+" has "+capital+" after closing");
    }

    public void printRemainingItemsInTheMenu(){
        System.out.println("-------------------------");
        System.out.println("Remaining foods and drinks:");
        for (Map.Entry<Menu.MenuItemType,HashMap<Menu.MenuItemKind,LinkedList<IMenu>>> menu: fullMenu.entrySet()){
            System.out.println("======= "+menu.getKey()+" =======");
            ArrayList<Map.Entry<Menu.MenuItemKind,LinkedList<IMenu>>> list = new ArrayList<>();
            list.addAll(menu.getValue().entrySet());
            Collections.sort(list,((o1, o2) -> Integer.compare(o2.getValue().size(),o1.getValue().size())));

            for(Map.Entry<Menu.MenuItemKind,LinkedList<IMenu>> a:list){
                System.out.println(a.getKey()+": "+a.getValue().size()+" items.");
            }
        }
    }

    private void printWaiters(){
        ArrayList<Waiter> listOfWaiters = new ArrayList<>();
        listOfWaiters.addAll(waiters);
        Collections.sort(listOfWaiters,((o1, o2) -> Double.compare(o2.getTips(), o1.getTips())));
        System.out.println("-------------------------");
        System.out.println("The waiter with most tips is "+listOfWaiters.get(0).getName());
        for (Waiter w: listOfWaiters){
            System.out.println(String.format("Name: %s tips amount: %.2f",w.getName(),w.getTips()));
        }
    }

    private void addToMenu(IMenu item){
        if(!fullMenu.containsKey(item.getType())){
            fullMenu.put(item.getType(), new HashMap<>());
        }
        if(!fullMenu.get(item.getType()).containsKey(item.getKind())){
            fullMenu.get(item.getType()).put(item.getKind(), new LinkedList<>());
        }
        fullMenu.get(item.getType()).get(item.getKind()).add(item);
    }
}
