package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.Component;
import com.mygdx.game.Components.PhysicsComponents.Transform;
import com.mygdx.game.Exceptions.ComponentNotFoundException;

import java.util.ArrayList;
import java.util.UUID;

/*
This class represents a generic entity and the required fields for each entity.

Require Features:
    List of Components


 */

public abstract class Entity
{
    public UUID id = UUID.randomUUID();
    private final int MAX_COMPONENTS = 10;
    private ArrayList<Component> components = new ArrayList<Component>();
    private Entity parent;
    private ArrayList<Entity> subEntities = new ArrayList<Entity>();

    public void tick()
    {
        components.forEach(Component::update);
    }

    public abstract void draw(SpriteBatch b);

    public <T extends Component> T getComponent(Class<T> toGet)
    {

        for(Component c : components)
        {
            if(toGet.isInstance(c))
            {
                return toGet.cast(c);
            }
        }

        return (T)new Component(){
            @Override
            public void update()
            {

            }
        };
    }

    public <T extends Entity> T getSubEntity(Class<T> toGet)
    {
        for(Entity e : subEntities)
        {
            if(toGet.isInstance(e))
            {
                return toGet.cast(e);
            }
        }

        return (T)new Entity(){
            @Override
            public void draw(SpriteBatch b) {

            }
        };
    }

    public void addComponent(Component c)
    {
        if(components.size() < MAX_COMPONENTS)
        {
            components.add(c);
            c.setParent(this);
            System.out.println(c.getClass().toString()+" setting parent to "+this.getClass().toString());
        }
    }

    public void removeComponent(Component c)
    {
        components.remove(c);
    }

    public Entity getParent() {
        return parent;
    }

    public void setParent(Entity parent) {
        if(this.parent == null)
        {
            this.parent = parent;
        }
        else
        {
            this.parent.removeSubEntity(this);
            this.parent = parent;
        }
    }

    public ArrayList<Entity> getSubEntities() {
        return subEntities;
    }

    public void addSubEntity(Entity e)
    {
        subEntities.add(e);
        e.setParent(this);
    }

    public void removeSubEntity(Entity e)
    {
        subEntities.remove(e);
    }

}