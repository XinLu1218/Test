/**
 * @title: LargebattleShip
 * @Author Scarlet
 * @Date: 31/10/2022 23:42
 * @Version 1.0
 */
public class LargeBattleShip extends Battleship{
    //uo to 1;
    private static int numOfLargeBattleShip = 1;

    public LargeBattleShip() {
        super();
        setSizeOfShip(3);
        setRemainHealth(3);
    }

    public static int getNumOfLargeBattleShip() {
        return numOfLargeBattleShip;
    }

    public static void setNumOfLargeBattleShip(int numOfBattleShip) {
        LargeBattleShip.numOfLargeBattleShip = numOfLargeBattleShip;
    }
    public void add(){
        numOfLargeBattleShip--;
    }
}
