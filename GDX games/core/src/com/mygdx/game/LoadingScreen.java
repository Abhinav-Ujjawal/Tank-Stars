package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Iterator;

public class LoadingScreen implements Screen {
    private MyGdxGame game;
    private Texture img;
    private Animation<TextureRegion> animation;
    private float stateTime;
    private static final int FRAME_COLS = 2, FRAME_ROWS = 3;
    public LoadingScreen(MyGdxGame g) {
        game = g;
        img = new Texture("LoadingScreen.png");
        TextureRegion[][] tmp = TextureRegion.split(img,img.getWidth()/FRAME_COLS,img.getHeight()/FRAME_ROWS);
        TextureRegion [] walkFrames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
        int index=0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        animation = new Animation<>(0.2f,walkFrames);
        stateTime = 0f;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//        System.out.println("HI");
        game.getBatch().begin();
        stateTime+=delta;
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, false);
        this.game.getBatch().draw(currentFrame, 0, 0,1600,800);
        if (Gdx.input.justTouched()){
            this.game.setScreen(new MainMenu(game));
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
        img.dispose();
    }
}
