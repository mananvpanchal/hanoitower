/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoitower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class DrawingPanel extends JPanel {

    public Object getLock() {
        return lock;
    }
    protected TowerMover mover;
    protected Object lock;

    public DrawingPanel(TowerMover mover) {
        this.mover = mover;
        lock = new Object();
    }

    public void fillPag(int count) {
        mover.fillSource(count);
    }

    public void moveTower() throws Exception {
        new Thread(new Runnable() {

            public void run() {
                try {
                    synchronized (lock) {
                        repaint();
                        lock.wait(1000);
                        mover.moveTowerSleep();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("thread done");
            }
        }).start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        Rectangle rect = g.getClipBounds();
        g.fillRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
        g.setColor(Color.BLACK);
        g.drawLine(10, (int) (rect.getHeight() - 10), (int) (rect.getWidth() - 10), (int) (rect.getHeight() - 10));
        mover.paintMove(g);
    }
    protected Thread thread = new Thread(new Runnable() {

        public void run() {
            try {
                synchronized (lock) {
                    repaint();
                    lock.wait(1000);
                    mover.moveTowerSleep();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("thread done");
        }
    });
}
