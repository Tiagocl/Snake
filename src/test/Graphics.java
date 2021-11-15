package test;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics extends JPanel implements ActionListener {

    private Timer t = new Timer(100,this);
    public String state;

    private Snake s;
    private Food f;
    private Game game;

    public Graphics(Game g) {
        t.start();
        state = "Start";

        game =g;
        s = g.getPlayer();
        f = g.getFood();

        //add a keylistener to our game
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }


    public void paintComponent (java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0,0,Game.width * Game.dimension, Game.height * Game.dimension);

        g2d.setColor(Color.red);
        g2d.fillRect(f.getX() * Game.dimension, f.getY() * Game.dimension, Game.width * Game.dimension,Game.height * Game.dimension);

        g2d.setColor(Color.green);

        for(Rectangle r : s.getBody()) {
            g2d.fill(r);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
