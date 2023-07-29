/**
 * Represents a transaction in a vending machine, including details such as the item sold, price, payment, and change dispensed.
 */

public class Transaction {
    Item itemSold;
    double price;
    double payment;
    double changeDispensed;

    /**
     * Constructs a new Transaction object with default values.
     * The item sold is set to null, price is set to 0, payment is set to 0, and change dispensed is set to 0.
     */
    public Transaction() {
        this.itemSold = null;
        this.price = 0;
        this.payment = 0;
        this.changeDispensed = 0;
    }

    /**
     * Creates a new transaction with the specified item sold, payment, and change dispensed.
     *
     * @param itemSold        the item that was sold in the transaction
     * @param payment         the payment made by the customer
     * @param changeDispensed the amount of change dispensed to the customer
     */
    public Transaction(Item itemSold, double payment, double changeDispensed) {
        this.itemSold = itemSold;
        this.price = itemSold.getPrice();
        this.payment = payment;
        this.changeDispensed = changeDispensed;
    }

    /**
     * Returns the item that was sold in this transaction.
     *
     * @return the item sold in the transaction
     */
    public Item getItemSold() {
        return itemSold;
    }

    /**
     * Sets the item that was sold in this transaction.
     *
     * @param itemSold the item sold in the transaction
     */
    public void setItemSold(Item itemSold) {
        this.itemSold = itemSold;
    }

    /**
     * Returns the price of the item in this transaction.
     *
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the item in this transaction.
     *
     * @param price the price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the payment made in this transaction.
     *
     * @return the payment made
     */
    public double getPayment() {
        return payment;
    }

    /**
     * Sets the payment made in this transaction.
     *
     * @param payment the payment made
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

    /**
     * Returns the amount of change dispensed in this transaction.
     *
     * @return the amount of change dispensed
     */
    public double getChangeDispensed() {
        return changeDispensed;
    }

    /**
     * Sets the amount of change dispensed in this transaction.
     *
     * @param changeDispensed the amount of change dispensed
     */
    public void setChangeDispensed(double changeDispensed) {
        this.changeDispensed = changeDispensed;
    }
}
