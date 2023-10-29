package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Bucket class - represents the bucket that the player controls.
 */
public class Bucket extends Rectangle implements ISprite {

  public static Texture texture;
  public static final int SIZE = 64;
  public static final int SPEED = 500;
  private int score;
  private final BitmapFont scoreFont;

  public Bucket() {
    super();
    x = (float) Drop.WIDTH / 2 - (float) SIZE / 2; // center of screen
    y = 20; // 20 pixels above bottom of screen
    width = SIZE;
    height = SIZE;
    score = 0;
    scoreFont = new BitmapFont();
  }

  public void draw(SpriteBatch batch) {
    batch.draw(texture, x, y);
    scoreFont.draw(batch, "Score: " + score, x, y);
  }

  public static void create() {
    texture = new Texture("bucket.png");
  }
  public static void dispose() {
    texture.dispose();
  }

  public void update(float delta, Vector3 touchPos) {
    // moves bucket based on keyboard input
    if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A)) moveLeft(delta);
    if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)) moveRight(delta);

    // moves bucket based on mouse input
    if (touchPos != null) updateMouse(touchPos.x);
  }

  private void updateMouse(float mouseX) {
    x = mouseX - (float) SIZE / 2;
    clampLeft();
    clampRight();
  }

  private void moveLeft(float delta) {
    x -= SPEED * delta;
    clampLeft();
  }

  private void moveRight(float delta) {
    x += SPEED * delta;
    clampRight();
  }

  private void clampLeft() {
    if (x < 0) {
      x = 0;
    }
  }

  private void clampRight() {
    if (x > Drop.WIDTH - SIZE) {
      x = Drop.WIDTH - SIZE;
    }
  }

  public int getScore() {
    return score;
  }

  public void incrementScore() {
    score++;
  }
}
