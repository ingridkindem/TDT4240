package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class Animation {
    protected ArrayList<TextureRegion> frames;
    protected ArrayList<TextureRegion> framesR;
    protected ArrayList<TextureRegion> framesL;


    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;
    private Texture h1;
    private Texture h2;
    private Texture h3;
    private Texture h4;
    private Texture h1R;
    private Texture h2R;
    private Texture h3R;
    private Texture h4R;
    protected int frameWidth;


    public Animation(float cycleTime) {
        frameCount = 4;

        h1 = new Texture("heli1.png");
        h2 = new Texture("heli2.png");
        h3 = new Texture("heli3.png");
        h4 = new Texture("heli4.png");
        h1R = new Texture("heli1R.png");
        h2R = new Texture("heli2R.png");
        h3R = new Texture("heli3R.png");
        h4R = new Texture("heli4R.png");

        frameWidth = h1.getWidth();

        framesL = new ArrayList<TextureRegion>();
        framesL.add(new TextureRegion(h1));
        framesL.add(new TextureRegion(h2));
        framesL.add(new TextureRegion(h3));
        framesL.add(new TextureRegion(h4));

        framesR = new ArrayList<TextureRegion>();
        framesR.add(new TextureRegion(h1R));
        framesR.add(new TextureRegion(h2R));
        framesR.add(new TextureRegion(h3R));
        framesR.add(new TextureRegion(h4R));

        maxFrameTime = cycleTime / frameCount;

        //Starting point
        frames = framesL;
        frame = 0;
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {
            frame++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount) {
            frame = 0;
        }
    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }
}
