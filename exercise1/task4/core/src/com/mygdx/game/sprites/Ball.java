package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Pong;

public class Ball {

    public final static Vector3 startPositionBall = new Vector3(Pong.WIDTH / 2 - Ball.SIZE / 2, Pong.HEIGHT / 2 - Ball.SIZE / 2, 0);
    private final static Vector3 startVelocityBall = new Vector3(250,0,0);

    private Vector3 position;
    private Vector3 velocity;

    private TextureRegion ball;

    public static final int SIZE = 18;

    public Ball() {
        position = startPositionBall;
        velocity = startVelocityBall;
        ball = new TextureRegion(new Texture("ball.png"));

    }

    public void update(float dt) {

        //Bounce of top and bottom
        if (position.y < 0) {
            position.add(0, 3, 0);
            velocity.add(0, -2 * velocity.y, 0);
        } else if (position.y > (Pong.HEIGHT - SIZE)) {
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

    public void addPosition(Vector3 position){

        this.position = this.position.add(position);
    }


    public Vector3 getVelocity() {

        return velocity;
    }

    public void setVelocity(Vector3 velocity) {

        this.velocity = velocity;
    }

    public void addVelocity(Vector3 velocity) {

        this.velocity = this.velocity.add(velocity);
    }

    public TextureRegion getTexture() {

        return ball;
    }


}
