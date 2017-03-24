package com.mygdx.game.Entities.Items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entities.Entity;

public abstract class Item extends Entity
{
    public static final int size = 64;
    public static final int stackSize = 50;
    String name;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    int quantity;

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public abstract void draw(SpriteBatch batch);


}