
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Serves as a driver class for the vending machine factory.
 */
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Capasilog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setVisible(true);

        ImageIcon eggboy = new ImageIcon("src/eggboy.jpg");
        frame.setIconImage(eggboy.getImage());
        frame.getContentPane().setBackground(new Color(231, 226, 210));

        int slots;
        boolean exitAll = false;
        boolean specialActive = false;
        Scanner sc = new Scanner(System.in);
        VendingMachine vendingMachine = null;
        SpecialVendingMachine vendingMachineSC = null;

        do {
            boolean exit = false;
            if (!specialActive) {
                do {
                    System.out.println("\nCAPASILOG VENDING MACHINE FACTORY");
                    System.out.println("1. CREATE REGULAR VENDING MACHINE");
                    System.out.println("2. CREATE SPECIAL VENDING MACHINE");
                    System.out.println("3. TEST VENDING MACHINE FEATURES");
                    System.out.println("4. EXIT PROGRAM");

                    int choice = sc.nextInt();

                    switch (choice) {

                        // CREATE REGULAR VENDING MACHINE
                        case 1 -> {
                            System.out.println("Input number of item slots: ");
                            slots = sc.nextInt();
                            sc.nextLine();
                            if (slots < 8) {
                                System.out.println("Below minimum number of slots.");
                                break;
                            } else {
                                vendingMachine = new VendingMachine(slots);
                                specialActive = false;
                                exit = true;
                            }
                            System.out.println("New regular vending machine created!");
                        }

                        // CREATE SPECIAL VENDING MACHINE
                        case 2 -> {
                            System.out.println("Input number of item slots: ");
                            slots = sc.nextInt();
                            sc.nextLine();
                            if (slots < 8) {
                                System.out.println("Below minimum number of slots.");
                                break;
                            } else {
                                vendingMachineSC = new SpecialVendingMachine(slots);
                                specialActive = true;
                                exit = true;

                            }
                            System.out.println("New special vending machine created!");
                        }

                        // TEST FEATURES
                        case 3 -> {
                            if (vendingMachine == null) {
                                System.out.println("No vending machine created yet!");
                            } else {
                                System.out.println("\nTEST VENDING MACHINE FEATURES");
                                System.out.println("1. TEST VENDING FEATURES");
                                System.out.println("2. MAINTENANCE FEATURES");
                                System.out.println("3. RETURN TO PREVIOUS MENU");
                                int testChoice = sc.nextInt();
                                switch (testChoice) {

                                    // TEST VENDING FEATURES
                                    case 1:
                                        System.out.println("\nTEST VENDING FEATURES");
                                        System.out.println("1. DISPLAY ITEMS");
                                        System.out.println("2. SELECT INDIVIDUAL ITEM FOR PURCHASE");
                                        System.out.println("3. CUSTOMIZED ORDER");
                                        System.out.println("4. RETURN TO PREVIOUS MENU");

                                        int choiceVending = sc.nextInt();
                                        sc.nextLine();

                                        switch (choiceVending) {

                                            //DISPLAY ITEMS FOR SALE IN VENDING MACHINE
                                            case 1:
                                                vendingMachine.displayItems(vendingMachine);
                                                break;

                                            //SELECT ITEM FOR PURCHASE
                                            case 2:
                                                vendingMachine.purchaseItem(vendingMachine);
                                                break;
                                            //CREATE CUSTOM ORDER FROM SOLD ITEMS
                                            case 3:
                                                System.out.println("This feature is not available for regular vending machines.");
                                                //vendingMachine.customizeOrder(vendingMachine);
                                                //TODO: IMPLEMENT SPECIAL VENDING MACHINE PURCHASE ITEM
                                                //IF THIS OPTION IS SELECTED WITH A REGULAR VENDING MACHINE ACTIVE,
                                                //DISPLAY ERROR MESSAGE "THIS OPTION IS ONLY FOR SPECIAL VENDING ETC"
                                            case 4:
                                                break;
                                        }
                                        break;

                                    // MAINTENANCE FEATURES
                                    case 2:
                                        System.out.println("\nMAINTENANCE FEATURES");
                                        System.out.println("1. STOCK ITEMS");
                                        System.out.println("2. RESTOCK ITEMS");
                                        System.out.println("3. SET ITEM PRICE");
                                        System.out.println("4. COLLECT MONEY");
                                        System.out.println("5. REPLENISH MONEY");
                                        System.out.println("6. DISPLAY TRANSACTIONS");
                                        System.out.println("7. DISPLAY TOTAL SALES");
                                        System.out.println("8. DISPLAY MONEY IN MACHINE");
                                        System.out.println("9. EXIT MAINTENANCE MENU");

                                        int choiceMaintenance = sc.nextInt();
                                        sc.nextLine();

                                        switch (choiceMaintenance) {

                                            // STOCK ITEMS
                                            case 1:
                                                vendingMachine.stockItem(vendingMachine);
                                                break;

                                            // RESTOCK ITEM
                                            case 2:
                                                vendingMachine.restockItem(vendingMachine);
                                                break;

                                            // SET ITEM PRICE
                                            case 3:
                                                vendingMachine.setItemPrice(vendingMachine);
                                                break;

                                            // COLLECT MONEY FROM VENDING MACHINE
                                            case 4:
                                                vendingMachine.collectMoney(vendingMachine);
                                                break;

                                            // REPLENISH MONEY IN VENDING MACHINE
                                            case 5:
                                                vendingMachine.replenishMoney(vendingMachine);
                                                break;

                                            // DISPLAY LIST OF TRANSACTIONS
                                            case 6:
                                                vendingMachine.displayTransactions(vendingMachine);
                                                break;

                                            // DISPLAY TOTAL SALES OF EACH ITEM
                                            case 7:
                                                vendingMachine.displayTotalSales(vendingMachine);
                                                break;

                                            // DISPLAY HOW MUCH OF EACH DENOMINATION IS STORED IN THE VENDING MACHINE
                                            case 8:
                                                vendingMachine.displayDenominations(vendingMachine);
                                                break;

                                            // EXIT
                                            case 9:
                                                break;
                                            default:
                                                System.out.println("Invalid input.");
                                                break;
                                        }
                                    case 3:
                                        break;

                                    default:
                                        System.out.println("Invalid input.");
                                        break;

                                }
                            }
                        }
                        case 4 -> {
                            exit = true;
                            exitAll = true;
                            System.out.println("\nExiting program..");
                        }
                    }


                } while (!exit);
            }

            if (specialActive) {
                do {
                    System.out.println("\nCAPASILOG VENDING MACHINE FACTORY");
                    System.out.println("1. CREATE REGULAR VENDING MACHINE");
                    System.out.println("2. CREATE SPECIAL VENDING MACHINE");
                    System.out.println("3. TEST VENDING MACHINE FEATURES");
                    System.out.println("4. EXIT PROGRAM");

                    int choice = sc.nextInt();

                    switch (choice) {

                        // CREATE REGULAR VENDING MACHINE
                        case 1 -> {
                            System.out.println("Input number of item slots: ");
                            slots = sc.nextInt();
                            sc.nextLine();
                            if (slots < 8) {
                                System.out.println("Below minimum number of slots.");
                            } else {
                                vendingMachine = new VendingMachine(slots);
                                specialActive = false;
                                exit = true;
                            }
                            System.out.println("New regular vending machine created!");
                        }

                        // CREATE SPECIAL VENDING MACHINE
                        case 2 -> {
                            System.out.println("Input number of item slots: ");
                            slots = sc.nextInt();
                            sc.nextLine();
                            if (slots < 8) {
                                System.out.println("Below minimum number of slots.");
                            } else {
                                vendingMachineSC = new SpecialVendingMachine(slots);
                                specialActive = true;
                                exit = true;
                            }
                            System.out.println("New special vending machine created!");
                        }

                        // TEST FEATURES
                        case 3 -> {
                            if (vendingMachineSC == null) {
                                System.out.println("No vending machine created yet!");
                            } else {
                                System.out.println("\nTEST VENDING MACHINE FEATURES");
                                System.out.println("1. TEST VENDING FEATURES");
                                System.out.println("2. MAINTENANCE FEATURES");
                                System.out.println("3. RETURN TO PREVIOUS MENU");
                                int testChoice = sc.nextInt();
                                switch (testChoice) {

                                    // TEST VENDING FEATURES
                                    case 1:
                                        System.out.println("\nTEST VENDING FEATURES");
                                        System.out.println("1. DISPLAY ITEMS");
                                        System.out.println("2. SELECT INDIVIDUAL ITEM FOR PURCHASE");
                                        System.out.println("3. CUSTOMIZED ORDER");
                                        System.out.println("4. RETURN TO PREVIOUS MENU");

                                        int choiceVending = sc.nextInt();
                                        sc.nextLine();

                                        switch (choiceVending) {

                                            //DISPLAY ITEMS FOR SALE IN VENDING MACHINE
                                            case 1:
                                                vendingMachineSC.displayItems(vendingMachineSC);
                                                break;

                                            //SELECT ITEM FOR PURCHASE
                                            case 2:
                                                vendingMachineSC.purchaseItem(vendingMachineSC);
                                                break;
                                            //CREATE CUSTOM ORDER FROM SOLD ITEMS
                                            case 3:
                                                vendingMachineSC.customizeOrder(vendingMachineSC);
                                                break;
                                            //TODO: IMPLEMENT SPECIAL VENDING MACHINE PURCHASE ITEM
                                            //IF THIS OPTION IS SELECTED WITH A REGULAR VENDING MACHINE ACTIVE,
                                            //DISPLAY ERROR MESSAGE "THIS OPTION IS ONLY FOR SPECIAL VENDING ETC"
                                            case 4:
                                                break;
                                        }
                                        break;

                                    // MAINTENANCE FEATURES
                                    case 2:
                                        System.out.println("\nMAINTENANCE FEATURES");
                                        System.out.println("1. STOCK ITEMS");
                                        System.out.println("2. RESTOCK ITEMS");
                                        System.out.println("3. SET ITEM PRICE");
                                        System.out.println("4. COLLECT MONEY");
                                        System.out.println("5. REPLENISH MONEY");
                                        System.out.println("6. DISPLAY TRANSACTIONS");
                                        System.out.println("7. DISPLAY TOTAL SALES");
                                        System.out.println("8. DISPLAY MONEY IN MACHINE");
                                        System.out.println("9. EXIT MAINTENANCE MENU");

                                        int choiceMaintenance = sc.nextInt();
                                        sc.nextLine();

                                        switch (choiceMaintenance) {

                                            // STOCK ITEMS
                                            case 1:
                                                vendingMachineSC.stockItem(vendingMachineSC);
                                                break;

                                            // RESTOCK ITEM
                                            case 2:
                                                vendingMachineSC.restockItem(vendingMachineSC);
                                                break;

                                            // SET ITEM PRICE
                                            case 3:
                                                vendingMachineSC.setItemPrice(vendingMachineSC);
                                                break;

                                            // COLLECT MONEY FROM VENDING MACHINE
                                            case 4:
                                                vendingMachineSC.collectMoney(vendingMachineSC);
                                                break;

                                            // REPLENISH MONEY IN VENDING MACHINE
                                            case 5:
                                                vendingMachineSC.replenishMoney(vendingMachineSC);
                                                break;

                                            // DISPLAY LIST OF TRANSACTIONS
                                            case 6:
                                                vendingMachineSC.displayTransactions(vendingMachineSC);
                                                break;

                                            // DISPLAY TOTAL SALES OF EACH ITEM
                                            case 7:
                                                vendingMachineSC.displayTotalSales(vendingMachineSC);
                                                break;

                                            // DISPLAY HOW MUCH OF EACH DENOMINATION IS STORED IN THE VENDING MACHINE
                                            case 8:
                                                vendingMachineSC.displayDenominations(vendingMachineSC);
                                                break;

                                            // EXIT
                                            case 9:
                                                break;
                                            default:
                                                System.out.println("Invalid input.");
                                                break;
                                        }
                                    case 3:
                                        break;

                                    default:
                                        System.out.println("Invalid input.");
                                        break;

                                }
                            }
                        }
                        case 4 -> {
                            exit = true;
                            exitAll = true;
                            System.out.println("\nExiting program..");
                        }
                    }


                } while (!exit);
            }
        } while (!exitAll);
        sc.close();
        }
    }
