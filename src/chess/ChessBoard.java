package chess;

import java.io.IOException;
import Pieces.*;

class ChessBoard {
	
	public static Piece[][] enPassant(Piece[][] board, int[] move){
		Space s = new Space();
		int i,j,k,l;
		i=move[0];
		j=move[1];
		k=move[2];
		l=move[3];
		
		if(board[k+1][l].toString().contains("bp")){//white did the en passant
			board[k+1][l]=s;
		}
		else if(board[k-1][l].toString().contains("wp")){//black did the en passant
			board[k-1][l]=s;
		}
		
		return board;
	}	
	//promotes a pawn if it reached the end of the board
	public static Piece[][] promotion(Piece[][] board, int[] move, String promo){
		int i,j,k,l;
		i=move[0];
		j=move[1];
		k=move[2];
		l=move[3];
		for(int a=0;a<8;a++){
			if(board[0][a].getClass().getName().equals("Pieces.Pawn")&&promo.equals("")||promo.equalsIgnoreCase("Q")){
				Queen q = new Queen("w");
				board[0][a]=q;
				return board;	
			}
			if(board[0][a].getClass().getName().equals("Pieces.Pawn")&&promo.equalsIgnoreCase("N")){
				Knight n = new Knight("w");
				board[0][a]=n;
				return board;	
			}
			if(board[0][a].getClass().getName().equals("Pieces.Pawn")&&promo.equalsIgnoreCase("B")){
				Bishop b = new Bishop("w");
				board[0][a]=b;
				return board;	
			}
			if(board[0][a].getClass().getName().equals("Pieces.Pawn")&&promo.equalsIgnoreCase("R")){
				Rook r = new Rook("w");
				board[0][a]=r;
				return board;	
			}
			if(board[7][a].getClass().getName().equals("Pieces.Pawn")&&promo.equals("")||promo.equalsIgnoreCase("Q")){
				Queen q = new Queen("b");
				board[7][a]=q;
			}
			if(board[7][a].getClass().getName().equals("Pieces.Pawn")&&promo.equalsIgnoreCase("N")){
				Knight n = new Knight("b");
				board[7][a]=n;
				return board;	
			}
			if(board[7][a].getClass().getName().equals("Pieces.Pawn")&&promo.equalsIgnoreCase("B")){
				Bishop b = new Bishop("b");
				board[7][a]=b;
				return board;	
			}
			if(board[7][a].getClass().getName().equals("Pieces.Pawn")&&promo.equalsIgnoreCase("R")){
				Rook r = new Rook("b");
				board[7][a]=r;
				return board;	
			}
			
		}
		return board;			
	}
	//after pieces are moved this method is called and updates white and black spaces that may be missing
	public static Piece[][] updateBoard(Piece[][] board){
		Space white = new Space();
		Space black = new Space("##");
		for(int i=0;i<8;i++){
			if(i%2!=0){//row starts with black space
				if(board[i][0].toString().equals(white.toString())){
					board[i][0]=black;
				}
				if(board[i][2].toString().equals(white.toString())){
					board[i][2]=black;
				}
				if(board[i][4].toString().equals(white.toString())){
					board[i][4]=black;
				}
				if(board[i][6].toString().equals(white.toString())){
					board[i][6]=black;
				}
			}
			else{//row starts with whitespace
				if(board[i][1].toString().equals(white.toString())){
					board[i][1]=black;
				}
				if(board[i][3].toString().equals(white.toString())){
					board[i][3]=black;
				}
				if(board[i][5].toString().equals(white.toString())){
					board[i][5]=black;
				}
				if(board[i][7].toString().equals(white.toString())){
					board[i][7]=black;
				}	
			}
			
		}
		return board;
	}
	//returns the index selected by the user 1 value at a time
	static int getMove(String input, int i) throws IOException {
			if(Character.isDigit(input.charAt(i))){
				int num=Character.getNumericValue(input.charAt(i));
				if(num==6){
					num=num-4;
					return num;
				}
				if(num==5){
					num=num-2;
					return num;
				}
				if(num==7){
					num=num-6;
					return num;
				}
				if(num==8){
					num=num-8;
					return num;
				}
				if(num==4){
					return num;
				}
				if(num==3){
					num=num+2;
					return num;
				}
				if(num==2){
					num=num+4;
					return num;
				}
				if(num==1){
					num=num+6;
					return num;
				}
			}
			if(input.charAt(i)=='a'||input.charAt(i)=='A'){
				return 0;
			}
			if(input.charAt(i)=='b'||input.charAt(i)=='B'){
				return 1;
			}
			if(input.charAt(i)=='c'||input.charAt(i)=='C'){
				return 2;
			}
			if(input.charAt(i)=='d'||input.charAt(i)=='D'){
				return 3;
			}
			if(input.charAt(i)=='e'||input.charAt(i)=='E'){
				return 4;
			}
			if(input.charAt(i)=='f'||input.charAt(i)=='F'){
				return 5;
			}
			if(input.charAt(i)=='g'||input.charAt(i)=='G'){
				return 6;
			}
			if(input.charAt(i)=='h'||input.charAt(i)=='H'){
				return 7;
			}

			else{
				return -1;	
			}
	}
	//prints the board
	public static void printBoard(Piece[][] board){
		//Uncomment below to see the indexes as they appear in the array
		//System.out.println("   0   1   2   3   4   5   6   7");
		//System.out.println("    a   b   c   d   e   f   g   h ");
		for(int i=0, k=8;i<8;i++,k--){
			//Uncomment below to see the indexes as they appear in the array
			//System.out.print(i);
			//System.out.print(k+" ");
			for(int j =0;j<8;j++){
				System.out.print(board[i][j].toString());
			}
			//Uncomment below to see the indexes as they appear in the array
			//System.out.print(i);
			System.out.print(" " +k);
			System.out.println();
		}
		//Uncomment below to see the indexes as they appear in the array
		//System.out.println("   0   1   2   3   4   5   6   7");
		System.out.println("  a   b   c   d   e   f   g   h ");
	}
	//puts the pieces on the board
	private static Piece[][] initializePieces(Piece[][] board){
		Pawn pW = new Pawn("w");
		Pawn pW2 = new Pawn("w");
		Pawn pW3 = new Pawn("w");
		Pawn pW4 = new Pawn("w");
		Pawn pW5 = new Pawn("w");
		Pawn pW6 = new Pawn("w");
		Pawn pW7 = new Pawn("w");
		Pawn pW8 = new Pawn("w");
		Pawn pB = new Pawn("b");
		Pawn pB2 = new Pawn("b");
		Pawn pB3 = new Pawn("b");
		Pawn pB4 = new Pawn("b");
		Pawn pB5 = new Pawn("b");
		Pawn pB6 = new Pawn("b");
		Pawn pB7 = new Pawn("b");
		Pawn pB8 = new Pawn("b");
		Rook rW = new Rook("w");
		Rook rW2 = new Rook("w");
		Rook rB = new Rook("b");
		Rook rB2 = new Rook("b");
		Bishop bW = new Bishop("w");
		Bishop bW2 = new Bishop("w");
		Bishop bB = new Bishop("b");
		Bishop bB2 = new Bishop("b");
		Knight nW = new Knight("w");
		Knight nW2 = new Knight("w");
		Knight nB = new Knight("b");
		Knight nB2 = new Knight("b");
		Queen qW = new Queen("w");
		Queen qB = new Queen("b");
		King kW = new King("w");
		King kB = new King("b");
		//loads pawns into table
		board[1][0]=pB;
		board[1][1]=pB2;
		board[1][2]=pB3;
		board[1][3]=pB4;
		board[1][4]=pB5;
		board[1][5]=pB6;
		board[1][6]=pB7;
		board[1][7]=pB8;
		board[6][0]=pW;
		board[6][1]=pW2;
		board[6][2]=pW3;
		board[6][3]=pW4;
		board[6][4]=pW5;
		board[6][5]=pW6;
		board[6][6]=pW7;
		board[6][7]=pW8;
		//loads Rooks
		board[0][0]=rB;
		board[0][7]=rB2;
		board[7][0]=rW;
		board[7][7]=rW2;
		//loads Knights
		board[0][1]=nB;
		board[0][6]=nB2;
		board[7][1]=nW;
		board[7][6]=nW2;
		//loads Bishops
		board[0][2]=bB;
		board[0][5]=bB2;
		board[7][2]=bW;
		board[7][5]=bW2;
		//loads Kings and Queens
		board[0][3]=qB;
		board[0][4]=kB;
		board[7][3]=qW;
		board[7][4]=kW;
		
		return board;
	}
	//places the black and white spaces on the board
	public static Piece[][] initializeBoard(Piece[][] board){
		for(int i=0;i<8;i++){
			if(i%2!=0){//row starts with black space
				Space white = new Space();
				Space black = new Space("##");
				Space white1 = new Space();
				Space black1 = new Space("##");
				Space white2 = new Space();
				Space black2 = new Space("##");
				Space white3 = new Space();
				Space black3 = new Space("##");
				board[i][0]=black;
				board[i][1]=white;
				board[i][2]=black1;
				board[i][3]=white1;
				board[i][4]=black2;
				board[i][5]=white2;
				board[i][6]=black3;
				board[i][7]=white3;
			}
			else{//row starts with whitespace
				Space white = new Space();
				Space black = new Space("##");
				Space white1 = new Space();
				Space black1 = new Space("##");
				Space white2 = new Space();
				Space black2 = new Space("##");
				Space white3 = new Space();
				Space black3 = new Space("##");
				board[i][0]=white;
				board[i][1]=black;
				board[i][2]=white1;
				board[i][3]=black1;
				board[i][4]=white2;
				board[i][5]=black2;
				board[i][6]=white3;
				board[i][7]=black3;	
			}		
		}
		board =initializePieces(board);
		return board;	
	}
}