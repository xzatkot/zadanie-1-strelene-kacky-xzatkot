package sk.stuba.fei.uim.oop.tiles;

public class Water extends Tile {
    public String name = "water";
    public String getName(){
        return this.name;
    }
    public Water(){
        super.owner=0;
    }
}
