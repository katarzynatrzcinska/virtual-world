/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import world.Position;
import world.World;

/**
 *
 * @author Kasia
 */
public class Tortoise extends Animal {
    private int counterOfMoves;
    public Tortoise (int x, int y, World world) {
        super(x, y, world);
        this.strength = 2;
        this.initiative = 1;
        this.counterOfMoves = 0;
    }
    
    @Override
    public void collision(int x, int y) {
        if(world.getOrganism(x, y) instanceof Tortoise) {
            Position tmp = world.getFree(this);
             if(tmp != null) {
                new Tortoise(tmp.getX(), tmp.getY(), world);
             }            
        }
        else super.collision(x, y);
    }
    
    @Override
    public void action(int range) {
        counterOfMoves++;
        if (counterOfMoves % 4 == 0)
            super.action(range);
        counterOfMoves %= 4;
    }
    
    @Override
    public String getName() {
        return "Zolw";
    }
}
