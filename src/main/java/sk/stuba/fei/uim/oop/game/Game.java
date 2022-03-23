package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.tiles.Duck;
import sk.stuba.fei.uim.oop.tiles.Water;
import sk.stuba.fei.uim.oop.tiles.Tile;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.card.*;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    int numOfPlayers;
    public ArrayList<Tile> pond = new ArrayList<>();
    public ArrayList<Tile> tileCardsStack = new ArrayList<>();
    public ArrayList<Card> cardStack = new ArrayList<>();
    public ArrayList<Player> players = new ArrayList<>();
    public boolean[] crosshairArray = {false, false, false, false, false, false};

    public Game() {
        System.out.println("**** Strelene kacky ****");
        this.numOfPlayers = ZKlavesnice.readInt("Zadaj pocet hracov: ");
        initialiseTileCards(this.numOfPlayers);
        createCardStack();
        startPond();
        initialisePlayers(this.numOfPlayers);
        dealCards();

        while(this.getWinner() == 0){
            //TODO
        }
        int winner = this.getWinner();
    }

    public boolean getBoolValue(int index){
        return crosshairArray[index];
    }
    public void setBoolValue(int index){
        crosshairArray[index] = true;
    }

    public void initialiseTileCards(int numOfPlayers){
        for (int i=0;i<numOfPlayers;i++){
            for (int j=0;j<5;j++) {
                this.tileCardsStack.add(new Duck(i+1));
            }
        }
        for (int i=0;i<5;i++){
            this.tileCardsStack.add(new Water());
        }
        Collections.shuffle(this.tileCardsStack);
    }

    public void startPond(){
        for (int i=0;i<6;i++){
            this.pond.add(this.tileCardsStack.get(0));
            this.tileCardsStack.remove(0);
        }
    }

    public void addCardToPond(){
        this.pond.add(this.tileCardsStack.get(0));
        this.tileCardsStack.remove(0);
    }

    public void createCardStack(){
        for (int i=0;i<10;i++){
            this.cardStack.add(new Aim());
        }
        for (int i=0;i<12;i++){
            this.cardStack.add(new Shoot());
        }
        for (int i=0;i<2;i++){
            this.cardStack.add(new WildBill());
        }
        for (int i=0;i<6;i++){
            this.cardStack.add(new DuckWagon());
        }
        this.cardStack.add(new Turboduck());
        for (int i=0;i<2;i++){
            this.cardStack.add(new Roshambo());
        }
        this.cardStack.add(new DuckDance());
        Collections.shuffle(this.cardStack);
    }

    public int getWinner() {
        int activePlayers = 0;
        int winner = 0;
        for (int i = 0; i < this.numOfPlayers; i++) {
            if (players.get(i).getLives() > 0) {
                activePlayers += 1;
                winner = i;
            }
        }
        if (activePlayers == 1) {
            return winner;
        }
        else{
            return 0;
        }
    }

    public void initialisePlayers(int numOfPlayers){
        for (int i=0;i<numOfPlayers;i++){
            this.players.add(new Player(i));
        }
    }

    public void dealCards(){
        for (int i=0;i<this.numOfPlayers;i++){
            for (int j=0;j<3;j++){
                this.players.get(i).addCardToHand(this.cardStack.get(0));
                this.cardStack.remove(0);
            }
        }
    }
}
