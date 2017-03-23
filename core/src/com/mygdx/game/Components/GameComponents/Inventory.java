
package com.mygdx.game.Components.GameComponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.Items.Item;
import com.mygdx.game.TopDown2DMain;

import java.util.ArrayList;

public class Inventory implements GameComponent
{
    int maxItems = 10;
    ArrayList<Item> items;
    Sprite inventoryGUI = new Sprite(new Texture("C:/Users/Jacob/Desktop/TopDown2D/core/assets/inventorygui.png"));

    public Inventory()
    {
        items = new ArrayList<Item>();
    }

    public boolean isFull()
    {
        if(items.size() >= maxItems)
        {
            return true;
        }
        return false;
    }

    public void addItem(Item i)
    {
        int n = contains(i.getName());
        if(n==-1)
        {
            if(!isFull())
            {
                items.add(i);
                System.out.println("added item "+i.getName()+" successfully!");
            }
            else
            {
                System.out.println("its full!!!");
            }
        }
        else
        {
            Item inList = items.get(n);
            if(inList.getQuantity() + i.getQuantity() <= Item.stackSize)
            {
                inList.setQuantity(inList.getQuantity()+i.getQuantity());
            }
            else
            {
                if(!isFull())
                {
                    i.setQuantity(i.getQuantity()-(Item.stackSize-inList.getQuantity()));
                    items.add(i);
                }
                inList.setQuantity(Item.stackSize);
            }
        }

    }

    public ArrayList<Item> getItems()
    {
        return items;
    }

    public void draw(SpriteBatch b)
    {
        OrthographicCamera cam = TopDown2DMain.topDown.getCamera();
        float effectiveViewportHeight = cam.viewportHeight * cam.zoom;
        float x = cam.position.x - Item.size/2*maxItems;
        float y = cam.position.y - effectiveViewportHeight/2;
        inventoryGUI.setPosition(x,y);
        inventoryGUI.draw(b);
        BitmapFont font = new BitmapFont();
        font.setColor(Color.RED);
        for(int i = 0; i < items.size(); i++)
        {
            items.get(i).getGraphics().getSprite().setPosition(x+i*Item.size+i*2+2,y+2);
            items.get(i).draw(b);
            font.draw(b,items.get(i).getName(),x+i*Item.size+i*2+3,y+16);
            font.draw(b,items.get(i).getQuantity()+"",x+i*Item.size+i*2+3,y+32);
        }
        for(int i = 0; i < 10; i++)
        {
            font.draw(b,i+1+"",x+i*Item.size+i*2+3,y+64);
        }
    }

    public int contains(String id)
    {
        int j = 0;
        for(Item i : items)
        {
            if(i.getName().equals(id) && i.getQuantity()<Item.stackSize)
            {
                return j;
            }
            j++;
        }
        return -1;
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