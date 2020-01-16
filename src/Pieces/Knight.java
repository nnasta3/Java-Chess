package Pieces;

public class Knight extends Piece{

	public String color;
	
	public String getColor() {
		return color;
	}

	public Knight(String color) {
		this.attacked=false;
		this.color=color;
	}

	@Override
	public String toString() {
		return " "+color+"N ";
	}

	@Override
	public boolean validMove(Piece[][] board, int[] move,boolean whiteTurn) {
		int i,j,k,l;
		i=move[0];
		j=move[1];
		k=move[2];
		l=move[3];
		
		if(whiteTurn){
			if((k==i+2&&l==j+1)||(k==i-2&&l==j-1)||(k==i+2&&l==j-1)||(k==i-2&&l==j+1)&&(board[k][l].getClass().getName().equals("Pieces.Space")||!board[k][l].toString().contains("w"))){
				return true;
			}
			else if(((k==i+1&&l==j+2)||(k==i+1&&l==j-2)||(k==i-1&&l==j-2)||k==i-1&&l==j+2)&&(board[k][l].getClass().getName().equals("Pieces.Space")||!board[k][l].toString().contains("w"))){
				return true;
			}			
			else{
				return false;
			}
		}
		if(!whiteTurn){
			if((k==i+2&&l==j+1)||(k==i-2&&l==j-1)||(k==i+2&&l==j-1)||(k==i-2&&l==j+1)&&(board[k][l].getClass().getName().equals("Pieces.Space")||!board[k][l].toString().contains("b"))){
				return true;
			}
			else if(((k==i+1&&l==j+2)||(k==i+1&&l==j-2)||(k==i-1&&l==j-2)||k==i-1&&l==j+2)&&(board[k][l].getClass().getName().equals("Pieces.Space")||!board[k][l].toString().contains("b"))){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
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
		int i,j,k,l;
		i=move[0];
		j=move[1];	
		if(board[i][j].toString().contains("wN")&&!whiteTurn){
			k=i-2;
			l=j+1;
			//High Up Right
			if(k>=0&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(true);
				}
			}
			k=i-1;
			l=j+2;
			//Low Up Right
			if(k>=0&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(true);
				}
			}
			k=i-2;
			l=j-1;
			//High Up Left
			if(k>=0&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(true);
				}
			}
			k=i-1;
			l=j-2;
			//low Up Left
			if(k>=0&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(true);
				}
			}
			k=i+2;
			l=j-1;
			//High Down Left
			if(k<=7&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(true);
				}
			}
			k=i+1;
			l=j-2;
			//Low Down Left
			if(k<=7&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(true);
				}
			}
			k=i+2;
			l=j+1;
			//High Down Right
			if(k<=7&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(true);
				}
			}
			k=i+1;
			l=j+2;
			//Low Down Right
			if(k<=7&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(true);
				}
			}
		}
		if(board[i][j].toString().contains("bN")&&whiteTurn){
			k=i-2;
			l=j+1;
			//High Up Right
			if(k>=0&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(true);
				}
			}
			k=i-1;
			l=j+2;
			//Low Up Right
			if(k>=0&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(true);
				}
			}
			k=i-2;
			l=j-1;
			//High Up Left
			if(k>=0&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(true);
				}
			}
			k=i-1;
			l=j-2;
			//low Up Left
			if(k>=0&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(true);
				}
			}
			k=i+2;
			l=j-1;
			//High Down Left
			if(k<=7&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(true);
				}
			}
			k=i+1;
			l=j-2;
			//Low Down Left
			if(k<=7&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(true);
				}
			}
			k=i+2;
			l=j+1;
			//High Down Right
			if(k<=7&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(true);
				}
			}
			k=i+1;
			l=j+2;
			//Low Down Right
			if(k<=7&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(true);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(true);
				}
			}
		}
		return board;
	}
	/*
	@Override
	public Piece[][] notAttacking(Piece[][] board, int[] move, boolean whiteTurn) {
		int i,j,k,l;
		i=move[0];
		j=move[1];	
		if(board[i][j].toString().contains("wN")){
			k=i-2;
			l=j+1;
			//High Up Right
			if(k>=0&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(false);
				}
			}
			k=i-1;
			l=j+2;
			//Low Up Right
			if(k>=0&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(false);
				}
			}
			k=i-2;
			l=j-1;
			//High Up Left
			if(k>=0&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(false);
				}
			}
			k=i-1;
			l=j-2;
			//low Up Left
			if(k>=0&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(false);
				}
			}
			k=i+2;
			l=j-1;
			//High Down Left
			if(k<=7&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(false);
				}
			}
			k=i+1;
			l=j-2;
			//Low Down Left
			if(k<=7&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(false);
				}
			}
			k=i+2;
			l=j+1;
			//High Down Right
			if(k<=7&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(false);
				}
			}
			k=i+1;
			l=j+2;
			//Low Down Right
			if(k<=7&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("b")){
					board[k][l].setAttacked(false);
				}
			}
		}
		if(board[i][j].toString().contains("bN")){
			k=i-2;
			l=j+1;
			//High Up Right
			if(k>=0&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(false);
				}
			}
			k=i-1;
			l=j+2;
			//Low Up Right
			if(k>=0&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(false);
				}
			}
			k=i-2;
			l=j-1;
			//High Up Left
			if(k>=0&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(false);
				}
			}
			k=i-1;
			l=j-2;
			//low Up Left
			if(k>=0&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(false);
				}
			}
			k=i+2;
			l=j-1;
			//High Down Left
			if(k<=7&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(false);
				}
			}
			k=i+1;
			l=j-2;
			//Low Down Left
			if(k<=7&&l>=0){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(false);
				}
			}
			k=i+2;
			l=j+1;
			//High Down Right
			if(k<=7&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(false);
				}
			}
			k=i+1;
			l=j+2;
			//Low Down Right
			if(k<=7&&l<=7){
				if(board[k][l].getClass().getName().equals("Pieces.Space")){
					board[k][l].setAttacked(false);
				}
				else if(board[k][l].toString().contains("w")){
					board[k][l].setAttacked(false);
				}
			}
		}
		return board;
	}
	 */
	
}
