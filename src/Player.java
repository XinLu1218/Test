import java.util.Scanner;
public class Player {
    private Board boardOfPlayer;
    private String name;
    private int score;

    //The constructor to the Player class take in the name of the player, along with a reference to the board;
    public Player(Board boardOfPlayer, String name) {
        this.boardOfPlayer = boardOfPlayer;
        this.name = name;
        score = 0;
    }

    public Board getBoardOfPlayer() {
        return boardOfPlayer;
    }

    public void setBoardOfPlayer(Board boardOfPlayer) {
        this.boardOfPlayer = boardOfPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



    public boolean takeTurns(){
        Scanner s = new Scanner(System.in);
        System.out.println(getName()+": Please enter the row and column of the square you want to hit(1-10):");
        //assume that users will enter correct information that is within bounds;
        //get the location that the player wanted to fire;
        int row = s.nextInt()-1;
        int column = s.nextInt()-1;
        //to find whether this square has been fired or not;
        if (boardOfPlayer.getBoard()[row][column].isFired()) {
            //if the square has been fired, player will lose their turn;
            System.out.println("The hit is invalid and now you lose this turn.");
            System.out.println("Your score is: "+getScore());
            return false;
        } else {
            System.out.println("You successfully hit this square!");
            //set isFire() = true;
            getBoardOfPlayer().getBoard()[row][column].setFired(true);
            //when remainHealth == 1, the ship would sunk after the hit;
            //if there is a ship;
            if(getBoardOfPlayer().getBoard()[row][column].getBattleship() != null){
                //if there is a ship and the remainingHealth of this ship == 1, which means after the attack, the ship will be sunk;
                if(getBoardOfPlayer().getBoard()[row][column].isShip() && getBoardOfPlayer().getBoard()[row][column].getBattleship().getRemainHealth() == 1) {
                    System.out.println("You hit the ship and the ship was sunked! ");
                    //when the ship has been hit, set the imag as "x";
                    getBoardOfPlayer().getBoard()[row][column].setImg("x");
                    //when a ship was sunk, the player would gain one more score;
                    score++;
                    System.out.println("Your score is "+getScore());
                    //when the ship was sunk, set battleship.isSunk() = true;
                    getBoardOfPlayer().getBoard()[row][column].getBattleship().setSunk(true);
                    //when the ship was sunk, numOfShip subtract 1;
                    getBoardOfPlayer().numOfShip--;
                    //when the ship was sunk, remainingHealth should be 0;
                    getBoardOfPlayer().getBoard()[row][column].getBattleship().hit();
                    //after a ship was sunk, if there is no ship on the board,which means the player hit all the ship and game is over;
                    if(getBoardOfPlayer().numOfShip == 0) {
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    //the player hit the first square of a ship, and the remaingHealth of this ship is 1 after this attack;
                    System.out.println("You hit the ship but the ship was not sunked! ");
                    System.out.println("Your score is "+getScore());
                    getBoardOfPlayer().getBoard()[row][column].setImg("x");
                    getBoardOfPlayer().getBoard()[row][column].getBattleship().hit();
                    return false;
                }
            }else{
                //there is no ship in this square, the player missed the ship;
                System.out.println("You missed the ship!");
                System.out.println("Your score is "+getScore());
                //set the imag of this square as "o", which means this square was fired;
                getBoardOfPlayer().getBoard()[row][column].setImg("o");
                return false;
            }
        }
    }
}
