/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plant;

import java.util.Random;
import organism.Organism;
import world.Position;
import world.World;

/**
 *
 * @author Kasia
 */
abstract public class Plant extends Organism {
    private static final int PROBABILITY = 2;
    public Plant(int x, int y, World world) {
        super(x, y, world);
    }
    
    @Override
    public void action(int range) {
        Random generator = new Random();
        if(generator.nextInt(PROBABILITY) != 0) {
             Position tmp = world.getFree(this);
             if(tmp != null) {
                 if(this instanceof Dandelion) new Dandelion(tmp.getX(), tmp.getY(), world);
                 else if(this instanceof Grass) new Grass(tmp.getX(), tmp.getY(), world);
                 else if(this instanceof Guarana) new Guarana(tmp.getX(), tmp.getY(), world);
                 else if(this instanceof DeadlyNightshade) new DeadlyNightshade(tmp.getX(), tmp.getY(), world);
             }
        }
    }
}
