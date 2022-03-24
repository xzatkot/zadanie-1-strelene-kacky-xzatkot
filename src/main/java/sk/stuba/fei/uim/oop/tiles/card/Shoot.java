package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Objects;

public class Shoot extends Card {
    public final String name = "Shoot";
    public Shoot(){
        super.name = this.name;
    }
    @Override
    public void activate(Game game) {
        int index = ZKlavesnice.readInt("Select a duck to shoot at: ")-1;

        while(!game.getBoolValue(index) || 0>index || index>6){
            index = ZKlavesnice.readInt("The duck has to be aimed at: ")-1;
        }

        game.crosshairArray[index] = false;
        if (Objects.equals(game.pond.get(index).getName(), "Water")){
            System.out.println("You fired at water.");
            game.usedCards.add(new Shoot());
            return;
        }
        game.players.get(game.pond.get(index).getOwner()-1).loseLife();
        game.pond.remove(index);
        game.addCardToPond();
    }
}
