package Pieces;

public class Rook extends Piece{

	public String color;
	public String getColor() {
		return color;
	}

	public Rook(String color) {
		this.attacked=false;
		this.setMoveCount(0);
		this.color=color;
	}

	@Override
	public String toString() {
		return " "+color+"R ";
	}

	@Override
	public boolean validMove(Piece[][] board, int[] move,boolean whiteTurn) {
		int i,j,k,l;
		i=move[0];
		j=move[1];
		k=move[2];
		l=move[3];
		if(whiteTurn){
			if(k>i && j==l){//moving downward				
				while(i<k){
					i=i+1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("w")){
						//System.out.println(board[i][j].toString()+" down");
						return false;
					}
				}
				if(i==k&&(board[i][j].getClass().getName().equals("Pieces.Space")||board[i][j].toString().contains("b"))){
					this.moveCount++;
					return true;
				}					
			}
			if(k<i && j==l){//moving upward
				while(k<i){
					i=i-1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("w")){
						//System.out.println(board[i][j].toString()+" up");
						return false;
					}
				}
				if(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("b")){
					this.moveCount++;
					return true;
				}							
			}
			if(k==i && j>l){//moving left
				while(j>l){
					j=j-1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("w")){
						//System.out.println(board[i][j].toString()+" left");
						return false;
					}
				}
				if(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("b")){
					this.moveCount++;
					return true;
				}
			}
			if(k==i && l>j){//moving right
				while(l>j){
					j=j+1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("w")){
						//System.out.println(board[i][j].toString()+" right");
						return false;
					}
				}
				if(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("b")){
					this.moveCount++;
					return true;
				}
			}
		}
		if(!whiteTurn){
			if(k>i && j==l){//moving downward				
				while(i<k){
					i=i+1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("b")){
						//System.out.println(board[i][j].toString()+" down");
						return false;
					}
				}
				if(i==k&&(board[i][j].getClass().getName().equals("Pieces.Space")||board[i][j].toString().contains("w"))){
					this.moveCount++;
					return true;
				}					
			}
			if(k<i && j==l){//moving upward
				while(k<i){
					i=i-1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("b")){
						//System.out.println(board[i][j].toString()+" up");
						return false;
					}
				}
				if(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("w")){
					this.moveCount++;
					return true;
				}							
			}
			if(k==i && j>l){//moving left
				while(j>l){
					j=j-1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("b")){
						//System.out.println(board[i][j].toString()+" left");
						return false;
					}
				}
				if(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("w")){
					this.moveCount++;
					return true;
				}
			}
			if(k==i && j<l){//moving right
				while(j<l){
					j=j+1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("b")){
						//System.out.println(board[i][j].toString()+" right");
						return false;
					}
				}
				if(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("w")){
					this.moveCount++;
					return true;
				}
			}
		}
		return false;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}
	/*
	@Override
	public boolean inCheck(Piece[][] board, int[] move, boolean whiteTurn) {
		// TODO Auto-generated method stub
		return false;
	}
	*/
	@Override
	public Piece[][] attacking(Piece[][] board, int[] move, boolean whiteTurn) {
		int i,j;
		i=move[0];
		j=move[1];

		if(board[i][j].toString().contains("wR")&&!whiteTurn){
			//moving downward				
			while(i<7){
				i=i+1;
				if(board[i][j].toString().contains("w")){//hit a white piece
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(true);
				}
				else if(board[i][j].toString().contains("b")){
					board[i][j].setAttacked(true);
					break;
				}
			}
			//moving upward
			i=move[0];
			j=move[1];
			while(i>0){
				i=i-1;
				if(board[i][j].toString().contains("w")){//hit a white piece
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(true);
				}
				else if(board[i][j].toString().contains("b")){
					board[i][j].setAttacked(true);
					break;
				}							
			}
			//moving left
			i=move[0];
			j=move[1];
			while(j>0){
				j=j-1;
				if(board[i][j].toString().contains("w")){//hit a white piece
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(true);
				}
				else if(board[i][j].toString().contains("b")){
					board[i][j].setAttacked(true);
					break;
				}	
			}	
			//moving right
			i=move[0];
			j=move[1];
			while(j<7){
				j=j+1;
				if(board[i][j].toString().contains("w")){//hit a white piece
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(true);
				}
				else if(board[i][j].toString().contains("b")){
					board[i][j].setAttacked(true);
					break;
				}
			}
		}
		else if(board[i][j].toString().contains("bR")&&whiteTurn){
			//moving downward	
			while(i<7){
				i=i+1;
				if(board[i][j].toString().contains("b")){
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(true);
				}
				else if(board[i][j].toString().contains("w")){
					board[i][j].setAttacked(true);
					break;
				}
			}
			//moving upward
			i=move[0];
			j=move[1];
			while(i>0){
				i=i-1;
				if(board[i][j].toString().contains("b")){
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(true);
				}
				else if(board[i][j].toString().contains("w")){
					board[i][j].setAttacked(true);
					break;
				}							
			}
			//moving left
			i=move[0];
			j=move[1];
			while(j>0){
				j=j-1;
				if(board[i][j].toString().contains("b")){
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(true);
				}
				else if(board[i][j].toString().contains("w")){
					board[i][j].setAttacked(true);
					break;
				}
			}	
			//moving right
			i=move[0];
			j=move[1];
			while(j<7){
				j=j+1;
				if(board[i][j].toString().contains("b")){
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(true);
				}
				else if(board[i][j].toString().contains("w")){
					board[i][j].setAttacked(true);
					break;
				}
			}
		}
		return board;
	}
	/*
	@Override
	public Piece[][] notAttacking(Piece[][] board, int[] move, boolean whiteTurn) {
		int i,j;
		i=move[0];
		j=move[1];

		if(board[i][j].toString().contains("wR")){
			//moving downward				
			while(i<7){
				i=i+1;
				if(board[i][j].toString().contains("w")){//hit a white piece
					board[i][j].setAttacked(false);
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(false);
				}
				else if(board[i][j].toString().contains("b")){
					board[i][j].setAttacked(false);
					break;
				}
			}
			//moving upward
			i=move[0];
			j=move[1];
			while(i>0){
				i=i-1;
				if(board[i][j].toString().contains("w")){//hit a white piece
					board[i][j].setAttacked(false);
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(false);
				}
				else if(board[i][j].toString().contains("b")){
					board[i][j].setAttacked(false);
					break;
				}							
			}
			//moving left
			i=move[0];
			j=move[1];
			while(j>0){
				j=j-1;
				if(board[i][j].toString().contains("w")){//hit a white piece
					board[i][j].setAttacked(false);
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(false);
				}
				else if(board[i][j].toString().contains("b")){
					board[i][j].setAttacked(false);
					break;
				}
			}	
			//moving right
			i=move[0];
			j=move[1];
			while(j<7){
				j=j+1;
				if(board[i][j].toString().contains("w")){//hit a white piece
					board[i][j].setAttacked(false);
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(false);
				}
				else if(board[i][j].toString().contains("b")){
					board[i][j].setAttacked(false);
					break;
				}
			}
		}
		else if(board[i][j].toString().contains("bR")){
			//moving downward				
			while(i<7){
				i=i+1;
				if(board[i][j].toString().contains("b")){//hit a white piece
					board[i][j].setAttacked(false);
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(false);
				}
				else if(board[i][j].toString().contains("w")){
					board[i][j].setAttacked(false);
					break;
				}
			}
			//moving upward
			i=move[0];
			j=move[1];
			while(i>0){
				i=i-1;
				if(board[i][j].toString().contains("b")){//hit a white piece
					board[i][j].setAttacked(false);
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(false);
				}
				else if(board[i][j].toString().contains("w")){
					board[i][j].setAttacked(false);
					break;
				}							
			}
			//moving left
			i=move[0];
			j=move[1];
			while(j>0){
				j=j-1;
				if(board[i][j].toString().contains("b")){//hit a white piece
					board[i][j].setAttacked(false);
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(false);
				}
				else if(board[i][j].toString().contains("w")){
					board[i][j].setAttacked(false);
					break;
				}
			}	
			//moving right
			i=move[0];
			j=move[1];
			while(j<7){
				j=j+1;
				if(board[i][j].toString().contains("b")){//hit a white piece
					board[i][j].setAttacked(false);
					break;
				}
				else if(board[i][j].getClass().getName().equals("Pieces.Space")){
					board[i][j].setAttacked(false);
				}
				else if(board[i][j].toString().contains("w")){
					board[i][j].setAttacked(false);
					break;
				}
			}
		}
		return board;
	}
	*/
}
