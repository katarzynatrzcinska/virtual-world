/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import static java.awt.event.KeyEvent.*;
import world.World;

/**
 *
 * @author Kasia
 */
public class Human extends Animal {
    private int strengthBonusFlag;
    private int key;
    
    public Human(int x, int y, World world) {
        super(x, y, world);
        this.strength = 5;
        this.strengthBonusFlag = -5;
        this.initiative = 4;
        key = 0;
        
    }

    @Override
    public void collision(int x, int y) {
        super.collision(x, y);
    }
    
    @Override
    public String getName() {
        return "Czlowiek";
    }
    
    @Override
    public void action(int range) {
        if (strengthBonusFlag > 0) {
		strengthBonusFlag--;
		strength--;
	}
        else if (strengthBonusFlag > -5) strengthBonusFlag--;
        switch (key) {
            case VK_LEFT:
                moveAnimal(getX()-1, getY());
                break;
            case VK_RIGHT:
                moveAnimal(getX()+1, getY());
                break;
            case VK_UP:
                moveAnimal(getX(), getY()-1);
                break;
            case VK_DOWN:
                moveAnimal(getX(), getY()+1);
                break;
            case VK_P:
		if (strengthBonusFlag <= -5) {
			strengthBonusFlag = 5;
			strength += 5;
			specialPowerInfo();
		};
            break;
        }
    }
    
    public void setKey(int key) {
        this.key = key;
    }
 
    public int getStrengthBonusFlag() {
        return strengthBonusFlag;
    }
}
