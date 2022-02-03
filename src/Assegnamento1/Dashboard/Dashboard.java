package Assegnamento1.Dashboard;

import Assegnamento1.Product.ElettronicDevice;
import Assegnamento1.User.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * The class {@code Dashboard } is used to represent the various methods of clients, employees and administrator.
 */
public class Dashboard {

    /**
     * This method is used to for the first login to the system.
     *
     * @param empList  It is employee.
     * @param cliList  It is client.
     * @param elDev    It is the ElettronicDevice list.
     * @param adm      It is adminstrator.
     * @param buyElDev It is  list of ElettronicDevice for the employee to purchase.
     * @throws IOException None.
     */
    public final void firstStart(final List<Employee> empList, final List<Client> cliList, final List<ElettronicDevice> elDev, final List<ElettronicDevice> buyElDev, Admin adm) throws IOException {

        Scanner scan = new Scanner(System.in);
        int choice = 1;

        do {
            System.out.println("\nWelcome to Electronic products store");
            System.out.println("""
                    What do you want to do:
                    0) Exit
                    1) Login
                    2) Sign in
                    choice:""");

            try {
                choice = Integer.parseInt(scan.next());
                switch (choice) {
                    case 0:
                        break;

                    case 1:
                        login(empList, cliList, elDev, buyElDev, adm);
                        break;

                    case 2:
                        cliList.add(registerClient());
                        login(empList, cliList, elDev, buyElDev, adm);
                        break;

                    default:
                        System.out.println("Wrong option\n\n");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: An integer was not entered!");

            }

        } while (choice != 0);
    }

    /**
     * This method is used to login.
     *
     * @param empList  It is employee.
     * @param cliList  It is client.
     * @param elDev    It is the ElettronicDevice list.
     * @param adm      It is adminstrator.
     * @param buyElDev It is  list of ElettronicDevice for the employee to purchase.
     * @throws IOException None.
     */
    public final void login(final List<Employee> empList, final List<Client> cliList, final List<ElettronicDevice> elDev, final List<ElettronicDevice> buyElDev, final Admin adm) throws IOException {

        boolean register = false;
        Scanner scan = new Scanner(System.in);


        System.out.println("LOGIN");
        System.out.println("username: ");
        String username = scan.next();
        System.out.println("password: ");
        String password = scan.next();

        if (username.equals(adm.getUsername())) {
            if (password.equals(adm.getPassword())) {

                adminDashboard(adm, elDev, empList, buyElDev, cliList);
                register = true;

            }
        }

        for (Employee e : empList) {
            if (username.equals(e.getUsername())) {
                if (password.equals(e.getPassword())) {

                    employeeDashboard(e, elDev, buyElDev, cliList);

                } else {
                    System.out.println("Wrong password");
                }
                register = true;

            }
        }

        for (Client e : cliList) {
            if (username.equals(e.getUsername())) {
                if (password.equals(e.getPassword())) {

                    clientDashboard(e, elDev, buyElDev);

                } else {
                    System.out.println("Wrong password");
                }
                register = true;

            }
        }

        if (!register) {
            System.out.println("User not found, would you like to register? [Y/N]");
            String reg = scan.next();

            if (reg.equalsIgnoreCase("Y")) {

                cliList.add(registerClient());
            }
        }

    }


    /**
     * This method is used to admin dashboard.
     *
     * @param userLog  It is admin.
     * @param elDev    It is the ElettronicDevice's list.
     * @param emp      It is the Employee list.
     * @param buyElDev It is  list of ElettronicDevice for the employee to purchase.
     * @param cliList  It is a support list for client.
     */
    public static void adminDashboard(final Admin userLog, final List<ElettronicDevice> elDev, final List<Employee> emp, final List<ElettronicDevice> buyElDev, final List<Client> cliList) {
        Scanner scan = new Scanner(System.in);
        int choice = 1;

        while (choice != 0) {
            System.out.println("\n\nADMINISTRATOR: " + userLog.getName() + " " + userLog.getSurname());
            System.out.println("""
                    0) Exit
                    1) Confirm order product
                    2) Replace product
                    3) View products
                    4) Add employee
                    5) Remove employee
                    6) Add product
                    7) Remove product
                    8) Products to buy
                    choice:""");

            try {
                choice = Integer.parseInt(scan.next());

                switch (choice) {
                    case 0 -> System.out.println("LOGOUT\n" + "See you later!");
                    case 1 -> userLog.confirmOrderProduct(cliList);
                    case 2 -> userLog.addAmount(elDev, buyElDev);
                    case 3 -> printProduct(elDev);
                    case 4 -> userLog.addEmployee(emp);
                    case 5 -> userLog.rmvEmployee(emp);
                    case 6 -> userLog.addProduct(elDev);
                    case 7 -> userLog.rmvProduct(elDev);
                    case 8 -> printProduct(buyElDev);
                    default -> System.out.println("No operation!");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: An integer was not entered!");
            }
        }
    }

    /**
     * This method is used to employee dashboard.
     *
     * @param emplog   It is employee.
     * @param elDev    It is the ElettronicDevice list.
     * @param buyElDev It is  list of ElettronicDevice for the employee to purchase.
     * @param cliList  It is a support list for client.
     */
    public static void employeeDashboard(final Employee emplog, final List<ElettronicDevice> elDev, final List<ElettronicDevice> buyElDev, final List<Client> cliList) {
        Scanner scan = new Scanner(System.in);
        int choice = 1;

        while (choice != 0) {
            System.out.println("\n\nEMPLOYEE: " + emplog.getName() + " " + emplog.getSurname());
            System.out.println("""
                    0) Exit
                    1) Confirm order product
                    2) Replace product
                    3) View products
                    4) Products to buy
                    choice:""");


            try {
                choice = Integer.parseInt(scan.next());
                switch (choice) {
                    case 0:
                        System.out.println("LOGOUT\n" + "See you later!");
                        break;

                    case 1:
                        emplog.confirmOrderProduct(cliList);
                        break;

                    case 2:
                        emplog.addAmount(elDev, buyElDev);
                        break;

                    case 3:
                        printProduct(elDev);
                        break;

                    case 4:
                        if (buyElDev.size() > 0) {
                            printProduct(buyElDev);
                        } else {
                            System.out.println("There are no products to buy!");
                        }
                        break;

                    default:
                        System.out.println("No operation!");

                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: An integer was not entered!");
            }
        }
    }


    /**
     * This method is used to client dashboard.
     *
     * @param userLog  is client.
     * @param elDev    is the ElettronicDevice list.
     * @param buyElDev It is  list of ElettronicDevice for the employee to purchase.
     * @throws IOException None.
     */
    public static void clientDashboard(final Client userLog, final List<ElettronicDevice> elDev, final List<ElettronicDevice> buyElDev) throws IOException {
        Scanner scan = new Scanner(System.in);
        int choice = 1;

        while (choice != 0) {

            System.out.println("\n\nCLIENT: " + userLog.getName() + " " + userLog.getSurname());
            System.out.println("""
                    0) Exit
                    1) Product search by product name, producer name and minimum/maximum price
                    2) Order product
                    3) View products
                    choice:""");

            try {
                choice = Integer.parseInt(scan.next());
                switch (choice) {
                    case 0 -> System.out.println("LOGOUT\n" + "See you later!");
                    case 1 -> userLog.searchProduct(elDev);
                    case 2 -> userLog.orderProduct(elDev, buyElDev);
                    case 3 -> printProduct(elDev);
                    default -> System.out.println("No operation");
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: An integer was not entered!");

            }
        }
    }

    /**
     * This method collects data from a new customer.
     *
     * @return client who has created.
     */
    private static Client registerClient() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("DATA:");
        System.out.println("Name: ");
        String name = br.readLine();

        System.out.println("Surname: ");
        String surname = br.readLine();

        System.out.println("Address: ");
        String address = br.readLine();

        System.out.println("Username: ");
        String username = br.readLine();

        System.out.println("Password: ");
        String password = br.readLine();

        return new Client(name, surname, username, password, address);
    }

    /**
     * This method print the elements into ElettronicDevice list.
     *
     * @param list It is the ElettronicDevice list.
     */
    public static void printProduct(List<ElettronicDevice> list) {
        for (ElettronicDevice e : list) {
            System.out.println(e.toString());
        }
    }

}