/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoitower;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class AppFrame extends JFrame {

    protected JTextField discCountField;
    protected DrawingPanel drawingPanel;
    protected JButton moveButton;

    public AppFrame(TowerMover mover) {
        setTitle("Hanoi Tower");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (7 * dimension.getWidth() / 10), (int) (7 * dimension.getHeight() / 10));
        setLocation((int) ((dimension.getWidth() - getWidth()) / 2), (int) ((dimension.getHeight() - getHeight()) / 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel northPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        northPanel.add(new JLabel("Enter disc count:"));
        northPanel.add(discCountField=new JTextField(10));
        drawingPanel=new DrawingPanel(mover);
        mover.setDrawingPanel(drawingPanel);
        JPanel buttonPanel=new JPanel();
        buttonPanel.add(moveButton=new JButton("Move"));
        moveButton.addActionListener(actionListener);
        
        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    protected ActionListener actionListener=new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            try {
                drawingPanel.fillPag(Integer.parseInt(discCountField.getText()));
                drawingPanel.moveTower();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };
}
