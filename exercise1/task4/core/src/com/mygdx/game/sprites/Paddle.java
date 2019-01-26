package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Pong;


public class Paddle {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 70;

    private Vector3 position;
    private Vector3 velocity;

    private TextureRegion paddle;


    public Paddle(Vector3 startPos) {
        position = startPos;
        velocity = new Vector3(0, 0, 0);
        paddle = new TextureRegion(new Texture("paddle.png"));
    }

    public void update(float dt) {


    }

    public void follow(Ball b) {

        if (b.getPosition().y > position.y + Paddle.HEIGHT / 2) {
            position.add(new Vector3(0, 3, 0));
        } else if (b.getPosition().y < position.y) {
            position.add(new Vector3(0, -3, 0));
        }

    }

    public void movePaddle(Vector3 positionNew) {
        position.set(positionNew);

    }

    public Vector3 getPosition() {

        return position;
    }

    public TextureRegion getTexture() {

        return paddle;
    }
}
