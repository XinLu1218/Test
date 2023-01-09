/**
 * @title: MediumBattleShip
 * @Author Scarlet
 * @Date: 31/10/2022 23:41
 * @Version 1.0
 */
public class MediumBattleShip extends Battleship{
    //up to 2;
    private static int numOfMediumBattleShip = 2;

    public MediumBattleShip() {
        super();
    }

    public static int getNumOfMediumBattleShip() {
        return numOfMediumBattleShip;
    }

    public static void setNumOfMediumBattleShip(int numOfMediumBattleShip) {
        MediumBattleShip.numOfMediumBattleShip = numOfMediumBattleShip;
    }
    public void add(){
        numOfMediumBattleShip--;
    }
}
