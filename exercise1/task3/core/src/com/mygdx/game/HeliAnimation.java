package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;

public class HeliAnimation extends ApplicationAdapter {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    public static final String TITLE = "Helicopter Animation";
    private GameStateManager gsm;
    private SpriteBatch batch;

    //Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gsm = new GameStateManager();
        gsm.push(new MenuState(gsm));
    }

    @Override
    public void render() {
        batch.begin();
        batch.end();

        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);

    }

    @Override
    public void dispose() {
        batch.dispose();
    }


}
