package model;

/**
 *
 * @author Nelson
 */
public class Weapon extends ComponentOcean {
    protected String weaponType;

    public Weapon(String weaponType, int price, int rows, int columns) {
        super(price, rows, columns);
        this.weaponType = weaponType;
    }   

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }        
}
