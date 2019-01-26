package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HeliMove;

public class Heli {
    private static int pos = 3;
    private Vector3 position;

    private boolean lastTouched;

    private TextureRegion helicopter;
    private TextureRegion helicopterR;
    private TextureRegion helicopterL;



    public Heli(int x, int y) {
        position = new Vector3(x, y, 0);
        helicopterR = new TextureRegion(new Texture("dogR.png"));
        helicopterL = new TextureRegion(new Texture("dogL.png"));
        lastTouched = false;
        helicopter = helicopterR;
    }


    public void update(float dt) {

        if (position.x < 0) {
            position.add(3, 0, 0);
            // lastTouched = true;
        } else if (position.x > HeliMove.WIDTH - helicopterR.getTexture().getWidth()) {
            position.add(-3, 0, 0);
            // lastTouched = false;
        }

        if (position.y < 0) {
            position.add(0, 3, 0);
        } else if (position.y > (HeliMove.HEIGHT - 2 * helicopterR.getTexture().getHeight())) {
            position.add(0, -3, 0);
        }

    }


    public Vector3 getPosition() {
        return position;
    }


    public TextureRegion getTexture() {

        return helicopter;
    }

    public void goUp() {
        position.add(0, pos, 0);
    }

    public void goDown() {
        position.add(0, -pos, 0);
    }

    public void goLeft() {
        helicopter = helicopterL;
        position.add(-pos, 0, 0);

    }

    public void goRight() {
        helicopter = helicopterR;
        position.add(pos, 0, 0);

    }

}
