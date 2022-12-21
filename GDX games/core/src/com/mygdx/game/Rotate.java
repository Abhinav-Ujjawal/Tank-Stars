package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Rotate implements Screen {
    Sprite s;
    MyGdxGame game;
    public Rotate(MyGdxGame g){
        game=g;
        s= new Sprite(new Texture("tanks/abrams body.png"));
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        s.setRotation(45);
        game.getBatch().begin();
        s.draw(game.getBatch());
        game.getBatch().end();
    }

    @Override
    public void resize(int i, int i1) {

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
