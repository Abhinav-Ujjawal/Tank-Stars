package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Iterator;

public class ChooseSecondTank implements Screen {
    private final MyGdxGame game;

    public ChooseSecondTank(MyGdxGame g) {
        game = g;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Texture img = new Texture("Tank2chooseScreen.jpg");
        Gdx.gl.glClearColor(0,0,0.5f,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(img,0,0,1600,800);
        game.getBatch().end();
        if (Gdx.input.justTouched()){
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
//            System.out.println("The x coordinate is "+x);
//            System.out.println("The y coordinate is "+y);
            if (x>=101 && x<= 544 && y<=644 && y>=291){
                game.setLastX(x);
                game.setLastY(y);
                this.game.getTankChoose().play(0.5f);
                this.game.setScreen(new InGameClass(game));
            }
            else if (x>=595 && x<=1018 && y<=643 &&y>=293) {
                game.setLastX(x);
                game.setLastY(y);
                this.game.getTankChoose().play(0.5f);
                this.game.setScreen(new InGameClass(game));
            }
            else if (x>=1085 && x<=1480 && y>=278 && y<=644){
                game.setLastX(x);
                game.setLastY(y);
                this.game.getTankChoose().play(0.5f);
                this.game.setScreen(new InGameClass(game));
            }
            ArrayList<Integer> g=new ArrayList<>();
            g.add(x);
            g.add(y);
            Iterator iter = g.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
        }
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
