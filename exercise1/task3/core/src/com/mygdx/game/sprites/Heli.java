package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HeliAnimation;

public class Heli {
    private static int VELO = -150;
    private Vector3 position;
    private Vector3 velocity;

    private Animation heliAnimation;


    public Heli(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(VELO, 100, 0);
        heliAnimation = new Animation(0.4f);
    }


    public void update(float dt) {
        heliAnimation.update(dt);
        if (position.x < 0) {
            position.add(3, 0, 0);
            heliAnimation.frames = heliAnimation.framesR;
            velocity.add(-2 * velocity.x, 0, 0);
        } else if (position.x > HeliAnimation.WIDTH - heliAnimation.frameWidth) {
            position.add(-3, 0, 0);
            heliAnimation.frames = heliAnimation.framesL;

            velocity.add(-2 * velocity.x, 0, 0);
        }

        if (position.y < 0) {
            position.add(0, 3, 0);
            velocity.add(0, -2 * velocity.y, 0);
        } else if (position.y > (HeliAnimation.HEIGHT - 2 * heliAnimation.getFrame().getRegionHeight())) {
            position.add(0, -3, 0);
            velocity.add(0, -2 * velocity.y, 0);
        }

        position.add(velocity.x * dt, velocity.y * dt, 0);

    }

    public Vector3 getPosition() {
        return position;
    }


    public TextureRegion getTexture() {
        return heliAnimation.getFrame();
    }

    public void jump() {
        velocity.y = 250;

    }
}
