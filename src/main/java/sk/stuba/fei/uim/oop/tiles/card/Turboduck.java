package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.tiles.Tile;

public class Turboduck extends Card {
    @Override
    public void activate(Game game) {
        int index = ZKlavesnice.readInt("Prosim vyber turbokacku: ")-1;

        Tile temp = game.pond.get(index);
        for (int i=index;i>0;i--){
            game.pond.set(index, game.pond.get(index-1));
        }
        game.pond.set(0, temp);
    }
}
