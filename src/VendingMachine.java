import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a vending machine.
 * Contains objects of Item, ItemSlot, Denominations, and Transaction classes and corresponding
 * methods to simulate vending features.
 *
 */
public class VendingMachine {
    private ArrayList<ItemSlot> itemSlots;
    private Denominations denominations;
    private double totalSales;
    private double moneyInMachine;
    private ArrayList<Transaction> transactionLog;

    /**

     Constructs a VendingMachine object with the specified number of slots.
     @param slots the number of slots available in the vending machine
     */
    public VendingMachine(int slots){
        this.itemSlots = new ArrayList<>(slots);
        this.denominations = new Denominations();
        this.totalSales = 0;
        this.moneyInMachine = 0;
        this.transactionLog = new ArrayList<>();
    }

    /**

     Retrieves the list of item slots in the vending machine.
     @return an ArrayList of ItemSlot objects representing the item slots in the vending machine
     */
    public ArrayList<ItemSlot> getItemSlots() {
        return itemSlots;
    }

    /**

     Retrieves the denominations object representing the available denominations in the vending machine.
     @return a Denominations object containing the available denominations in the vending machine
     */
    public Denominations getDenominations() {
        return denominations;
    }

    /**
     * Retrieves the total sales amount of the vending machine.
     *
     * @return a double value representing the total sales amount of the vending machine
     */
    public double getTotalSales() {
        return totalSales;
    }

    /**
     * Retrieves the total amount of money in the vending machine.
     *
     * @return a double value representing the total amount of money in the vending machine
     */
    public double getMoneyInMachine() {
        return moneyInMachine;
    }

    /**
     * Retrieves the transaction log of the vending machine.
     *
     * @return an ArrayList of Transaction objects representing the transaction log of the vending machine
     */
    public ArrayList<Transaction> getTransactionLog() {
        return transactionLog;
    }


    /**
     * Sets the list of item slots in the vending machine.
     *
     * @param itemSlots an ArrayList of ItemSlot objects representing the new item slots in the vending machine
     */
    public void setItemSlots(ArrayList<ItemSlot> itemSlots){
        this.itemSlots = itemSlots;
    }

    /**
     * Sets the denominations object representing the available denominations in the vending machine.
     *
     * @param denominations a Denominations object containing the new available denominations in the vending machine
     */
    public void setDenominations(Denominations denominations){
        this.denominations = denominations;
    }

    /**
     * Sets the transaction log of the vending machine.
     *
     * @param transactionLog an ArrayList of Transaction objects representing the new transaction log of the vending machine
     */
    public void setTransactionLog(ArrayList<Transaction> transactionLog){
        this.transactionLog = transactionLog;
    }

    /**
     * Sets the total sales amount of the vending machine.
     *
     * @param totalSales a double value representing the new total sales amount of the vending machine
     */
    public void setTotalSales(double totalSales){
        this.totalSales = totalSales;
    }

    /**
     * Sets the amount of money currently in the vending machine.
     *
     * @param moneyInMachine a double value representing the new amount of money in the vending machine
     */
    public void setMoneyInMachine(double moneyInMachine){
        this.moneyInMachine = moneyInMachine;
    }

    /**
     * Computes and sets the amount of money currently in the vending machine based on the denominations provided.
     *
     * @param denominations the denominations object containing the count of each denomination
     * @param vendingMachine the vending machine object to update with the computed money amount
     */
    public void computeMoneyInMachine(Denominations denominations, VendingMachine vendingMachine){
        double totalMoney = 0.0;
        totalMoney += denominations.getP1Coin();
        totalMoney += denominations.getP5Coin() * 5.0;
        totalMoney += denominations.getP10Coin() * 10.0;
        totalMoney += (denominations.getP20Coin() + denominations.getP20Bill()) * 20.0;
        totalMoney += denominations.getP50Bill() * 50.0;
        totalMoney += denominations.getP100Bill() * 100.0;
        totalMoney += denominations.getP200Bill() * 200.0;
        totalMoney += denominations.getP500Bill() * 500.0;
        totalMoney += denominations.getP1000Bill() * 1000.0;

        vendingMachine.setMoneyInMachine(totalMoney);
    }
    /**
     * Displays the items available in the vending machine.
     *
     * @param vendingMachine the vending machine object containing the items to display
     */
    public void displayItems(VendingMachine vendingMachine){
        ArrayList<ItemSlot> items = vendingMachine.getItemSlots();
        System.out.println("==========ITEMS IN VENDING MACHINE==========");
        System.out.println("NAME    PRICE    CALORIES    QUANTITY");
        for (ItemSlot i: items){
            System.out.println(i.getItem().getName() +"     "+ i.getItem().getPrice() +"        "+ i.getItem().getCalories()+"      "+i.getQuantity());
        }
    }

