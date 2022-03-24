package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.tiles.Duck;
import sk.stuba.fei.uim.oop.tiles.Water;
import sk.stuba.fei.uim.oop.tiles.Tile;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.card.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Game {

    int numOfPlayers;
    public ArrayList<Tile> pond = new ArrayList<>();
    public ArrayList<Tile> tileCardsStack = new ArrayList<>();
    public ArrayList<Card> cardStack = new ArrayList<>();
    public ArrayList<Card> usedCards = new ArrayList<>();
    public ArrayList<Player> players = new ArrayList<>();
    public boolean[] crosshairArray = {false, false, false, false, false, false};

    public Game() {
        System.out.println("**** Duck Hunt ****");
        this.numOfPlayers = ZKlavesnice.readInt("Enter number of players (2-6): ");
        initialiseTileCards(this.numOfPlayers);
        createCardStack();
        startPond();
        initialisePlayers(this.numOfPlayers);
        dealCards();

        int turn = 0;

        while(this.getWinner() == 0){
            int playerTurn = turn % this.numOfPlayers;
            System.out.println();
            System.out.println("##################################");
            printLives();
            System.out.println("Player " + (playerTurn+1) + "'s turn");
            printPond();
            this.players.get(playerTurn).printCardsInHand();
            playCard(playerTurn);
            System.out.println();
            checkDeadPlayers();
            if (this.getWinner() != 0){
                break;
            }

            turn++;
        }
        int winner = this.getWinner();
        System.out.println("Player " + (winner) + " wins!");
    }

    public void checkDeadPlayers(){
        for (int i=0;i<this.numOfPlayers;i++){
            if (!this.players.get(i).isAlive()){
                for(int j=0;j<3;j++){
                    this.cardStack.add(this.players.get(i).cardsInHand.get(j));
                }
            }
        }
    }

    public void playCard(int playerTurn){
        System.out.println();
        if (this.cardStack.size() == 0){
            this.cardStack.addAll(this.usedCards);
            Collections.shuffle(this.cardStack);
            this.usedCards.clear();
        }
        if (!isPlayable(playerTurn)){
            this.cardStack.add(this.players.get(playerTurn).cardsInHand.get(0));
            this.players.get(playerTurn).cardsInHand.remove(0);
            this.players.get(playerTurn).addCardToHand(this.cardStack.get(0));
            this.cardStack.remove(0);
            System.out.println("No logical option available, a card has been replaced.");
            return;
        }
        int cardPlayed = ZKlavesnice.readInt("Choose which card to play: ")-1;
        while(cardPlayed<0 || cardPlayed>2){
            cardPlayed = ZKlavesnice.readInt("Card index out of range: ")-1;
        }
        while(!isCardPlayable(this.players.get(playerTurn).cardsInHand.get(cardPlayed))){
            cardPlayed = ZKlavesnice.readInt("Unable to play this card, please choose another: ")-1;
        }
        this.players.get(playerTurn).cardsInHand.get(cardPlayed).activate(this);
        this.usedCards.add(this.players.get(playerTurn).cardsInHand.get(cardPlayed));
        this.players.get(playerTurn).removeCard(cardPlayed);
        this.players.get(playerTurn).addCardToHand(this.cardStack.get(0));
        this.cardStack.remove(0);
    }

    public boolean isPlayable(int playerTurn){
        int allTrue = 0;
        int allFalse = 0;
        for (int i=0;i<6;i++){
            if (this.crosshairArray[i]){
                allTrue++;
                continue;
            }
            allFalse++;
        }
        if((Objects.equals(this.players.get(playerTurn).cardsInHand.get(0).getName(), "Aim")) &&
                (Objects.equals(this.players.get(playerTurn).cardsInHand.get(1).getName(), "Aim")) &&
                (Objects.equals(this.players.get(playerTurn).cardsInHand.get(2).getName(), "Aim")) &&
                allTrue == 6){
            return false;
        }
        return (!Objects.equals(this.players.get(playerTurn).cardsInHand.get(0).getName(), "Shoot")) ||
                (!Objects.equals(this.players.get(playerTurn).cardsInHand.get(1).getName(), "Shoot")) ||
                (!Objects.equals(this.players.get(playerTurn).cardsInHand.get(2).getName(), "Shoot")) ||
                allFalse != 6;
    }

    public boolean getBoolValue(int index){
        return crosshairArray[index];
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
                winner = i+1;
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

    public void printPond(){
        for (int i=0;i<6;i++){
            System.out.print((i+1) + ".  ");
            if(this.crosshairArray[i]){
                System.out.print("Aimed at       ");
            }
            else{
                System.out.print("Not aimed at   ");
            }
            System.out.println(this.pond.get(i).getName());
        }
    }

    public void printLives(){
        for (int i=0;i<this.numOfPlayers;i++){
            System.out.println("Player nr. " + this.players.get(i).getPlayerID() + "    lives: " +
                    this.players.get(i).getLives());
        }
    }

    public boolean isCardPlayable(Card card){
        if (Objects.equals(card.getName(), "Aim")){
            if (this.crosshairArray[0] && this.crosshairArray[1] && this.crosshairArray[2] &&
                    this.crosshairArray[3] && this.crosshairArray[4] && this.crosshairArray[5]) {
                return false;
            }
        }
        if (Objects.equals(card.getName(), "Shoot")){
            return this.crosshairArray[0] || this.crosshairArray[1] || this.crosshairArray[2] ||
                    this.crosshairArray[3] || this.crosshairArray[4] || this.crosshairArray[5];
        }
        return true;
    }
}
