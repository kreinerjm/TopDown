package com.mygdx.game.Entities.Characters;


import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.SpriteBatch;
        import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.GameComponents.Inventory;
import com.mygdx.game.Components.GraphicsComponents.SpriteGraphics;
        import com.mygdx.game.Components.InputComponents.PlayerKeyboardInput;
import com.mygdx.game.Components.InputComponents.PlayerMouseInput;
import com.mygdx.game.Entities.Games.TopDownGame;
import com.mygdx.game.Entities.Worlds.TiledWorld;
import com.mygdx.game.Entities.Worlds.World;
import com.mygdx.game.TopDown2DMain;

public class Player extends Character
{
    PlayerMouseInput mInput = new PlayerMouseInput();
    Inventory inventory;

    Texture[] textures;
    float speed = 10f;
    public Player()
    {
        inventory = new Inventory();
        textures = new Texture[8];
        textures[0] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerFront.png"));
        textures[1] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerBack.png"));
        textures[2] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerLeft.png"));
        textures[3] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerRight.png"));
        textures[4] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerFrontLeft.png"));
        textures[5] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerFrontRight.png"));
        textures[6] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerBackLeft.png"));
        textures[7] = new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\playerBackRight.png"));
        graphicsComponent = new SpriteGraphics(textures);
        inputComponent = new PlayerKeyboardInput();
        setPosition(new Vector2(0,0));
    }

    public void tick()
    {
        getInputComponent().updateCharacter(this,TopDown2DMain.topDown.getWorld());
        mInput.updateCharacter(this, (TiledWorld)TopDown2DMain.topDown.getWorld());
    }

    public void draw(SpriteBatch batch)
    {
        getGraphicsComponent().draw(batch);
    }

    public float getSpeed()
    {
        return speed;
    }


    public Inventory getInventory()
    {
        return inventory;
    }

    public Texture[] getTextures() {
        return textures;
    }
}