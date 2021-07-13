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
public class TowerMover {

    protected Pag aStack,  bStack,  cStack;
    protected int discCount;
    protected DrawingPanel drawingPanel;

    public TowerMover() {
        aStack = new Pag("A");
        bStack = new Pag("B");
        cStack = new Pag("C");
    }

    public void fillSource(int count) {
        discCount=count;
        int discWidth=100;
        for (int i = 1; i <= count; i++) {
            aStack.push(new Disc(i, discWidth));
            discWidth=discWidth-10;
        }
    }

    public void moveTower() {
        moveTower(aStack, bStack, cStack, aStack.size());
    }

    public void moveTower(Stack sourceStack, Stack targetStack, Stack interStack, int count) {
        if (count > 1) {
            moveTower(sourceStack, interStack, targetStack, count - 1);
        }
        moveDisk(sourceStack, targetStack, count - 1);
        if (count > 1) {
            moveTower(interStack, targetStack, sourceStack, count - 1);
        }
    }

    public void moveDisk(Stack sourceStack, Stack targetStack, int count) {
        targetStack.push(sourceStack.pop());
    }
    
    
    public void moveTowerSleep() throws Exception {
        moveTowerSleep(aStack, bStack, cStack, aStack.size());
    }
    
    public void moveTowerSleep(Stack sourceStack, Stack targetStack, Stack interStack, int count) throws Exception {
        if (count > 1) {
            moveTowerSleep(sourceStack, interStack, targetStack, count - 1);
        }
        moveDiskSleep(sourceStack, targetStack, count - 1);
        if (count > 1) {
            moveTowerSleep(interStack, targetStack, sourceStack, count - 1);
        }
    }
    
    public void moveDiskSleep(Stack sourceStack, Stack targetStack, int count) throws Exception {
        targetStack.push(sourceStack.pop());
        drawingPanel.repaint();
        drawingPanel.getLock().wait(1000);
    }

    public void display() {
        System.out.println(aStack);
        System.out.println(bStack);
        System.out.println(cStack);
        System.out.println();
    }
    
    public void paintMove(Graphics g) {
        Rectangle rect=g.getClipBounds();
        int aPointX=(int)rect.getWidth()/4;
        int bPointX=2*aPointX;
        int cPointX=3*aPointX;
        aStack.paintPag(g, aPointX, (int)(rect.getHeight()-10));
        bStack.paintPag(g, bPointX, (int)(rect.getHeight()-10));
        cStack.paintPag(g, cPointX, (int)(rect.getHeight()-10));
    }

    public DrawingPanel getDrawingPanel() {
        return drawingPanel;
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
}
