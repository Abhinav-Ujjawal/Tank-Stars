package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen{
    final MyGdxGame game;
    private Texture mainmenuimage;
    public MainMenu(final MyGdxGame g){
        game=g;
    }
    @Override
    public void show(){

    }
    @Override
    public void render(float delta){
        mainmenuimage=new Texture("Main Menu.jpg");
        if (Gdx.input.justTouched()){
            // x coordinate is 1128 - 1442
            // y is 147 - 252
            // y is 296 - 402
            // y is 445 - 554
            // y is 597 - 705
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            if (x>=1128 && x<= 1442){
                if (y<=252 && y>=147){
                    game.getButton().play(0.2f);
                    // vs player
                    game.setScreen(new ChooseFirstTank(game));
                }
                else if (y<=402 && y>=296){
                    game.getButton().play(0.2f);
                    game.setScreen(new ChooseTank(game));
                    // vs computer
                }
                else if (y<=554 && y>=445){
                    game.getButton().play(0.2f);
                    game.setScreen(new SavedGames(game));
                }
                else if (y<=705 && y>=597){
                    game.getButton().play(0.2f);
                    Gdx.app.exit();
                }
            }
        }
        Gdx.gl.glClearColor(0,0,0.5f,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(mainmenuimage,0,0,1600,800);
        game.getBatch().end();

    }
    @Override
    public void resize(int width,int size){

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
        mainmenuimage.dispose();
    }
}