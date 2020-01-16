package chess;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import Pieces.*;


public class Chess extends ChessBoard{

	public static boolean check;
	private static boolean draw;
	public static boolean canPassant;
	public static boolean passant;

	
	public static void main(String[] args) throws IOException {
		
		boolean whiteTurn=true;
		boolean blackTurn=false;
		check = false;
		draw=false;
		canPassant=false;

		
		Piece[][] board = new Piece[8][8];	
		Piece[][] prevTurn = new Piece[8][8];
		int[] moves = new int[4];
		
		board=initializeBoard(board);
		printBoard(board);
		

		String input=" ";
		String arg1;
		String arg2;
		String promo="";
		Scanner scan = new Scanner(System.in);
		
		while(input.length()>0){
			//resets the attacker's board every turn
			board = setFalse(board);
			board = getAttacks(board,whiteTurn);			
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					if(board[i][j].getClass().getName().equals("Pieces.King")&&board[i][j].isAttacked()){
						if(whiteTurn&&checkMate(board,whiteTurn)){//only if checkmate
							System.out.println("Checkmate");
							System.out.println("Black wins");
							return;
						}
						if(!whiteTurn&&checkMate(board,whiteTurn)){//only if checkmate
							System.out.println("Checkmate");
							System.out.println("White wins");
							return;
						}
						else{//just a regular check
							System.out.println("Check");
						}
					}

				}
			}
			//Uncomment to see indecies being attacked
			//for(int i=0;i<8;i++){
				//for(int j=0;j<8;j++){
					//System.out.print(board[i][j].isAttacked()+"	");//+board[i][j].toString()
				//}
				//System.out.println();
			//}
			
			if(whiteTurn){
				System.out.print("White's move: ");
			}
			if(blackTurn){
				System.out.print("Black's move: ");
			}
			
			input = scan.nextLine();
			StringTokenizer st = new StringTokenizer(input);
			if(st.countTokens()==0){
				break;
			}
			if(st.countTokens()>3){
				System.out.println("Invalid Move, Try Again");
				continue;
			}
			arg1 = st.nextToken();
			if(arg1.equalsIgnoreCase("resign")){
				if(whiteTurn){
					System.out.println("Resign");
					System.out.println("Black Wins");
					return;
				}
				else{
					System.out.println("Resign");
					System.out.println("White Wins");
					return;
				}
			}
			if(arg1.equalsIgnoreCase("draw")&&draw){
				System.out.println("Draw");
				return;
			}
			else{
				draw =false;
			}
			arg2 = st.nextToken();
			if(st.hasMoreTokens()){
				promo = st.nextToken();
				if(promo.equalsIgnoreCase("draw?")){
					draw = true;
				}
				if(!promo.equals("")&&!promo.equalsIgnoreCase("Q")&&!promo.equalsIgnoreCase("N")&&!promo.equalsIgnoreCase("B")&&!promo.equalsIgnoreCase("R")&&!promo.equalsIgnoreCase("draw?")){
					System.out.println("Invalid Move, Try Again");
					continue;
				}
			}
			//moves stores the selected pieces index and the destination index
			moves[0]=getMove(arg1, 1);//row
			moves[1]=getMove(arg1, 0);//col		
			moves[2]=getMove(arg2, 1);//row
			moves[3]=getMove(arg2, 0);//col

