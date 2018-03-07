/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import animal.*;
import plant.*;
import gui.MainFrame;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import organism.Container;
import organism.Organism;


/**
 *
 * @author Kasia
 */
public class World implements Serializable{
    private int height;
    private int width;
    private int turns;
    private Container container;
    private List<String> infoList = new ArrayList<String>();
    private final static int NUMBEROFORGANISMS = 20;
    
    public World(int height, int width) {
        this.height = height;
        this.width = width;
        turns = 0;
        container = new Container();
    }
    
    public void nextTurn(MainFrame mainFrame) {
        turns++;
        for(int i=0;i<getContainer().getSize();i++) {
            if (getContainer().getOrganism(i) != null
                && getContainer().getOrganism(i).getBirthday() < turns)
		{
			getContainer().getOrganism(i).action(1);
		}
        }
        getContainer().eraseAll();
        getContainer().sort();
        
    }
    public Container getContainer() {
        return container;
    }
    
    public int getTurns() {
        return turns;
    }
    
    public int getHeigth() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public Organism getOrganism(int x, int y) {
        return container.searchForOrganism(x, y);
    }
    
    public boolean checkCollision(int x, int y) {
        if(container.searchForOrganism(x, y) == null) return false;
        else return true;
    }
    
    public Position getFree(Organism organism) {
        int i = -1, j = -1;
	while (i<2
		&& !(!organism.checkCollisionOnBorder(organism.getX() + i, organism.getY() + j)
                && organism.getWorld().getOrganism(organism.getX() + i, organism.getY() + j) == null))
	{
		j++;
		if (j == 2) {
			i++;
			j = -1;
		}
	}
	if (i != 2) return new Position(organism.getX() + i, organism.getY() + j);
	else return null;
    }
    
    public void report(String info) {
        infoList.add(info);
    }

    public List<String> getReports() {
        return infoList;
    }
    
    public Human getHuman() {
        for(int i=0;i<getContainer().getSize();i++) {
            if (getContainer().getOrganism(i) != null)
                    if (getContainer().getOrganism(i) instanceof Human) {
                        return (Human)getContainer().getOrganism(i);
		}
        }
        return null;
    }
    
    public void newGame() {
        Random generator = new Random();
        this.getContainer().getContainer().clear();
        for (int i = 0; i < NUMBEROFORGANISMS; i++) {

		int x = generator.nextInt(this.getWidth());
		int y = generator.nextInt(this.getHeigth());
		while (this.getOrganism(x, y) != null)
		{
                    x = generator.nextInt(this.getWidth());
                    y = generator.nextInt(this.getHeigth());
		}

		switch (i) {
		case 0:
			new Human(x, y, this);
			break;
		case 1:
			new Wolf(x, y, this);
			break;
		case 2:
			new Wolf(x, y, this);
			break;
		case 3:
			new Sheep(x, y, this);
			break;
		case 4:
			new Sheep(x, y, this);
			break;
		case 5:
			new Fox(x, y, this);
			break;
		case 6:
			new Fox(x, y, this);
			break;
		case 7:
			new Tortoise(x, y, this);
			break;
		case 8:
			new Tortoise(x, y, this);
			break;
		case 9:
			new Antylope(x, y, this);
			break;
		case 10:
			new Antylope(x, y, this);
			break;
		case 11:
			new Dandelion(x, y, this);
			break;
		case 12:
			new Dandelion(x, y, this);
			break;
		case 13:
			new Grass(x, y, this);
			break;
		case 14:
			new Grass(x, y, this);
			break;
		case 15:
			new Guarana(x, y, this);
			break;
		case 16:
			new Guarana(x, y, this);
			break;
		case 17:
			new DeadlyNightshade(x, y, this);
			break;
		case 18:
			new DeadlyNightshade(x, y, this);
			break;
		}
	}
    }
    
    public void saveGame() {
        try
      {
         FileOutputStream fileOut = new FileOutputStream("game.txt");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(this);
         out.close();
         fileOut.close();
      }catch(IOException i) {}
    }
}
