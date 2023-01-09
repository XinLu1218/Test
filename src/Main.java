import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean result1;
        boolean result2;

        //build a board, make a reference to player1;
        Board board1 = new Board(10,10);
        //build a board, make a reference to player2;
        Board board2 = new Board(10,10);
        //initialise all the square;
        board1.populate(10,10);
        board2.populate(10,10);
        //assume that player will enter valid number;
        System.out.println("Please choose the version you want to play: 1-basic version(5 ships) 2-extended version(6 ships). Please enter 1 or 2:");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        if(choice == 1){
            //generate 5 ships on the board;
            board1.generate();
            board2.generate();
        }else{
            //generate 6 ships on the board;
            board1.newGenerate();
            board2.newGenerate();
        }
        //build a new object,make a reference to board;
        Player player1 = new Player(board1,"Player1");
        Player player2 = new Player(board2,"player2");
        while(true){
            System.out.println("------------------------------------------------------------");
            System.out.println(board1.toString());
            //if the return = true ,which means there is no ship on board;
            result1 = player1.takeTurns();
            if(result1 == true){
                break;
            }
            System.out.println(board1.toString());
            System.out.println("------------------------------------------------------------");
            System.out.println(board2.toString());
            result2 = player2.takeTurns();
            if(result2==true){
                break;
            }
            System.out.println(board2.toString());
        }
        if(player1.getScore() > player2.getScore()){
            System.out.println("Game Over! The winner is "+player1.getName()+" and the final score is "+player1.getScore());
        }else if(player1.getScore() < player2.getScore()){
            System.out.println("Game Over! The winner is "+player2.getName()+" and the final score is "+player2.getScore());
        }else {
            System.out.println("Game Over! It is a draw!");
        }
    }
}