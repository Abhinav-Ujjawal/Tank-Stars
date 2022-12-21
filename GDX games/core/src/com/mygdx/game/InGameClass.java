package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class InGameClass implements Screen, Serializable {
    private BitmapFont f=new BitmapFont();
    private MyGdxGame game;
    private Tank t1;
    private Tank t2;
    private int turn;
//    private Projectile p;
    public InGameClass(MyGdxGame g) {
        turn=0;
        game = g;
    }

    @Override
    public void show() {
        int x=game.getSecondlastX();
        int y=game.getSecondlastY();
        if (x>=101 && x<= 544 && y<=644 && y>=291){
            t1=new Abrams(game,new Sprite(new Texture("tanks/abrams body.png")),new Sprite(new Texture("tanks/abrams turret.png")),800-619,280);
        }
        else if (x>=595 && x<=1018 && y<=643 &&y>=293) {
            t1=new Frost(game,new Sprite(new Texture("tanks/frost body.png")),new Sprite(new Texture("tanks/frost turret.png")),800-619,280);
        }
        else if (x>=1085 && x<=1480 && y>=278 && y<=644){
            t1=new Spectre(game,new Sprite(new Texture("tanks/spectre body.png")),new Sprite(new Texture("tanks/spectre turret.png")),800-619,280);
        }
        x=game.getLastX();
        y=game.getLastY();
        if (x>=101 && x<= 544 && y<=644 && y>=291){
            t2 = new Abrams(game, new Sprite(new Texture("tanks/abrams flipped body.png")),new Sprite(new Texture("tanks/abrams flipped turret.png")),1400,200);
        }
        else if (x>=595 && x<=1018 && y<=643 &&y>=293) {
            t2 = new Frost(game, new Sprite(new Texture("tanks/frost flipped body.png")),new Sprite(new Texture("tanks/frost flipped turret.png")),1400,200);
        }
        else if (x>=1085 && x<=1480 && y>=278 && y<=644){
            t2 = new Spectre(game, new Sprite(new Texture("tanks/spectre flipped body.png")),new Sprite(new Texture("tanks/spectre flipped turret.png")),1400,200);
        }
    }

    @Override
    public void render(float delta) {
        String s= "Player 1 Health = "+t1.getHealth();
//        super.render(delta);
//        renderer.setView(game.getCamera());
//        renderer.render();
//        t1.draw();
        game.getGamemusic().play();
        game.getBatch().begin();
        game.getBatch().draw(new Texture("background.jpg"),0,0,1600,800);
        // draw tanks
        ArrayList<Sprite> sp = new ArrayList<>();
        game.getBatch().draw(t1.getBody(),t1.getPos().x, t1.YfromX(t1.getPos().x),160,80);
        game.getBatch().draw(t1.getTurret(),t1.getPos().x+60,t1.YfromX(t1.getPos().x)+80,80,20);
        game.getBatch().draw(t2.getBody(),t2.getPos().x,t2.YfromX(t2.getPos().x),160,80);
        game.getBatch().draw(t2.getTurret(),t2.getPos().x+60,t2.YfromX(t2.getPos().x)+80,80,20);
        f.setColor(0.5f,1f,0.3f,0.6f);
        f.draw(game.getBatch(),s,300,600);
        s= "Player 2 Health = "+t2.getHealth();
        f.draw(game.getBatch(),s,1300,600);
        s= "Player 2 Fuel = "+t2.getFuel();
        f.draw(game.getBatch(),s,1300,580);
        s= "Player 1 Fuel = "+t1.getFuel();
        f.draw(game.getBatch(),s,300,580);
//        t1.getBody().draw(game.getBatch());
//        t1.getBody().setSize(160,80);
//        t1.getBody().setPosition(t1.getPos().x,t1.YfromX(t1.getPos().x));
//        t1.getTurret().draw(game.getBatch());
//        t1.getTurret().setScale(80,20);
//        t1.getTurret().setPosition(t1.getPos().x+50,t1.YfromX(t1.getPos().x)+80);
//        t1.getBody().setOrigin(0,0);
//        t1.getTurret().setOrigin(0,0);
//        t2.get().setOrigin(0,0);
//        t2.getBody().setOrigin(0,0);
//        t2.getBody().draw(game.getBatch());
//        t2.getBody().setSize(160,80);
//        t2.getBody().setPosition(t2.getPos().x,t2.YfromX(t2.getPos().x));
//        t2.getTurret().draw(game.getBatch());
//        t2.getTurret().setScale(80,20);
//        t2.getTurret().setPosition(t2.getPos().x+50,t2.YfromX(t2.getPos().x)+80);

        if (turn%2==0) {
//            p.setX0((int) (t1.getTurret().getX()+t1.getTurret().getWidth())+10);
//            p.setY0((int) (t1.getTurret().getY()+t1.getTurret().getHeight())+10);
//            p.draw();
            try {
                t1.getBody().setRotation((float) Math.toDegrees(Math.atan((t1.YfromX((t1.getBody().getX() + t1.getBody().getWidth())) - t1.YfromX(t1.getBody().getX())) / t1.getBody().getWidth())));
            }
            catch (Exception ignored){
            }
        }
        else {
//            p.setX0((int) (t1.getTurret().getX()+t1.getTurret().getWidth())+10);
//            p.setY0((int) (t1.getTurret().getY()+t1.getTurret().getHeight())+10);
            try {
                t2.getBody().setRotation((float) Math.toDegrees(Math.atan((t2.YfromX((t2.getBody().getX() + t2.getBody().getWidth())) - t2.YfromX(t2.getBody().getX())) / t2.getBody().getWidth())));
            }
            catch (Exception ignored){
            }
        }
        // for pause menu
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
//            System.out.println("("+x+","+y+")");
            game.getGamemusic().pause();
            game.getButton().play(0.2f);
            this.game.setScreen(new PauseScreen(game));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.D)){
            if (turn%2==0){
                t1.move(delta);
            }
            else{
                t2.move(delta);
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            if (turn%2==0){
                int x=Gdx.input.getX();
                int y=Gdx.input.getY();
                float x1=t1.getBody().getX();
                float y1=t1.getBody().getY();
                double pw=(double) ((x-x1)*(x-x1)+(y-y1)*(y-y1));
                double power= Math.pow(pw,0.5);
                Vector2 initial = new Vector2(t1.getTurret().getX()+t1.getTurret().getWidth(),t1.getTurret().getY()+t1.getTurret().getHeight());
                Vector2 proj=new Vector2(t1.getTurret().getX()+t1.getTurret().getWidth(),t1.getTurret().getY()+t1.getTurret().getHeight());
                Projectile p= new Projectile(game,Math.toDegrees(Math.atan((y-y1)/(x-x1))), (int) proj.x, (int) proj.y, (float) power);
                t1.attack(t2,p,proj,initial,power,x,y,x1,y1);
                t1.setFuel(100);
            }
            else{
                int x=Gdx.input.getX();
                int y=Gdx.input.getY();
                float x1=t2.getBody().getX();
                float y1=t2.getBody().getY();
                double pw=(double) ((x-x1)*(x-x1)+(y-y1)*(y-y1));
                double power= Math.pow(pw,0.5);
                Vector2 initial = new Vector2(t2.getTurret().getX()+t2.getTurret().getWidth(),t2.getTurret().getY()+t2.getTurret().getHeight());
                Vector2 proj=new Vector2(t2.getTurret().getX()+t2.getTurret().getWidth(),t2.getTurret().getY()+t2.getTurret().getHeight());
                Projectile p= new Projectile(game,Math.toDegrees(Math.atan((y-y1)/(x-x1))), (int) proj.x, (int) proj.y, (float) power);
                t2.attack(t1,p,proj,initial,power,x,y,x1,y1);
                t2.setFuel(100);
            }
            turn+=1;
        }
        game.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
