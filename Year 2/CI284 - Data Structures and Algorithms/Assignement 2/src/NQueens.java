import java.util.Scanner;

public class NQueens {
	
	static int[][] board;								//a 2D array for the board.
	static String Queen;								//string comprised of the co-ordinates of the queen inputed by the user.
	
	public static void main(String args[]) {		
		board = new int[8][8];							//creates the 2D array for an 8x8 board.
		for(int row = 0; row < 8; row++) {				//loops through the rows.
			for(int col = 0; col < 8; col++) {			//loops through the columns.
				board[row][col] = 0;
			}
		}
	
	outputSolution(board);								//prints the board at the beginning to prompt the user for input.
	
	Scanner scan = new Scanner(System.in);													//prompts scanner.
	System.out.println("input desired queen position");										//initiates input from user.
	Queen = scan.next();																	//takes input from scanner as a string and puts into Queen variable.
	Queen = Queen.toUpperCase();															//certifies user input is in upper-case to circumvent upper & lower case sensitivity.
	while(Queen.charAt(0) > 'H' || Queen.charAt(1) > '8' || Queen.length() > 2){			//validates that the co-ordinate inputed is a valid position on the board.
		System.out.println("co-ordinate not valid on board, please input another");			//print statement to inform user that the inputed position is not valid.
		Queen = scan.next();																//takes new input and allocates to Queen.
		Queen = Queen.toUpperCase();														//certifies input is upper-case.
	}
	
	scan.close();																			//ends the scanner.
	solveNQ();																				//runs solveNQ function.
	
	}
	
	/*a utility function to print the solution*/
	static void outputSolution(int board[][]) {								
		/*loops 9 times rather than 8 to give the boarder.*/
		for(int row = 0; row < 9; row++) {								//goes through all rows of the board.
			for(int col = 0; col < 9; col++) {							//goes through all columns of the board.
				if (row == 0 && col == 0) 								//if at the top left hand corner;
					{System.out.print("\\|");}							//print \| as the start of the chess boarder. *has 2 \ as it is an escape char*
				else if(row == 0) 										//if at the first row;
					{System.out.print("_" + (char)(col+64) + "_");}		//outputs correct letter from the alphabet depending on col numb.
				else if(col == 0) 										//if at the first col;
					{System.out.print(row + "|");}						//output row numb.
				else {													//if not first col or row;
					if(board [row-1][col-1] == 1) 						//if position at said value = 1 then its a Q.
						{System.out.print(" Q");}						//outputs Q for Queen at this position.
					else 												//if it is not a queen.
						{System.out.print(" . ");}						//print a "." to illustrate no queen at this position.
				}
			}
			System.out.println("");										//moves to next line.
		}
	}
	
	/* utility function to check if queen can be placed on position [row][col]
	 * function is called when "col" queen is placed.*/
	static boolean isSafe(int board[][], int row, int col) {
		int i, j;
		
		/*checks this row on the left side for a queen.
		 * if there is a queen at this position => checks the left only as they are being inserted in this order.*/
		for(i = 0; i < col; i++) 
			if(board[row][i] == 1)
				return false;
		
		 /* check upper diagonal on left side.
		  * if queen is found in this position;
		  * return false as it is not a safe position.*/
		for(i = row, j = col; i >= 0 && j >= 0; i--, j--) 
			if(board[i][j] == 1)
				return false;
		
		/* check lower diagonal on left side.
		 * if queen is found in this position;
		 * return false as it is not a safe position*/
		for (i = row, j = col; j >= 0 && i < 8; i++, j--) 
            if (board[i][j] == 1) 
                return false;
		
		/* if no queens have been found in the same row or diagonal;
		 *  return true as it is a safe position.*/
		return true; 		
	}
	
	/* a recursive utility function to solve N Queen problem.*/
	static boolean solveNQUtil(int board[][], int col) { 
     
	/* base case: If all queens are placed then return true */
     if (col == 8) {
    	 for(int i = 0; i < 8; i++) {
    		 for(int j = 0; j < 8; j++) {
    			 char character = (char)(i+65);
    			 if(character == Queen.charAt(0) && ((char)(j +1) == (Queen.charAt(1) - '0')) && board[j][i] == 1) {
    				 outputSolution(board);
    				 System.out.println();
    				 return true;
    			 }
    		 }
    	 }
     }
          
     boolean res = false;									//boolean variable containing if the solution was found or not.
		for(int i = 0; i < 8; i++) {						//goes through the rows on the board.
			if(isSafe(board, i, col)) {						//checks if current position is safe; if yes, run the code in the if statement, if not then move on to the next iteration of the loop
				board[i][col] = 1;							//allocates coordinate = to 1 representing queen placement.
				res = solveNQUtil(board, col+1) || res;		//short circuit used as evaluation to say if the next column has a valid position then set res to true, else keep res as false and set the coordinate back to 0.
				board[i][col] = 0;							//sets coordinate = to 0 if no valid queen position in the next column i.e. backtracking.
			}
		}
		
		return res;											//returns value of the res variable - true if a solution is found or false if a solution is not found.
	}
	
	static void solveNQ() { 
        
		System.out.println("all posibile solutions for inputed queen are as follows:");							//outputs that the program is going to display all possible solutions
		if (solveNQUtil(board,0) == false) {														//keeps running the solveNQUtil method, starting from the 0th column, and checks to see if this returns false - indicating no solution found
			System.out.print("solution does not exist");											//Lets the user know that there is no solution for this coordinate.
		}
	}
}
