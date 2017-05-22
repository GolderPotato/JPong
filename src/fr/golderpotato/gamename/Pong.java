package fr.golderpotato.gamename;

import fr.golderpotato.gamename.entity.Entity;
import fr.golderpotato.gamename.entity.entities.Ball;
import fr.golderpotato.gamename.entity.entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.*;

/**
 * Created by Eliaz on 21/05/2017.
 */
public class Pong extends Canvas implements Runnable, KeyListener{

    public static Pong GAME;
    public boolean running = true;
    public int WIDTH = 0;
    public int HEIGHT = 0;
    public JFrame jFrame;
    public java.util.List<Entity> entities = new ArrayList<>();
    public int runningTicks = 0;
    public Ball BALL;
    public Player P1;
    public Player P2;
    public int playerSpeed = 15;



    public Pong(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.WIDTH = (int)screenSize.getWidth();
        this.HEIGHT = (int)screenSize.getHeight();

        this.addKeyListener(this);
        this.setFocusable(true);
        this.jFrame = new JFrame("Pong");
        this.jFrame.setSize(WIDTH, HEIGHT);
        this.jFrame.setResizable(false);
        this.jFrame.setUndecorated(true);
        this.jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        this.jFrame.setLayout(new BorderLayout());
        this.jFrame.setVisible(true);

        this.jFrame.add(this, BorderLayout.CENTER);

        this.GAME = this;
        this.BALL = new Ball("Ball", WIDTH/2, HEIGHT/2);
        this.P1 = new Player("Player1", 30, HEIGHT/2-50, WIDTH/2 - 60, HEIGHT/2-10);
        this.P2 = new Player("Player2", WIDTH-70, HEIGHT/2-50, WIDTH/2 + 42, HEIGHT/2-10);

        addEntity(BALL);
        addEntity(P1);
        addEntity(P2);

        this.run();
    }

    @Override
    public void run(){
        while (this.running){
            try{Thread.sleep(50);}catch (Exception e){e.printStackTrace();}
            runningTicks++;
            tick();
            render();
        }
    }

    public void tick(){
        for(Entity ents : entities){
            ents.tick();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);
        g.fillRect(getWidth()/2-5, 0, 10, getHeight());

        for(Entity ents : entities){
            ents.render(g);
        }

        g.dispose();
        bs.show();
    }

    public void addEntity(Entity entity){
        this.entities.add(entity);
        entity.invoke();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // PLAYER 1
        if(e.getKeyCode() == 90){
            P1.setYVel(-playerSpeed);
        }
        if(e.getKeyCode() == 83){
            P1.setYVel(playerSpeed);
        }

        // PLAYER 2
        if(e.getKeyCode() == 38){
            P2.setYVel(-playerSpeed);
        }
        if(e.getKeyCode() == 40){
            P2.setYVel(playerSpeed);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(""+e.getKeyCode());
        // PLAYER 1
        if(e.getKeyCode() == 90){
            P1.setYVel(0);
        }
        if(e.getKeyCode() == 83){
            P1.setYVel(0);
        }

        // PLAYER 2
        if(e.getKeyCode() == 38){
            P2.setYVel(0);
        }
        if(e.getKeyCode() == 40){
            P2.setYVel(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
