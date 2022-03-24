package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Objects;

public class WildBill extends Card {
    public final String name = "Wild Bill";
    public WildBill(){
        super.name = this.name;
    }
    @Override
    public void activate(Game game) {
        int index = ZKlavesnice.readInt("Select the duck to kill: ")-1;
        while (0>index || index>6){
            index = ZKlavesnice.readInt("Select the duck to kill: ")-1;
        }

        if (Objects.equals(game.pond.get(index).getName(), "Water")){
            System.out.println("You fired at water.");
            game.usedCards.add(new WildBill());
            return;
        }
        game.crosshairArray[index] = false;
        game.cardStack.add(new Aim());
        game.players.get(game.pond.get(index).getOwner()-1).loseLife();
        game.pond.remove(index);
        game.addCardToPond();
    }
}
