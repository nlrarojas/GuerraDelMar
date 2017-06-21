package model;

/**
 *
 * @author Nelson
 */
public class Mine extends Fabric{
    private int steelAmount;
    
    public Mine(int price, int rows, int columns, int pSpeed) {
        super(price, rows, columns, pSpeed);
        this.steelAmount = 0;
    }
    
    public void fabricSteel(){
        this.steelAmount += 50;
    }

    public int getSteelAmount() {
        return steelAmount;
    }

    public void setSteelAmount(int steelAmount) {
        this.steelAmount = steelAmount;
    }
}
