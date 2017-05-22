package fr.golderpotato.gamename.entity.entities;

import fr.golderpotato.gamename.Pong;
import fr.golderpotato.gamename.entity.LivingEntity;
import fr.golderpotato.gamename.util.HitBox2D;

import java.awt.*;

/**
 * Created by Eliaz on 22/05/2017.
 */
public class Player extends LivingEntity{

    private int score;
    private int scoreX;
    private int scoreY;

    public Player(String name, int x, int y, int scoreX, int scoreY){
        super(name, x, y);
        setHitbox(new HitBox2D(30, 100));
        this.scoreX = scoreX;
        this.scoreY = scoreY;
    }

    @Override
    public void invoke() {

    }

    @Override
    public void render(Graphics g) {
        g.fillRect(getX(), getY(), 30, 100);
        g.drawString(String.valueOf(score), scoreX, scoreY);
    }

    public void tick() {
        setY(getY()+getYVel());
        if(getY() < 0){
            setY(0);
        }
        if(getY() > Pong.GAME.getHeight() - getHitbox().getyOffset()){
            setY(Pong.GAME.getHeight() - getHitbox().getyOffset());
        }
        if(score >= 10){
            System.out.println(getDisplayName()+" wins! GG");
            System.exit(0);
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void resetScore(){
        this.score = 0;
    }

    public void addScore(int add){
        this.score+=add;
    }
}
