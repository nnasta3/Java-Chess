package Pieces;

public class King extends Piece{
	public String color;

	
	public String getColor() {
		return color;
	}

	public King(String color) {
		this.attacked=false;
		this.setMoveCount(0);
		this.color=color;
	}

	@Override
	public String toString() {
		return " "+color+"K ";
	}

	@Override
	public boolean validMove(Piece[][] board, int[] move,boolean whiteTurn) {
		int i,j,k,l;
		i=move[0];
		j=move[1];
		k=move[2];
		l=move[3];
		
		if(whiteTurn){
			if(board[k][l].isAttacked()){
				return false;
			}
			if(((k==i+1&&l==j)||(k==i+1&&l==j+1)||(k==i+1&&l==j-1)||(k==i&&l==j+1)|(k==i&&l==j-1)||(k==i-1&&l==j)||(k==i-1&&l==j+1)||(k==i-1&&l==j-1))&&!board[k][l].toString().contains("w")){
				this.moveCount++;
				return true;
			}
			if((i==7&&j==4) && (k==7 && l==6) && (!board[7][5].isAttacked() && !board[7][6].isAttacked())){//castling right
				if((board[7][4].getMoveCount()==0&&board[7][7].getMoveCount()==0)){
					while(j<l){
						j=j+1;
						//System.out.println(board[i][j].toString());
						if(board[i][j].getClass().getName().equals("Pieces.Space")){
							continue;
						}
						else{
							return false;
						}
					}
					this.moveCount++;
					this.castle=true;
					return true;
				}
			}
			if((i==7&&j==4) && (k==7 && l==2) && (!board[7][3].isAttacked() && !board[7][2].isAttacked())){//castling left
				if(board[7][4].getMoveCount()==0&&board[7][0].getMoveCount()==0){
					while(j>l){
						j=j-1;
						//System.out.println(board[i][j].toString());
						if(board[i][j].getClass().getName().equals("Pieces.Space")){
							continue;
						}
						else{
							return false;
						}
					}
					this.moveCount++;
					this.castle=true;
					return true;
				}
			}					
			else{
				return false;
			}
		}
		if(!whiteTurn){
			if(board[k][l].isAttacked()){
				return false;
			}
			if(((k==i+1&&l==j)||(k==i+1&&l==j+1)||(k==i+1&&l==j-1)||(k==i&&l==j+1)|(k==i&&l==j-1)||(k==i-1&&l==j)||(k==i-1&&l==j+1)||(k==i-1&&l==j-1))&&!board[k][l].toString().contains("b")){
				this.moveCount++;
				return true;
			}
			if((i==0&&j==4) && (k==0 && l==6) && (!board[0][5].isAttacked()&&!board[0][6].isAttacked())){//castling right
				if(board[0][4].getMoveCount()==0&&board[0][7].getMoveCount()==0){
					while(j<l){
						j=j+1;
						//System.out.println(board[i][j].toString());
						if(board[i][j].getClass().getName().equals("Pieces.Space")){
							continue;
						}
						else{
							return false;
						}
					}
					this.moveCount++;
					this.castle=true;
					return true;
				}
			}
			if((i==0&&j==4) && (k==0 && l==2) && (!board[0][3].isAttacked() && !board[0][2].isAttacked())){//castling left
				if(board[i][j].getMoveCount()==0&&board[0][0].getMoveCount()==0){
					if(board[0][4].getMoveCount()==0&&board[0][0].getMoveCount()==0){
						while(j>l){
							j=j-1;
							//System.out.println(board[i][j].toString());
							if(board[i][j].getClass().getName().equals("Pieces.Space")){
								continue;
							}
							else{
								return false;
							}
						}
						this.moveCount++;
						this.castle=true;
						return true;
					}
				}
			}
			else{
				return false;
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
		int i,j,k,l;
		i=move[0];
		j=move[1];
		
		
		return board;
	}
	/*
	@Override
	public Piece[][] notAttacking(Piece[][] board, int[] move, boolean whiteTurn) {

		return board;
	}
	*/
	
	
}
