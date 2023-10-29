package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface ISprite {

  void draw(SpriteBatch spriteBatch);
  static void dispose();
}
