package model;

/**
 *
 * @author Nelson
 */
public class Barco extends ComponentOcean{
    int time;
    public Barco(int price, int rows, int columns) {
        super(price, rows, columns);
        time = 90;
    }
    
}
