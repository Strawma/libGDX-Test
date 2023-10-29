package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

/**
 * Raindrop class - represents a raindrop that falls from the sky.
 */
public class Raindrop extends Rectangle implements ISprite{

  public static Texture texture;
  public static final int SIZE = 64;

  public Raindrop() {
    super();
    x = MathUtils.random(0, Drop.WIDTH - SIZE);
    y = Drop.HEIGHT;
    width = SIZE;
    height = SIZE;
  }

  public void draw(SpriteBatch batch) {
    batch.draw(texture, x, y);
  }

  public void update(float delta) {
    fall(delta);
  }

  public static void create() {
    texture = new Texture("drop.png");
  }
  public static void dispose() {
    texture.dispose();
  }

  private void fall(float delta) {
    y -= (int) (200 * delta);
  }

  public boolean isOffScreen() {
    return y + SIZE < 0;
  }

  public boolean overlapsBucket(Bucket bucket) {
    return this.overlaps(bucket);
  }
}
