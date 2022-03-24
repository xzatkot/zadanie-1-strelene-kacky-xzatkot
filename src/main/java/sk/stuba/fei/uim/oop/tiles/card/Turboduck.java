package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.tiles.Tile;

public class Turboduck extends Card {
    public final String name = "Turboduck";
    public Turboduck(){
        super.name = this.name;
    }
    @Override
    public void activate(Game game) {
        int index = ZKlavesnice.readInt("Please select the turboduck: ")-1;

        Tile temp = game.pond.get(index);
        for (int i=index;i>0;i--){
            game.pond.set(i, game.pond.get(i-1));
        }
        game.pond.set(0, temp);
    }
}
