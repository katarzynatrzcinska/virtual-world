/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organism;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Kasia
 */
public class Container implements Serializable {
    private List<Organism> container = new ArrayList<Organism>();
   
    public void addToContainer(Organism organism) {
        container.add(organism);
    }
    
    public void deleteFromContainer(Organism organism) {
        for (int i=0; i<container.size(); i++) {
            if (organism.equals(container.get(i))) {
                container.set(i, null);
            }
        }       
    }
    
    public void deleteFromContainer(int index) {
         container.set(index, null);
    }
    
    public void eraseAll() {
        for (int i=0; i<container.size(); i++) {
            if (container.get(i) == null) {
                container.remove(i);
                i--;
            }
        }    
    }
    
    public void sort() {
        for(int i=container.size() -1; i >= 0; i--) {
            for (int j=0; j<i; j++) {
                if (container.get(j).initiative < container.get(j+1).initiative) {
                   Collections.swap(getContainer(), j, j+1);
                }
                else if(container.get(j).initiative == container.get(j+1).initiative 
                        && container.get(j).birthday > container.get(j+1).birthday) {
                    Collections.swap(getContainer(), j, j+1);
                }

            }
        }
    }
    
    public int getSize() {
        return container.size();
    }
    
    public List<Organism> getContainer() {
        return container;
    }
    
    public Organism getOrganism(int index) {
        return container.get(index);
    }

    public Organism searchForOrganism(int x, int y){
        for(int i=0;i<container.size();i++){
            if (container.get(i) != null && container.get(i).getX()==x && container.get(i).getY()==y) {
                return container.get(i);
            }
        }
        return null;
    }
}
