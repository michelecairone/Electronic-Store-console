package Assegnamento1.User;

import Assegnamento1.Product.ElettronicDevice;

import java.util.List;
import java.util.*;

/**
 * The class {@code Admin } is used to represent Administrator entity.
 */
public final class Admin extends Employee {

    /**
     * Class constructor.
     *
     * @param name     It is the Admin's name.
     * @param surname  It is the Admin's surname.
     * @param username It is the Admin's username.
     * @param password It is the Admin's password.
     */
    public Admin(final String name, final String surname, final String username, final String password) {

        super(name, surname, username, password);

    }

    /**
     * This method is used to add a new employee
     *
     * @param list It is the Employee list
     */
    public void addEmployee(final List<Employee> list) {
        Scanner scan = new Scanner(System.in);
        Employee e = new Employee();

        System.out.println("EMPLOYEE DATA: ");

        System.out.println("Name: ");
        e.setName(scan.next());

        System.out.println("Surname: ");
        e.setSurname(scan.next());

        System.out.println("Username: ");
        e.setUsername(scan.next());

        System.out.println("Password: ");
        e.setPassword(scan.next());

        for (Employee i : list) {
            if (i.getUsername().equals(e.getUsername())) {

                System.out.println("Username already exists!");
                return;

            }
        }

        list.add(e);
        System.out.println("Registered employee!\nCREDENTIALS:\n" + e.toString());
    }

    /**
     * This method is used to add a new employee.
     *
     * @param list     It is the Employee list.
     * @param name     It is the name of new employee.
     * @param surname  It is the surname of new employee.
     * @param username It is the username of new employee.
     * @param password It is the password of new employee.
     */
    public void addEmployee(final List<Employee> list, final String name, final String surname, final String username, final String password) {

        for (Employee i : list) {
            if (username.equals(i.getUsername())) {

                System.out.println("Username already exists!");
                return;
            }
        }

        list.add(new Employee(name, surname, username, password));
    }

    /**
     * This method is used to remove an employee.
     *
     * @param list It is the Employee list.
     */
    public void rmvEmployee(final List<Employee> list) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Username of the account you want to remove:");
        String r = scan.next();

        for (Employee e : list) {
            if (e.getUsername().equals(r)) {

                list.remove(e);
                System.out.println("Employee account deleted!");
                return;

            }
        }

        System.out.println("Username not found!");
    }

    /**
     * This method is used to add a new product.
     *
     * @param list It is the ElettronicDevice list.
     */
    public void addProduct(final List<ElettronicDevice> list) {
        Scanner scan = new Scanner(System.in);
        ElettronicDevice dev = new ElettronicDevice();

        System.out.println("PRODUCT DATA: ");
        System.out.println("Name: ");
        dev.setName(scan.next());

        System.out.println("ID (numeric): ");

        try {
            dev.setId(Integer.parseInt(scan.next()));
        } catch (NumberFormatException e) {
            System.out.println("ERROR: a non-numeric ID was entered!");
            return;
        }

        System.out.println("Producer: ");
        dev.setProducer(scan.next());

        System.out.println("Price: ");
        try {
            dev.setPrice(Float.parseFloat(scan.next()));
        } catch (NumberFormatException e) {
            System.out.println("ERROR: the price has not been entered correctly!");
            return;
        }

        System.out.println("Amount: ");
        try {
            dev.setAmount(Integer.parseInt(scan.next()));
        } catch (NumberFormatException e) {
            System.out.println("ERROR: a non-numeric quantity has been entered!");
            return;
        }

        for (ElettronicDevice i : list) {
            if (i.getId() == dev.getId()) {
                System.out.println("Product ID already exists!");
                return;
            }
        }

        list.add(dev);
        System.out.println("Product added!\nProduct details:\n" + dev.toString());
    }

    /**
     * This method is used to remove a product
     *
     * @param list It is the ElettronicDevice list
     */
    public void rmvProduct(final List<ElettronicDevice> list) {
        Scanner scan = new Scanner(System.in);

        System.out.println("ID of the product you want to remove: ");
        int i;

        try {
            i = Integer.parseInt(scan.next());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: a non-numeric ID was entered!");
            return;
        }

        for (ElettronicDevice e : list) {
            if (e.getId() == i) {

                list.remove(e);
                System.out.println("Product removed!");
                return;

            }
        }

        System.out.println("ID not found!");
    }
}
