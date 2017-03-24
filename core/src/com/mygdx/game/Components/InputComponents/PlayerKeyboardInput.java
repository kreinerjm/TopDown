package com.mygdx.game.Components.InputComponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.GraphicsComponents.SpriteGraphics;
import com.mygdx.game.Components.PhysicsComponents.Transform;
import com.mygdx.game.Entities.Characters.Character;
import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Worlds.TiledWorld;

public class PlayerKeyboardInput extends PlayerInput<Player,TiledWorld>
{
    public void updateCharacter(Player p, TiledWorld t) {
        Transform transform = p.getComponent(Transform.class);

        boolean up = false, left = false, right = false, down = false;
        Vector2 currentPosition = transform.getPosition();
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            p.setPosition(new Vector2(currentPosition.x-transform.getVelocity().x,currentPosition.y));
            left = true;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            p.setPosition(new Vector2(currentPosition.x+transform.getVelocity().x,currentPosition.y));
            right = true;
        }
        currentPosition = transform.getPosition();
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            p.setPosition(new Vector2(currentPosition.x,currentPosition.y+transform.getVelocity().y));
            up = true;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            down = true;
            p.setPosition(new Vector2(currentPosition.x,currentPosition.y-transform.getVelocity().y));
        }

        if(up && left)
        {
            p.setDirection(Character.Direction.UpLeft);
        }
        else if(up && right)
        {
            p.setDirection(Character.Direction.UpRight);
        }
        else if(down && left)
        {
            p.setDirection(Character.Direction.DownLeft);
        }
        else if(down && right)
        {
            p.setDirection(Character.Direction.DownRight);
        }
        else if(down)
        {
            p.setDirection(Character.Direction.Down);
        }
        else if(up)
        {
            p.setDirection(Character.Direction.Up);
        }
        else if(left)
        {
            p.setDirection(Character.Direction.Left);
        }
        else if(right)
        {
            p.setDirection(Character.Direction.Right);
        }
        p.getComponent(SpriteGraphics.class).updateIndex(p);
    }

    @Override
    public void update() {

    }
}