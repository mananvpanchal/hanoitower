/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoitower;

import java.awt.Graphics;

/**
 *
 * @author Administrator
 */
public class Disc {

    protected int index;
    protected int width;
    protected int height;
    
    public Disc(int index, int width) {
        this.index=index;
        this.width=width;
        this.height=10;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void paintDisc(Graphics g, int pagX, int pagY) {
        g.drawRect(pagX-width/2, pagY, width, height);
    }
    public String toString() {
        return index+"";
    }
}
