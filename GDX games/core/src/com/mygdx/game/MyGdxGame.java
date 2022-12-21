package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends Game {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Sound button;
	private Sound tankChoose;
	private Music gamemusic;
	private int lastX;
	private int lastY;
	private int secondlastX;
	private int secondlastY;
	private static MyGdxGame game=null;
//	private Viewport vp;
	private MyGdxGame(){}
	public static MyGdxGame getInstance(){
		if (game==null){
			game=new MyGdxGame();
		}
		return game;
	}
	@Override
	public void create () {
		this.lastX=0;
		this.lastY=0;
		batch = new SpriteBatch();
		camera=(new OrthographicCamera());
		camera.setToOrtho(false, 1600, 800);
		batch.setProjectionMatrix(camera.combined);
		button=Gdx.audio.newSound(Gdx.files.internal("button.mp3"));
		tankChoose=Gdx.audio.newSound(Gdx.files.internal("tank-equip.mp3"));
		gamemusic=Gdx.audio.newMusic(Gdx.files.internal("gameplay-theme.mp3"));
		this.setScreen(new LoadingScreen(this));
	}

	public int getSecondlastX() {
		return secondlastX;
	}

	public void setSecondlastX(int secondlastX) {
		this.secondlastX = secondlastX;
	}

	public int getSecondlastY() {
		return secondlastY;
	}

	public void setSecondlastY(int secondlastY) {
		this.secondlastY = secondlastY;
	}

	public int getLastX() {
		return lastX;
	}

	public void setLastX(int lastX) {
		this.lastX = lastX;
	}

	public int getLastY() {
		return lastY;
	}

	public void setLastY(int lastY) {
		this.lastY = lastY;
	}

	@Override
	public void render () {
		super.render();
	}

//	@Override
//	public void resize(int width, int height) {
//		vp.update(width, height);
//	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}

	public Sound getButton() {
		return button;
	}

	public Sound getTankChoose() {
		return tankChoose;
	}

	public Music getGamemusic() {
		return gamemusic;
	}

}
