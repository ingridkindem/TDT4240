package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.HeliMove;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = HeliMove.WIDTH;
		config.height = HeliMove.HEIGHT;
		config.title = HeliMove.TITLE;
		new LwjglApplication(new HeliMove(), config);
	}
}
