package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array; // array acts like arraylist with less garbage
import com.badlogic.gdx.utils.TimeUtils;
import java.util.Iterator;

public class Raindrops {

  private final Array<Raindrop> raindrops;
  private long lastDropTime;

  public Raindrops() {
    raindrops = new Array<>();
    spawnRaindrop();
  }

  private void spawnRaindrop() {
    raindrops.add(new Raindrop());
    lastDropTime = TimeUtils.nanoTime();
  }

  public void update() {
    if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
      spawnRaindrop();
    }
    for (Iterator<Raindrop> iter = raindrops.iterator(); iter.hasNext();) {
      Raindrop raindrop = iter.next();
      raindrop.update();
      if (raindrop.isOffScreen()) {
        iter.remove();
      }
    }
  }

  public void draw(SpriteBatch spriteBatch) {
    for (Raindrop raindrop : raindrops) {
      raindrop.draw(spriteBatch);
    }
  }
}
