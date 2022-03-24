package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Collections;

public class DuckDance extends Card {
    public final String name = "Duck dance";
    public DuckDance(){
        super.name = this.name;
    }
    @Override
    public void activate(Game game) {
        for (int i=0;i<6;i++){
            game.tileCardsStack.add(game.pond.get(i));
        }
        game.pond.clear();
        Collections.shuffle(game.tileCardsStack);
        game.startPond();
    }
}
