package model;

import java.util.Random;

/**
 *
 * @author Nelson
 */
public class WildCard extends ComponentOcean{
    String tipoComodin;
    boolean shieldActivate;
    Random random;
    public WildCard(String tipoComodin, int price, int rows, int columns) {
        super(price, rows, columns);
        this.tipoComodin = tipoComodin;
        random = new Random();
    }
    
    public int disparos(){
        return random.nextInt(3) + 2;
    }

    public String getTipoComodin() {
        return tipoComodin;
    }

    public void setTipoComodin(String tipoComodin) {
        this.tipoComodin = tipoComodin;
    }

    public boolean isShieldActivate() {
        return shieldActivate;
    }

    public void setShieldActivate(boolean shieldActivate) {
        this.shieldActivate = shieldActivate;
    }        
}
