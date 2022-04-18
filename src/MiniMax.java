/**
 * A Connect-4 player that makes random valid moves.
 * 
 * @author Daniel Szafir
 *
 */

//
//
//
//Once you have a sense for how the game works, create a new class called GreedyPlayer.java that implements the Player interface. You will go over how to code this player in recitation, but as an overview, the major logic of your calcMove() method is:
//
//Consider all possible moves the AI could make
//For each move:
//Temporarily make the move using board.move()
//Calculate a score based on how the board is for you now that you've made the move
//Undo the move using board.unmove 
//Return the move that had the highest calculated score
//To calculate the score regarding how good a certain move would be, you will write a simple heuristic evaluation function that returns the difference between how many connect-4's you have and how many connect-4's your opponent has.
//
//Once you have written this player, try playing against it. Try pitting it against the RandomPlayer. How does it fare? Why do you think that is? 

public class MiniMax implements Player
{
    private static java.util.Random rand = new java.util.Random();
    int id;
    int cols;
    

    @Override
    public String name() {
        return "mini max";
    }

    @Override
    public void init(int id, int msecPerMove, int rows, int cols) {
    	this.id = id; //id is your players id
    	this.cols = cols;
    	
    }

    @Override
    public void calcMove(
        Connect4Board board, int oppMoveCol, Arbitrator arb) 
        throws TimeUpException {
        // Make sure there is room to make a move.
        if (board.isFull()) {
            throw new Error ("Complaint: The board is full!");
        }
        
        int col = 0;
        // find maximum score from all possible moves
                
     //connect4board.java
        //move( int col, int id)
        // unmove(int col, int id)
        //isvalidmove(int col)
        
     //arbitrator.java
        //setmove(int col)
        //isTimeup();
       

//        Your next step is to implement a player that uses the minimax strategy to look several steps into the future. 
//        It will generally not be possible to calculate all possible steps from a given board position till the end of the game, 
//        so you will use a process called iterative deepening search. This iterative deepening process works as follows:
//
//        	Initialize a maximum search depth to be 1
//        	While there is time remaining to calculate your move (you can check this with the arb.isTimeUp() method) and your current 
//        	search depth is <= the number of moves remaining (you can check this with the board.numEmptyCells() method):
//        	Do a minimax search to the depth of your maximum search variable
//        	Set your move as the best move found so far
//        	Increment your maximum search depth
//        	In other words, your AI will determine what move to make by first doing a 1-depth search (equivalent to the GreedyPlayer),
//          then looking two moves in the future, then looking 3 moves in the future, etc. while there is still time to calculate a move.
//        	
        arb.setMove(largest(scores));
    }
    
    static int largest(int arr[])
    {
        int i;
          
        // Initialize maximum element
        int max = arr[0];
       
        // Traverse array elements from second and
        // compare every element with current max  
        for (i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = i;
       
        return max;
    }
    
    
    
 // Return the number of connect-4s that player #id has.
 	public int calcScore(Connect4Board board, int id)
 	{
 		final int rows = board.numRows();
 		final int cols = board.numCols();
 		int score = 0;
 		// Look for horizontal connect-4s.
 		for (int r = 0; r < rows; r++) {
 			for (int c = 0; c <= cols - 4; c++) {
 				if (board.get(r, c + 0) != id) continue;
 				if (board.get(r, c + 1) != id) continue;
 				if (board.get(r, c + 2) != id) continue;
 				if (board.get(r, c + 3) != id) continue;
 				score++;
 			}
 		}
 		// Look for vertical connect-4s.
 		for (int c = 0; c < cols; c++) {
 			for (int r = 0; r <= rows - 4; r++) {
 				if (board.get(r + 0, c) != id) continue;
 				if (board.get(r + 1, c) != id) continue;
 				if (board.get(r + 2, c) != id) continue;
 				if (board.get(r + 3, c) != id) continue;
 				score++;
 			}
 		}
 		// Look for diagonal connect-4s.
 		for (int c = 0; c <= cols - 4; c++) {
 			for (int r = 0; r <= rows - 4; r++) {
 				if (board.get(r + 0, c + 0) != id) continue;
 				if (board.get(r + 1, c + 1) != id) continue;
 				if (board.get(r + 2, c + 2) != id) continue;
 				if (board.get(r + 3, c + 3) != id) continue;
 				score++;
 			}
 		}
 		for (int c = 0; c <= cols - 4; c++) {
 			for (int r = rows - 1; r >= 4 - 1; r--) {
 				if (board.get(r - 0, c + 0) != id) continue;
 				if (board.get(r - 1, c + 1) != id) continue;
 				if (board.get(r - 2, c + 2) != id) continue;
 				if (board.get(r - 3, c + 3) != id) continue;
 				score++;
 			}
 		}
 		return score;
 	}
    
    
    
    
    
    
    
    
}
