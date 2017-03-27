package com.mygdx.game.Components;

import com.mygdx.game.Entities.Entity;

import java.util.UUID;

public abstract class Component
{
    public UUID id = UUID.randomUUID();
    Entity parent;

    public Entity getParent(){return parent;}
    public void setParent(Entity set){parent=set;}
    public abstract void update();

}