/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_L;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_P;
import static java.awt.event.KeyEvent.VK_S;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import virtualworld.MyException;
import world.World;

/**
 *
 * @author Kasia
 */
public class MoveListener implements KeyListener {
    private World world;
    private MainFrame mainFrame;

    public MoveListener(MainFrame mainFrame, World world) {
        this.world = world;
        this.mainFrame = mainFrame;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e){
        if (e.getExtendedKeyCode() == VK_L) {
            try
          {
             FileInputStream fileIn = new FileInputStream("game.txt");
             ObjectInputStream in = new ObjectInputStream(fileIn);
             world = (World) in.readObject();
             in.close();
             fileIn.close();
          } catch(IOException i)
          { 
              mainFrame.report.addReport("Odczyt z pliku nie powiodl sie.");
          } catch(ClassNotFoundException c)
          {
              mainFrame.report.addReport("Odczyt z pliku nie powiodl sie.");
          }
            mainFrame.getGame().refreshButtons(world); 
            world.getReports().clear();
            mainFrame.getReport().refreshReports(world.getReports());
        }
        else if (e.getExtendedKeyCode() == VK_S) {
            world.saveGame();
        }
        else if (e.getExtendedKeyCode() == VK_N) {
            world.newGame();
            mainFrame.getGame().refreshButtons(world); 
            world.getReports().clear();
            mainFrame.getReport().refreshReports(world.getReports());
        }
        else {
            try {
                if (world.getHuman() == null) throw new MyException("Brak czlowieka.");
                world.getHuman().setKey(e.getExtendedKeyCode());
                if (world.getHuman().getStrengthBonusFlag() > 0 ||
                    world.getHuman().getStrengthBonusFlag() <= -5 && (e.getExtendedKeyCode() == VK_P)) {
                    mainFrame.create.setPowerInfo("Moc specjalna trwa.");
                }
                else mainFrame.create.setPowerInfo("Moc specjalna - zwiekszenie sily");
            } catch (MyException ex) {
                world.report(ex.message());
            }
            world.nextTurn(mainFrame);
            mainFrame.getReport().refreshReports(world.getReports());
            world.getReports().clear();
            mainFrame.getGame().refreshButtons(world);   
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
