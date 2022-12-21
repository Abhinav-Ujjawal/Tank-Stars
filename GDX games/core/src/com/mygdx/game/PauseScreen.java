package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class PauseScreen implements Screen {
    private MyGdxGame game;

    public PauseScreen(MyGdxGame g) {
        game = g;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Texture img = new Texture("Pause Screen.jpg");
        Gdx.gl.glClearColor(0,0,0.5f,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(img,0,0,1600,800);
        game.getBatch().end();
        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            if (x>=704 && x<= 951 && y<=759 && y>=665){
                game.getButton().play(0.2f);
                this.game.setScreen(new MainMenu(game));
            }
            else if (x>=704 && x<=951 && y>=124 && y<=222){
                game.getButton().play(0.2f);
                this.game.setScreen(new InGameClass(game));
            }
            else if (x>=704 && x<=951 && y>=261 && y<=356){
                game.getButton().play(0.2f);
                this.game.setScreen(new MainMenu(game));
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
