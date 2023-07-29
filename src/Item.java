/**
 * The Item class represents an item that can be sold in a vending machine.
 * It contains information about the name, price, and calorie count of the item.
 */

public class Item {
    private String name;
    private double price;
    private int calories;

    /**
     * Constructs a new Item with the specified name, price, and calorie count.
     *
     * @param name     the name of the item
     * @param price    the price of the item
     * @param calories the calorie count of the item
     */
    public Item(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the item.
     *
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the calorie count of the item.
     *
     * @return the calorie count of the item
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the name of the item to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the price of the item to be set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the calorie count of the item.
     *
     * @param calories the calorie count of the item to be set
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }
}
