/**
 * Represents the denominations of currency in a vending machine.
 * Currency separated into bills and coins of differing values.
 */

public class Denominations {

    private int p1Coin;
    private int p5Coin;
    private int p10Coin;
    private int p20Coin;
    private int p20Bill;
    private int p50Bill;
    private int p100Bill;
    private int p200Bill;
    private int p500Bill;
    private int p1000Bill;

    /**
     * Constructs a new instance of the Denominations class with all denominations set to zero.
     */
    public Denominations() {
        this.p1Coin = 0;
        this.p5Coin = 0;
        this.p10Coin = 0;
        this.p20Coin = 0;
        this.p20Bill = 0;
        this.p50Bill = 0;
        this.p100Bill = 0;
        this.p200Bill = 0;
        this.p500Bill = 0;
        this.p1000Bill = 0;
    }

    /**
     * Returns the number of 1 Peso coins in the denominations.
     *
     * @return The number of 1 Peso coins.
     */
    public int getP1Coin() {
        return p1Coin;
    }

    /**
     * Sets the number of 1 Peso coins in the denominations.
     *
     * @param p1Coin The number of 1 Peso coins to set.
     */
    public void setP1Coin(int p1Coin) {
        this.p1Coin = p1Coin;
    }

    /**
     * Returns the number of 5 Peso coins in the denominations.
     *
     * @return The number of 5 Peso coins.
     */
    public int getP5Coin() {
        return p5Coin;
    }

    /**
     * Sets the number of 5 Peso coins in the denominations.
     *
     * @param p5Coin The number of 5 Peso coins to set.
     */
    public void setP5Coin(int p5Coin) {
        this.p5Coin = p5Coin;
    }

    /**
     * Returns the number of 10 Peso coins in the denominations.
     *
     * @return The number of 10 Peso coins.
     */
    public int getP10Coin() {
        return p10Coin;
    }

    /**
     * Sets the number of 10 Peso coins in the denominations.
     *
     * @param p10Coin The number of 10 Peso coins to set.
     */
    public void setP10Coin(int p10Coin) {
        this.p10Coin = p10Coin;
    }

    /**
     * Returns the number of 20 Peso coins in the denominations.
     *
     * @return The number of 20 Peso coins.
     */
    public int getP20Coin() {
        return p20Coin;
    }

    /**
     * Sets the number of 20 Peso coins in the denominations.
     *
     * @param p20Coin The number of 20 Peso coins to set.
     */
    public void setP20Coin(int p20Coin) {
        this.p20Coin = p20Coin;
    }

    /**
     * Returns the number of 20 Peso bills in the denominations.
     *
     * @return The number of 20 Peso bills.
     */
    public int getP20Bill() {
        return p20Bill;
    }

    /**
     * Sets the number of 20 Peso bills in the denominations.
     *
     * @param p20Bill The number of 20 Peso bills to set.
     */
    public void setP20Bill(int p20Bill) {
        this.p20Bill = p20Bill;
    }

    /**
     * Returns the number of 50 Peso bills in the denominations.
     *
     * @return The number of 50 Peso bills.
     */
    public int getP50Bill() {
        return p50Bill;
    }

    /**
     * Sets the number of 50 Peso bills in the denominations.
     *
     * @param p50Bill The number of 50 Peso bills to set.
     */
    public void setP50Bill(int p50Bill) {
        this.p50Bill = p50Bill;
    }

    /**
     * Returns the number of 100 Peso bills in the denominations.
     *
     * @return The number of 100 Peso bills.
     */
    public int getP100Bill() {
        return p100Bill;
    }

    /**
     * Sets the number of 100 Peso bills in the denominations.
     *
     * @param p100Bill The number of 100 Peso bills to set.
     */
    public void setP100Bill(int p100Bill) {
        this.p100Bill = p100Bill;
    }

    /**
     * Returns the number of 200 Peso bills in the denominations.
     *
     * @return The number of 200 Peso bills.
     */
    public int getP200Bill() {
        return p200Bill;
    }

    /**
     * Sets the number of 200 P

     eso bills in the denominations.
     *
     * @param p200Bill The number of 200 Peso bills to set.
     */
    public void setP200Bill(int p200Bill) {
        this.p200Bill = p200Bill;
    }

    /**
     * Returns the number of 500 Peso bills in the denominations.
     *
     * @return The number of 500 Peso bills.
     */
    public int getP500Bill() {
        return p500Bill;
    }

    /**
     * Sets the number of 500 Peso bills in the denominations.
     *
     * @param p500Bill The number of 500 Peso bills to set.
     */
    public void setP500Bill(int p500Bill) {
        this.p500Bill = p500Bill;
    }

    /**
     * Returns the number of 1000 Peso bills in the denominations.
     *
     * @return The number of 1000 Peso bills.
     */
    public int getP1000Bill() {
        return p1000Bill;
    }

    /**
     * Sets the number of 1000 Peso bills in the denominations.
     *
     * @param p1000Bill The number of 1000 Peso bills to set.
     */
    public void setP1000Bill(int p1000Bill) {
        this.p1000Bill = p1000Bill;
    }

    /**
     * Computes the total amount of money represented by the given denominations object
     *
     * @param denominations The denominations object representing the quantities of different coins and bills.
     * @return The total amount of money computed from the denominations.
     */
    public double computeTotal(Denominations denominations) {
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

        return totalMoney;
    }
    /**
     * Empties the money stored in the vending machine by setting the quantities of all denominations to zero.
     *
     * @param denominations The denominations object representing the quantities of different coins and bills to be emptied.
     */
    public void emptyMachine(Denominations denominations) {
        setP1Coin(0);
        setP5Coin(0);
        setP10Coin(0);
        setP20Coin(0);
        setP20Bill(0);
        setP50Bill(0);
        setP100Bill(0);
        setP200Bill(0);
        setP500Bill(0);
        setP1000Bill(0);
    }

}
