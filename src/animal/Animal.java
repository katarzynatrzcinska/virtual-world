/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import java.util.Random;
import organism.Organism;
import world.World;
import plant.*;

/**
 *
 * @author Kasia
 */
abstract public class Animal extends Organism {
    public Animal(int x, int y, World world){
        super(x, y, world);
    }
    
    @Override
    public void action(int range) {
        Random generator = new Random();
        int x, y;
	do {
		x = generator.nextInt(range * 2 + 1) - range;
		y = generator.nextInt(range * 2 + 1) - range;
	} while (x == 0 && y == 0);
        this.moveAnimal(getX() + x, getY() + y);
    }
    
    @Override
    public void collision(int x, int y) {
        if(world.getOrganism(x, y) instanceof DeadlyNightshade) {
            this.eatInfo(world.getOrganism(x, y));
            world.getOrganism(x, y).collision(this.getX(), this.getY());
        }
        else if(world.getOrganism(x, y) instanceof Antylope && ((Antylope)world.getOrganism(x, y)).collision()) {
            moveAnimal(x,y);
        }
        else if(world.getOrganism(x, y) instanceof Tortoise && this.strength < 5);
        else if(this.strength < world.getOrganism(x, y).getStrength()) {
            if(world.getOrganism(x, y) instanceof Animal)
                (world.getOrganism(x, y)).beatInfo(this);
            else 
                this.eatInfo(world.getOrganism(x, y));
            if (this instanceof Human) 
                deadInfo();
            this.deleteOrganism();
        }
        else {
            if(world.getOrganism(x, y) instanceof Animal) 
                this.beatInfo(world.getOrganism(x, y));
            else {
                this.eatInfo(world.getOrganism(x, y)); 
                world.getOrganism(x, y).collision(this.getX(), this.getY());
            }
            world.getOrganism(x, y).deleteOrganism();
            this.moveAnimal(x, y);
        }
    }
    
    public void moveAnimal(int x, int y) {
        if(!checkCollisionOnBorder(x,y))
        {
            if((world.getOrganism(x, y) != null))
            {
                collision(x,y);
            }
            else {
                this.setXY(x, y);
            }
        }
    }
}
