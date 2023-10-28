package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Bucket class - represents the bucket that the player controls.
 */
public class Bucket extends Rectangle {

  public static final Texture bucketImage = new Texture("bucket.png");
  public static final int SIZE = bucketImage.getWidth();

  public Bucket() {
    super();
    x = (float) DropGame.WIDTH / 2 - (float) SIZE / 2; // center of screen
    y = 20; // 20 pixels above bottom of screen
    width = SIZE;
    height = SIZE;
  }

  public void draw(SpriteBatch batch) {
    batch.draw(bucketImage, x, y);
  }

}