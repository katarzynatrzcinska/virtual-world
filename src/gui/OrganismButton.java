/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Insets;
import javax.swing.JButton;

/**
 *
 * @author Kasia
 */
public class OrganismButton extends JButton {
        public int x;
        public int y;
        MainFrame mainFrame;
        public OrganismButton(String string, int x, int y, MainFrame mainFrame) {
            super(string);
            setBorder(null);
            setMargin(new Insets(0, 0, 0, 0));
            this.x = x;
            this.y = y;
            this.mainFrame = mainFrame;
        }   
        
        public void setSelected() {
            mainFrame.create.show(this);
        }
        
        public void paintComponent() {}
}
