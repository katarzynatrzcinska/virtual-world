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
public class Grass extends Plant {
     public Grass(int x, int y, World world) {
        super(x, y, world);
        this.strength = 0;
        this.initiative = 0;
    }
    
    public void action() {
       super.action(1);
    }
    
    @Override
    public String getName() {
        return "Trawa";
    }
    
    @Override
    public void collision(int x, int y) {}
}
