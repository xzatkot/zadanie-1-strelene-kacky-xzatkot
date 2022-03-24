package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.tiles.card.Card;
import sk.stuba.fei.uim.oop.game.Game;

import java.util.ArrayList;

public class Player {
    private final int playerID;
    private int lives = 5;
    public ArrayList<Card> cardsInHand = new ArrayList<>();

    public Player(int num){
        playerID = num+1;
    }

    public void loseLife(){
        this.lives -= 1;
    }

    public void addCardToHand(Card card){
        this.cardsInHand.add(card);
    }

    public void removeCard(int index){
        this.cardsInHand.remove(index);
    }

    public int getLives() {
        return this.lives;
    }

    public boolean isAlive(){
        return this.getLives() > 0;
    }

    public void printCardsInHand() {
        for (int i=0; i<3;i++){
            System.out.print((i+1) + ". " + cardsInHand.get(i).getName() + "   ");
        }
    }
    public int getPlayerID(){
        return this.playerID;
    }
}
