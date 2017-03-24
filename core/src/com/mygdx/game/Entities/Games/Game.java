package com.mygdx.game.Entities.Games;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Components.GraphicsComponents.SpriteGraphics;
import com.mygdx.game.Components.PhysicsComponents.Transform;
import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.Worlds.World;
import com.mygdx.game.Exceptions.ComponentNotFoundException;

public abstract class Game extends Entity
{
    private OrthographicCamera camera;

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public abstract void draw(SpriteBatch batch);

    public void updateCamera() {

        float x = getSubEntity(Player.class).getComponent(Transform.class).getPosition().x+getSubEntity(Player.class).getComponent(SpriteGraphics.class).getReferenceSprite().getWidth()/2;
        float y = getSubEntity(Player.class).getComponent(Transform.class).getPosition().y+getSubEntity(Player.class).getComponent(SpriteGraphics.class).getReferenceSprite().getHeight()/2;

        camera.position.set(x,y,0);
        camera.update();

    }
}