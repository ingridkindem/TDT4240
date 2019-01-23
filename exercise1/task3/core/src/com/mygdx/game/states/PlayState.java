package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.sprites.Dog;
import com.mygdx.game.sprites.Heli;

import java.awt.Rectangle;

public class PlayState extends State {
    private Heli heli;
    public Texture bg;
    private Dog dog;
    private Rectangle dogR;
    private Rectangle heliR;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        heli = new Heli(50, 100);
        bg = new Texture("sky2.png");
        dog = new Dog(30, 250);
        dogR = new Rectangle(dog.getTextureDog().getRegionWidth(),dog.getTextureDog().getRegionHeight());
        heliR = new Rectangle(heli.getTexture().getRegionWidth(),heli.getTexture().getRegionHeight());

    }

    //Finne ut hvordan rectangle følger Sprite
    protected void collision(){
        if (dogR.intersects(heliR)){
        }

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
