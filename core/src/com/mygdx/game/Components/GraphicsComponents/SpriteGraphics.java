package com.mygdx.game.Components.GraphicsComponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Components.PhysicsComponents.Transform;
import com.mygdx.game.Entities.Characters.Player;

public class SpriteGraphics extends GraphicsComponent
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

    public void updateSpritePositions()
    {
        for(int i = 0; i < sprite.length; i++)
        {
            sprite[i].setPosition(getParent().getComponent(Transform.class).getPosition().x,getParent().getComponent(Transform.class).getPosition().y);
        }
    }


    @Override
    public void update() {

    }
}