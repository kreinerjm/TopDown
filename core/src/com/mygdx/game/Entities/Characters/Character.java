
package com.mygdx.game.Entities.Characters;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.AudioComponents.CharacterAudioComponent;
import com.mygdx.game.Components.GraphicsComponents.GraphicsComponent;
import com.mygdx.game.Components.GraphicsComponents.SpriteGraphics;
import com.mygdx.game.Components.InputComponents.InputComponent;
import com.mygdx.game.Components.InputComponents.PlayerInput;
import com.mygdx.game.Components.PhysicsComponents.PlayerCollidablePhysics;
import com.mygdx.game.Entities.Entity;

public abstract class Character extends Entity
{
    public enum Direction {Down,Up,Left,Right,DownLeft,DownRight,UpLeft,UpRight;
        public int getIndexOf()
        {
            return this.ordinal();
        }
    }
    Direction direction = Direction.Down;

    Vector2 velocity = new Vector2(0,0);
    Vector2 acceleration = new Vector2(0,0);

    SpriteGraphics graphicsComponent;
    PlayerInput inputComponent;
    CharacterAudioComponent audioComponent;
    PlayerCollidablePhysics physicsComponent;

    public void setPosition(Vector2 pos)
    {
        super.setPosition(pos);
        for(int i = 0; i < graphicsComponent.getSprites().length; i++)
        {
            graphicsComponent.getSprites()[i].setPosition(pos.x,pos.y);
        }

    }

    public SpriteGraphics getGraphicsComponent()
    {
        return graphicsComponent;
    }

    public PlayerInput getInputComponent()
    {
        return inputComponent;
    }

    public void setGraphicsComponent(SpriteGraphics s)
    {
        graphicsComponent = s;
    }

    public void setInputComponent(PlayerInput i)
    {
        inputComponent = i;
    }

    public void setDirection(Direction d)
    {
        direction = d;
    }

    public Direction getDirection()
    {
        return direction;
    }
}