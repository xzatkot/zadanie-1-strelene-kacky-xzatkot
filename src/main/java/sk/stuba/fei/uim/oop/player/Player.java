package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.tiles.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private int playerID;
    private int lives = 5;
    private ArrayList<Card> cardsInHand;

    public void loseLife(){
        this.lives -= 1;
    }
}
