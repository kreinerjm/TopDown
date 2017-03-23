package com.mygdx.game.Components.GraphicsComponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Entity;

public class SpriteGraphics implements GraphicsComponent
{


    Sprite[] sprite;
    int currentIndex = 0;

    public SpriteGraphics(Texture[] t)
    {
        sprite = new Sprite[t.length];

        for(int i = 0; i < t.length; i++)
        {
            sprite[i] = new Sprite(t[i]);
            sprite[i].setSize(100,100);
        }
    }

    public Sprite getReferenceSprite()
    {
        return sprite[0];
    }

    public Sprite getSprite() {
        return sprite[currentIndex];
    }

    public Sprite[] getSprites()
    {
        return sprite;
    }

    public void draw(SpriteBatch batch)
    {
        sprite[currentIndex].draw(batch);
    }

    public void updateIndex(Player p)
    {
        currentIndex = p.getDirection().getIndexOf();
    }


    @Override
    public Entity getParent() {
        return null;
    }

    @Override
    public void setParent(Entity set) {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String s) {

    }
}