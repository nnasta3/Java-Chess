package Pieces;


public class Pawn extends Piece {
	public String color;
	
	@Override
	public boolean validMove(Piece[][] board, int[] move,boolean whiteTurn) {
		int i,j,k,l;
		i=move[0];
		j=move[1];
		k=move[2];
		l=move[3];
		
		if(whiteTurn){
			if((l==j&&k==i-2)&&i==6&&board[k][l].getClass().getName().equals("Pieces.Space")){//allows for pawn to move 2 spaces only on first move
				//System.out.println("Broken here");
				this.moveCount++;
				return true;
			}
			if (l==j&&k==i-1&&board[k][l].getClass().getName().equals("Pieces.Space")){//only lets pawn move 1 space forward 
				//System.out.println("Broken here");
				this.moveCount++;
				return true;
			}
			if((l==j-1||l==j+1&&k==i-1)&&(!board[k][l].toString().contains("w")&&board[k][l].toString().contains("b"))){//used to move diagonally to take other pieces
				this.moveCount++;
				//System.out.println("Broken here");
				return true;
			}
			if(l==j-1||l==j+1&&k==i-1&&!board[k][l].toString().contains("w")){//en passant 	
				if(k+1<8){
					if(board[k+1][l].getMoveCount()==1 &&board[k+1][l].toString().contains("bp")){
						this.moveCount++;
						return true;
					}
				}
				else{
					return false;
				}
				
			}
			
			else {
				return false;
			}
		}
		else if(!whiteTurn){
			if(l==j&&k==i+2&&i==1&&board[k][l].getClass().getName().equals("Pieces.Space")){
				this.moveCount++;
				return true;
			}
			else if (l==j&&k==i+1&&board[k][l].getClass().getName().equals("Pieces.Space")){
				this.moveCount++;
				return true;
			}
			if((l==j-1||l==j+1)&&k==i+1&&(!board[k][l].getClass().getName().equals("Pieces.Space")&&!board[k][l].toString().contains("b")&&board[k][l].toString().contains("w"))){
				this.moveCount++;
				//System.out.println(board[k][l].getClass().getName());
				//System.out.println(board[k][l].toString());
				return true;
			}
			if(l==j-1||l==j+1&&k==i+1&&!board[k][l].toString().contains("b")){
				if(k-1>0){
					if(board[k-1][l].toString().contains("wp")&&board[k-1][l].getMoveCount()==1){
						this.moveCount++;
						return true;
					}
				}
				else{
					return false;
				}
			}
		}
		return whiteTurn;
		
	}

	
	public String getColor() {
		return color;
	}

	public Pawn(String color) {
		this.attacked=false;
		this.moveCount=0;
		this.color=color;
	}
	
	@Override
	public String toString() {
		return " "+color+"p ";
	}

	public int getMoveCount() {
		return moveCount;
	}
	/*
	@Override
	public boolean inCheck(Piece[][] board, int[] move, boolean whiteTurn) {
		int i,j;
		i=move[0];
		j=move[1];
		
		if(whiteTurn){
			if(j!=0&&i!=0){
				if(board[i-1][j-1].toString().contains("bK")&&board[i][j].toString().contains("wp")){
					return true;
				}
			}
			if(j!=7&&i!=0){
				if(board[i-1][j+1].toString().contains("bK")&&board[i][j].toString().contains("wp")){
					return true;
				}
			}
			else{
				return false;
			}
		}
		if(!whiteTurn){
			if(j!=0&&i!=7){
				if(board[i+1][j-1].toString().contains("wK")&&board[i][j].toString().contains("bp")){
					return true;
				}
			}
			if(j!=7&&i!=7){
				if(board[i+1][j+1].toString().contains("wK")&&board[i][j].toString().contains("bp")){
					return true;
				}
			}
			else{
				return false;
			}
		}
		return false;
	}
	*/
	@Override
	public Piece[][] attacking(Piece[][] board, int[] move, boolean whiteTurn) {
		int i,j;
		i=move[0];
		j=move[1];		
		if(board[i][j].toString().contains("wp") &&!whiteTurn){
			if(j==0&&i>0){
				if(board[i-1][j+1].toString().contains("b")||board[i-1][j+1].getClass().getName().equals("Pieces.Space")){
					board[i-1][j+1].setAttacked(true);
					return board;
				}
			}
			if(j==7&&i>0){
				if(board[i-1][j-1].toString().contains("b")||board[i-1][j-1].getClass().getName().equals("Pieces.Space")){
					board[i-1][j-1].setAttacked(true);
					return board;
				}
			}
			else if( (j!=0&&j!=7) && i>0){
				if(board[i-1][j+1].toString().contains("b")||board[i-1][j+1].getClass().getName().equals("Pieces.Space")){
					board[i-1][j+1].setAttacked(true);
				}
				if(board[i-1][j-1].toString().contains("b")||board[i-1][j-1].getClass().getName().equals("Pieces.Space")){
					board[i-1][j-1].setAttacked(true);
				}
				return board;
			}
			return board;
		}
		else if(board[i][j].toString().contains("bp")&&whiteTurn){
			if(j==0&&i<7){
				if(board[i+1][j+1].toString().contains("w")||board[i+1][j+1].getClass().getName().equals("Pieces.Space")){
					board[i+1][j+1].setAttacked(true);
					return board;
				}
			}
			else if(j==7&&i<7){
				if(board[i+1][j-1].toString().contains("w")||board[i+1][j-1].getClass().getName().equals("Pieces.Space")){
					board[i+1][j-1].setAttacked(true);
					return board;
				}
			}
			else if( (j!=7&&j!=0) && i<7 ){
				if(board[i+1][j+1].toString().contains("w")||board[i+1][j+1].getClass().getName().equals("Pieces.Space")){
					board[i+1][j+1].setAttacked(true);
				}
				if(board[i+1][j-1].toString().contains("w")||board[i+1][j-1].getClass().getName().equals("Pieces.Space")){
					board[i+1][j-1].setAttacked(true);
				}
				return board;
			}
			return board;
		}
		return board;
	}

	/*
	@Override
	public Piece[][] notAttacking(Piece[][] board, int[] move, boolean whiteTurn) {
		int i,j;
		i=move[0];
		j=move[1];		
		if(board[i][j].toString().contains("wp")){
			if(j==0&&i>0){
				board[i-1][j+1].setAttacked(false);
				return board;
			}
			if(j==7&&i>0){
				board[i-1][j-1].setAttacked(false);
				return board;
			}
			else if( (j!=0&&j!=7) && i>0){
				board[i-1][j+1].setAttacked(false);
				board[i-1][j-1].setAttacked(false);
				return board;
			}
			return board;
		}
		else if(board[i][j].toString().contains("bp")){
			if(j==0&&i<7){
				board[i+1][j+1].setAttacked(false);
				return board;
			}
			else if(j==7&&i<7){
				board[i+1][j-1].setAttacked(false);
				return board;
			}
			else if( (j!=7&&j!=0) && i<7 ){				
				board[i+1][j+1].setAttacked(false);
				board[i+1][j-1].setAttacked(false);
				return board;
			}
			return board;
		}
		return board;
	}
	*/
}