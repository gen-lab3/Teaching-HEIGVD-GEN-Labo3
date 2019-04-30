public class Piece {
    private String name;
    private Square location;

    Piece(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square newLoc) {
        this.location = newLoc;
    }
}
