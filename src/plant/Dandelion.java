/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plant;

import world.World;

/**
 *
 * @author Kasia
 */
public class Dandelion extends Plant {
    private static final int REPRODUCTION_AMOUNT=3;
    
    public Dandelion(int x, int y, World world) {
        super(x, y, world);
        this.strength = 0;
        this.initiative = 0;
    }
    
    public void action() {
        for(int i=0;i<REPRODUCTION_AMOUNT;i++) {
            super.action(1);
        }
    }
    
    @Override
    public String getName() {
        return "Mlecz";
    }
    
    @Override
    public void collision(int x, int y) {}
}
