package com.mygdx.game1.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game1.MyHeliGame;
import com.mygdx.game1.sprites.Heli;

public class PlayState extends State {
    private Heli heli;
    public Texture bg;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        heli = new Heli(50, 100);
        bg = new Texture("sky2.png");
    }


    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            heli.jump();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        heli.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, 0, 0);
        sb.draw(heli.getTexture(), heli.getPosition().x, heli.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
