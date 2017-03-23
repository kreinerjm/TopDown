package com.mygdx.game.Components.GraphicsComponents;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Components.Component;

public interface GraphicsComponent extends Component
{

    abstract void draw(SpriteBatch batch);

}