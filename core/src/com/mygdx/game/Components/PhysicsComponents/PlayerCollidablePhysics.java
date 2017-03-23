package com.mygdx.game.Components.PhysicsComponents;

import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.Worlds.TiledWorld;

public class PlayerCollidablePhysics implements CollidablePhysics
{

    public void updatePlayer(Player p, TiledWorld world)
    {

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