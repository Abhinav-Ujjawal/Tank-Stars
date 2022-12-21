package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Projectile {
    private int x0,y0;
    private Sprite dot;
    private MyGdxGame game;
    private double ang, vel;

    public double getAng() {
        return ang;
    }

    public double getVel() {
        return vel;
    }

    public int getY0() {
        return y0;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public void setY0(int y0) {
        this.y0 = y0;
    }

    public void setAng(double ang) {
        this.ang = ang;
    }

    public void setVel(double vel) {
        this.vel = vel;
    }

    public float getY(float x){
        return (float)(x*Math.tan(Math.toRadians(ang))-4.9*x*x/((vel*vel)*(float)(Math.pow(Math.cos(Math.toRadians(ang)),2))));
    }
    public Projectile(MyGdxGame game,double angle, int x, int y, float power){
        vel=power/6;
        this.game=game;
        ang=angle;
        x0=0;
        y0=0;
        vel=power/6f;
        if (angle<0){
            this.ang+=360;
        }
        Texture t =new Texture("tracker.png");
        dot=new Sprite(t,0,0,t.getWidth(),t.getHeight());
    }
    double derivative(double x){
        try {
            return Math.toDegrees(Math.atan(((float) Math.tan(Math.toRadians(ang)) - 9.8 * x / (vel * vel * (float) (Math.pow(Math.cos(Math.toRadians(ang)), 2))))));
        }
        catch (Exception e){
            return 90.0;
        }
    }
    public void draw(){
        int gap = 0;
//        game.getBatch().begin();
        for (int i = 0; i < 10; i++) {
            dot.setPosition(x0+gap,800-getY(x0+gap));
            dot.draw(game.getBatch());
            gap+=20;
        }
//        game.getBatch().end();
    }
    public void remove(){

    }
}
