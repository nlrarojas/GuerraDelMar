package model;

/**
 *
 * @author Nelson
 */
public class Fabric extends ComponentOcean{
    private int speed;
    
    public Fabric(int price, int rows, int columns, int pSpeed) {
        super(price, rows, columns);
        this.speed = pSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
