package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class Tank implements Serializable {
    private MyGdxGame game;
    private int fuel = 100;
//    private float speed = 60 * 2, g = 60 * 1.8f, animationTime = 0, increment;
    // v is velocity and g is gravity
    private Vector2 pos = new Vector2();
    private Sprite body;
    private Sprite turret;
    private int health;
    private Sprite weapon;

    public int getFuel() {
        return fuel;
    }
    public Tank(MyGdxGame game, Sprite s, Sprite turret, int x, int y) {
        this.game=game;
        weapon =new Sprite(new Texture("tanks/rocket.png"),10,40);
        this.body=s;
        this.turret=turret;
        health=800;
        pos.x=x;
        pos.y=y;
        body.setX(x);
        body.setY(y);
    }
    public void save(){

    }
    public Vector2 getPos() {
        return pos;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getHealth() {
        return health;
    }

    public void attack(Tank t,Projectile p,Vector2 proj,Vector2 initial,double power,float x ,float y,float x1,float y1){
//        Gdx.gl.glClearColor( 1, 0, 0, 1 );
        if(proj.y> YfromX(proj.x)) {
//            weapon.setPosition();
            weapon.setRotation((float) p.derivative(x-x1));
            weapon.setX(proj.x);
            weapon.setY(p.getY((int) proj.x-(int)initial.x)+initial.y);
            System.out.println("Change = " +p.getY((int) proj.x-(int)initial.x));
            System.out.println(weapon.getX());
            System.out.println(weapon.getY());
            game.getBatch().draw(weapon,proj.x,p.getY((int) proj.x-(int)initial.x)+initial.y,80,20);
            proj.y=p.getY((int) proj.x-(int)initial.x)+initial.y;
            proj.x= proj.x+2;
//            System.out.println("("+proj.x+","+YfromX(proj.y)+")");
//            System.out.println(proj.y+ " "+YfromX(proj.x));
        }
    }
    public void takeDamage(int x){
        health-=x;
    }
    public void move(float dt){
        if (fuel<=2) {
            fuel = 0;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            body.setPosition(body.getX()+70*dt,YfromX(body.getX()));
            turret.setPosition(turret.getX()+70*dt, YfromX(turret.getX()));
            pos.x= body.getX();
            pos.y= body.getY();
        }
       else{
            body.setPosition(body.getX()-70*dt, body.getY());
            turret.setPosition(turret.getX()-70*dt, turret.getY());
            pos.x= body.getX();
            pos.y= body.getY();
        }
        fuel-=4;
    }
    public float YfromX(float x){
        float y;
        if (x<=134){
            y=(7/134f)*x+181;
        }
        else if (x<=314){
            y=192+(x-134)*48f/(180);
        }
        else if(x<=488){
            y=236+(x-314)*4f/174;
        }
        else if (x<=642){
            y=238-(x-488)*7f/154;
        }
        else if (x<=794){
            y=231+(x-642)*37f/152;
        }
        else if (x<=1020){
            y=268-(x-794)*2f/226;
        }
        else if (x<=1254) {
            y=256-(x-1020)*37f/234;
        }
        else if (x<=1534){
            y=229+(x-1254)*46f/280;
        }
        else {
            y=275+ (x-1564) /64;
        }
        return y;
    }
    public void update(){
        float x=getPos().x;
//        if (x<=134){
//            y=(7/134f)*x+181;
//        }
//        else if (x<=314){
//            y=192+(x-134)*48f/(180);
//        }
//        else if(x<=488){
//            y=236+(x-314)*4f/174;
//        }
//        else if (x<=642){
//            y=238-(x-488)*7f/154;
//        }
//        else if (x<=794){
//            y=231+(x-642)*37f/152;
//        }
//        else if (x<=1020){
//            y=268-(x-794)*2f/226;
//        }
//        else if (x<=1254) {
//            y=256-(x-1020)*37f/234;
//        }
//        else if (x<=1534){
//            y=229+(x-1254)*46f/280;
//        }
//        else {
//            y=275+ (x-1564) /64;
//        }

//        int x = Gdx.input.getX();
//        int y = 800-Gdx.input.getY();
//        try{
////            Gdx.app.log("Here","Reached");
////            System.out.println(turret.getRotation());
////            turret.setOrigin(0,0);
////            turret.setRotation((float) Math.toDegrees(Math.atan((turret.getY()-y)/(turret.getX()-x*1.0f))));
////            body.setOrigin(body.getX(),body.getY());
////            System.out.println((float) Math.toDegrees(Math.atan((YfromX((body.getX()+body.getWidth()))-YfromX(body.getX()))/body.getWidth())));
//            body.setRotation((float) Math.toDegrees(Math.atan((YfromX((body.getX()+body.getWidth()))-YfromX(body.getX()))/body.getWidth())));
////            turret.setPosition(1400,690);
////            game.getBatch().begin();
////            turret.draw(game.getBatch());
////            game.getBatch().end();
////            System.out.println(turret.getRotation());
////            turret.setRotation(45);
////            body.setRotation();
////            game.getBatch().draw(getTurret(),turret.getX(),turret.getY(),30,10);
//        }
//        catch (Exception ignored){
//        }
//        body.setRotation();
    }

    public Sprite getBody() {
        return body;
    }

    public Sprite getTurret() {
        return turret;
    }
}
