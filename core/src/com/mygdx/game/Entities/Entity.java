package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.Component;
import com.mygdx.game.Exceptions.ComponentNotFoundException;

import java.util.ArrayList;

public abstract class Entity
{
    private final int MAX_COMPONENTS = 10;
    private ArrayList<Component> components = new ArrayList<Component>();
    private Vector2 position;
    private Entity parent;
    private ArrayList<Entity> subEntities = new ArrayList<Entity>();
    private int width, height;

    public abstract void tick();

    public abstract void draw(SpriteBatch b);

    public Component getComponent(String s) throws ComponentNotFoundException
    {
        for(Component c : components)
        {
            if(c.getClass().toString().equals(s))
            {
                return c;
            }
        }
        throw new ComponentNotFoundException();
    }

    public void addComponent(Component c)
    {
        if(components.size() < MAX_COMPONENTS)
            components.add(c);
    }

    public void removeComponent(Component c)
    {
        components.remove(c);
    }

    public void setPosition(Vector2 pos)
    {
        position = pos;
    }

    public Vector2 getPosition()
    {
        return position;
    }

    public int getMAX_COMPONENTS()
    {
        return MAX_COMPONENTS;
    }

    public Entity getParent() {
        return parent;
    }

    public void setParent(Entity parent) {
        if(this.parent == null)
        {
            this.parent = parent;
            parent.addSubEntity(this);
        }
        else
        {
            this.parent.removeSubEntity(this);
            this.parent = parent;
            parent.addSubEntity(this);
        }
    }

    public ArrayList<Entity> getSubEntities() {
        return subEntities;
    }

    public void addSubEntity(Entity e)
    {
        subEntities.add(e);
    }

    public void removeSubEntity(Entity e)
    {
        subEntities.remove(e);
    }

}