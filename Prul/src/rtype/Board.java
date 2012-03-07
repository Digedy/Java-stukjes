package rtype;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    Image star;
    Image twee;
    Timer timer;
    int x, y;
    Random random = new Random();
    int rol = 0;

    public Board() {
        setBackground(Color.BLACK);

        ImageIcon ii =
            new ImageIcon(this.getClass().getResource("3.png"));
        star = ii.getImage();

        ImageIcon ij =
            new ImageIcon(this.getClass().getResource("32.gif"));
        twee = ij.getImage();

        setDoubleBuffered(true);

        x = y = 10;
        timer = new Timer(25, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        if(rol ==0){
        g2d.drawImage(star, x, y, this);
        }
        else{
            g2d.drawImage(twee,x,y,this);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {

        x += 1;
        y += 1;
        rol = random.nextInt(2);
        if (y > 240) {
            y = -45;
            x = -45;
        }
        repaint();
    }
}