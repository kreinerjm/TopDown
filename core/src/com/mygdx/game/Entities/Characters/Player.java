package com.mygdx.game.Entities.Characters;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.GameComponents.Inventory;
import com.mygdx.game.Components.GraphicsComponents.SpriteGraphics;
import com.mygdx.game.Components.InputComponents.PlayerKeyboardInput;
import com.mygdx.game.Components.InputComponents.PlayerMouseInput;
import com.mygdx.game.Components.PhysicsComponents.Transform;
import com.mygdx.game.Entities.Worlds.TiledWorld;
import com.mygdx.game.TopDown2DMain;

public class Player extends Character
{

    public Player()
    {
        textures = new Texture[8];
        textures[0] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerFront.png"));
        textures[1] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerBack.png"));
        textures[2] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerLeft.png"));
        textures[3] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerRight.png"));
        textures[4] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerFrontLeft.png"));
        textures[5] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerFrontRight.png"));
        textures[6] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerBackLeft.png"));
        textures[7] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerBackRight.png"));

        Transform transform = new Transform(100,100);
        transform.setVelocity(new Vector2(5,5));
        addComponent(transform);
        addComponent(new PlayerKeyboardInput());
        addComponent(new PlayerMouseInput());
        addComponent(new SpriteGraphics(textures));
        addComponent(new Inventory());
        getComponent(SpriteGraphics.class).updateSpritePositions();
    }

    public void tick()
    {
        getComponent(PlayerKeyboardInput.class).updateCharacter(this,TopDown2DMain.topDown.getSubEntity(TiledWorld.class));
        getComponent(PlayerMouseInput.class).updateCharacter(this, TopDown2DMain.topDown.getSubEntity(TiledWorld.class));
    }

    public void draw(SpriteBatch batch)
    {
        getComponent(SpriteGraphics.class).draw(batch);
        getComponent(Inventory.class).draw(batch);
    }

    public Texture[] getTextures() {
        return textures;
    }
}