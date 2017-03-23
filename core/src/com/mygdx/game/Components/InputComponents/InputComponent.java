package com.mygdx.game.Components.InputComponents;

import com.mygdx.game.Components.Component;
import com.mygdx.game.Entities.Worlds.World;
import com.mygdx.game.Entities.Characters.Character;

public interface InputComponent<T extends Character, U extends World> extends Component
{

    abstract void updateCharacter(T character, U world);

}