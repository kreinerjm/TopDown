package com.mygdx.game.Components.GraphicsComponents;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Components.Component;

public abstract class GraphicsComponent extends Component
{

    abstract void draw(SpriteBatch batch);

}