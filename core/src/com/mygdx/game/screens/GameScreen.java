package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Bucket;
import com.mygdx.game.Drop;
import com.mygdx.game.Raindrops;

public class GameScreen extends BaseScreen {

  private Music rainMusic;
  private static final float RAIN_MUSIC_VOLUME = 0.1f;

  private final Bucket bucket;
  private final Raindrops raindrops;

  public GameScreen(Game game, int width, int height) {
    super(game, width, height);

    // creates bucket rectangle
    bucket = new Bucket();

    // creates raindrops array
    raindrops = new Raindrops();

    // plays rain music
    rainMusic.setLooping(true);
    rainMusic.setVolume(RAIN_MUSIC_VOLUME);
    rainMusic.play();
  }

  @Override
  protected Color getBackgroundColor() {
    return Drop.BACKGROUND;
  }

  protected void draw(SpriteBatch batch) {
    raindrops.draw(batch);
    bucket.draw(batch);
  }

  protected void update(float delta) {
    Vector3 touchPos = null;
    if (Gdx.input.isTouched()) {
      touchPos = new Vector3();
      touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); // gets mouse position
      camera.unproject(touchPos); // converts mouse position to game coordinates
    }

    if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.ESCAPE)) {
      Gdx.app.exit();
    }

    bucket.update(delta, touchPos);
    raindrops.update(delta, bucket);
  }

  protected SpriteBatch getSpriteBatch() {
    return Drop.batch;
  }

  @Override
  public void create() {
    Bucket.create();
    Raindrops.create();
    rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
  }

  @Override
  public void dispose() {
    Bucket.dispose();
    Raindrops.dispose();
    rainMusic.dispose();
  }
}
