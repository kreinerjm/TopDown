package com.mygdx.game.Entities.Games;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Worlds.World;

public abstract class Game extends Entity
{
    private World world;
    private Player player;
    private OrthographicCamera camera;

    public void setPlayer(Player player) {
        this.player = player;
        player.setParent(this);
    }

    public Player getPlayer() {
        return player;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
        world.setParent(this);
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public abstract void draw(SpriteBatch batch);

    public void updateCamera()
    {
        float x = player.getPosition().x+player.getGraphicsComponent().getReferenceSprite().getWidth()/2;
        float y = player.getPosition().y+player.getGraphicsComponent().getReferenceSprite().getHeight()/2;

        camera.position.set(x,y,0);
        camera.update();
    }
}