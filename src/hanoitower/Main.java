/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoitower;

import java.util.Stack;

/**
 *
 * @author Administrator
 */
public class Main {
    
    public static void main(String[] args) {
        
        //Console View
        /*TowerMover mover=new TowerMover();
        mover.fillSource(5);
        mover.display();
        mover.moveTower();
        mover.display();*/
        
        
        //Frame View
        TowerMover mover=new TowerMover();
        AppFrame frame=new AppFrame(mover);
        frame.setVisible(true);
    }
    
}
