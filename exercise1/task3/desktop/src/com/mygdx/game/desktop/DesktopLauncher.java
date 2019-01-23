package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.HeliAnimation;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = HeliAnimation.HEIGHT;
		config.width = HeliAnimation.WIDTH;
		config.title = HeliAnimation.TITLE;
		new LwjglApplication(new HeliAnimation(), config);
	}
}
