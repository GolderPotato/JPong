package fr.golderpotato.gamename.entity;

import java.awt.*;

/**
 * Created by Eliaz on 21/05/2017.
 */
public class LivingEntity extends Entity{

    public int yVel;
    public int xVel;


    public LivingEntity(String displayName, int x, int y){
        super(displayName, x,y, true);
    }

    public void render(Graphics g){

    }

    public void invoke(){

    }

    public void tick(){

    }

    public int getXVel(){
        return this.xVel;
    }

    public void setxVel(int xVel){
        this.xVel = xVel;
    }

    public void addXVel(int add){
        this.xVel+=add;
    }

    public int getYVel(){
        return this.yVel;
    }

    public void setYVel(int yVel){
        this.yVel = yVel;
    }

    public void addYVel(int add){
        this.yVel+=add;
    }


}
