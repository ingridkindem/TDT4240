package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.sprites.Dog;
import com.mygdx.game.sprites.Heli;
import com.badlogic.gdx.math.Rectangle;


public class PlayState extends State {
    private Heli heli;
    public Texture bg;
    private Dog dog;
    private Rectangle dogR;
    private Rectangle heliR;

    public Vector3 left = new Vector3(-4, 0, 0);
    public Vector3 right = new Vector3(4, 0, 0);
    public Vector3 up = new Vector3(0, 4, 0);
    public Vector3 down = new Vector3(0, -4, 0);
    private Vector3 dogBounce;
    private Vector3 heliBounce;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        heli = new Heli(90, 50);
        bg = new Texture("sky2.png");
        dog = new Dog(30, 500);
        dogR = new Rectangle(dog.getPositionDog().x, dog.getPositionDog().y,
                dog.getTextureDog().getRegionWidth(), dog.getTextureDog().getRegionHeight());
        heliR = new Rectangle(heli.getPosition().x, heli.getPosition().y,
                heli.getTexture().getRegionWidth(), heli.getTexture().getRegionHeight());

    }

    protected void collision() {
        if (dogR.overlaps(heliR)) {

            if (dog.getPositionDog().x > heli.getPosition().x) {
                dog.addPosition(right);
                heli.addPosition(left);
            } else {
                dog.addPosition(left);
                heli.addPosition(right);

            }

            if (dog.getPositionDog().y > heli.getPosition().y) {
                dog.addPosition(up);
                heli.addPosition(down);
            } else {
                dog.addPosition(down);
                heli.addPosition(up);

            }

            dogBounce = new Vector3(-2 * dog.getVelocity().x + randomInt(), -2 * dog.getVelocity().y + randomInt(), 0);
            heliBounce = new Vector3(-2 * heli.getVelocity().x + randomInt(), -2 * heli.getVelocity().y + randomInt(), 0);

            dog.addVelocity(dogBounce);
            heli.addVelocity(heliBounce);
        }
    }

    public int randomInt() {
        return (int) (Math.random() * 5 + 1);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            heli.jump();
            dog.jump();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        collision();

        heliR.setPosition(heli.getPosition().x, heli.getPosition().y);
        dogR.setPosition(dog.getPositionDog().x, dog.getPositionDog().y);

        heli.update(dt);
        dog.updateDog(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, 0, 0);
        sb.draw(heli.getTexture(), heli.getPosition().x, heli.getPosition().y);
        sb.draw(dog.getTextureDog(), dog.getPositionDog().x, dog.getPositionDog().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
