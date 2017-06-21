package model;

/**
 *
 * @author Nelson
 */
public class MultiShot extends Weapon{
    private boolean inTarget;
    
    public MultiShot(String weaponType, int price, int rows, int columns) {
        super(weaponType, price, rows, columns);
        this.inTarget = false;
    }        

    public Torpedo[] generateTorpedo(){
        if(inTarget){
            Torpedo [] newTorpedoes = new Torpedo[4];
            for (int i = 0; i < 4; i++) {
                newTorpedoes[i] = new Torpedo(weaponType, price, rows, columns);
            }
            return newTorpedoes;
        }
        return null;
    }
    
    public boolean isInTarget() {
        return inTarget;
    }

    public void setInTarget(boolean inTarget) {
        this.inTarget = inTarget;
    }        
}
