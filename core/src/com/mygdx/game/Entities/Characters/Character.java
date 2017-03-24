
package com.mygdx.game.Entities.Characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.GraphicsComponents.SpriteGraphics;
import com.mygdx.game.Components.PhysicsComponents.Transform;
import com.mygdx.game.Entities.Entity;

public abstract class Character extends Entity
{
    Texture[] textures;
    public enum Direction {Down,Up,Left,Right,DownLeft,DownRight,UpLeft,UpRight;
        public int getIndexOf()
        {
            return this.ordinal();
        }
    }
    Direction direction = Direction.Down;

    public void setPosition(Vector2 pos){
        getComponent(Transform.class).setPosition(pos);
        getComponent(SpriteGraphics.class).updateSpritePositions();
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