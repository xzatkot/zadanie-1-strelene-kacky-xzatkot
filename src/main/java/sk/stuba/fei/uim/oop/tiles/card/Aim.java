package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.game.Game;

public class Aim extends Card {
    @Override
    public void activate(Game game) {
        int index = ZKlavesnice.readInt("Prosim zadaj index terca: ");

        while(game.getBoolValue(index)){
            index = ZKlavesnice.readInt("Prosim zadaj index terca: ");
        }

        game.crosshairArray[index] = true;
    }
}
