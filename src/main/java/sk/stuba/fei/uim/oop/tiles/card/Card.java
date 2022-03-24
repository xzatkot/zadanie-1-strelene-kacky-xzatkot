package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;

public abstract class Card {
    public String name;

    public abstract void activate(Game game);

    public String getName() {
        return this.name;
    }
}
