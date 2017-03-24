package com.mygdx.game.Entities.Scenery;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.GraphicsComponents.SpriteGraphics;
import com.mygdx.game.Components.PhysicsComponents.Transform;
import com.mygdx.game.Entities.Items.Mineral;
import com.mygdx.game.Entities.Items.TestMineral;

/**
 * Created by Jacob on 3/20/2017.
 */
public class MineralNode extends Scenery
{

    Texture t;
    int amountPerMine;
    float mineChance;

    public MineralNode(Vector2 pos, int amt, float chance, Texture img) {
        t = img;
        SpriteGraphics graphics = new SpriteGraphics(new Texture[]{t});
        graphics.getSprite().setSize(50,50);
        addComponent(new Transform(pos));
        amountPerMine = amt;
        mineChance = chance;
        graphics.getSprite().setPosition(pos.x,pos.y);
        addComponent(graphics);
}

    public float getMineChance() {
        return mineChance;
    }

    public void setMineChance(float mineChance) {
        this.mineChance = mineChance;
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(SpriteBatch b) {
        getComponent(SpriteGraphics.class).draw(b);
    }

    public Mineral getMineral()
    {
        return new TestMineral("Copper",amountPerMine,t);
    }

}
