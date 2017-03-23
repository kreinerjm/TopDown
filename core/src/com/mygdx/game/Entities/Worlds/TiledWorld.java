package com.mygdx.game.Entities.Worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Items.Mineral;
import com.mygdx.game.Entities.Items.TestMineral;
import com.mygdx.game.Entities.Scenery.MineralNode;
import com.mygdx.game.SimplexNoise.OpenSimplexNoise;
import com.mygdx.game.TopDown2DMain;

import java.util.ArrayList;

public class TiledWorld extends World
{
    int worldWidth, worldHeight;
    static float tileWidth = 64f;
    int[][] terrain;
    public float effectiveViewportHeight,effectiveViewportWidth;

    public ArrayList<MineralNode> getNodes() {
        return nodes;
    }

    ArrayList<MineralNode> nodes = new ArrayList<MineralNode>();

    Texture[] textures = {new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\marble.png")),new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\space.png"))};

    public TiledWorld(int wid, int hei)
    {
        worldWidth = wid;
        worldHeight = hei;
        terrain = new int[worldWidth][worldHeight];
        generateWorld();
    }


    public void tick()
    {

    }

    public void draw(SpriteBatch batch)
    {
        OrthographicCamera cam = TopDown2DMain.topDown.getCamera();
        effectiveViewportWidth = cam.viewportWidth * cam.zoom;
        effectiveViewportHeight = cam.viewportHeight * cam.zoom;


        for(float i = cam.position.x-tileWidth-effectiveViewportWidth/2; i < cam.position.x+effectiveViewportWidth+tileWidth; i+=tileWidth)
        {
            for(float j = cam.position.y-tileWidth-effectiveViewportHeight/2; j < cam.position.y+effectiveViewportHeight+tileWidth; j+=tileWidth)
            {
                if(i/tileWidth > 0 && i/tileWidth < worldWidth && j/tileWidth > 0 && j/tileWidth < worldHeight)
                {
                    int iIndex = (int)(i/tileWidth);
                    int jIndex = (int)(j/tileWidth);
                    Sprite cloned = new Sprite(textures[terrain[iIndex][jIndex]]);
                    cloned.setPosition((int)(i/tileWidth)*tileWidth,(int)(j/tileWidth)*tileWidth);
                    cloned.setSize(tileWidth,tileWidth);
                    cloned.draw(batch);
                }
            }
        }

        for(MineralNode m : nodes)
        {
            m.draw(batch);
        }

        TopDown2DMain.topDown.getPlayer().getInventory().draw(batch);

    }

    public void generateWorld()
    {
        double[][] values = new double[worldWidth][worldHeight];
        for(int i = 0; i < worldWidth; i++)
        {
            for(int j = 0; j < worldHeight; j++)
            {
                values[i][j] = 0;
                if(values[i][j] > -11)
                {
                    terrain[i][j] = 0;
                }
                else
                {
                    terrain[i][j] = 1;
                }
            }
        }
        nodes.add(new MineralNode(new Vector2(50f,50f),5,.5f,new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\CopperNode.png"))));
        nodes.add(new MineralNode(new Vector2(150f,150f),3,.3f,new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\IronNode.png"))){
            @Override
            public Mineral getMineral()
            {
                return new TestMineral("Iron",3,new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\IronNode.png")));
            }
        });
        nodes.add(new MineralNode(new Vector2(250f,250f),2,.2f,new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\PlatinumNode.png"))){
            @Override
            public Mineral getMineral()
            {
                return new TestMineral("Titanium",2,new Texture(Gdx.files.internal("C:\\Users\\Jacob\\Desktop\\TopDown2D\\core\\assets\\PlatinumNode.png")));
            }
        });
        //smooth();
    }

    public void drawCameraView(Camera c)
    {

    }

    /*public Sprite getRegion(int x, int y)
    {
        return new Sprite(new TextureRegion(spriteMap,x*17,y*17,16,16));
    }*/

    public int getTileAt(int x,int y)
    {
        if(x > 0 && x < worldWidth && y > 0 && y < worldHeight)
        {
            return terrain[x][y];
        }
        else
            return -1;
    }

    public void smooth()
    {
        for(int i = 0; i < 50000; i++)
        {
            int randX = (int)(Math.random()*(double)worldWidth);
            int randY = (int)(Math.random()*(double)worldHeight);
            if(getNumSimNeighbors(randX,randY) <= 6)
            {
                //System.out.println("wee");
                if(terrain[randX][randY] == 0)
                {
                    terrain[randX][randY] = 1;
                }
                else
                {
                    terrain[randX][randY] = 0;
                }
            }
        }
    }

    public int getNumSimNeighbors(int x, int y)
    {
        int toRet = 0;
        for(int i = x-1; i < x+1; i++)
        {
            for(int j = y-1; j < y+1; j++)
            {
                if(x > 0 && x < worldWidth && y > 0 && y < worldHeight && !(i==x&&j==y))
                {
                    if(terrain[i][j] == terrain[x][y])
                    {
                        toRet++;

                    }
                }
            }
        }
        return toRet;
    }

}