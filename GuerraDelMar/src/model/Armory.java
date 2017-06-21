package model;

/**
 *
 * @author Nelson
 */
public class Armory extends Fabric{
    
    public Armory(int price, int rows, int columns, int pSpeed) {
        super(price, rows, columns, pSpeed);
    }
    
    public Weapon generateWeapon(String pTipoWeapon, int price, int rows, int columns){
        return new Weapon(pTipoWeapon, price, rows, columns);
    }
}
