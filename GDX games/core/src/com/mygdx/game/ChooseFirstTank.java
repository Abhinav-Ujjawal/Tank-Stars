package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

public class ChooseFirstTank implements Screen {
    final MyGdxGame game;
    public ChooseFirstTank(MyGdxGame g) {
        game=g;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Texture img = new Texture("Tank1chooseScreen.jpg");
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
                game.setSecondlastX(x);
                game.setSecondlastY(y);
                this.game.getTankChoose().play(0.5f);
                this.game.setScreen(new ChooseSecondTank(game));
            }
            else if (x>=595 && x<=1018 && y<=643 &&y>=293) {
                game.setSecondlastX(x);
                game.setSecondlastY(y);
                this.game.getTankChoose().play(0.5f);
                this.game.setScreen(new ChooseSecondTank(game));
            }
            else if (x>=1085 && x<=1480 && y>=278 && y<=644){
                game.setSecondlastX(x);
                game.setSecondlastY(y);
                this.game.getTankChoose().play(0.5f);
                this.game.setScreen(new ChooseSecondTank(game));
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
