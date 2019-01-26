package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Pong;


public class EndState extends State {
    private Texture background;
    private BitmapFont font;
    private int winner;


    public EndState(GameStateManager gsm, int i) {
        super(gsm);
        background = new Texture("bgPong.png");
        font = new BitmapFont();
        font.getData().setScale(4);
        font.setColor(Color.MAGENTA);
        winner = i;

    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new MenuState(gsm));
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
        font.draw(sb, "PLAYER " + winner + " WINS", Pong.WIDTH / 2 - 222, Pong.HEIGHT - 200);

        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        font.dispose();

    }

}
