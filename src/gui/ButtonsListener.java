/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import animal.*;
import plant.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import world.World;

/**
 *
 * @author Kasia
 */
public class ButtonsListener implements ActionListener {
    private MainFrame mainFrame;
    private World world;
    
    ButtonsListener(World world, MainFrame mainFrame) {
        this.world = world;
        this.mainFrame = mainFrame; 
    }
    
    ButtonsListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame; 
    }
    
    ButtonsListener () {};
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o instanceof OrganismButton) {
            OrganismButton organismButton = (OrganismButton)o;
            organismButton.setSelected();
        }
        if (o instanceof JButton) {
            if (((JButton) o).getText().equals("Dodaj")) {
                if(world.getOrganism(mainFrame.getCreate().selectedX, mainFrame.getCreate().selectedY) == null) {
                switch (mainFrame.getCreate().getSelected()) {
                    case "Wilk": new Wolf(mainFrame.getCreate().selectedX, mainFrame.getCreate().selectedY,  world);
                    case "Antylopa": new Antylope(mainFrame.getCreate().selectedX, mainFrame.getCreate().selectedY,  world);
                    case "Lis": new Fox(mainFrame.getCreate().selectedX, mainFrame.getCreate().selectedY,  world);
                    case "Owca": new Sheep(mainFrame.getCreate().selectedX, mainFrame.getCreate().selectedY,  world);
                    case "Zolw": new Tortoise(mainFrame.getCreate().selectedX, mainFrame.getCreate().selectedY,  world);
                    case "Guarana": new Guarana(mainFrame.getCreate().selectedX, mainFrame.getCreate().selectedY,  world);
                    case "Mlecz": new Dandelion(mainFrame.getCreate().selectedX, mainFrame.getCreate().selectedY,  world);
                    case "Trawa": new Grass(mainFrame.getCreate().selectedX, mainFrame.getCreate().selectedY,  world);
                    case "Wilcze jagody": new DeadlyNightshade(mainFrame.getCreate().selectedX, mainFrame.getCreate().selectedY,  world);
                }
                mainFrame.getGame().refreshButtons(world); 
            }
            }
        }
    }
}