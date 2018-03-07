/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import world.World;

/**
 *
 * @author Kasia
 */
public class MainFrame extends JFrame {
    private World world;
    Game game;
    private JTextArea textArea = new JTextArea();
    Report report = new Report(textArea, 
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    Create create;
    
    public MainFrame(World world) {
        create = new Create(world, this);
        game = new Game(world, this);
        this.world = world;
        setLayout(new GridBagLayout());
        setFocusable(true);
        Container contentPane = getContentPane();//pobiera środek 
        contentPane.setBackground(Color.darkGray);
        setTitle("Wirtualny świat Katarzyna Trzcińska 160871");
        GridBagConstraints gbc = new GridBagConstraints();//wybiera element
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,500);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        game.setBackground(Color.decode("#FCC072"));
        report.setBackground(Color.blue);
        create.setBackground(Color.decode("#A34351"));

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        contentPane.add(game, gbc);
        
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        contentPane.add(report, gbc);
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPane.add(create, gbc);
        
        setVisible(true);
    }
    
    public Game getGame() {
        return game;
    }
    
    public Report getReport() {
        return report;
    }
    
    public Create getCreate() {
        return create;
    }
}
