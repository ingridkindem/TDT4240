package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HeliMove;
import com.mygdx.game.sprites.Heli;

public class PlayState extends State {
    private Heli heli;
    private Texture bg;
    private Texture up;
    private Texture down;
    private Texture left;
    private Texture right;
    private Rectangle upR;
    private Rectangle downR;
    private Rectangle leftR;
    private Rectangle rightR;
    private BitmapFont font;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, HeliMove.WIDTH, HeliMove.HEIGHT);
        heli = new Heli(150, 200);
        bg = new Texture("sky2.png");
        up = new Texture("up.png");
        down = new Texture("down.png");
        left = new Texture("left.png");
        right = new Texture("right.png");
        downR = new Rectangle(80, 45, 50, 50);
        upR = new Rectangle(80, 115, 50, 50);
        leftR = new Rectangle(45, 80, 50, 50);
        rightR = new Rectangle(115, 80, 50, 50);
        font = new BitmapFont();
        font.getData().setScale(1);
        font.setColor(Color.WHITE);
    }


    @Override
    protected void handleInput() {
        Vector3 tmp = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(tmp);
        if (downR.contains(tmp.x, tmp.y)) {
            heli.goDown();
        }
        if (upR.contains(tmp.x, tmp.y)) {
            heli.goUp();
        }
        if (leftR.contains(tmp.x, tmp.y)) {
            heli.goLeft();
        }
        if (rightR.contains(tmp.x, tmp.y)) {
            heli.goRight();
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
        sb.draw(down, 80, 45, 50, 50);
        sb.draw(up, 80, 115, 50, 50);
        sb.draw(left, 45, 80, 50, 50);
        sb.draw(right, 115, 80, 50, 50);
        sb.draw(heli.getTexture(), heli.getPosition().x, heli.getPosition().y);
        font.draw(sb, "x: " + heli.getPosition().x + " y: " + heli.getPosition().y, 10, 690);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
