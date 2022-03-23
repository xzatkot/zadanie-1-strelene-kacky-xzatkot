package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.tiles.*;

public class Shoot extends Card {
    @Override
    public void activate(Game game) {
        int index = ZKlavesnice.readInt("Prosim zadaj index terca vystrelu: ");

        while(game.getBoolValue(index)){
            index = ZKlavesnice.readInt("Prosim zadaj index terca vystrelu: ");
        }

        game.crosshairArray[index] = false;
        game.players.get(game.pond.get(index).getOwner()-1).loseLife();
        game.pond.remove(index);
        game.pond.add(game.tileCardsStack.get(0));
        game.tileCardsStack.remove(0);
    }
}
