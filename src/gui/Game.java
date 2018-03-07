/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import world.World;

/**
 *
 * @author Kasia
 */
public class Game extends JPanel {
    private JButton[][] map;
    private int wymiarX;
    private int wymiarY;
    private ButtonsListener mapListener;
    private OrganismButton selected;
    private MainFrame mainFrame;
    
    public Game(World world, MainFrame mainFrame) {  
        this.mainFrame = mainFrame;
        this.wymiarX = world.getWidth();
        this.wymiarY = world.getHeigth();
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(5,5,5,5));
        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        mapListener = new ButtonsListener(mainFrame);
        map = new JButton[wymiarX][];
        for (int x=0; x<wymiarX; x++) {
            map[x]=new JButton[wymiarY];
            for (int y=0; y<wymiarY; y++) {
                map[x][y] = new OrganismButton("",x,y,mainFrame);
                map[x][y].addActionListener(mapListener);
                map[x][y].setFocusable(false);
                gbc.gridx = x;
                gbc.gridy = y;
                gbc.insets = new Insets(2,2,2,2);
                add(map[x][y], gbc);
            }
        }
    }
    
    public void refreshButtons(World world) {
        for (int x=0; x<wymiarX; x++) {
            for (int y=0; y<wymiarY; y++) {
                ImageIcon icon = new ImageIcon();
                 map[x][y].setBackground(Color.decode("#F8F2DC"));
                if(world.getOrganism(x, y) == null) {
                    icon = new ImageIcon("blank.png");
                    map[x][y].setIcon(icon);
                }
                else {
                    switch(world.getOrganism(x, y).getName()) {
                    case "Wilk":
                        icon = new ImageIcon("wilk.png");
                        break;
                    case "Owca":
                        icon = new ImageIcon("owca.png");
                        break;
                    case "Lis":
                        icon = new ImageIcon("lis.png");
                        break;
                    case "Antylopa":
                        icon = new ImageIcon("antylopa.png");
                        break;
                    case "Zolw":
                        icon = new ImageIcon("zolw.png");
                        break;
                    case "Guarana":
                        icon = new ImageIcon("guarana.png");
                        break;
                    case "Trawa":
                        icon = new ImageIcon("trawa.png");
                        break;
                    case "Wilcze jagody":
                        icon = new ImageIcon("wilcze jagody.png");
                        break;
                    case "Mlecz":
                        icon = new ImageIcon("mlecz.png");
                        break;
                    case "Czlowiek":
                        icon = new ImageIcon("czlowiek1.png");
                        break;    
                }
                    map[x][y].setIcon(icon);
                }
            }
        }
    }
}
