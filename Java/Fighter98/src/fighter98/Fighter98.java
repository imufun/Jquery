/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighter98;

import fighter98.display.Display.*;
import fighter98.Game.*;

public class Fighter98 {

    public static void main(String[] args) {
       Game game =  new Game("Fighter98", 800, 600);
       game.start();
    }

}
