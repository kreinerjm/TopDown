package com.mygdx.game.Components.InputComponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.Scenery.MineralNode;
import com.mygdx.game.Entities.Worlds.TiledWorld;
import com.mygdx.game.TopDown2DMain;

public class PlayerMouseInput implements PlayerInput<Player,TiledWorld>
{
    public void updateCharacter(Player p, TiledWorld world)
    {
        if(Gdx.input.justTouched() && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            System.out.println("CLICK");
            float w = Gdx.graphics.getWidth();
            float h = Gdx.graphics.getHeight();

            float x = TopDown2DMain.topDown.getCamera().position.x - (world.effectiveViewportWidth / 2) + (Gdx.input.getX() / w) * world.effectiveViewportWidth;
            float y = TopDown2DMain.topDown.getCamera().position.y - (world.effectiveViewportHeight / 2) + (1f - (Gdx.input.getY() / h)) * world.effectiveViewportHeight;



            for (MineralNode m : world.getNodes()) {
                if (x > m.getPosition().x && y > m.getPosition().y && x < m.getPosition().x + 50 && y < m.getPosition().y + 50) {
                    if(Math.random() < m.getMineChance())
                        p.getInventory().addItem(m.getMineral());
                    else
                        System.out.println("Mine failed");

                }
            }
        }
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