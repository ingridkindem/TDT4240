package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.HeliAnimation;

public class Dog {
    private  static int VELODOG = -150;
    private Vector3 position;
    private Vector3 velocity;

    private TextureRegion dog;


    public Dog(int x, int y){
        position = new Vector3(x,y,0);
        velocity = new Vector3(VELODOG,50,0);
        dog = new TextureRegion(new Texture("dogL.png"));

    }


    public void updateDog(float dt){

        if(position.x < 0){
            dog.flip(true,false);
            position.add(3,0,0);
            velocity.add(-2*velocity.x,0,0);
        }

        else if(position.x > HeliAnimation.WIDTH-dog.getTexture().getWidth()) {
            dog.flip(true,false);
            position.add(-3,0,0);
            velocity.add(-2*velocity.x,0,0);
        }

        if(position.y < 0){
            position.add(0,3,0);
            velocity.add(0,-2*velocity.y,0);
        }

        else if(position.y > (HeliAnimation.HEIGHT - 2*dog.getTexture().getHeight())) {
            position.add(0,-3,0);
            velocity.add(0,-2*velocity.y,0);
        }

        position.add(velocity.x * dt,velocity.y * dt,0);

    }

    public Vector3 getPositionDog() {
        return position;
    }



    public TextureRegion getTextureDog() {
        return dog;
    }

    public void jump() {
        velocity.y = 100;

    }

}
