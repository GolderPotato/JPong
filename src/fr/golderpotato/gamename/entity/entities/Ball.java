package fr.golderpotato.gamename.entity.entities;

import fr.golderpotato.gamename.Pong;
import fr.golderpotato.gamename.entity.LivingEntity;
import fr.golderpotato.gamename.util.HitBox2D;

import java.awt.*;
import java.util.Random;

/**
 * Created by Eliaz on 21/05/2017.
 */
public class Ball extends LivingEntity{

    public Random random = new Random();
    public int baseVel = 15;

    public Ball(String playerName, int x, int y){
        super(playerName, x,y);
        setHitbox(new HitBox2D(30,30));
    }

    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(this.getX(),this.getY(), 30, 30);
    }

    public void invoke(){
        this.xVel = -baseVel;
        this.yVel = -baseVel;
    }

    public void tick(){
        if(this.getX() <= 30){
            this.baseVel+=1;
            this.setX(Pong.GAME.getWidth()/2);
            this.setY(Pong.GAME.getHeight()/2);
            this.setxVel(random.nextInt(2) == 1 ? baseVel : -baseVel);
            Pong.GAME.P2.addScore(1);
        }
        if(this.getX()+60 >= Pong.GAME.getWidth()){
            this.baseVel+=1;
            this.setX(Pong.GAME.getWidth()/2);
            this.setY(Pong.GAME.getHeight()/2);
            this.setxVel(random.nextInt(2) == 1 ? baseVel: -baseVel);
            Pong.GAME.P1.addScore(1);
        }
        if(this.getY() <= 0){
            this.yVel = baseVel;
        }
        if(this.getY()+30 >= Pong.GAME.getHeight()){
            this.yVel = -baseVel;
        }
        this.setY(this.getY()+this.getYVel());
        this.setX(this.getX()+this.getXVel());
        if(HitBox2D.isCollided(this, Pong.GAME.P1)){
            this.setxVel(invert(this.getXVel()));
        }
        if(HitBox2D.isCollided(this, Pong.GAME.P2)){
            this.setxVel(invert(this.getXVel()));
        }
    }

    public int invert(int invert){
        if(invert != 0){
            if(invert < 0){
                return Math.abs(invert);
            }else{
                return -invert;
            }
        }
        return invert;
    }
}
