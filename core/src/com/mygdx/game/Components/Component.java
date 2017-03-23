package com.mygdx.game.Components;

import com.mygdx.game.Entities.Entity;

public interface Component
{

    Entity getParent();
    void setParent(Entity set);
    String getId();
    void setId(String s);

}