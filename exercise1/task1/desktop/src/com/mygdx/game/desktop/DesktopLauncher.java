package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game1.MyHeliGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MyHeliGame.WIDTH;
		config.height = MyHeliGame.HEIGHT;
		config.title = MyHeliGame.TITLE;
		new LwjglApplication(new MyHeliGame(), config);
	}
}
