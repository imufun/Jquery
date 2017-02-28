/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingfighter;

import gameloop.StartingClass;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author imran
 */
public class KingFighter {

    public static void main(String[] args) {
        Display display = new Display(800, 600, "!!!!");
        StartingClass startingClass = new StartingClass();
        startingClass.init();
    }

}
