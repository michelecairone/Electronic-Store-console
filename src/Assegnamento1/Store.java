package Assegnamento1;

import Assegnamento1.Dashboard.Dashboard;
import Assegnamento1.Product.ElettronicDevice;
import Assegnamento1.User.*;


import java.io.IOException;
import java.util.*;


/**
 * The class {@code Store} in used to contain the main method to
 * execute the simulation and it contains system data and methods
 * to manage system data.
 *
 * @author Leonardo Minaudo 297792 {@literal <}leonardo.minaudo{@literal @}studenti.unipr.it{@literal >}
 * @author Michele Cairone 284972 {@literal <}michele.cairone{@literal @}studenti.unipr.it{@literal >}
 */
public final class Store {

    /**
     * MAIN
     *
     * @param args None.
     * @throws IOException None.
     */
    public static void main(String[] args) throws IOException {
        Dashboard db = new Dashboard();
        List<Employee> emp = new ArrayList<>();
        List<ElettronicDevice> elDev = new ArrayList<>();
        List<ElettronicDevice> buyElDev = new ArrayList<>();
        List<Client> lclient = new ArrayList<>();


        Admin adm = new Admin("Admin", "Istrator", "admin", "1234");

        adm.addEmployee(emp, "Leonardo", "Minaudo", "LMinaudo", "LM123");
        adm.addEmployee(emp, "Michele", "Cairone", "MCairone", "MC456");

        Client usr = new Client("Filip", "Pino", "FPino", "123stella", "Via del Sole, 15");
        lclient.add(usr);
        Client usr1 = new Client("Giovanni", "Po", "giovi", "123", "Via Trento, 8");
        lclient.add(usr1);
        Client usr2 = new Client("Sara", "Millefiori", "mllfiori", "sara", "Via Palermo, 105/B");
        lclient.add(usr2);


        ElettronicDevice element1 = new ElettronicDevice("Notebook", 1, "Acer", 799.995F, 10);
        ElettronicDevice element2 = new ElettronicDevice("Smartphone", 2, "Motorola", 799.99F, 5);
        ElettronicDevice element3 = new ElettronicDevice("Smartwatch", 3, "Apple", 459.90F, 2);
        ElettronicDevice element4 = new ElettronicDevice("Televisione", 4, "Samsung", 2999.90F, 2);
        ElettronicDevice element5 = new ElettronicDevice("Notebook", 5, "HP", 579.90F, 7);
        ElettronicDevice element6 = new ElettronicDevice("Macbook Air", 6, "Apple", 1159.00F, 5);


        elDev.add(element1);
        elDev.add(element2);
        elDev.add(element3);
        elDev.add(element4);
        elDev.add(element5);
        elDev.add(element6);

        db.firstStart(emp, lclient, elDev, buyElDev, adm);
    }
}
