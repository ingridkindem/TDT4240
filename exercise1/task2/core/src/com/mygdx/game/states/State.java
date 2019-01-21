package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected Vector3 mouse;
    protected GameStateManager gsm;
    protected OrthographicCamera cam;

    protected State(GameStateManager gsm) {
        cam = new OrthographicCamera();
        this.gsm = gsm;
        mouse = new Vector3();

    }


    protected abstract void handleInput();

    public abstract void update(float dt);

    public abstract void render(SpriteBatch sb);

    public abstract void dispose();


}
