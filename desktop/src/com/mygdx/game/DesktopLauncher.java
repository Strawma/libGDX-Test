package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
		config.useVsync(true);
		config.setForegroundFPS(60);
		config.setTitle("Test Game");
		new Lwjgl3Application(new MyGdxGame(), config);
	}
}
