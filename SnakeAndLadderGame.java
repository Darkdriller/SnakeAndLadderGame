public class SnakeAndLadderGame {
        public static final int LADDER = 1;
        public static final int SNAKE = 2;
	public static void main(String[] args) {
		int playerPos = 0;
                int dice = 0;
		System.out.println("Snake And Ladder Game");
		System.out.println("Starting Position of the Player = " + playerPos);
                dice =  (int) (Math.random() * 6 ) + 1;
                System.out.println("Roll:  " +  dice);
                
                //get Option

                int op = (int) Math.floor(Math.random() * 10) % 3;

                switch(op){
                      case LADDER:
                           playerPos += dice;
                           System.out.println("Encountered Ladder");
                           System.out.println("New Position: " + playerPos);
                           break;
                      
                      case SNAKE:
                           playerPos -= dice;
                           System.out.println("Encountered Snake!");
                           System.out.println("New Position: " + playerPos);
                           break;
                      
                      default:
                           System.out.println("No Play!");
                           System.out.println("New Position: " + playerPos);
                }
                

	}
}
