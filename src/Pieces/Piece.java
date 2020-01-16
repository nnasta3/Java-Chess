package Pieces;

public abstract class Piece {
	//TO DO
	//1.Implement Move in all pieces except Space, it will check if the move entered is valid and return true/false
	//2. figure out check & checkmate
	abstract public boolean validMove(Piece[][] board, int[] move,boolean whiteTurn);
	/*
	abstract public boolean inCheck(Piece[][] board, int[] move,boolean whiteTurn);
	*/
	abstract public Piece[][] attacking(Piece[][] board, int[] move,boolean whiteTurn);
	/*
	abstract public Piece[][] notAttacking(Piece[][] board, int[] move,boolean whiteTurn);
	*/
	public int moveCount;
	public boolean castle;
	public boolean attacked;
	
	
	
	public boolean isAttacked() {
		return attacked;
	}
	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}
	public boolean isCastle() {
		return castle;
	}
	public void setCastle(boolean castle) {
		this.castle = castle;
	}
	public int getMoveCount() {
		return moveCount;
	}
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}
	public int x;
	public int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}