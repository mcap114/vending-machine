
import java.util.Scanner;

/**
 * Serves as a driver class for the vending machine factory.
 */
public class Main {
    public static void main(String[] args) {
        int slots;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        VendingMachine vendingMachine = null;

        do {
            System.out.println("\nVENDING MACHINE FACTORY");
            System.out.println("1. CREATE REGULAR VENDING MACHINE");
            System.out.println("2. CREATE SPECIAL VENDING MACHINE");
            System.out.println("3. TEST VENDING MACHINE FEATURES");
            System.out.println("4. EXIT PROGRAM");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Input number of item slots: ");
                    slots = sc.nextInt();
                    sc.nextLine();
                    if (slots < 8) {
                        System.out.println("Below minimum number of slots.");
                    } else {
                        vendingMachine = new VendingMachine(slots);
                    }
                    System.out.println("New regular vending machine created!");
                    break;
                case 2:
                    System.out.println("Input number of item slots: ");
                    slots = sc.nextInt();
                    sc.nextLine();
                    if (slots < 8) {
                        System.out.println("Below minimum number of slots.");
                    } else {
                        vendingMachine = new SpecialVendingMachine(slots);
                    }
                    System.out.println("New special vending machine created!");
                    break;
                case 3:
                    if (vendingMachine == null){
                        System.out.println("No vending machine created yet!");
                        break;
                    }
                    else{
                        System.out.println("\nTEST VENDING MACHINE FEATURES");
                        System.out.println("1. TEST VENDING FEATURES");
                        System.out.println("2. MAINTENANCE FEATURES");
                        int testChoice = sc.nextInt();
                        switch (testChoice) {
                            case 1:
                                System.out.println("\nTEST VENDING FEATURES");
                                System.out.println("1. DISPLAY ITEMS");
                                System.out.println("2. SELECT INDIVIDUAL ITEM FOR PURCHASE");
                                System.out.println("3. CUSTOMIZED ORDER");

                                int choiceVending = sc.nextInt();
                                sc.nextLine();

                                switch(choiceVending){
                                    case 1:
                                        vendingMachine.displayItems(vendingMachine);
                                        break;
                                    case 2:
                                        vendingMachine.purchaseItem(vendingMachine);
                                        break;
                                    case 3:
                                        //TODO: IMPLEMENT SPECIAL VENDING MACHINE PURCHASE ITEM
                                        //IF THIS OPTION IS SELECTED WITH A REGULAR VENDING MACHINE ACTIVE,
                                        //DISPLAY ERROR MESSAGE "THIS OPTION IS ONLY FOR SPECIAL VENDING ETC"
                                }
                                break;
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

                                switch(choiceMaintenance){
                                    case 1:
                                        vendingMachine.stockItem(vendingMachine);
                                        break;
                                    case 2:
                                        vendingMachine.restockItem(vendingMachine);
                                        break;
                                    case 3:
                                        vendingMachine.setItemPrice(vendingMachine);
                                        break;
                                    case 4:
                                        vendingMachine.collectMoney(vendingMachine);
                                        break;
                                    case 5:
                                        vendingMachine.replenishMoney(vendingMachine);
                                        break;
                                    case 6:
                                        vendingMachine.displayTransactions(vendingMachine);
                                        break;
                                    case 7:
                                        vendingMachine.displayTotalSales(vendingMachine);
                                        break;
                                    case 8:
                                        vendingMachine.displayDenominations(vendingMachine);
                                        break;
                                    case 9:
                                        break;
                                    default:
                                        System.out.println("Invalid input.");
                                        break;
                                }

                                break;
                        }
                        break;
                    }


                case 4:
                    exit = true;
                    sc.close();
                    System.out.println("\nExiting program..");
                    break;
            }

        } while (exit == false);
    }
}