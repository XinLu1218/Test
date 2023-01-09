import java.util.Random;
public class Board {
    private int row;
    private int column;
    private Square[][] board;
    //to save all the ships' information on the board;
    private Battleship[] ship;
    //to check the remaining ships on board;
    int numOfShip;

    @Override
    public String toString() {
        //define a string to concat images;
        String s = "";
        //use a double loop to get image of each square;
        for (Square[] b : board) {
            for (Square bb : b) {
                s += String.format("%3s", bb.toString());
            }
            //go to next line;
            s += "\r\n";
        }
        return s;
    }
    public Board(int row,int column) {
        board = new Square[row][column];
        //assume that there are 5 ships on the board;
        //build an array(length of 5) to save 5 battleships;
        ship = new Battleship[6];
        numOfShip = 0;
    }

    public Square[][] getBoard() {

        return board;
    }

    public void setBoard(Square[][] board) {

        this.board = board;
    }

    public Battleship[] getShip() {
        return ship;
    }

    public void setShip(Battleship[] ship) {
        this.ship = ship;
    }


    //To populate the board data structure with Square objects;
    public void populate(int row, int column){
        for(int i = 0; i < row; i++){
            for(int j = 0;j < column;j++){
                board[i][j] = new Square();
            }
        }
    }
    public void generate(){
        for(int i = 0;i < 5;i++){
            //build a new battleship object in each loop;
            Battleship battleship = new Battleship();
            numOfShip++;
            //put the object into array;
            ship[i] = battleship;
            Random r = new Random();
            while(true){
                //use Random.nextBoolean() to define the direction of each ship;
                //true-ships placed vertically on the board;
                //false-ships placed horizontally on the board;
                boolean direction = r.nextBoolean();
                //vertical;
                if(direction){
                    //To avoid out of bounds of the board, when direction is vertical and the length of ship is 2,
                    // the first square's coordinate will locate on row[0-8],column[0-9];
                    int row1 = r.nextInt(9);
                    int column1 = r.nextInt(10);
                    //if the first square has ship or the second square has ship,
                    //program should pass it and jump into next loop(continue);
                    if(board[row1][column1].isShip() || board[row1+1][column1].isShip()){
                        continue;
                    }else{
                        //if there is no ship on first and second square;
                        //make a reference between this battleship and the first square;
                        board[row1][column1].setBattleship(battleship);
//                        board[row1][column1].setImg("!");
                        //set isShip() = true, means there is a ship in this square;
                        board[row1][column1].setShip(true);
                        //make a reference between this battleship and the second square;
                        board[row1+1][column1].setBattleship(battleship);
//                        board[row1+1][column1].setImg("!");
                        //set isShip() = true, means there is a ship in this square;
                        board[row1+1][column1].setShip(true);
                        //jump out of the while loop;
                        break;
                    }
                }else {
                    //horizontal;
                    //To avoid out of bounds of the board, when direction is horizontal and the length of ship is 2,
                    // the first square's coordinate will locate on row[0-9],column[0-8];
                    int row2 = r.nextInt(10);
                    int column2 = r.nextInt(9);
                    if (board[row2][column2].isShip() || board[row2][column2 + 1].isShip()) {
                        continue;
                    } else {
                        board[row2][column2].setBattleship(battleship);
                        //use a symbol "!" to show there is a ship;
//                        board[row2][column2].setImg("!");
                        board[row2][column2].setShip(true);
                        board[row2][column2 + 1].setBattleship(battleship);
//                        board[row2][column2+1].setImg("!");
                        board[row2][column2 + 1].setShip(true);
                        //jump out of the while loop;
                        break;
                    }
                }
            }
        }
    }
    public void newGenerate(){
        Random r = new Random();
        SmallBattleShip.setNumOfSmallBattleShip(3);
        MediumBattleShip.setNumOfMediumBattleShip(2);
        LargeBattleShip.setNumOfLargeBattleShip(1);
        //there are 3 loops and each loop generate each ship;
        //there is 1 large ship on the board;
        for(int i = 0;i < 1;i++){
            LargeBattleShip largeBattleShip = new LargeBattleShip();
            //add a new ship,numOfLargeBattleShip--;
            largeBattleShip.add();
            ship[numOfShip++] = largeBattleShip;
            while(true){
                boolean direction = r.nextBoolean();
                //vertical;
                if(direction){
                    //To avoid out of bounds of the board, when direction is vertical and the length of ship is 3,
                    // the first square's coordinate will locate on row[0-7],column[0-9];
                    int row1 = r.nextInt(8);
                    int column1 = r.nextInt(10);
                    //if the first square has ship or the second square has ship,
                    //program should pass it and jump into next loop(continue);
                    if(board[row1][column1].isShip() || board[row1+1][column1].isShip() || board[row1+2][column1].isShip()){
                        continue;
                    }else{
                        board[row1][column1].setBattleship(largeBattleShip);
//                        board[row1][column1].setImg("!");
                        //set isShip() = true, means there is a ship in this square;
                        board[row1][column1].setShip(true);
                        //make a reference between this battleship and the second square;
                        board[row1+1][column1].setBattleship(largeBattleShip);
//                        board[row1+1][column1].setImg("!");
                        //set isShip() = true, means there is a ship in this square;
                        board[row1+1][column1].setShip(true);
                        //jump out of the while loop;
                        board[row1+2][column1].setBattleship(largeBattleShip);
//                        board[row1+2][column1].setImg("!");
                        board[row1+2][column1].setShip(true);
                        break;
                    }
                }else {
                    //horizontal;
                    //To avoid out of bounds of the board, when direction is horizontal and the length of ship is 2,
                    // the first square's coordinate will locate on row[0-9],column[0-7];
                    int row2 = r.nextInt(10);
                    int column2 = r.nextInt(8);
                    if (board[row2][column2].isShip() || board[row2][column2 + 1].isShip() || board[row2][column2 + 2].isShip()) {
                        continue;
                    } else {
                        board[row2][column2].setBattleship(largeBattleShip);
//                        board[row2][column2].setImg("!");
                        board[row2][column2].setShip(true);
                        board[row2][column2 + 1].setBattleship(largeBattleShip);
//                        board[row2][column2+1].setImg("!");
                        board[row2][column2 + 1].setShip(true);
                        board[row2][column2 + 2].setBattleship(largeBattleShip);
//                        board[row2][column2+2].setImg("!");
                        board[row2][column2 + 2].setShip(true);
                        break;
                    }
                }
            }
            while(MediumBattleShip.getNumOfMediumBattleShip() > 0){
                MediumBattleShip mediumBattleShip = new MediumBattleShip();
                mediumBattleShip.add();
                ship[numOfShip++] = mediumBattleShip;
                while(true) {
                    boolean direction = r.nextBoolean();
                    //vertical;
                    if (direction) {
                        //To avoid out of bounds of the board, when direction is vertical and the length of ship is 2,
                        // the first square's coordinate will locate on row[0-8],column[0-9];
                        int row1 = r.nextInt(9);
                        int column1 = r.nextInt(10);
                        //if the first square has ship or the second square has ship,
                        //program should pass it and jump into next loop(continue);
                        if (board[row1][column1].isShip() || board[row1 + 1][column1].isShip()) {
                            continue;
                        } else {
                            //if there is no ship on first and second square;
                            //make a reference between this battleship and the first square;
                            board[row1][column1].setBattleship(mediumBattleShip);
//                            board[row1][column1].setImg("!");
                            //set isShip() = true, means there is a ship in this square;
                            board[row1][column1].setShip(true);
                            //make a reference between this battleship and the second square;
                            board[row1 + 1][column1].setBattleship(mediumBattleShip);
//                            board[row1+1][column1].setImg("!");
                            //set isShip() = true, means there is a ship in this square;
                            board[row1 + 1][column1].setShip(true);
                            //jump out of the while loop;
                            break;
                        }
                    } else {
                        //horizontal;
                        //To avoid out of bounds of the board, when direction is horizontal and the length of ship is 2,
                        // the first square's coordinate will locate on row[0-9],column[0-8];
                        int row2 = r.nextInt(10);
                        int column2 = r.nextInt(9);
                        if (board[row2][column2].isShip() || board[row2][column2 + 1].isShip()) {
                            continue;
                        } else {
                            board[row2][column2].setBattleship(mediumBattleShip);
//                            board[row2][column2].setImg("!");
//                            board[row2][column2].setShip(true);
                            board[row2][column2 + 1].setBattleship(mediumBattleShip);
//                            board[row2][column2+1].setImg("!");
                            board[row2][column2 + 1].setShip(true);
                            //jump out of the while loop;
                            break;
                        }
                    }
                }
                while(SmallBattleShip.getNumOfSmallBattleShip() > 0){
                    SmallBattleShip smallBattleShip = new SmallBattleShip();
                    smallBattleShip.add();
                    ship[numOfShip++] = smallBattleShip;
                    while(true) {
                        boolean direction = r.nextBoolean();
                        //vertical;
                        if (direction) {
                            int row1 = r.nextInt(10);
                            int column1 = r.nextInt(10);
                            //program should pass it and jump into next loop(continue);
                            if (board[row1][column1].isShip()) {
                                continue;
                            } else {
                                board[row1][column1].setBattleship(smallBattleShip);
//                                board[row1][column1].setImg("!");
                                //set isShip() = true, means there is a ship in this square;
                                board[row1][column1].setShip(true);
                                break;
                            }
                        } else {
                            //horizontal;
                            int row2 = r.nextInt(10);
                            int column2 = r.nextInt(10);
                            if (board[row2][column2].isShip()) {
                                continue;
                            } else {
                                board[row2][column2].setBattleship(smallBattleShip);
//                                board[row2][column2].setImg("!");
                                board[row2][column2].setShip(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}


