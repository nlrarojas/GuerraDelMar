package model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Nelson
 */
public class Bomb extends Weapon{
    
    private Queue<Bomb> bombList;
    private Random random;
    public Bomb(String weaponType, int price, int rows, int columns) {
        super(weaponType, price, rows, columns);
        this.bombList = new LinkedList<>();        
        random = new Random();
        loadBombs();
    }
    
    private void loadBombs(){
        this.bombList.add(new Bomb(weaponType, price, rows, columns));
        this.bombList.add(new Bomb(weaponType, price, rows, columns));
        this.bombList.add(new Bomb(weaponType, price, rows, columns));
    }
    
    public boolean randomBomb(){
        return random.nextBoolean();
    }
    
    public Bomb getBomb(){
        return bombList.poll();
    }
}
