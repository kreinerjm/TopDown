package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
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
        topDown = new TopDownGame(new TiledWorld(256,128),new Player());

        OrthographicCamera camera = new OrthographicCamera(30, 30 * (h / w));
        camera.zoom = 40.0f;
        camera.position.set(0,0,0);
        topDown.setCamera(camera);

        topDown.getPlayer().setPosition(new Vector2(100f,100f));

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
        for(Texture t : topDown.getPlayer().getTextures())
        {
            t.dispose();
        }
    }

    @Override
    public void pause() {

    }

}