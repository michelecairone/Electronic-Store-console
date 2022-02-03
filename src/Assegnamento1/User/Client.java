package Assegnamento1.User;

import java.io.*;
import java.util.*;

import Assegnamento1.Product.ElettronicDevice;

/**
 * The class {@code Client } inherit from Person
 * is used to represent  Client entity.
 */
public final class Client extends Person {

    /**
     * Class fields.
     * address - It is the address of the client.
     * shop - It is the shopping cart of various clients.
     */
    private String address;
    private final List<ElettronicDevice> shop = new ArrayList<>();

    /**
     * Class constructor.
     *
     * @param name     It is the Client's name.
     * @param surname  It is the Client's surname.
     * @param username It is the Client's username.
     * @param password It is the Client's password.
     * @param address  It is the Client's address.
     */
    public Client(final String name, final String surname, final String username, final String password, final String address) {

        super(name, surname, username, password);
        this.setAddress(address);

    }

    /**
     * This method is used to get the Client's address.
     *
     * @return It returns the Client's address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * This method is used to set the Client's address.
     *
     * @param address is the Client's address.
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * This method is used to search for products.
     *
     * @param list It is the ElettronicDevice list.
     * @throws IOException None.
     */
    public void searchProduct(final List<ElettronicDevice> list) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float minPrice = 0, maxPrice = 0;
        List<ElettronicDevice> elprint = new ArrayList<>();

        System.out.println("Insert product name: ");
        String name = br.readLine();

        System.out.println("Insert  producer: ");
        String producer = br.readLine();

        System.out.println("Insert  minimum price: ");
        String str = br.readLine();

        if (str.equals("")) minPrice = 0;
        else {

            try {
                minPrice = Float.parseFloat(str);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: the price has not been entered correctly!");
            }
        }

        System.out.println("Insert  maximum price: ");
        str = br.readLine();

        if (str.equals("")) maxPrice = 0;
        else {

            try {
                maxPrice = Float.parseFloat(str);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: the price has not been entered correctly!");
            }
        }

        System.out.println("\nFound these products:\n");

        for (ElettronicDevice e : list) {
            if (name.equalsIgnoreCase(e.getName()) || (name.equals(""))) {

                elprint.add(e);

                if ((!producer.equalsIgnoreCase(e.getProducer())) && (!(producer.equals("")))) elprint.remove(e);

            }
        }

        float finalMinPrice = minPrice;
        elprint.removeIf(n -> (n.getPrice() <= finalMinPrice));

        if (maxPrice != 0) {
            float finalMaxPrice = maxPrice;
            elprint.removeIf(n -> (n.getPrice() >= finalMaxPrice));
        }

        for (ElettronicDevice e : elprint) {
            System.out.println(e.toString());
        }
    }

    /**
     * This method clean the shop list.
     */
    public void clearOrder() {
        this.shop.clear();
    }

    /**
     * This method print the elements into shop list.
     */
    public void getOrder() {

        for (ElettronicDevice e : this.shop) {
            System.out.println(e.toString());
        }
    }

    /**
     * This method is used to buy a product.
     *
     * @param elDev    It is the ElettronicDevice list.
     * @param buyElDev It is  list of ElettronicDevice for the employee to purchase.
     */
    public void orderProduct(final List<ElettronicDevice> elDev, final List<ElettronicDevice> buyElDev) {
        Scanner scan = new Scanner(System.in);
        boolean check;
        boolean continue_ = true;

        while (continue_) {
            check = false;
            System.out.print("Insert ID product to order: ");
            int id = 0;

            try {
                id = Integer.parseInt(scan.next());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: An integer was not entered!");
            }

            for (ElettronicDevice i : elDev) {

                if (i.getId() == id) {

                    System.out.println(i.toString());
                    check = true;

                    System.out.println("\nAmount to order:");
                    int qnt = Integer.parseInt(scan.next());

                    if ((qnt > 0) && (qnt <= i.getAmount())) {

                        if (i.getAmount() == qnt) {

                            addOrder(new ElettronicDevice(i));

                            i.setAmount(i.getAmount() - qnt);
                            buyElDev.add(elDev.remove(elDev.indexOf(i)));

                        } else {
                            int a = i.getAmount();
                            i.setAmount(qnt);
                            addOrder(new ElettronicDevice(i));

                            i.setAmount(a - qnt);
                        }
                        System.out.println("PURCHASED PRODUCT");
                        break;
                    } else System.out.println("Quantity entered not available");
                }
            }

            if (!check) {
                System.out.println("Product ID not present!");
            }

            System.out.println("Do you want to continue to buy? (insert true to continue): "); // It allows user to do another search
            continue_ = Boolean.parseBoolean(scan.next());
        }
    }


    /**
     * This method add an order into shop list.
     *
     * @param e It is an ElettronicDevice element.
     */
    public void addOrder(final ElettronicDevice e) {

        for (ElettronicDevice i : this.shop) {
            if (i.getId() == e.getId()) {
                i.setAmount(i.getAmount() + e.getAmount());
                return;
            }
        }

        this.shop.add(e);
    }

    /**
     * This method checks if each client's cart is empty or not.
     *
     * @return true if it is full and false if it is empty.
     */
    public boolean isEmptyShop() {
        return this.shop.size() != 0;
    }
}
