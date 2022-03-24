package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.tiles.Tile;

public class DuckWagon extends Card {
    public final String name = "Duck wagon";
    public DuckWagon(){
        super.name = this.name;
    }
    @Override
    public void activate(Game game) {
        Tile temp = game.pond.get(0);
        game.pond.remove(0);
        game.addCardToPond();
        game.tileCardsStack.add(temp);
    }
}
