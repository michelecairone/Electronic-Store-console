package Assegnamento1.User;

import Assegnamento1.Product.ElettronicDevice;

import java.util.*;


/**
 * The class {@code Employee} inherit from Person.
 * Defines the employee of the electronic device store and the methods used by them.
 */
public class Employee extends Person {

    /**
     * Class constructor. It is used by Admin.
     * to instantiate new Employee objects without parameters
     */
    public Employee() {
    }

    /**
     * Class constructor. It is used by Admin.
     *
     * @param name     It is the name of the employee
     * @param surname  It is the surname of the employee
     * @param username It is the username of the employee
     * @param password It is the password of the employee
     */
    public Employee(final String name, final String surname, final String username, final String password) {

        super(name, surname, username, password);

    }


    /**
     * This method is used to confirm buy a product.
     *
     * @param cliList It is a support list for client.
     */
    public void confirmOrderProduct(final List<Client> cliList) {
        Scanner scan = new Scanner(System.in);

        for (Client c : cliList) {

            if (c.isEmptyShop()) {

                System.out.println("The client's products " + c.getUsername() + " are these:\n");
                c.getOrder();
                System.out.println("SHIPPING ADDRESS: " + c.getAddress());

                System.out.println("Do you want to confirm " + c.getUsername() + "'s purchases?[Y/N]");
                String choice;
                choice = scan.next();

                if (choice.equalsIgnoreCase("y")) {

                    System.out.println("Order confirmed");
                    c.clearOrder();

                } else {
                    System.out.println("Unconfirmed order:\n filed!");
                }
                return;
            }
        }

        System.out.println("No orders to be confirmed!\n");
    }


    /**
     * This method is used to add other quantities of electronic device.
     *
     * @param elDev    It is the ElettronicDevice's list.
     * @param buyElDev It is  list of ElettronicDevice for the employee to purchase.
     */
    public void addAmount(final List<ElettronicDevice> elDev, final List<ElettronicDevice> buyElDev) {
        int id;
        Scanner scan = new Scanner(System.in);
        System.out.println("Product ID: ");

        try {
            id = Integer.parseInt(scan.next());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: An integer was not entered!");
            return;
        }

        for (ElettronicDevice i : elDev) {

            if (i.getId() == id) {

                System.out.println("Indicate the quantity to add: ");
                int q;

                try {
                    q = Integer.parseInt(scan.next());
                    if (q > 0) {
                        i.setAmount(i.getAmount() + q);
                        return;
                    } else {
                        System.out.println("ERROR: A negative quantity was entered!\n");

                    }
                    return;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: An integer was not entered!");
                    return;
                }
            }
        }

        for (ElettronicDevice j : buyElDev) {

            if (j.getId() == id) {

                System.out.println("Indicate the quantity to add: ");
                int q;

                try {
                    q = Integer.parseInt(scan.next());

                    if (q > 0) {
                        j.setAmount(j.getAmount() + q);

                        elDev.add(buyElDev.remove(buyElDev.indexOf(j)));
                        return;
                    } else System.out.println("ERROR: A negative quantity was entered!\n");

                    return;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: An integer was not entered!");
                    return;
                }
            }
        }

        System.out.println("Product ID not present!");
    }
}
