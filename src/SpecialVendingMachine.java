import java.util.ArrayList;
import java.util.Scanner;

public class SpecialVendingMachine extends VendingMachine{


    public SpecialVendingMachine(int slots){
        super(slots);
    }

    public void customizeOrder(VendingMachine vendingMachine) {

        double payment;
        Denominations paymentDenominations = new Denominations();
        Scanner sc = new Scanner(System.in);

        vendingMachine.displayItems(vendingMachine);
        boolean exit = false;
        do {
            System.out.println("\n\nINSERT MONEY AND QUANTITY");
            System.out.println("1. 1 PESO COIN");
            System.out.println("2. 5 PESO COIN");
            System.out.println("3. 10 PESO COIN");
            System.out.println("4. 20 PESO COIN");
            System.out.println("5. 20 PESO BILL");
            System.out.println("6. 50 PESO BILL");
            System.out.println("7. 100 PESO BILL");
            System.out.println("8. 200 PESO BILL");
            System.out.println("9. 500 PESO BILL");
            System.out.println("10. 1000 PESO BILL");
            System.out.println("11. PROCEED TO ITEM SELECTION");

            int choice = sc.nextInt();
            int quantityInserted;
            sc.nextLine();


            switch (choice) {
                case 1 -> {
                    System.out.println("Enter how many 1 Peso Coins to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();
                    if (quantityInserted > 0) {
                        paymentDenominations.setP1Coin(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                }
                case 2 -> {
                    System.out.println("Enter how many 5 Peso Coins to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();
                    if (quantityInserted > 0) {
                        paymentDenominations.setP5Coin(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                }
                case 3 -> {
                    System.out.println("Enter how many 10 Peso Coins to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();
                    if (quantityInserted > 0) {
                        paymentDenominations.setP10Coin(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                }
                case 4 -> {
                    System.out.println("Enter how many 20 Peso Coins to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();
                    if (quantityInserted > 0) {
                        paymentDenominations.setP20Coin(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                }
                case 5 -> {
                    System.out.println("Enter how many 20 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();
                    if (quantityInserted > 0) {
                        paymentDenominations.setP20Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                }
                case 6 -> {
                    System.out.println("Enter how many 50 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();
                    if (quantityInserted > 0) {
                        paymentDenominations.setP50Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                }
                case 7 -> {
                    System.out.println("Enter how many 100 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();
                    if (quantityInserted > 0) {
                        paymentDenominations.setP100Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                }
                case 8 -> {
                    System.out.println("Enter how many 200 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();
                    if (quantityInserted > 0) {
                        paymentDenominations.setP200Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                }
                case 9 -> {
                    System.out.println("Enter how many 500 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();
                    if (quantityInserted > 0) {
                        paymentDenominations.setP500Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                }
                case 10 -> {
                    System.out.println("Enter how many 1000 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();
                    if (quantityInserted > 0) {
                        paymentDenominations.setP1000Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                }
                case 11 -> exit = true;
            }
        } while (!exit);

        payment = paymentDenominations.computeTotal(paymentDenominations);
        ArrayList<ItemSlot> slots = vendingMachine.getItemSlots();
        vendingMachine.computeMoneyInMachine(vendingMachine.getDenominations(), vendingMachine);

        boolean exitPurchaseSelect = false;
        ArrayList<ItemSlot> customOrder = new ArrayList<>();

        do {
            vendingMachine.displayItems(vendingMachine);

            System.out.println("1. SELECT ITEM");
            System.out.println("2. PROCEED TO CHECKOUT");

            int customChoice = sc.nextInt();

            switch (customChoice) {

                // SELECT ITEM TO ADD TO ORDER
                case 1:
                System.out.println("Enter name of item to purchase: ");
                String itemName = sc.nextLine();
                boolean found = false;
                boolean validPurchase = true;
                for (ItemSlot i : slots) {
                    if (itemName.equals(i.getItem().getName())) {
                        found = true;

                        // Checks if the selected item is in stock
                        if (i.getQuantity() == 0) {
                            System.out.println("Item out of stock, please select a different item");
                        } else if (i.getQuantity() > 0) {
                            customOrder.add(i);
                            for (ItemSlot j : customOrder) {
                                if (j.getItem().getName().equals(i.getItem().getName())) {

                                }
                            }


                        }
                    } else if (!found) {
                        System.out.println("Item not found.");
                        break;

                    }
                }
                break;

                case 2:
                    exitPurchaseSelect = true;
                    break;
            }
            }
            while (!exitPurchaseSelect) ;


                }
            }