    /**
     * Allows the user to purchase items from the vending machine.
     * Contains logic for calculating change and updating corresponding object attributes.
     *
     * @param vendingMachine
     */
    public void purchaseItem(VendingMachine vendingMachine) {

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
                case 1:
                    System.out.println("Enter how many 1 Peso Coins to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();

                    if (quantityInserted > 0) {
                        paymentDenominations.setP1Coin(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 2:
                    System.out.println("Enter how many 5 Peso Coins to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();

                    if (quantityInserted > 0) {
                        paymentDenominations.setP5Coin(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 3:
                    System.out.println("Enter how many 10 Peso Coins to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();

                    if (quantityInserted > 0) {
                        paymentDenominations.setP10Coin(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 4:
                    System.out.println("Enter how many 20 Peso Coins to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();

                    if (quantityInserted > 0) {
                        paymentDenominations.setP20Coin(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 5:
                    System.out.println("Enter how many 20 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();

                    if (quantityInserted > 0) {
                        paymentDenominations.setP20Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 6:
                    System.out.println("Enter how many 50 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();

                    if (quantityInserted > 0) {
                        paymentDenominations.setP50Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 7:
                    System.out.println("Enter how many 100 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();

                    if (quantityInserted > 0) {
                        paymentDenominations.setP100Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 8:
                    System.out.println("Enter how many 200 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();

                    if (quantityInserted > 0) {
                        paymentDenominations.setP200Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 9:
                    System.out.println("Enter how many 500 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();

                    if (quantityInserted > 0) {
                        paymentDenominations.setP500Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 10:
                    System.out.println("Enter how many 1000 Peso Bills to insert: ");
                    quantityInserted = sc.nextInt();
                    sc.nextLine();

                    if (quantityInserted > 0) {
                        paymentDenominations.setP1000Bill(quantityInserted);
                        System.out.println("Successfully inserted! Current total: " + paymentDenominations.computeTotal(paymentDenominations));
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 11:
                    exit = true;
                    break;
            }
        } while (exit == false);

        payment = paymentDenominations.computeTotal(paymentDenominations);
        vendingMachine.displayItems(vendingMachine);
        ArrayList<ItemSlot> slots = vendingMachine.getItemSlots();

        System.out.println("Enter name of item to purchase: ");
        String itemName = sc.nextLine();
        boolean found = false;
        for (ItemSlot i : slots) {
            if (itemName.equals(i.getItem().getName())) {
                found = true;
                double change = i.getItem().getPrice() - payment;
                if (change > vendingMachine.getMoneyInMachine()) {
                    System.out.println("Not enough money in machine to dispense change.");
                    System.out.println("Contact maintenance to replenish money.");
                } else if (payment < i.getItem().getPrice()) {
                    System.out.println("Insufficient amount inserted."); }
                else {
                    System.out.println("Item purchased successfully!");
                    Transaction transaction = new Transaction();
                    transaction.setItemSold(i.getItem());
                    transaction.setPayment(payment);
                    transaction.setChangeDispensed(change);
                    transaction.setPrice(i.getItem().getPrice());

                    int index = slots.indexOf(i);

                    vendingMachine.getItemSlots().get(index).setQuantity(vendingMachine.getItemSlots().get(index).getQuantity() - 1);
                    vendingMachine.getItemSlots().get(index).setSales(vendingMachine.getItemSlots().get(index).getSales() + 1);
                    vendingMachine.getTransactionLog().add(transaction);
                    vendingMachine.setTotalSales(vendingMachine.getTotalSales() + vendingMachine.getItemSlots().get(index).getItem().getPrice());
                }

            }

        }
        if (found == false){
            System.out.println("Item not found.");
        }
    }
    /**
     * Stocks a new item in the vending machine by adding it to the item slots.
     *
     * @param vendingMachine The vending machine object in which the item is to be stocked.
     */
    public void stockItem(VendingMachine vendingMachine) {
        ArrayList<ItemSlot> slots = vendingMachine.getItemSlots();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter capacity of item to be stocked:");
        int capacity = sc.nextInt();
        sc.nextLine();

        if (capacity < 10) {
            System.out.println("Invalid capacity entered.");
        } else {
            System.out.println("Enter name of item to be stocked: ");
            String name = sc.nextLine();

            System.out.println("Enter price of item to be stocked: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter calories of item to be stocked: ");
            int calories = sc.nextInt();
            sc.nextLine();

            Item newItem = new Item(name, price, calories);

            System.out.println("Enter initial quantity to be stocked:");
            int quantity = sc.nextInt();
            sc.nextLine();

            if (quantity < 0) {
                System.out.println("Invalid quantity entered. Set to default value (0).");
                quantity = 0;
            }

            ItemSlot newItemSlot = new ItemSlot(newItem, capacity, quantity);
            slots.add(newItemSlot);

            System.out.println(newItem.getName());
            System.out.println("New Item added!");
        }
    }

    /**
     * Restocks an item in the vending machine by increasing its quantity.
     *
     * @param vendingMachine The vending machine object containing the item slots to be restocked.
     */
    public void restockItem(VendingMachine vendingMachine) {
        displayItems(vendingMachine);
        ArrayList<ItemSlot> slots = vendingMachine.getItemSlots();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the item to be restocked: ");
        String itemName = sc.nextLine();
        boolean found = false;

        for (ItemSlot i : slots) {
            if (itemName.equals(i.getItem().getName())) {
                found = true;
                System.out.println("Input the quantity to be restocked: ");
                int restockAmount = i.getQuantity() + sc.nextInt();
                sc.nextLine();

                System.out.println("Successfully restocked! New quantity: " + restockAmount);
                i.setQuantity(restockAmount);
            }

            }
        if (found == false){
            System.out.println("Item not found.");
        }
    }


    /**
     * Sets the price of an item in the vending machine.
     *
     * @param vendingMachine The vending machine object containing the item slots.
     */
    public void setItemPrice(VendingMachine vendingMachine) {
        displayItems(vendingMachine);
        ArrayList<ItemSlot> slots = vendingMachine.getItemSlots();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the item to adjust the price of: ");
        String itemName = sc.nextLine();
        boolean found = false;

        for (ItemSlot i : slots) {
            if (itemName.equals(i.getItem().getName())) {
                found = true;
                System.out.println("Input the new price of the item: ");
                double newPrice = sc.nextDouble();
                sc.nextLine();

                System.out.println("Successfully changed! New price: " + newPrice);
                i.getItem().setPrice(newPrice);
            }

        }
        if (found == false) {
            System.out.println("Item not found.");
        }
    }

    /**
     * Collects the money from the vending machine and performs the necessary actions.
     *
     * This method computes the total amount of money in the vending machine, prints the total amount collected,
     * empties the denominations in the machine, and provides a reminder to replenish cash before the next purchase.
     *
     * @param vendingMachine The VendingMachine object representing the vending machine.
     */
    public void collectMoney(VendingMachine vendingMachine) {
        vendingMachine.computeMoneyInMachine(vendingMachine.getDenominations(), vendingMachine);
        double totalMoney = vendingMachine.getMoneyInMachine();

        System.out.println("Successfully collected money! Total amount collected: " + totalMoney);
        vendingMachine.getDenominations().emptyMachine(vendingMachine.getDenominations());
        System.out.println("Make sure to replenish cash before next purchase!");
    }

    /**
     * Replenishes the denominations inside the vending machine based on user input
     * @param vendingMachine
     */
    public void replenishMoney(VendingMachine vendingMachine){
        Denominations denominations = vendingMachine.getDenominations();
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        do{
            System.out.println("SELECT DENOMINATION TO REPLENISH");
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
            System.out.println("11. EXIT REPLENISH MENU");

            int choice = sc.nextInt();
            int replenish = 0;
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter how many 1 Peso Coins to replenish: ");
                    replenish = sc.nextInt();
                    sc.nextLine();

                    if (replenish >= 0){
                        vendingMachine.getDenominations().setP1Coin(getDenominations().getP1Coin() + replenish);
                        System.out.println("Successfully replenished! New amount: " +vendingMachine.getDenominations().getP1Coin());
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 2:
                    System.out.println("Enter how many 5 Peso Coins to replenish: ");
                    replenish = sc.nextInt();
                    sc.nextLine();

                    if (replenish > 0){
                        vendingMachine.getDenominations().setP5Coin(getDenominations().getP5Coin() + replenish);
                        System.out.println("Successfully replenished! New amount: " +vendingMachine.getDenominations().getP5Coin());
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 3:
                    System.out.println("Enter how many 10 Peso Coins to replenish: ");
                    replenish = sc.nextInt();
                    sc.nextLine();

                    if (replenish > 0){
                        vendingMachine.getDenominations().setP10Coin(getDenominations().getP10Coin() + replenish);
                        System.out.println("Successfully replenished! New amount: " +vendingMachine.getDenominations().getP10Coin());
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 4:
                    System.out.println("Enter how many 20 Peso Coins to replenish: ");
                    replenish = sc.nextInt();
                    sc.nextLine();

                    if (replenish > 0){
                        vendingMachine.getDenominations().setP20Coin(getDenominations().getP20Coin() + replenish);
                        System.out.println("Successfully replenished! New amount: " +vendingMachine.getDenominations().getP20Coin());
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 5:
                    System.out.println("Enter how many 20 Peso Bills to replenish: ");
                    replenish = sc.nextInt();
                    sc.nextLine();

                    if (replenish > 0){
                        vendingMachine.getDenominations().setP20Bill(getDenominations().getP20Bill() + replenish);
                        System.out.println("Successfully replenished! New amount: " +vendingMachine.getDenominations().getP20Bill());
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 6:
                    System.out.println("Enter how many 50 Peso Bills to replenish: ");
                    replenish = sc.nextInt();
                    sc.nextLine();

                    if (replenish > 0){
                        vendingMachine.getDenominations().setP50Bill(getDenominations().getP50Bill() + replenish);
                        System.out.println("Successfully replenished! New amount: " +vendingMachine.getDenominations().getP50Bill());
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 7:
                    System.out.println("Enter how many 100 Peso Bills to replenish: ");
                    replenish = sc.nextInt();
                    sc.nextLine();

                    if (replenish > 0){
                        vendingMachine.getDenominations().setP100Bill(getDenominations().getP100Bill() + replenish);
                        System.out.println("Successfully replenished! New amount: " +vendingMachine.getDenominations().getP100Bill());
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 8:
                    System.out.println("Enter how many 200 Peso Bills to replenish: ");
                    replenish = sc.nextInt();
                    sc.nextLine();

                    if (replenish > 0){
                        vendingMachine.getDenominations().setP200Bill(getDenominations().getP200Bill() + replenish);
                        System.out.println("Successfully replenished! New amount: " +vendingMachine.getDenominations().getP200Bill());
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 9:
                    System.out.println("Enter how many 500 Peso Bills to replenish: ");
                    replenish = sc.nextInt();
                    sc.nextLine();

                    if (replenish > 0){
                        vendingMachine.getDenominations().setP500Bill(getDenominations().getP500Bill() + replenish);
                        System.out.println("Successfully replenished! New amount: " +vendingMachine.getDenominations().getP500Bill());
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 10:
                    System.out.println("Enter how many 1000 Peso Bills to replenish: ");
                    replenish = sc.nextInt();
                    sc.nextLine();

                    if (replenish > 0){
                        vendingMachine.getDenominations().setP1000Bill(getDenominations().getP1000Bill() + replenish);
                        System.out.println("Successfully replenished! New amount: " +vendingMachine.getDenominations().getP1000Bill());
                    } else {
                        System.out.println("Invalid amount entered.");
                    }
                    break;
                case 11:
                    exit = true;
                    break;
            }

        } while (exit == false);
        }

    /**
     *
     *
      */
public void displayTotalSales(VendingMachine vendingMachine){
    ArrayList<ItemSlot> slots = vendingMachine.getItemSlots();

    System.out.println("=========TOTAL SALES==========");
    System.out.println("ITEM NAME       UNITS SOLD      TOTAL SALES");
    for (ItemSlot i : slots){
        System.out.println(i.getItem().getName() + "                "+ i.getSales() +"              P"+ (i.getSales() * i.getItem().getPrice()));
    }
    System.out.println("\nTotal of all items: P" + vendingMachine.getTotalSales());
}


    /**
     * Displays the transaction log of the vending machine.
     *
     * @param vendingMachine The VendingMachine object containing the transaction log to be displayed.
     */
    public void displayTransactions(VendingMachine vendingMachine) {
        ArrayList<Transaction> transactions = vendingMachine.getTransactionLog();

        System.out.println("===========TRANSACTION LOG============");
        System.out.println("ITEM NAME    PRICE    PAYMENT INSERTED     CHANGE DISPENSED");
        for (Transaction i : transactions) {
            System.out.println(i.getItemSold().getName() + "          " + i.getItemSold().getPrice() + "          " + i.getPayment() + "           " + i.getChangeDispensed());
        }
    }


}
