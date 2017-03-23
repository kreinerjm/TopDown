package com.mygdx.game.Entities.Games;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Worlds.World;

public class TopDownGame extends Game {

    public TopDownGame(World world, Player player) {
        setWorld(world);
        setPlayer(player);
    }

    public void tick()
    {
        getWorld().tick();
        getPlayer().tick();
        updateCamera();
    }

    public void draw(SpriteBatch batch)
    {
        batch.setProjectionMatrix(getCamera().combined);
        batch.begin();
        getWorld().draw(batch);
        getPlayer().draw(batch);
        getPlayer().getInventory().draw(batch);
        batch.end();
    }

}