			//Uncomment below to see the user input as indexes in the array
			//System.out.print(moves[0]+","+moves[1]+" "+moves[2]+","+moves[3]);
			System.out.println();
			//update player turn, the board, and print the board on successful move
			prevTurn = board;
			if(Move(board,moves,whiteTurn)){				
				//need to see if king is in check or check mate before board prints to either print check or checkmate
				if(whiteTurn){
					whiteTurn = false;
					blackTurn = true;
				}
				else{
					blackTurn = false;
					whiteTurn = true;
				}
								
				//System.out.println(passant+" "+canPassant);
				if(passant && canPassant){
					board = enPassant(board,moves);
					passant = false;
					canPassant = false;
				}
				
				board=promotion(board,moves,promo);//checks to see if any pawn can be promoted and promotes it
				board=updateBoard(board);//fixes missing spaces					
				printBoard(board);		
				
			}		
		}
		
	}
	
	private static Piece[][] getAttacks(Piece[][] board,boolean whiteTurn) {
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				int[] move =new int[2];
				move[0]=i;
				move[1]=j;
				board=board[i][j].attacking(board, move, whiteTurn);
			}
		}
		return board;
	}

	private static Piece[][] setFalse(Piece[][] board) {
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				board[i][j].setAttacked(false);
			}
		}
		return board;
	}

	public static boolean checkMate(Piece[][] board, boolean whiteTurn){
		//check if the king can move, then if any pieces can block for the king
		int count=0;
		int countMore=0;
		if(whiteTurn){//check whiteKing movements
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					if(board[i][j].toString().contains("wK")){
						int[] move = new int[4];
						move[0]=i;
						move[1]=j;
						move[2]=i+1;
						move[3]=j;
						if(move[2]<7){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						
						move[2]=i+1;
						move[3]=j+1;
						if(move[2]<7&&move[3]<7){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i+1;
						move[3]=j-1;
						if(move[2]<7&&move[3]>0){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i;
						move[3]=j+1;
						if(move[3]<7){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i;
						move[3]=j-1;
						if(move[3]>0){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i-1;
						move[3]=j;
						if(move[2]>0){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i-1;
						move[3]=j-1;
						if(move[2]>0&&move[3]>0){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i-1;
						move[3]=j+1;
						if(move[2]>0&&move[3]<7){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						break;
					}
				}
			}
			for(int i=0;i<8;i++){//check if any piece can move to those locations
				for(int j=0;j<8;j++){
					if(board[i][j].toString().contains("wK")){
						int[] move = new int[4];
						move[0]=i;
						move[1]=j;
						move[2]=i+1;
						move[3]=j;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]<7){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i+1;
						move[3]=j+1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]<7&&move[3]<7){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i+1;
						move[3]=j-1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]<7&&move[3]>0){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i;
						move[3]=j+1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[3]<7){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i;
						move[3]=j-1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[3]>0){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i-1;
						move[3]=j;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]>0){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i-1;
						move[3]=j-1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]>0&&move[3]>0){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i-1;
						move[3]=j+1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]>0&&move[3]<7){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						break;
					}
				}
			}
			if(count==0&&countMore!=0){
				return true;
			}
			else{
				return false;
			}
					
			
		}
		else if(!whiteTurn){//check blackKing movements
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					if(board[i][j].toString().contains("bK")){
						int[] move = new int[4];
						move[0]=i;
						move[1]=j;
						move[2]=i+1;
						move[3]=j;
						if(move[2]<7){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						
						move[2]=i+1;
						move[3]=j+1;
						if(move[2]<7&&move[3]<7){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i+1;
						move[3]=j-1;
						if(move[2]<7&&move[3]>0){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i;
						move[3]=j+1;
						if(move[3]<7){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i;
						move[3]=j-1;
						if(move[3]>0){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i-1;
						move[3]=j;
						if(move[2]>0){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i-1;
						move[3]=j-1;
						if(move[2]>0&&move[3]>0){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						move[2]=i-1;
						move[3]=j+1;
						if(move[2]>0&&move[3]<7){
							if(board[i][j].validMove(board, move, whiteTurn)){
								count++;
							}
						}
						break;
					}
				}
			}
			for(int i=0;i<8;i++){//check if any piece can move to those locations
				for(int j=0;j<8;j++){
					if(board[i][j].toString().contains("bK")){
						int[] move = new int[4];
						move[0]=i;
						move[1]=j;
						move[2]=i+1;
						move[3]=j;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]<7){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i+1;
						move[3]=j+1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]<7&&move[3]<7){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i+1;
						move[3]=j-1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]<7&&move[3]>0){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i;
						move[3]=j+1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[3]<7){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i;
						move[3]=j-1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[3]>0){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i-1;
						move[3]=j;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]>0){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i-1;
						move[3]=j-1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]>0&&move[3]>0){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						move[2]=i-1;
						move[3]=j+1;
						for(int l=0;l<8;l++){
							for(int m=0;m<8;m++){
								if(move[2]>0&&move[3]<7){
									if(board[l][m].validMove(board, move, whiteTurn)){
										countMore++;
									}
								}
							}
						}
						break;
					}
				}
			}
			if(count==0&&countMore!=0){
				return true;
			}
			else{
				return false;
			}
			
		}
		
		return false;
	}

	//returns true if the move happened false otherwise
	public static boolean Move(Piece[][] board, int[] move, boolean whiteTurn) {
		int i,j,k,l;
		Space s = new Space();
		i=move[0];
		j=move[1];
		k=move[2];
		l=move[3];	
		
		if(whiteTurn&&board[i][j].toString().contains("b")){//trying to move a piece belonging to the other color
				System.out.println("Illegal move, try again");
				return false;
		}
		else if(!whiteTurn&&board[i][j].toString().contains("w")){//trying to move a piece belonging to the other color
				System.out.println("Illegal move, try again");
				return false;
		}
		if(board[i][j].getClass().getName().equals(s.getClass().getName())){//checks if the first argument is a white or black space and prints an error
			System.out.println("Illegal move, try again");
			//Below prints the type of object
			//System.out.println("Illegal move, try again"+"  "+board[i][j].getClass().getName()+"  "+board[k][l].getClass().getName());
			return false;
		}
		else{
			if(board[i][j].validMove(board, move, whiteTurn)){//this will return a boolean, if true then execute the move false print invalid
				//System.out.println(board[i][j].isCastle());
				if(board[i][j].isCastle()){
					if(whiteTurn){
						if((i==7&& j==4) && (k==7 && l==6)){//castle right
							board[i][j]=s;
							board[7][5]=board[7][7];
							board[7][7]=s;
							board[k][l].setCastle(false);
							return true;
						}
						else if((i==7&& j==4) && (k==7 && l==2)){//castle left
							board[i][j]=s;
							board[k][l+1]=board[k][l-2];
							board[k][l-2]=s;
							board[k][l].setCastle(false);
							return true;
						}
					}
					if(!whiteTurn){
						if((i==0&& j==4) && (k==0 && l==6)){//castle right
							board[i][j]=s;
							board[k][l-1]=board[k][l+1];
							board[k][l+1]=s;
							board[k][l].setCastle(false);
							return true;
						}
						else if((i==0&& j==4) && (k==0 && l==2)){//castle left						
							board[i][j]=s;
							board[k][l+1]=board[k][l-2];
							board[k][l-2]=s;
							board[k][l].setCastle(false);
							return true;
						}
					}
				}
				else{
					Piece temp = board[i][j];
					Piece temp2 = board[k][l];
					board[k][l]=board[i][j];
					board[i][j]=s;
					board = setFalse(board);
					board = getAttacks(board,whiteTurn);
					for(int n=0;n<8;n++){
						for(int m=0;m<8;m++){
							if(board[n][m].getClass().getName().equals("Pieces.King")&&board[n][m].isAttacked()){
								System.out.println("Illegal move, try again");
								board[i][j]=temp;
								board[k][l]=temp2;
								return false;
							}
						}
					}
				}
				
				//En Passant
				if(board[k][l].getClass().getName().equals("Pieces.Pawn")&&(k==4||k==3)){
					if(whiteTurn){
						if(l-1<0){
							//System.out.println(board[k][l].getMoveCount());
							if(board[k][l].getMoveCount()==1&&(board[k][l+1].toString().contains("bp"))){
								canPassant = true;
								return canPassant;
								//System.out.println(canPassant);
							}
						}
						if(l+1>7){
							//System.out.println(board[k][l].getMoveCount());
							if(board[k][l].getMoveCount()==1&&(board[k][l-1].toString().contains("bp"))){
								canPassant = true;
								return canPassant;
								//System.out.println(canPassant);
							}
						}
						else{
							if(l-1>=0 && l+1 <=7){
							//System.out.println(board[k][l].getMoveCount());
								if(board[k][l].getMoveCount()==1&&(board[k][l-1].toString().contains("bp")||(board[k][l+1].toString().contains("bp")))){
									canPassant = true;
									return canPassant;
									//System.out.println(canPassant);
								}
							}
						}
					}
					if(!whiteTurn){
						if(l-1<0){
							//System.out.println(board[k][l].getMoveCount());
							if(board[k][l].getMoveCount()==1&&(board[k][l+1].toString().contains("wp"))){
								canPassant = true;
								return canPassant;
								//System.out.println(canPassant);
							}
						}
						if(l+1>7){
							//System.out.println(board[k][l].getMoveCount());
							if(board[k][l].getMoveCount()==1&&(board[k][l-1].toString().contains("wp"))){
								canPassant = true;
								return canPassant;
								//System.out.println(canPassant);
							}
						}
						else if(l-1>=0 && l+1 <=7){
							//System.out.println(board[k][l].getMoveCount());
							//System.out.print(board[k][l-1].toString());
							if(board[k][l].getMoveCount()==1&&(board[k][l-1].toString().contains("wp")||(board[k][l+1].toString().contains("wp")))){
								canPassant = true;
								return canPassant;
								//System.out.println(canPassant);
							}
						}
					}
				}
				if(canPassant){
					if(whiteTurn){
						if(board[k][l].toString().contains("wp")&&board[k+1][l].toString().contains("bp")){//passant happened
							passant = true;
							return passant;
						}
						else{//no passant happened
							canPassant = false;
						}
					}
					if(!whiteTurn){
						if(board[k][l].toString().contains("bp")&&board[k-1][l].toString().contains("wp")){//passant happened
							passant = true;
							return passant;
						}
						else{//no passant happened
							canPassant = false;
						}
					}
				}
				return true;
			}
			else{
				System.out.println("Illegal move, try again");
				return false;
			}
			
		}
	}
	
}
