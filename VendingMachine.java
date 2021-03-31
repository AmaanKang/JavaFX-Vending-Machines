
/*This class runs a vending machine located in a break room. Various functions of the machine are:
 *1. User can add money to the credit.
 *2. User can take back the unused credit.
 *3. User can vend an item.
 * @author Amandeep Kaur
 *
 * Date Created: July 14, 2020
 */

public class VendingMachine {

    //price of the product
    private double productPrice;
    //name of the product
    private String productName;
    //number of the items left in the machine
    private int productQuantity;
    //unused credit of the user
    private double unusedCredit;
    //the total amount of money vended
    private double amountMoney;

    /**
     * @return number of items in the machine
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * @param productQuantity number of products
     */
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * @return price of the item
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice price of item
     */
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return name of the item
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName name of the item
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return amount of money vended since the machine started
     */
    public double getAmountMoney() {
        return amountMoney;
    }

    /**
     * @param amountMoney amount of money vended
     */
    public void setAmountMoney(double amountMoney) {
        this.amountMoney = amountMoney;
    }

    /**
     * @param unusedCredit unused money left in the machine
     */
    public void setUnusedCredit(double unusedCredit) {
        this.unusedCredit = unusedCredit;
    }

    /**
     * @return unused money
     */
    public double getUnusedCredit() {
        return unusedCredit;
    }

    /**
     * method used for entering money in machine
     *
     * @param amount money to be deposited in machine
     */
    public void enterMoney(double amount) {
        if (amount > 0) {
            unusedCredit = unusedCredit + amount;
            amountMoney = amountMoney + amount;
        }
    }

    /**
     * gives the change back
     *
     * @return all the unused money left in the machine
     */
    public double coinReturn() {
        unusedCredit = 0;
        amountMoney = amountMoney - unusedCredit;
        return unusedCredit;
    }

    /**
     * vends an item if the credit is enough and items are available
     *
     * @return vended item
     */
    public double vendItem() {
        if (unusedCredit >= productPrice && productQuantity > 0) {
            unusedCredit -= productPrice;
            amountMoney += productPrice;
            productQuantity--;
        }
        return productQuantity;
    }

    /**
     * @return string representation of vending machine
     */
    public String toString() {
        return (productQuantity + " " + productName + ", " + "$ " + String.format("%.2f", productPrice) + " each" + "\n" + "Unused Credit is: " + "$ " + String.format("%.2f", unusedCredit) + "\n" + "Money vended is: " + "$ " + String.format("%.2f", amountMoney) + ".");
    }


}
