package sk.stuba.fei.uim.oop.tiles;

public class Duck extends Tile {
    public int owner;
    public String name = "Kacka hraca ";
    public Duck(int playerNum){
        this.owner = playerNum;
        this.name += playerNum;
    }
}
