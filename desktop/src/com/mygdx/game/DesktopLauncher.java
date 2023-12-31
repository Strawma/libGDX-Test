package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Drop Game");
		config.setWindowedMode(Drop.WIDTH, Drop.HEIGHT);
		config.useVsync(true);
		config.setForegroundFPS(60);
		new Lwjgl3Application(new Drop(), config);
	}
}
