/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoitower;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Stack;

/**
 *
 * @author Administrator
 */
public class Pag extends Stack {
    
    protected String name;
    
    public Pag(String name) {
        this.name=name;
    }
    
    public String toString() {
        return name+": "+super.toString();
    }
    
    public void paintPag(Graphics g, int x, int y) {
        Rectangle rect=g.getClipBounds();
        int discHeight=10;
        int pagHeight=10;
        for(int i=0;i<size();i++) {
            Disc disc=(Disc)get(i);
            disc.paintDisc(g, x, y-pagHeight);
            //g.drawRect(x-discWidth/2, y-pagHeight, discWidth, discHeight);
            pagHeight=pagHeight+10;
        }
    }
}
