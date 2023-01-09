
public class Battleship {
    private boolean isSunk;
    private int sizeOfShip;
    //how many more hits it can take before sinking;
    private int remainHealth;

    public Battleship() {
        isSunk = false;
        sizeOfShip = 2;
        remainHealth =2;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }

    public int getSizeOfShip() {
        return sizeOfShip;
    }

    public void setSizeOfShip(int sizeOfShip) {

        this.sizeOfShip = sizeOfShip;
    }

    public int getRemainHealth() {
        return remainHealth;
    }

    public void setRemainHealth(int remainHealth) {

        this.remainHealth = remainHealth;
    }
    public void hit(){
        remainHealth--;
    }
}
