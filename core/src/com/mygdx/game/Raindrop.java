package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import java.awt.Rectangle;

/**
 * Raindrop class - represents a raindrop that falls from the sky.
 */
public class Raindrop extends Rectangle implements ISprite{

  public static final Texture TEXTURE = new Texture("drop.png");
  public static final int SIZE = TEXTURE.getWidth();

  public Raindrop() {
    super();
    x = MathUtils.random(0, DropGame.WIDTH - SIZE);
    y = DropGame.HEIGHT;
    width = SIZE;
    height = SIZE;
  }

  public void draw(SpriteBatch batch) {
    batch.draw(TEXTURE, x, y);
  }

  public void update() {
    fall();
  }

  private void fall() {
    y -= (int) (200 * Gdx.graphics.getDeltaTime());
  }

  public boolean isOffScreen() {
    return y + SIZE < 0;
  }
}
