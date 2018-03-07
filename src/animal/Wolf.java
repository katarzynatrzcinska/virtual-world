/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import animal.Animal;
import world.Position;
import world.World;

/**
 *
 * @author Kasia
 */
public class Wolf extends Animal {
    public Wolf (int x, int y, World world) {
        super(x, y, world);
        this.strength = 9;
        this.initiative = 5;
    }
    
    @Override
    public void collision(int x, int y) {
        if(world.getOrganism(x, y) instanceof Wolf) {
            Position tmp = world.getFree(this);
            if(tmp != null) {
                new Wolf(tmp.getX(), tmp.getY(), world);
            }            
        }
        else super.collision(x, y);
    }
    
    @Override
    public void action(int range) {
        super.action(1);
    }
    
    @Override
    public String getName() {
        return "Wilk";
    }
}
