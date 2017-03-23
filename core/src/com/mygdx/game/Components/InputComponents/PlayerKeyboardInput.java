package com.mygdx.game.Components.InputComponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Characters.Character;
import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.Worlds.TiledWorld;
import com.mygdx.game.Entities.Worlds.World;

public class PlayerKeyboardInput implements PlayerInput<Player,TiledWorld>
{
    public void updateCharacter(Player p, TiledWorld t)
    {
        boolean up = false, left = false, right = false, down = false;
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            p.setPosition(new Vector2(p.getPosition().x-p.getSpeed(),p.getPosition().y));
            left = true;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            p.setPosition(new Vector2(p.getPosition().x+p.getSpeed(),p.getPosition().y));
            right = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            p.setPosition(new Vector2(p.getPosition().x,p.getPosition().y+p.getSpeed()));
            up = true;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            down = true;
            p.setPosition(new Vector2(p.getPosition().x,p.getPosition().y-p.getSpeed()));
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
        p.getGraphicsComponent().updateIndex(p);
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