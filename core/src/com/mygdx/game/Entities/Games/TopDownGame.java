package com.mygdx.game.Entities.Games;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Components.GameComponents.Inventory;
import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Worlds.TiledWorld;
import com.mygdx.game.Entities.Worlds.World;

public class TopDownGame extends Game {

    public TopDownGame() {

    }

    public void tick()
    {
        getSubEntity(TiledWorld.class).tick();
        getSubEntity(Player.class).tick();
        updateCamera();
    }

    public void draw(SpriteBatch batch)
    {
        batch.setProjectionMatrix(getCamera().combined);
        batch.begin();
        getSubEntity(TiledWorld.class).draw(batch);
        getSubEntity(Player.class).draw(batch);
        getSubEntity(Player.class).getComponent(Inventory.class).draw(batch);
        batch.end();
    }

}