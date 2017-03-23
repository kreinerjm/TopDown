package com.mygdx.game.Entities.Items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Components.GraphicsComponents.SpriteGraphics;

/**
 * Created by Jacob on 3/20/2017.
 */
public class TestMineral extends Mineral {

    public TestMineral(String s, int q, Texture t)
    {
        graphics = new SpriteGraphics(new Texture[]{t});
        name = s;
        quantity = q;
        graphics.getSprite().setSize(Item.size,Item.size);
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(SpriteBatch b) {
        graphics.draw(b);
    }



}
