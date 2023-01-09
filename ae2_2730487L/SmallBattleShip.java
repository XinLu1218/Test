/**
 * @title: SmallBattleShip
 * @Author Scarlet
 * @Date: 31/10/2022 23:41
 * @Version 1.0
 */
public class SmallBattleShip extends Battleship{
    //up to 3;
    private static int numOfSmallBattleShip = 3;

    public SmallBattleShip() {
        super();
        setSizeOfShip(1);
        setRemainHealth(1);
    }

    public static int getNumOfSmallBattleShip() {
        return numOfSmallBattleShip;
    }

    public static void setNumOfSmallBattleShip(int numOfSmallBattleShip) {
        SmallBattleShip.numOfSmallBattleShip = numOfSmallBattleShip;
    }
    public void add(){
        numOfSmallBattleShip--;
    }
}
