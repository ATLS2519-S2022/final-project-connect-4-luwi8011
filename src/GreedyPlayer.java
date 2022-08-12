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

public class GreedyPlayer implements Player
{
    private static java.util.Random rand = new java.util.Random();
    int id;
    int cols;
    

    @Override
    public String name() {
        return "Greedy";
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
       
        
        	//For each move:
        	//Temporarily make the move using board.move()
        	//Calculate a score based on how the board is for you now that you've made the move
        	//Undo the move using board.unmove 
        	//Return the move that had the highest calculated score
        	//To calculate the score regarding how good a certain move would be, you will write a simple heuristic evaluation function that returns the difference between how many connect-4's you have and how many connect-4's your opponent has.
        int[] scores = new int[cols];
        
        for(int i =0; i < cols; i ++) {
			if(board.isValidMove(i)) {
				board.move(i, id);
				scores[i] = calcScore(board, id);
				board.unmove(i, id);
			}
			else {
				scores[i] = -100;
			}
		}
        
        
		        
        
        
//        for (int element: scores) {
//            System.out.println(element);
//        }
        arb.setMove(largest(scores, board));
    }
    
    static int largest(int arr[], Connect4Board board)
    {
        int i;
          
        // Initialize maximum element
        int max = arr[0];
       
        // Traverse array elements from second and
        // compare every element with current max  
        for(int z = 0; z < arr.length; z++) {
    		if(!board.isValidMove(z)) {
    			arr[z] = -100;
    		}
        }
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = i;
            }
        }
        
        // if the highest score possible is zero, then try to place token in a random column.
        // I could have made this code a lot better and pick a random column from a list of legal colums but whatever, 
        //itll try random column a handful of times and if none of them work itll just play the first legal column
        if(arr[max] == 0) {
        	int randomNumber = (int) (Math.random()*(6-0)) + 0;
        	if (board.isValidMove(randomNumber) ) {
        		System.out.println(randomNumber);
        		return randomNumber;
        	}
        	else if(board.isValidMove(randomNumber) ) {
        		 randomNumber = (int) (Math.random()*(6-0)) + 0;
            	if (board.isValidMove(randomNumber) ) {
            		System.out.println(randomNumber);
            		return randomNumber;
            	}
        	}
        	else if(board.isValidMove(randomNumber) ) {
       		 randomNumber = (int) (Math.random()*(6-0)) + 0;
           	if (board.isValidMove(randomNumber) ) {
           		System.out.println(randomNumber);
           		return randomNumber;
           	}
       	}
        	else if(board.isValidMove(randomNumber) ) {
       		 randomNumber = (int) (Math.random()*(6-0)) + 0;
           	if (board.isValidMove(randomNumber) ) {
           		System.out.println(randomNumber);
           		return randomNumber;
           	}
       	}
        	else if(board.isValidMove(randomNumber) ) {
       		 randomNumber = (int) (Math.random()*(6-0)) + 0;
           	if (board.isValidMove(randomNumber) ) {
           		System.out.println(randomNumber);
           		return randomNumber;
           	}
       	}
        	else if(board.isValidMove(randomNumber) ) {
       		 randomNumber = (int) (Math.random()*(6-0)) + 0;
           	if (board.isValidMove(randomNumber) ) {
           		System.out.println(randomNumber);
           		return randomNumber;
           	}
       	}
        	else if(board.isValidMove(randomNumber) ) {
       		 randomNumber = (int) (Math.random()*(6-0)) + 0;
           	if (board.isValidMove(randomNumber) ) {
           		System.out.println(randomNumber);
           		return randomNumber;
           	}
       	}
        	else if(board.isValidMove(randomNumber) ) {
       		 randomNumber = (int) (Math.random()*(6-0)) + 0;
           	if (board.isValidMove(randomNumber) ) {
           		System.out.println(randomNumber);
           		return randomNumber;
           	}
       	}
        	
        	else {
        		for(int z = 0; z < arr.length; z++) {
            		if(!board.isValidMove(z)) {
            			arr[z] = -100;
            		}
                }
        		
        		
        		for(int z = 0; z < arr.length; z++) {
            		if(arr[z] >=0) {
            			return z;
            		}
                }
       		 return max;
       	}
        	
        	
        }
        

        
        
        
        if(board.isValidMove(max)) {
        	return max;
        }
        // do this if somehow max isnt valid, it just finds the next valid move
        else {
        	for(int z = 0; z < arr.length; z++) {
        		if(board.isValidMove(z)) {
        			return z;
        		}
        	}
        	
        	return max;
        }
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
