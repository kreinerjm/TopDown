package com.mygdx.game.Components;

import com.mygdx.game.Entities.Entity;

public abstract class Component
{

    Entity parent;

    public Entity getParent(){return parent;}
    public void setParent(Entity set){parent=set;}
    public abstract void update();

}