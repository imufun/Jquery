package entity;

import fighter98.Game;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final float BOOST_SPEED = 8.0f;
    public static final int DEFAULT_CREATER_WIDTH = 64,
            DEFAULT_CREATER_HIGHT = 64;

    protected int health;
    protected float speed;
    protected float boostspeed;

    protected float xMove, yMove;

    public Creature(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        boostspeed = BOOST_SPEED;
    }

    //move
    public void move() {

        x += xMove;
        y += yMove;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getBoostspeed() {
        return boostspeed;
    }

    public void setBoostspeed(float boostspeed) {
        this.boostspeed = boostspeed;
    }
    
    

}
