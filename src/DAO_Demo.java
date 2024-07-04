
import java.sql.*;
import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DAO_Demo {
    public static DAO_Factory daoFactory; // creating globle variable of DAO_Facory type

    public static Scanner sc = new Scanner(System.in);

    // main function
    public static void main(String[] args) {

        try {
            daoFactory = new DAO_Factory(true); // passing defualt user as Manager
            while (true) {

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------------------");

                if (daoFactory.CurrentUser()) {
                    System.out.println(
                            " |Music Store Information System|      " + dtf.format(now)
                                    + "                    |Logged As: Manager|");
                } else {
                    System.out.println(
                            " |Music Store Information System|      " + dtf.format(now)
                                    + "                    |Logged As: Cashier|");
                }

                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(
                        " |Main Menu|   (C/M-> Tells Wheather Cahsier Or Manager Or Both Can Perfrom This Task) ");
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| Use Cases                              |  |To Select|");
                System.out.println(" -----------------------------------------------------");
                System.out.println("| To Display ProductList (C/M)           |  | Enter 1 |");
                System.out.println("| To Add A New Customer (C/M)            |  | Enter 2 |");
                System.out.println("| To Order A Product (C/M)               |  | Enter 3 |");
                System.out.println("| To Display CustomerList (M)            |  | Enter 4 |");
                System.out.println("| To Add A New Album (M)                 |  | Enter 5 |");
                System.out.println("| To Delete A Customer (M)               |  | Enter 6 |");
                System.out.println("| To Change CustomerDetails (M)          |  | Enter 7 |");
                System.out.println("| To Change User(Manager/Cashier) (C/M)  |  | Enter 8 |");
                System.out.println("| To Quit (C/M)                          |  | Enter 9 |");

                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.print("Please Select Your Choice: ");
                int option = sc.nextInt();
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------------------");

                if (option == 1)
                    ViewProductList();
                else if (option == 2)
                    AddingCustomer();
                else if (option == 3)
                    OrderProduct();
                else if (option == 4)
                    ViewCustomerList();
                else if (option == 5)
                    AddingNewAlbum();
                else if (option == 6)
                    Delete_Customer();
                else if (option == 7)
                    ChnagingCustomerDetails();
                else if (option == 8)
                    ChangeUser();
                else if (option == 9) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("You Need to Select Atleast One Option From Above");
                }

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public static void AddingCustomer() {

        System.out.println("Adding new customer to store...");
        int intInput;
        String strInput;

        Customer cus = new Customer();
        System.out.println();

        System.out.print("Enter Customer'ID (int) : ");
        intInput = sc.nextInt();
        cus.setCusID(intInput);

        System.out.print("Enter Customer's Name: ");
        sc.nextLine();
        strInput = sc.nextLine();
        cus.setCusName(strInput);

        System.out.print("Enter Customer Email: ");
        strInput = sc.nextLine();
        cus.setCusEmail(strInput);

        System.out.print("Enter Customer Phone: ");
        strInput = sc.nextLine();
        cus.setCusPhone(strInput);

        System.out.print("Enter Customer Address: ");
        strInput = sc.nextLine();
        cus.setCusAdd(strInput);

        try {

            daoFactory.activateConnection();

            // Carry out DB operations using DAO
            User udao = daoFactory.getUserDAO();
            udao.Add_customer(cus);

            // End transaction boundary with success
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
        } catch (Exception e) {
            // End transaction boundary with failure
            // System.out.println("3ok tested ");
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
            e.printStackTrace();
        }
    }

    public static void ChangeUser() {
        if (daoFactory.CurrentUser()) {
            while (true) {
                System.out.println("UserName: Cashier");
                System.out.println("------------------");
                System.out.print("Enter Password: ");
                // sc.next();
                String inp = sc.next();
                if (inp.equals("Cashier")) {
                    System.out.println("Switching User From Manager To Cashier...");
                    daoFactory.setCashierAsUser();
                    break;
                } else {
                    System.out.println("Invalid Password!, Please Try Again");
                    System.out.print("Quit (Y/N): ");
                    String inpY = sc.next();
                    if (inpY.equals("Y")) {
                        break;
                    }
                }

            }

        } else {

            while (true) {
                System.out.println("UserName: Manager");
                System.out.println("------------------");
                System.out.print("Enter Password: ");
                // sc.next();
                String inp = sc.next();
                if (inp.equals("Manager")) {
                    System.out.println("Switching User From Cashier To Manager...");
                    daoFactory.setManagerAsUser();
                    break;
                } else {
                    System.out.println("Invalid Password!, Please Try Again");
                    System.out.print("Quit (Y/N): ");
                    String inpY = sc.next();
                    if (inpY.equals("Y")) {
                        break;
                    }

                }

            }

        }

    }

    public static void ViewCustomerList() {

        if (!daoFactory.CurrentUser()) {
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Error!..Only Manager Can Perform This Operation.");
            System.out.println("You Can Switch User From Cashier To Manager To Perfrom This Task...");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------------------");
            return;
        }

        try {
            daoFactory.activateConnection();

            User user = daoFactory.getUserDAO();
            user.View_CustomerList();
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
        } catch (Exception e) {
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
            e.printStackTrace();
        }
    }

    public static void ViewProductList() {

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Displaying all Product details...");

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------");
        try {
            daoFactory.activateConnection();

            User user = daoFactory.getUserDAO();
            user.View_ProductList();
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
        } catch (Exception e) {
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
            e.printStackTrace();
        }
    }

    public static void Delete_Customer() {
        if (!daoFactory.CurrentUser()) {
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Error!..Only Manager Can Perform This Operation.");
            System.out.println("You Can Switch User From Cashier To Manager To Perfrom This Task...");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------------------");
            return;
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Enter Customer's ID to be removed: ");
        int intInput = sc.nextInt();

        try {
            // Start transaction boundary
            daoFactory.activateConnection();

            // Carry out DB operations using DAO
            User udao = daoFactory.getUserDAO();
            udao.Delete_Customer(intInput); // passing id of customer's need to be deleted

            // End transaction boundary with success
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
        } catch (Exception e) {
            // End transaction boundary with failure
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
            e.printStackTrace();
        }

    }

    public static void ChnagingCustomerDetails() {
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Enter Customer's ID: ");
        int intInput = sc.nextInt();

        try {
            // Start transaction boundary
            daoFactory.activateConnection();

            // Carry out DB operations using DAO
            User udao = daoFactory.getUserDAO();
            udao.Changing_Customer_Details(intInput);

            // End transaction boundary with success
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
        } catch (Exception e) {
            // End transaction boundary with failure
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
            e.printStackTrace();
        }
    }

    public static void AddingNewAlbum() {

        if (!daoFactory.CurrentUser()) {
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Error!..Only Manager Can Perform This Operation.");
            System.out.println("You Can Switch User From Cashier To Manager To Perfrom This Task...");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------------------");
            return;
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Adding new Album to store...");
        int intInput;
        String strInput;

        Album album = new Album();
        System.out.println();

        System.out.print("Enter Album'ID(int): ");
        intInput = sc.nextInt();
        album.setAlbumID(intInput);

        System.out.print("Enter AlbumArtistID(int): ");
        intInput = sc.nextInt();
        album.setAlbumArtistID(intInput);

        System.out.print("Enter Album's Title: ");
        // sc.next();
        strInput = sc.nextLine();
        album.setAlbumTitle(strInput);

        System.out.print("Enter Release Date: ");
        strInput = sc.nextLine();
        album.setReleaseDate(strInput);

        System.out.print("Enter price: ");
        intInput = sc.nextInt();
        album.setAlbumPrice(intInput);

        System.out.print("Enter Genre: ");
        // sc.next();
        strInput = sc.nextLine();
        album.setAlbumGenre(strInput);

        System.out.print("Enter Quantity: ");
        intInput = sc.nextInt();
        album.setAlbumQuantity(intInput);

        try {
            // Start transaction boundary
            daoFactory.activateConnection();

            // Carry out DB operations using DAO
            User udao = daoFactory.getUserDAO();
            udao.Add_Album(album);

            // End transaction boundary with success
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
        } catch (Exception e) {
            // End transaction boundary with failure
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
            e.printStackTrace();
        }
    }

    public static void OrderProduct() {

        System.out.println("Available Products In Shope, Please Select Your Choice.");

        ViewProductList();
        System.out.print("Enter the AlbumId of Album to order: ");
        int albumid = sc.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        try {
            // Start transaction boundary
            daoFactory.activateConnection();

            // Carry out DB operations using DAO
            User udao = daoFactory.getUserDAO();
            udao.Order_Product(albumid, quantity);

            // End transaction boundary with success
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
        } catch (Exception e) {
            // End transaction boundary with failure
            daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
            e.printStackTrace();
        }
    }

}