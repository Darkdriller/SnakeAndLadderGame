import java.util.*;
public class SnakeAndLadderGame {
         // Player Class
         static class Player {
             private int currentPosition;
             public Dice dice;

             public Player() {
                 this.currentPosition = 0;
                 this.dice = new Dice();
             }

             public int getCurrentPosition() {
                 return currentPosition;
             }

             public void setCurrentPosition(int currentPosition) {
                 this.currentPosition = currentPosition;
             }
         }

         //Dice Class

         static class Dice {

             Random random = new Random();
             public int diceCount = 0;

             public int rollDice() {
                 diceCount++;
                 return random.nextInt(6) + 1;

             }

             public int getCount(){

                   return diceCount;
                }

             public int rollOption() {
                 return random.nextInt(2);
             }
         }


         // Game Board

         static class GameBoard {

                private final Map<Integer, Integer> board; 

                public GameBoard() {
                    this.board = new HashMap<>();
                    boardCreation();
                }

                private void boardCreation(){
                    board.put(14, 8);
                    board.put(27, 19);
                    board.put(35, 22);
                    board.put(49, 11);
                    board.put(72, 92);
                    board.put(85, 98);
                    board.put(99, 63);
                }

                public int movePlayerOnBoard(int currentPosition){
                    if (board.containsKey(currentPosition)){
                        int nextPosition = board.get(currentPosition);
                        if (nextPosition < currentPosition){
                            System.out.println("Oops! You landed on a snake. Going back to position " + nextPosition + ".");
                        }else {
                            System.out.println("Congratulations! You found a ladder. Climbing to position " + nextPosition + ".");
                        }
                        return nextPosition;
                    }
                    return currentPosition;
                }

            }



        public static final int PLAY = 1;
	public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Dice dice = new Dice();
        GameBoard board = new GameBoard();
        int currentPlayer = 1;
        System.out.println("Snake And Ladder Game Initiated");
        while (player1.getCurrentPosition() < 100 && player2.getCurrentPosition() < 100){
            Player currentPlayerObj = (currentPlayer == 1) ? player1 : player2;

            int diceValue = currentPlayerObj.dice.rollDice();
            int option = currentPlayerObj.dice.rollOption();

            switch (option){

                case PLAY:
                    int newPosition = currentPlayerObj.getCurrentPosition() + diceValue;
                    newPosition = board.movePlayerOnBoard(newPosition);
                    if (newPosition <= 100) {
                        currentPlayerObj.setCurrentPosition(newPosition);
                    }
                    System.out.println("Player " + currentPlayer + " rolled a " + diceValue + ". Current position is "
                            + currentPlayerObj.getCurrentPosition());
                    break;
                default:
                    System.out.println("No Play. Player " + currentPlayer + "'s current position is "
                            + currentPlayerObj.getCurrentPosition());
                    break;
            }

                currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }
        if (player1.getCurrentPosition() == 100) {
            System.out.println("Player 1 won the game!");
            System.out.println("Player 1 Dice Rolls: " + player1.dice.diceCount);
            System.out.println("Player 2 Dice Rolls: " + player2.dice.diceCount);


        } else {
            System.out.println("Player 2 won the game!");
            System.out.println("Player 1 Dice Rolls: " + player1.dice.diceCount);
            System.out.println("Player 2 Dice Rolls: " + player2.dice.diceCount);
        }
	}
}
