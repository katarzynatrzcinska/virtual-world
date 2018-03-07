/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworld;

import gui.Game;
import java.io.IOException;
import world.World;
import gui.MainFrame;
import gui.MoveListener;

/**
 *
 * @author Kasia
 */
public class VirtualWorld {
        private final static int WIDTH = 20;
        private final static int HEIGHT = 20;
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
        
    public static void main(String[] args) throws IOException {
        World swiat = new World(WIDTH, HEIGHT);
        swiat.newGame();
        MainFrame program = new MainFrame(swiat);
        MoveListener moveListener = new MoveListener(program, swiat);
        program.addKeyListener(moveListener);
        Game game = program.getGame();
        game.refreshButtons(swiat);
    }
}