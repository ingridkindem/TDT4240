package com.mygdx.game.sprites;

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


    public Paddle(Vector3 startPos){
        position = startPos;
        velocity = new Vector3(0, 0, 0);
        paddle = new TextureRegion(new Texture("paddle.png"));
    }

    public void update(float dt) {

        if (position.y < 0) {
            position.add(0, 3, 0);
            velocity.add(0, -2 * velocity.y, 0);
        } else if (position.y > (Pong.HEIGHT - HEIGHT)) {
            position.add(0, -3, 0);
            velocity.add(0, -2 * velocity.y, 0);
        }

        position.add(velocity.x * dt, velocity.y * dt, 0);

    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3 velocity) {
        this.velocity = velocity;
    }

    public TextureRegion getTexture() {
        return paddle;
    }

    public void addVelocity(Vector3 velocityNew) {
        velocity.add(velocityNew);
    }
}
