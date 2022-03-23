package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.tiles.Tile;

public class DuckWagon extends Card {
    @Override
    public void activate(Game game) {
        Tile temp = game.pond.get(0);
        game.pond.remove(0);
        game.pond.add(game.tileCardsStack.get(0));
        game.tileCardsStack.remove(0);
        game.tileCardsStack.add(temp);
    }
}
