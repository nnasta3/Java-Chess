package Pieces;

public class Bishop extends Piece{

	public String color;
	
	public String getColor() {
		return color;
	}

	public Bishop(String color) {
		this.attacked=false;
		this.color=color;
	}

	@Override
	public String toString() {
		return " "+color+"B ";
	}

	@Override
	public boolean validMove(Piece[][] board, int[] move ,boolean whiteTurn) {
		int i,j,k,l;
		i=move[0];
		j=move[1];
		k=move[2];
		l=move[3];
		if(whiteTurn){
			if(i<k&&j<l){
				while(i<k&&j<l){//Diagonal Down Right
					i=i+1;
					j=j+1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("w")){
						//System.out.println(board[i][j].toString());
						return false;
					}
				}
				if((i==k&&j==l)&&(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("b"))){
					return true;
				}
			}
			if(i>k&&j<l){
				while(i>k&&j<l){//Diagonal Up Right
					i=i-1;
					j=j+1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("w")){
						//System.out.println(board[i][j].toString());
						return false;
					}					
				}
				if((i==k&&j==l)&&(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("b"))){
					return true;
				}
			}
			if(i>k&&j>l){
				while(i>k&&j>l){//Diagonal Up Left
					i=i-1;
					j=j-1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("w")){
						//System.out.println(board[i][j].toString());
						return false;
					}								
				}
				if((i==k&&j==l)&&(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("b"))){
					return true;
				}
			}
			if(i<k&&j>l){
				while(k>i&&j>l){//Diagonal Down Left
					i=i+1;
					j=j-1;
					if(!board[k][l].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("w")){
						//System.out.println(board[i][j].toString());
						return false;
					}				
				}
				if((i==k&&j==l)&&(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("b"))){
					return true;
				}	
			}
		}
		if(!whiteTurn){
			if(i<k&&j<l){
				while(i<k&&j<l){//Diagonal Down Right
					i=i+1;
					j=j+1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("b")){
						//System.out.println(board[i][j].toString());
						return false;
					}
				}
				if((i==k&&j==l)&&(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("w"))){
					return true;
				}
			}
			if(i>k&&j<l){
				while(i>k&&j<l){//Diagonal Up Right
					i=i-1;
					j=j+1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("b")){
						//System.out.println(board[i][j].toString());
						return false;
					}					
				}
				if((i==k&&j==l)&&(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("w"))){
					return true;
				}
			}
			if(i>k&&j>l){
				while(i>k&&j>l){//Diagonal Up Left
					i=i-1;
					j=j-1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("b")){
						//System.out.println(board[i][j].toString());
						return false;
					}								
				}
				if((i==k&&j==l)&&(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("w"))){
					return true;
				}
			}
			if(i<k&&j>l){
				while(k>i&&j>l){//Diagonal Down Left
					i=i+1;
					j=j-1;
					if(!board[k][l].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("b")){
						//System.out.println(board[i][j].toString());
						return false;
					}				
				}
				if((i==k&&j==l)&&(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("w"))){
					return true;
				}	
			}
		}
		return false;
	}
	/*
	@Override
	public boolean inCheck(Piece[][] board, int[] move, boolean whiteTurn) {
		int i,j,k,l;
		i=move[0];
		j=move[1];
		if(whiteTurn){			
			while(i<7&&j<7){//Diagonal Down Right
				i=i+1;
				j=j+1;
				if(board[j][j].toString().contains("bK")){
					return true;
				}
			}
			i=move[0];
			j=move[1];
			while(i>0&&j<7){//Diagonal Up Right
				i=i-1;
				j=j+1;	
				if(board[i][j].toString().contains("bK")){
					return true;
				}
			}
			i=move[0];
			j=move[1];
			while(i>0&&j>0){//Diagonal Up Left
				i=i-1;
				j=j-1;
				if(board[i][j].toString().contains("bK")){
					return true;
				}
			}
			i=move[0];
			j=move[1];
			while(7>i&&j>0){//Diagonal Down Left
				i=i+1;
				j=j-1;			
				if(board[i][j].toString().contains("bK")){
					return true;
				}	
			}
			
			return false;
		}
		if(!whiteTurn){
			while(i<7&&j<7){//Diagonal Down Right
				i=i+1;
				j=j+1;
				if(board[j][j].toString().contains("wK")){
					return true;
				}
			}
			i=move[0];
			j=move[1];
			while(i>0&&j<7){//Diagonal Up Right
				i=i-1;
				j=j+1;	
				if(board[i][j].toString().contains("wK")){
					return true;
				}
			}
			i=move[0];
			j=move[1];
			while(i>0&&j>0){//Diagonal Up Left
				i=i-1;
				j=j-1;
				if(board[i][j].toString().contains("wK")){
					return true;
				}
			}
			i=move[0];
			j=move[1];
			while(7>i&&j>0){//Diagonal Down Left
				i=i+1;
				j=j-1;			
				if(board[i][j].toString().contains("wK")){
					return true;
				}	
			}			
			return false;
		}
		return false;
	}
	 */
	@Override
	public Piece[][] attacking(Piece[][] board, int[] move, boolean whiteTurn) {
		int i,j;
		i=move[0];
		j=move[1];
		if(board[i][j].toString().contains("wB")&&!whiteTurn){			
			while(i<7&&j<7){//Diagonal Down Right
				i=i+1;
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
			i=move[0];
			j=move[1];
			while(i>0&&j<7){//Diagonal Up Right
				i=i-1;
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
			i=move[0];
			j=move[1];
			while(i>0&&j>0){//Diagonal Up Left
				i=i-1;
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
			i=move[0];
			j=move[1];
			while(7>i&&j>0){//Diagonal Down Left
				i=i+1;
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
			
			return board;			
		}
		else if(board[i][j].toString().contains("bB")&&whiteTurn){
			while(i<7&&j<7){//Diagonal Down Right
				i=i+1;
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
			i=move[0];
			j=move[1];
			while(i>0&&j<7){//Diagonal Up Right
				i=i-1;
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
			i=move[0];
			j=move[1];
			while(i>0&&j>0){//Diagonal Up Left
				i=i-1;
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
			i=move[0];
			j=move[1];
			while(7>i&&j>0){//Diagonal Down Left
				i=i+1;
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
		if(board[i][j].toString().contains("wB")){			
			while(i<7&&j<7){//Diagonal Down Right
				i=i+1;
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
			i=move[0];
			j=move[1];
			while(i>0&&j<7){//Diagonal Up Right
				i=i-1;
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
			i=move[0];
			j=move[1];
			while(i>0&&j>0){//Diagonal Up Left
				i=i-1;
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
			i=move[0];
			j=move[1];
			while(7>i&&j>0){//Diagonal Down Left
				i=i+1;
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
			
			return board;			
		}
		else if(board[i][j].toString().contains("bB")){
			while(i<7&&j<7){//Diagonal Down Right
				i=i+1;
				j=j+1;
				if(board[i][j].toString().contains("b")){
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
			i=move[0];
			j=move[1];
			while(i>0&&j<7){//Diagonal Up Right
				i=i-1;
				j=j+1;	
				if(board[i][j].toString().contains("b")){
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
			i=move[0];
			j=move[1];
			while(i>0&&j>0){//Diagonal Up Left
				i=i-1;
				j=j-1;
				if(board[i][j].toString().contains("b")){
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
			i=move[0];
			j=move[1];
			while(7>i&&j>0){//Diagonal Down Left
				i=i+1;
				j=j-1;			
				if(board[i][j].toString().contains("b")){
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
			return board;
		}
		
		return board;
	}
	*/
}
