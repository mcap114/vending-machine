import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;

public class SpecialVendingMachine extends VendingMachine{


    public SpecialVendingMachine(int slots){
        super(slots);
    }

    public void customizeOrder(SpecialVendingMachine vendingMachine) {

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
        ArrayList<Item> customOrder = new ArrayList<>();

        do {
            vendingMachine.displayItems(vendingMachine);

            System.out.println("1. SELECT ITEM");
            System.out.println("2. PROCEED TO CHECKOUT");

            int customChoice = sc.nextInt();
            sc.nextLine();

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
                            customOrder.add(i.getItem());
                            System.out.println("\nCurrent Items:");
                            System.out.println("NAME    PRICE    CALORIES");
                            for (Item d: customOrder){
                                System.out.println(d.getName() +"     "+ d.getPrice() +"        "+ d.getCalories()+"      ");
                            }
                            System.out.println("\nTotal price: " +vendingMachine.computeTotalPrice(customOrder));
                            System.out.println("Total calories: " +vendingMachine.computeTotalCalories(customOrder) +"\n\n");
                            }

                    }
                    } if (!found) {
                    System.out.println("Item not found.");
                    break;

                }
                break;

                case 2:
                    exitPurchaseSelect = true;
                    break;
            }
            }
            while (!exitPurchaseSelect);

        //PURCHASE LOGIC GOES HERE

        boolean validPurchase = true;
        double bundlePrice = vendingMachine.computeTotalPrice(customOrder);
        double change = abs(bundlePrice - payment);

        // Checks if inserted payment is enough
        if (payment < bundlePrice) {
            System.out.println("Insufficient amount inserted.");
            System.out.println("Returned money: " +payment);
            validPurchase = false;
        }

        // Checks if there is enough money in the machine to dispense change
        else if (change > vendingMachine.getMoneyInMachine()) {
            System.out.println("Not enough money in machine to dispense change.");
            System.out.println("Contact maintenance to replenish money.");
            System.out.println("Returned money: " +payment);
            validPurchase = false;
        }

        int changeHolder = (int) change;
        Denominations denominationsChange = new Denominations();

        if (changeHolder / 1000 >= 1){
            if (vendingMachine.getDenominations().getP1000Bill() != 0) // Initial check, skips to next denomination if this one is empty
            {
                int quotient = changeHolder / 1000; // Variable quotient stores how many of this denomination is needed for the current amount of changeHolder
                denominationsChange.setP1000Bill(quotient);
                if (denominationsChange.getP1000Bill() > vendingMachine.getDenominations().getP1000Bill()) // Checks if the vending machine has enough of this denomination stored to dispense amount
                {
                    validPurchase = false;
                } else {
                    validPurchase = true;
                    changeHolder = changeHolder - (1000 * quotient); //Updates the value of changeHolder to compute for the next denomination
                }
            }
        }

        if (changeHolder / 500 >= 1){
            if (vendingMachine.getDenominations().getP500Bill() != 0) // Initial check, skips to next denomination if this one is empty
            {
                int quotient = changeHolder / 500; // Variable quotient stores how many of this denomination is needed for the current amount of changeHolder
                denominationsChange.setP500Bill(quotient);
                if (denominationsChange.getP500Bill() > vendingMachine.getDenominations().getP500Bill()) // Checks if the vending machine has enough of this denomination stored to dispense amount
                {
                    validPurchase = false;
                } else {
                    validPurchase = true;
                    changeHolder = changeHolder - (500 * quotient); //Updates the value of changeHolder to compute for the next denomination
                }
            }
        }

        if (changeHolder / 200 >= 1){
            if (vendingMachine.getDenominations().getP200Bill() != 0) // Initial check, skips to next denomination if this one is empty
            {
                int quotient = changeHolder / 200; // Variable quotient stores how many of this denomination is needed for the current amount of changeHolder
                denominationsChange.setP200Bill(quotient);
                if (denominationsChange.getP200Bill() > vendingMachine.getDenominations().getP200Bill()) // Checks if the vending machine has enough of this denomination stored to dispense amount
                {
                    validPurchase = false;
                } else {
                    validPurchase = true;
                    changeHolder = changeHolder - (200 * quotient); //Updates the value of changeHolder to compute for the next denomination
                }
            }
        }

        if (changeHolder / 100 >= 1){
            if (vendingMachine.getDenominations().getP100Bill() != 0) // Initial check, skips to next denomination if this one is empty
            {
                int quotient = changeHolder / 100; // Variable quotient stores how many of this denomination is needed for the current amount of changeHolder
                denominationsChange.setP100Bill(quotient);
                if (denominationsChange.getP100Bill() > vendingMachine.getDenominations().getP100Bill()) // Checks if the vending machine has enough of this denomination stored to dispense amount
                {
                    validPurchase = false;
                } else {
                    validPurchase = true;
                    changeHolder = changeHolder - (100 * quotient); //Updates the value of changeHolder to compute for the next denomination
                }
            }
        }

        if (changeHolder / 50 >= 1){
            if (vendingMachine.getDenominations().getP50Bill() != 0) // Initial check, skips to next denomination if this one is empty
            {
                int quotient = changeHolder / 50; // Variable quotient stores how many of this denomination is needed for the current amount of changeHolder
                denominationsChange.setP50Bill(quotient);
                if (denominationsChange.getP50Bill() > vendingMachine.getDenominations().getP50Bill()) // Checks if the vending machine has enough of this denomination stored to dispense amount
                {
                    validPurchase = false;
                } else {
                    validPurchase = true;
                    changeHolder = changeHolder - (50 * quotient); //Updates the value of changeHolder to compute for the next denomination
                }
            }
        }


        if (changeHolder / 20 >= 1){
            if (vendingMachine.getDenominations().getP20Bill() != 0) // Initial check, skips to next denomination if this one is empty
            {
                int quotient = changeHolder / 20; // Variable quotient stores how many of this denomination is needed for the current amount of changeHolder
                denominationsChange.setP20Bill(quotient);
                if (denominationsChange.getP20Bill() > vendingMachine.getDenominations().getP20Bill()) // Checks if the vending machine has enough of this denomination stored to dispense amount
                {
                    validPurchase = false;
                } else {
                    validPurchase = true;
                    changeHolder = changeHolder - (20 * quotient); //Updates the value of changeHolder to compute for the next denomination
                }
            }
        }

        if (changeHolder / 20 >= 1){
            if (vendingMachine.getDenominations().getP20Coin() != 0) // Initial check, skips to next denomination if this one is empty
            {
                int quotient = changeHolder / 20; // Variable quotient stores how many of this denomination is needed for the current amount of changeHolder
                denominationsChange.setP20Coin(quotient);
                if (denominationsChange.getP20Coin() > vendingMachine.getDenominations().getP20Coin()) // Checks if the vending machine has enough of this denomination stored to dispense amount
                {
                    validPurchase = false;
                } else {
                    validPurchase = true;
                    changeHolder = changeHolder - (20 * quotient); //Updates the value of changeHolder to compute for the next denomination
                }
            }
        }

        if (changeHolder / 10 >= 1){
            if (vendingMachine.getDenominations().getP10Coin() != 0) // Initial check, skips to next denomination if this one is empty
            {
                int quotient = changeHolder / 10; // Variable quotient stores how many of this denomination is needed for the current amount of changeHolder
                denominationsChange.setP10Coin(quotient);
                if (denominationsChange.getP10Coin() > vendingMachine.getDenominations().getP10Coin()) // Checks if the vending machine has enough of this denomination stored to dispense amount
                {
                    validPurchase = false;
                } else {
                    validPurchase = true;
                    changeHolder = changeHolder - (10 * quotient); //Updates the value of changeHolder to compute for the next denomination
                }
            }
        }

        if (changeHolder / 5 >= 1){
            if (vendingMachine.getDenominations().getP5Coin() != 0) // Initial check, skips to next denomination if this one is empty
            {
                int quotient = changeHolder / 5; // Variable quotient stores how many of this denomination is needed for the current amount of changeHolder
                denominationsChange.setP5Coin(quotient);
                if (denominationsChange.getP5Coin() > vendingMachine.getDenominations().getP5Coin()) // Checks if the vending machine has enough of this denomination stored to dispense amount
                {
                    validPurchase = false;
                } else {
                    validPurchase = true;
                    changeHolder = changeHolder - (5 * quotient); //Updates the value of changeHolder to compute for the next denomination
                }
            }
        }

        if (changeHolder / 1 >= 1){
            if (vendingMachine.getDenominations().getP1Coin() != 0) // Initial check, skips to next denomination if this one is empty
            {
                int quotient = changeHolder / 1; // Variable quotient stores how many of this denomination is needed for the current amount of changeHolder
                denominationsChange.setP1Coin(quotient);
                if (denominationsChange.getP5Coin() > vendingMachine.getDenominations().getP1Coin()) // Checks if the vending machine has enough of this denomination stored to dispense amount
                {
                    validPurchase = false;
                } else {
                    validPurchase = true;
                    changeHolder = changeHolder - (1 * quotient); //Updates the value of changeHolder to compute for the next denomination
                }
            }
        }

        if (validPurchase == true) {


            vendingMachine.preparationDialogue(customOrder);


            System.out.println("\nPurchase successful!");
            System.out.println("Change dispensed: ");

            //TODO: DISPLAY CHANGE IN DIFFERENT DENOMINATIONS

            if (denominationsChange.getP1000Bill() > 0){
                System.out.println(denominationsChange.getP1000Bill()+ " P1000 Bills");
            }

            if (denominationsChange.getP500Bill() > 0){
                System.out.println(denominationsChange.getP500Bill()+ " P500 Bills");
            }

            if (denominationsChange.getP200Bill() > 0){
                System.out.println(denominationsChange.getP200Bill()+ " P200 Bills");
            }

            if (denominationsChange.getP100Bill() > 0){
                System.out.println(denominationsChange.getP100Bill()+ " P100 Bills");
            }

            if (denominationsChange.getP50Bill() > 0){
                System.out.println(denominationsChange.getP50Bill()+ " P50 Bills");
            }

            if (denominationsChange.getP20Bill() > 0){
                System.out.println(denominationsChange.getP20Bill()+ " P20 Bills");
            }

            if (denominationsChange.getP10Coin() > 0){
                System.out.println(denominationsChange.getP10Coin()+ " P10 Coins");
            }

            if (denominationsChange.getP5Coin() > 0){
                System.out.println(denominationsChange.getP5Coin()+ " P5 Coins");
            }

            if (denominationsChange.getP1Coin() > 0){
                System.out.println(denominationsChange.getP1Coin()+ " P1 Coins");
            }

            System.out.println("Total: " +change);

            double totalPrice = vendingMachine.computeTotalPrice(customOrder);
            int totalCalories = vendingMachine.computeTotalCalories(customOrder);

            Item silog = new Item("Silog meal", totalPrice, totalCalories );

            Transaction transaction = new Transaction();
            transaction.setItemSold(silog);
            transaction.setPayment(payment);
            transaction.setChangeDispensed(change);
            transaction.setPrice(totalPrice);

            for (Item i : customOrder){
                for (ItemSlot j: slots){
                    if (j.getItem() == i){
                        int index = slots.indexOf(j);

                        // Updates item quantity
                        vendingMachine.getItemSlots().get(index).setQuantity(vendingMachine.getItemSlots().get(index).getQuantity() - 1);

                        // Updates sales log
                        vendingMachine.getItemSlots().get(index).setSales(vendingMachine.getItemSlots().get(index).getSales() + 1);

                        // Updates total sales
                        vendingMachine.setTotalSales(vendingMachine.getTotalSales() + vendingMachine.getItemSlots().get(index).getItem().getPrice());
                    }
                }
            }

            // Adds transaction to list of transactions
            vendingMachine.getTransactionLog().add(transaction);

            // Decreases change dispensed from stored money
            vendingMachine.getDenominations().setP1000Bill(vendingMachine.getDenominations().getP1000Bill() - denominationsChange.getP1000Bill());
            vendingMachine.getDenominations().setP500Bill(vendingMachine.getDenominations().getP500Bill() - denominationsChange.getP500Bill());
            vendingMachine.getDenominations().setP200Bill(vendingMachine.getDenominations().getP200Bill() - denominationsChange.getP200Bill());
            vendingMachine.getDenominations().setP100Bill(vendingMachine.getDenominations().getP100Bill() - denominationsChange.getP100Bill());
            vendingMachine.getDenominations().setP50Bill(vendingMachine.getDenominations().getP50Bill() - denominationsChange.getP50Bill());
            vendingMachine.getDenominations().setP20Bill(vendingMachine.getDenominations().getP20Bill() - denominationsChange.getP20Bill());
            vendingMachine.getDenominations().setP20Coin(vendingMachine.getDenominations().getP20Coin() - denominationsChange.getP20Coin());
            vendingMachine.getDenominations().setP10Coin(vendingMachine.getDenominations().getP10Coin() - denominationsChange.getP10Coin());
            vendingMachine.getDenominations().setP5Coin(vendingMachine.getDenominations().getP5Coin() - denominationsChange.getP5Coin());
            vendingMachine.getDenominations().setP1Coin(vendingMachine.getDenominations().getP1Coin() - denominationsChange.getP1Coin());

            // Adds payment to denominations
            vendingMachine.getDenominations().setP1000Bill(vendingMachine.getDenominations().getP1000Bill() + paymentDenominations.getP1000Bill());
            vendingMachine.getDenominations().setP500Bill(vendingMachine.getDenominations().getP500Bill() + paymentDenominations.getP500Bill());
            vendingMachine.getDenominations().setP200Bill(vendingMachine.getDenominations().getP200Bill() + paymentDenominations.getP200Bill());
            vendingMachine.getDenominations().setP100Bill(vendingMachine.getDenominations().getP100Bill() + paymentDenominations.getP100Bill());
            vendingMachine.getDenominations().setP50Bill(vendingMachine.getDenominations().getP50Bill() + paymentDenominations.getP50Bill());
            vendingMachine.getDenominations().setP20Bill(vendingMachine.getDenominations().getP20Bill() + paymentDenominations.getP20Bill());
            vendingMachine.getDenominations().setP20Coin(vendingMachine.getDenominations().getP20Coin() + paymentDenominations.getP20Coin());
            vendingMachine.getDenominations().setP10Coin(vendingMachine.getDenominations().getP10Coin() + paymentDenominations.getP10Coin());
            vendingMachine.getDenominations().setP5Coin(vendingMachine.getDenominations().getP5Coin() + paymentDenominations.getP5Coin());
            vendingMachine.getDenominations().setP1Coin(vendingMachine.getDenominations().getP1Coin() + paymentDenominations.getP1Coin());

        }

    }

    public int computeTotalCalories(ArrayList<Item> items){
        int totalCalories = 0;

        for (Item i: items){
            totalCalories += i.getCalories();
        }

        return totalCalories;
    }

    public double computeTotalPrice(ArrayList<Item> items){
        double totalPrice = 0;

        for (Item i: items){
            totalPrice += i.getPrice();
        }

        return totalPrice;
    }


    public void preparationDialogue(ArrayList<Item> items){
    for (Item i: items){
        if (i.getName().equals("Egg")){
            System.out.println("Frying egg..");
        }
        else if (i.getName().equals("Tapa")){
            System.out.println("Cooking tapa..");
        }
        else if (i.getName().equals("Tocino")){
            System.out.println("Cooking tocino..");
        }
        else if (i.getName().equals("Longganisa")){
            System.out.println("Cooking longganisa..");
        }
        else if (i.getName().equals("Hotdog")){
            System.out.println("Cooking hotdog..");
        }
        else if (i.getName().equals("Rice")){
            System.out.println("Frying rice..");
        }
    }
        System.out.println("Putting everything on a plate..");
        System.out.println("Silog done!");
    }


}


