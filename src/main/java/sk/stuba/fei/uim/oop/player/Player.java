package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.tiles.card.Card;

import java.util.ArrayList;

public class Player {
    private int playerID;
    private int lives = 5;
    private ArrayList<Card> cardsInHand;

    public void loseLife(){
        this.lives -= 1;
    }

    public void addCardToHand(Card card){
        this.cardsInHand.add(card);
    }

    public void assignPlayerNum(int num){
        this.playerID = num;
    }

    public int getPlayerID(){
        return this.playerID;
    }

    public int getLives() {
        return this.lives;
    }

    public void printCardsInHand() {
        for (int i=0; i<3;i++){
            System.out.print(cardsInHand.get(i).getClass());
        }
    }
}
