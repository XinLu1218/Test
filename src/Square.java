
public class Square {
    private int row;
    private int column;
    private boolean isShip;
    private Battleship battleship;
    private boolean isFired;
    //different imgs stands for different status
    //initial-'-'; missed-'o'; was hit-'x';
    private String img;

    public Square() {
        //initialise each square has no ship and has not been fired;
        //initialise the default image is "-";
        isShip = false;
        isFired = false;
        img = "-";
        battleship = null;
    }

    public boolean isShip() {
        return isShip;
    }

    public void setShip(boolean ship) {
        isShip = ship;
    }

    public Battleship getBattleship() {
        return battleship;
    }

    public void setBattleship(Battleship battleship) {
        this.battleship = battleship;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String imag) {
        this.img = imag;
    }

    //rewrite the toString() to get image of each square;
    @Override
    public String toString() {
        return getImg();
    }
}
