package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public abstract class BaseScreen implements Screen {

  protected final Game game;
  protected final OrthographicCamera camera;

  public BaseScreen(Game game, int width, int height) {
    this.game = game;
    camera = new OrthographicCamera();
    camera.setToOrtho(false, width, height);
    create();
  }

  @Override
  public void render(float delta) {
    ScreenUtils.clear(getBackgroundColor());

    getSpriteBatch().begin();
    draw(getSpriteBatch());
    getSpriteBatch().end();

    update(delta);
  }

  protected abstract void create();

  protected abstract void draw(SpriteBatch batch);

  protected abstract void update(float delta);

  protected abstract SpriteBatch getSpriteBatch();

  protected abstract Color getBackgroundColor();

  @Override
  public void show() {

  }

  @Override
  public void resize(int width, int height) {

  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void hide() {

  }
}
