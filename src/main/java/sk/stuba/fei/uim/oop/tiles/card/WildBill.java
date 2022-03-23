package sk.stuba.fei.uim.oop.tiles.card;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class WildBill extends Card {
    public final String name = "Divoky Bill";
    public WildBill(){
        super.name = this.name;
    }
    @Override
    public void activate(Game game) {
        int index = ZKlavesnice.readInt("Prosim vyber kacku na odstrel: ")-1;

        game.crosshairArray[index] = false;
        game.cardStack.add(new Aim());
        game.players.get(game.pond.get(index).getOwner()-1).loseLife();
        game.pond.remove(index);
        game.pond.add(game.tileCardsStack.get(0));
        game.tileCardsStack.remove(0);
    }
}
