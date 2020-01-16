package Pieces;

public class Queen extends Piece{
	public String color;
	
	public String getColor() {
		return color;
	}

	public Queen(String color) {
		this.attacked=false;
		this.color=color;
	}

	@Override
	public String toString() {
		return " "+color+"Q ";
	}

	@Override
	public boolean validMove(Piece[][] board, int[] move,boolean whiteTurn) {
		int i,j,k,l,m,n;
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
					return true;
				}
			}
			if(k==i && j<l){//moving right
				while(j<l){
					j=j+1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("w")){
						//System.out.println(board[i][j].toString()+" right");
						return false;
					}
				}
				if(board[k][l].getClass().getName().equals("Pieces.Space")||board[k][l].toString().contains("b")){
				}
			}

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
			if(k>i && j==l){//moving downward				
				while(i<k){
					i=i+1;
					if(!board[i][j].getClass().getName().equals("Pieces.Space")&&board[i][j].toString().contains("b")){
						//System.out.println(board[i][j].toString()+" down");
						return false;
					}
				}
				if(i==k&&(board[i][j].getClass().getName().equals("Pieces.Space")||board[i][j].toString().contains("w"))){
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
					return true;
				}
			}

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
				//System.out.println(board[i][j].toString()+" we are here");
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
		//System.out.println(board[i][j].toString());
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
		int i,j;
		i=move[0];
		j=move[1];
		if(board[i][j].toString().contains("wQ")&&!whiteTurn){			
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
			i=move[0];
			j=move[1];
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
		else if(board[i][j].toString().contains("bQ")&&whiteTurn){
			i=move[0];
			j=move[1];
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
			i=move[0];
			j=move[1];
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
		}
		
		return board;
		
	}
	/*
	@Override
	public Piece[][] notAttacking(Piece[][] board, int[] move, boolean whiteTurn) {
		int i,j;
		i=move[0];
		j=move[1];
		if(board[i][j].toString().contains("wQ")){			
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
			i=move[0];
			j=move[1];
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
		else if(board[i][j].toString().contains("bQ")){
			i=move[0];
			j=move[1];
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
			i=move[0];
			j=move[1];
			while(i<7&&j<7){//Diagonal Down Right
				i=i+1;
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
			i=move[0];
			j=move[1];
			while(i>0&&j<7){//Diagonal Up Right
				i=i-1;
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
			i=move[0];
			j=move[1];
			while(i>0&&j>0){//Diagonal Up Left
				i=i-1;
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
			i=move[0];
			j=move[1];
			while(7>i&&j>0){//Diagonal Down Left
				i=i+1;
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
		}	
		return board;		
	}
	*/
}
