package controller;

import model.Armory;
import model.Barco;
import model.Bomb;
import model.Market;
import model.Mine;
import model.MultiShot;
import model.Remolino;
import model.Temple;
import model.Torpedo;
import model.WildCard;

/**
 *
 * @author Nelson
 */
public class Generator {
    public Armory getArmory(){
        return new Armory(1500, 0, 0, 0);
    }
    
    public Barco getBarco(){
        return new Barco(2500, 0, 0);
    }
    
    public Bomb getBomb(){
        return new Bomb("Bomba", 2000, 0, 0);
    }
    
    public Market getMarket(){
        return new Market(2000, 0, 0);
    }
    
    public Mine getMine(){
        return new Mine(1000, 0, 0, 60);
    }
    
    public MultiShot getMultiShot(){
        return new MultiShot("MultiShot", 1000, 0, 0);
    }
    
    public Remolino getRemolino(){
        return new Remolino();
    }
    
    public Temple getTemple(){
        return new Temple(2500, 0, 0, 5 * 60);
    }
    
    public Torpedo getTorpedo(){
        return new Torpedo("Torpedo", 500, 0, 0);
    }
    
    public WildCard getWeapon(String pTipoComodin){
        return new WildCard(pTipoComodin, 0, 0, 0);
    }
}
