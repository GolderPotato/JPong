package fr.golderpotato.gamename.util;

import fr.golderpotato.gamename.entity.Entity;
import fr.golderpotato.gamename.entity.LivingEntity;

/**
 * Created by Eliaz on 22/05/2017.
 */
public class HitBox2D {

    private int xOffset;
    private int yOffset;

    public HitBox2D(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public int getxOffset() {
        return xOffset;
    }

    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }

    public void setyOffset(int yOffset) {
        this.yOffset = yOffset;
    }

    public static boolean isCollided(LivingEntity e1, LivingEntity e2){
        if(e1.getX() >= e2.getX() && e1.getX() <= e2.getX() + e2.getHitbox().getxOffset()){
            if(e1.getY() >= e2.getY() && e1.getY() <= e2.getY() + e2.getHitbox().getyOffset()){
                return true;
            }
            if(e1.getY()+e1.getHitbox().getyOffset() >= e2.getY() && e1.getY()+e1.getHitbox().getyOffset() <= e2.getY() + e2.getHitbox().getyOffset()){
                return true;
            }
        }
        if(e1.getX()+e1.getHitbox().getyOffset() >= e2.getX() && e1.getX()+e1.getHitbox().getyOffset() <= e2.getX() + e2.getHitbox().getxOffset()){
            if(e1.getY() >= e2.getY() && e1.getY() <= e2.getY() + e2.getHitbox().getyOffset()){
                return true;
            }
            if(e1.getY()+e1.getHitbox().getyOffset() >= e2.getY() && e1.getY()+e1.getHitbox().getyOffset() <= e2.getY() + e2.getHitbox().getyOffset()){
                return true;
            }
        }
        return false;
    }

}
