package sk.stuba.fei.uim.oop.tiles;

public class Duck extends Tile {
    public int owner;
    public String name = "Kacka hraca ";
    public Duck(int playerNum){
        this.owner = playerNum;
        super.owner = playerNum;
        this.name += playerNum;
    }

    public int getOwner() {
        return this.owner;
    }
}
