package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Pong;


public class MenuState extends State {
    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bgPong.png");
        playBtn = new Texture("play.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            dispose();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Pong.WIDTH, Pong.HEIGHT);
        sb.draw(playBtn, (Pong.WIDTH / 2) - (int)(0.1*playBtn.getWidth() / 2), Pong.HEIGHT / 2, (int)(playBtn.getWidth() * 0.1), (int)(playBtn.getHeight()*0.1));
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();

    }

}
