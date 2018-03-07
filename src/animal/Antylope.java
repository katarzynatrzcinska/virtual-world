/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import java.util.Random;
import world.Position;
import world.World;

/**
 *
 * @author Kasia
 */
public class Antylope extends Animal {
    public Antylope (int x, int y, World world) {
        super(x, y, world);
        this.strength = 4;
        this.initiative = 4;
    }
    
    @Override
    public void collision(int x, int y) {
        if(world.getOrganism(x, y) instanceof Antylope) {
            Position tmp = world.getFree(this);
            if(tmp != null) {
                new Antylope(tmp.getX(), tmp.getY(), world);
             }            
        }
        else super.collision(x, y);
    }
    
    public boolean collision() {
        Random generator = new Random();
        Position tmp = world.getFree(this);
        if(generator.nextInt(2) == 1 && tmp != null) {
            moveAnimal(tmp.getX(), tmp.getY());
            return true;
        }
        return false;
    }
    
    @Override
    public void action(int range) {
        super.action(2);
    }
    
    @Override
    public String getName() {
        return "Antylopa";
    }
}
