/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import world.World;

/**
 *
 * @author Kasia
 */
public class Create extends JPanel {
    int selectedX;
    int selectedY;
    private JLabel powerInfo = new JLabel("Moc specjalna - zwiekszenie sily");
    private JLabel position = new JLabel("Pole");
    private JLabel addInfo = new JLabel("Dodaj organizm:");
    private JLabel nameInfo = new JLabel("");
    private JLabel strengthInfo = new JLabel("Sila:");
    private JLabel initiativeInfo = new JLabel("Inicjatywa:");
    private JComboBox organisms = new JComboBox();
    private JButton add = new JButton("Dodaj");
    private World world;
    private MainFrame mainFrame;
    
    public Create(World world, MainFrame mainFrame) {
        this.world = world;
        this.mainFrame = mainFrame;   
        setLayout(new GridBagLayout());
        addToComboBox();
        ButtonsListener buttonsListener = new ButtonsListener(world, mainFrame);
        add.addActionListener(buttonsListener);
        add.setFocusable(false);
        organisms.addActionListener(buttonsListener);
        organisms.setFocusable(false);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(2, 0, 0, 0);
        add(powerInfo, gbc);
        gbc.gridy = 2;
        gbc.insets = new Insets(15, 0, 0, 0);
        add(position, gbc);
        gbc.insets = new Insets(2, 0, 0, 0);
        gbc.gridy = 3;
        add(addInfo, gbc);
        add(nameInfo, gbc);
        gbc.gridy = 4;
        add(organisms, gbc);
        add(strengthInfo, gbc);
        gbc.gridy = 5;
        add(add, gbc);
        add(initiativeInfo, gbc);
        show(null);
    }

    public String getSelected() {
        return organisms.getSelectedItem().toString();
    }
    
    public void addToComboBox() {
        organisms.addItem("Wilk");
        organisms.addItem("Antylopa");
        organisms.addItem("Lis");
        organisms.addItem("Owca");
        organisms.addItem("Zolw");
        organisms.addItem("Mlecz");
        organisms.addItem("Trawa");
        organisms.addItem("Wilcze jagody");
        organisms.addItem("Guarana");
        organisms.setSelectedIndex(0);
    }
    
    public void setPosition(int x, int y) {
        selectedX = x;
        selectedY = y;
        position.setText("Pole: (" + x + ", " + y + ")");
    }
    
    public void setName(String name) {
        nameInfo.setText(name);
    }
    
    public void setStrength(int strength) {
        strengthInfo.setText("Sila " + strength);
    }
        
    public void setInitiative(int initiative) {
        initiativeInfo.setText("Inicjatywa " + initiative);
    }
    
    public void setPowerInfo(String string) {
        powerInfo.setText(string);
    }
      
    public void show(OrganismButton button) {
        if (button == null) {
            position.setVisible(false);
            addInfo.setVisible(false);
            organisms.setVisible(false);
            add.setVisible(false);
            nameInfo.setVisible(false);
            strengthInfo.setVisible(false);
            initiativeInfo.setVisible(false);
        }
        else if (world.getOrganism(button.x, button.y) == null){
            setPosition(button.x, button.y);
            position.setVisible(true);
            addInfo.setVisible(true);
            organisms.setVisible(true);
            add.setVisible(true);
            nameInfo.setVisible(false);
            strengthInfo.setVisible(false);
            initiativeInfo.setVisible(false);
        }
        else {
            setPosition(button.x, button.y);
            setName(world.getOrganism(button.x, button.y).getName());
            setStrength(world.getOrganism(button.x, button.y).getStrength());
            setInitiative(world.getOrganism(button.x, button.y).getInitiative());
            position.setVisible(true);
            addInfo.setVisible(false);
            organisms.setVisible(false);
            add.setVisible(false);
            nameInfo.setVisible(true);
            strengthInfo.setVisible(true);
            initiativeInfo.setVisible(true);
        }
    }
}
