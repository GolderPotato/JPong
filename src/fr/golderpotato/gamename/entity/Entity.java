package fr.golderpotato.gamename.entity;

import fr.golderpotato.gamename.util.HitBox2D;

import java.awt.*;

/**
 * Created by Eliaz on 21/05/2017.
 */
public abstract class Entity {

    private String displayName;
    private int x;
    private int y;
    private boolean living;
    private boolean renderDisplayName;
    private HitBox2D hitbox;

    public Entity(String displayName, int x, int y){
        this.displayName = displayName;
        this.x = x;
        this.y = y;
        this.living = true;
    }

    public Entity(String displayName, int x, int y, boolean living){
        this.displayName = displayName;
        this.x = x;
        this.y = y;
        this.living = living;
    }

    public abstract void render(Graphics g);

    public abstract void invoke();

    public abstract void tick();


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public boolean isRenderDisplayName() {
        return renderDisplayName;
    }

    public void setRenderDisplayName(boolean renderDisplayName) {
        this.renderDisplayName = renderDisplayName;
    }

    public HitBox2D getHitbox(){
        return this.hitbox;
    }

    public void setHitbox(HitBox2D hitbox){
        this.hitbox = hitbox;
    }
}
