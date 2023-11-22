public class SnakeAndLadderGame {
	public static void main(String[] args) {
		int playerPos = 0;
                int dice = 0;
		System.out.println("Snake And Ladder Game");
		System.out.println("Starting Position of the Player = " + playerPos);
                dice =  (int) (Math.random() * 6 ) + 1;
                System.out.println("Roll:  " +  dice);

	}
}
