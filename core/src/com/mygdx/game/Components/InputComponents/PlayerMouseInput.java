package com.mygdx.game.Components.InputComponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.GameComponents.Inventory;
import com.mygdx.game.Components.PhysicsComponents.Transform;
import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Scenery.MineralNode;
import com.mygdx.game.Entities.Worlds.TiledWorld;
import com.mygdx.game.TopDown2DMain;

public class PlayerMouseInput extends PlayerInput<Player,TiledWorld>
{
    public void updateCharacter(Player p, TiledWorld world)
    {
        if(Gdx.input.justTouched() && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            float w = Gdx.graphics.getWidth();
            float h = Gdx.graphics.getHeight();

            float x = TopDown2DMain.topDown.getCamera().position.x - (world.effectiveViewportWidth / 2) + (Gdx.input.getX() / w) * world.effectiveViewportWidth;
            float y = TopDown2DMain.topDown.getCamera().position.y - (world.effectiveViewportHeight / 2) + (1f - (Gdx.input.getY() / h)) * world.effectiveViewportHeight;



            for (MineralNode m : world.getNodes()) {
                Vector2 pos = m.getComponent(Transform.class).getPosition();
                float xPos = pos.x;
                float yPos = pos.y;
                if (x > xPos && y > yPos && x < xPos + 50 && y < yPos + 50) {
                    if(Math.random() < m.getMineChance())
                        p.getComponent(Inventory.class).addItem(m.getMineral());
                    else
                        System.out.println("Mine failed");
                }
            }
        }
    }

    @Override
    public void update() {

    }
}