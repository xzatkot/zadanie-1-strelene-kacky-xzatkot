package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.card.*;
import java.util.ArrayList;

public class Game {
    //public Duck[] pond = {null};
    public ArrayList<Card> cardStack = new ArrayList<>();
    public boolean[] crosshairArray = {false};
    public Game() {
        System.out.println("**** Strelene kacky ****");
        int numOfPlayers = ZKlavesnice.readInt("Zadaj pocet hracov: ");
    }
    public boolean getBoolValue(int index){
        return crosshairArray[index];
    }
    public void setBoolValue(int index){
        crosshairArray[index] = true;
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
    }
}
