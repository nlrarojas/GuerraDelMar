package model;

/**
 *
 * @author Nelson
 */
public class Temple extends Fabric{        
    public Temple(int price, int rows, int columns, int pSpeed) {
        super(price, rows, columns, pSpeed);
    }
    
    public WildCard generateWildCard(String pWildCardType){
        return new WildCard(pWildCardType, price, rows, columns);
    }
}
