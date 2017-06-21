package model;

/**
 *
 * @author Nelson
 */
public class Torpedo extends Weapon{
    protected int quantity;
    
    public Torpedo(String weaponType, int price, int rows, int columns) {
        super(weaponType, price, rows, columns);
        this.quantity = 10;
    }

    public int getQuantity() {
        return quantity--;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }       
}
