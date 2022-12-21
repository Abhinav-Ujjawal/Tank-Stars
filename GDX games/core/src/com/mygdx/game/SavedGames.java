package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class SavedGames implements Screen {
    private final MyGdxGame game;
    public SavedGames(MyGdxGame g) {
        game = g;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Texture img = new Texture("Resume Screen.jpg");
        Gdx.gl.glClearColor(0,0,0.5f,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(img,0,0,1600,800);
        game.getBatch().end();
        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            if (x>=208 && x<= 1393){
                if (y<=306 && y>=258){
                    game.getButton().play(0.2f);
                    this.game.setScreen(new InGameClass(game));
                }
                else if (y<=432 && y>=385){
                    game.getButton().play(0.2f);
                    this.game.setScreen(new InGameClass(game));
                }
                else if (y<=562 && y>=516){
                    game.getButton().play(0.2f);
                    this.game.setScreen(new InGameClass(game));
                }
                else if (y<=687 && y>=642){
                    game.getButton().play(0.2f);
                    this.game.setScreen(new InGameClass(game));
                }
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
