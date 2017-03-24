package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.PhysicsComponents.Transform;
import com.mygdx.game.Entities.Characters.Player;
import com.mygdx.game.Entities.Games.Game;
import com.mygdx.game.Entities.Games.TopDownGame;
import com.mygdx.game.Entities.Worlds.TiledWorld;

public class TopDown2DMain extends ApplicationAdapter
{
    public static Game topDown;
    SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        topDown = new TopDownGame();
        Player player = new Player();
        player.getComponent(Transform.class).setPosition(new Vector2(100f,100f));
        topDown.addSubEntity(player);
        topDown.addSubEntity(new TiledWorld(256,128));


        OrthographicCamera camera = new OrthographicCamera(30, 30 * (h / w));
        camera.zoom = 40.0f;
        camera.position.set(0,0,0);
        topDown.setCamera(camera);

        camera.update();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        topDown.tick();
        topDown.draw(batch);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        for(Texture t : topDown.getSubEntity(Player.class).getTextures())
        {
            t.dispose();
        }
    }

    @Override
    public void pause() {

    }

}