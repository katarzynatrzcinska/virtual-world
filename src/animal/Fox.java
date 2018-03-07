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
public class Fox extends Animal {
    public Fox (int x, int y, World world) {
        super(x, y, world);
        this.strength = 3;
        this.initiative = 7;
    }
    
    @Override
    public void collision(int x, int y) {
        if(world.getOrganism(x, y) instanceof Fox) {
            Position tmp = world.getFree(this);
            if(tmp != null) {
                new Fox(tmp.getX(), tmp.getY(), world);
             }            
        }
        else super.collision(x, y);
    }
    
    @Override
    public void action(int range) {
        Random generator = new Random();
        int x, y;
        do {
            x = generator.nextInt(3)-1;
            y = generator.nextInt(3)-1;
        } while (x == 0 && y == 0);
        
        if(!checkCollisionOnBorder(getX() + x, getY() + y)) {
            if(world.getOrganism(getX() + x, getY() + y) == null) 
                moveAnimal(getX() + x, getY() + y);
            else if(world.getOrganism(getX() + x, getY() + y).getStrength() <= strength) 
                moveAnimal(getX() + x, getY() + y);   
            }
    }
    
    @Override
    public String getName() {
        return "Lis";
    }
}
