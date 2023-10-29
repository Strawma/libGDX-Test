package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.MainMenuScreen;

public class Drop extends Game {

  public static final Color BACKGROUND = new Color(0,0,0.2f,1f);
  public static SpriteBatch batch;

  // constants for width and height of game screen - used in desktop and html launchers
  public static final int WIDTH = 800;
  public static final int HEIGHT = 480;

  public void create() {
    batch = new SpriteBatch();
    this.setScreen(new MainMenuScreen(this, WIDTH, HEIGHT));
  }

  public void render() {
    super.render();
  }

  public void dispose() {
    batch.dispose();
  }
}
