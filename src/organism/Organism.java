/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organism;

import java.io.Serializable;
import world.Position;
import world.World;

/**
 *
 * @author Kasia
 */
abstract public class Organism implements Serializable {
    protected int strength;
    protected int initiative;
    protected int birthday;
    protected World world;
    protected Position position;
    
    public Organism(int x, int y, World world) {
        position = new Position(x, y);
        this.world = world;
        this.birthday = world.getTurns();
        world.getContainer().addToContainer(this);
    }
    
    abstract public void collision(int x, int y);
    abstract public void action(int range);
    abstract public String getName();
    
    public boolean checkCollisionOnBorder(int x, int y) {
        if (x >= 0 
                && x < world.getWidth() 
                && y >= 0
                && y < world.getHeigth() ) return false;
        else 
            return true;
    }
    
    public int getX() { 
        return position.getX(); 
    }
    
    public int getY() { 
        return position.getY(); 
    }
    
    public int getInitiative() { 
        return initiative; 
    }
    
    public int getStrength() { 
        return strength; 
    }
    
    public int getBirthday() { 
        return birthday; 
    }
    
    public void setStrength(int strength) { 
        this.strength = strength; 
    }
    
    public World getWorld() { 
        return this.world; 
    }
    
    public void setXY(int x, int y){
        this.position.setX(x);
        this.position.setY(y);
    }
    
    public void deleteOrganism() {
        world.getContainer().deleteFromContainer(this);
    }
    
    public void reproductionInfo() {
        String info = new String(this.getName() + " rozmnaza sie.");
        world.report(info);
    }
    
    public void beatInfo(Organism looser) {
        String info = new String(this.getName() + " pokonal " + looser.getName() + ".");
        world.report(info);
    }
    
    public void deadInfo() {
        String info = new String(this.getName() + " umiera.");
        world.report(info);
    }
    
    public void eatInfo(Organism looser) {
        String info = new String(this.getName() + " zjada " + looser.getName() + ".");
        world.report(info);
    }
    
    public void specialPowerInfo() {
        String info = new String(this.getName() + " uzyl mocy specjalnej.");
        world.report(info);
    }
    public void valueSpecialPowerInfo() {
        String info = new String(this.getName() + ", moc specjalna trwa.");
        world.report(info);
    }
}
