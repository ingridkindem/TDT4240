package com.mygdx.game1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game1.states.GameStateManager;
import com.mygdx.game1.states.MenuState;

public class MyHeliGame extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public static final String TITLE = "Helicopter";
	private GameStateManager gsm;
	private SpriteBatch batch;

	//Texture img;

	@Override
	public void create () {
		Gdx.gl.glClearColor(25, 100, 5, 50);
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		//img = new Texture("heli1.png");
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		//batch.draw(img, 0, 0);
		batch.end();

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	//	img.dispose();
	}


}
