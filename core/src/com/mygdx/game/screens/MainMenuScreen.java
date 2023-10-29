package com.mygdx.game.screens;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Drop;

public class MainMenuScreen extends BaseScreen {

  private BitmapFont font;

  public MainMenuScreen(Game game, int width, int height) {
    super(game, width, height);
  }

  @Override
  protected Color getBackgroundColor() {
    return Drop.BACKGROUND;
  }

  @Override
  protected void draw(SpriteBatch batch) {
    font.draw(batch, "Welcome to Drop!!!", 100, 150);
    font.draw(batch, "Tap anywhere to begin!", 100, 100);
  }

  @Override
  protected void update(float delta) {
    if (Gdx.input.isTouched()) {
      game.setScreen(new GameScreen(game, Drop.WIDTH, Drop.HEIGHT));
      dispose();
    }
  }

  @Override
  protected SpriteBatch getSpriteBatch() {
    return Drop.batch;
  }

  @Override
  public void create() {
    font = new BitmapFont();
  }

  @Override
  public void dispose() {
    font.dispose();
  }
}
