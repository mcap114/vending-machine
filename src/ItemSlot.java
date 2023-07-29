/**
 * Represents a slot in the vending machine that holds a specific item.
 * Each slot has a maximum capacity and keeps track of the current quantity of the item in stock.
 */

public class ItemSlot {
    private Item item;
    private int capacity;
    private int quantity;
    private int sales;


    /**
     * Constructs a new ItemSlot with the specified item, capacity, and initial quantity.
     *
     * @param item     the item to be stored in this slot
     * @param capacity the maximum capacity of this slot
     * @param quantity the initial quantity of the item in this slot
     */
    public ItemSlot(Item item, int capacity, int quantity) {
        this.item = item;
        this.capacity = capacity;
        this.quantity = quantity;
        this.sales = 0;
    }

    /**
     * Returns the item stored in this ItemSlot.
     *
     * @return the item stored in this ItemSlot
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets the item to be stored in this ItemSlot.
     *
     * @param item the item to be stored
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Returns the maximum capacity of this ItemSlot.
     *
     * @return the maximum capacity of this ItemSlot
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the maximum capacity of this ItemSlot.
     *
     * @param capacity the maximum capacity to be set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Returns the quantity of items currently stored in this ItemSlot.
     *
     * @return the quantity of items in this ItemSlot
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of items to be stored in this ItemSlot.
     *
     * @param quantity the quantity of items to be set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the number of sales for this item.
     *
     * @return The number of sales for this item.
     */
    public int getSales() {
        return sales;
    }

    /**
     * Sets the number of sales for this item.
     *
     * @param sales The number of sales for this item.
     */
    public void setSales(int sales) {
        this.sales = sales;
    }
}
