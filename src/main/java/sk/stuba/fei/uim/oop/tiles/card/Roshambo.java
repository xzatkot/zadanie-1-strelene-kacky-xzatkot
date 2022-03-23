package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.tiles.Tile;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Collections;

public class Roshambo extends Card {
    @Override
    public void activate(Game game) {
        Collections.shuffle(game.pond);
    }
}
