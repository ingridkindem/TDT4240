package com.mygdx.game1.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game1.MyHeliGame;

public class Heli {
    private  static int GRAVITY = -150;
    private Vector3 position;
    private Vector3 velocity;

    private boolean lastTouched;

    private Texture heli;
    private TextureRegion helicopter;


    public Heli(int x, int y){
        position = new Vector3(x,y,0);
        velocity = new Vector3(GRAVITY,100,0);
        helicopter = new TextureRegion(new Texture("dog.png"));
        lastTouched =false;


    }

    /*public void update(float dt){
        if(position.y>0)
            velocity.add(0,GRAVITY,0);

        velocity.scl(dt);
        position.add(0,velocity.y,0);

        if(position.y <0)
            position.y = 0;

             velocity.scl(1/dt);

    }*/


    public void update(float dt){
       /*if(position.x>0 && position.x<125 && lastTouched == false){
            velocity.add(GRAVITY,0,0);

        }
        if(position.x>0 && position.x<125 && lastTouched == true){
            velocity.add(-GRAVITY,0,0);

        }
*/
        //velocity.scl(dt);
        //position.add(velocity.x,0,0);

        if(position.x < 0){
            helicopter.flip(true,false);
            position.add(3,0,0);
            lastTouched = true;
            velocity.add(-2*velocity.x,0,0);
        }

        else if(position.x > MyHeliGame.WIDTH-helicopter.getTexture().getWidth()) {
            helicopter.flip(true,false);
            position.add(-3,0,0);
            lastTouched = false;
            velocity.add(-2*velocity.x,0,0);
        }

        if(position.y < 0){
            position.add(0,3,0);
            velocity.add(0,-2*velocity.y,0);
        }

        else if(position.y > (MyHeliGame.HEIGHT - 2*helicopter.getTexture().getHeight())) {
            position.add(0,-3,0);
            velocity.add(0,-2*velocity.y,0);
        }

        position.add(velocity.x * dt,velocity.y * dt,0);

        //velocity.scl(1/dt);

    }

    public Vector3 getPosition() {
        return position;
    }



    public TextureRegion getTexture() {
        return helicopter;
    }

    public void jump(){
        velocity.y = 250;

    }
}
