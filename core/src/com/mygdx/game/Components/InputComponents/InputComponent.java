package com.mygdx.game.Components.InputComponents;

import com.mygdx.game.Components.Component;
import com.mygdx.game.Entities.Characters.Character;
import com.mygdx.game.Entities.Worlds.World;

public abstract class InputComponent<T extends Character, U extends World> extends Component
{

    public abstract void updateCharacter(T character, U world);

}