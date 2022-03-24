package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.game.Game;

public class Aim extends Card {
    public final String name = "Aim";
    public Aim(){
        super.name = this.name;
    }
    @Override
    public void activate(Game game) {
        int index = ZKlavesnice.readInt("Select the index of target: ")-1;

        while(game.getBoolValue(index)){
            index = ZKlavesnice.readInt("Select the index of target: ")-1;
        }

        game.crosshairArray[index] = true;
    }
}
