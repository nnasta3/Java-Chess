package Pieces;

public class Space extends Piece{

	public String type;
	public Space() {
		this.attacked=false;
		this.type="    ";
	}
	
	public Space(String black) {
		this.attacked=false;
		this.type=" ## ";
	}
	@Override
	public String toString() {
		return type;
	}
	@Override
	public boolean validMove(Piece[][] board, int[] move,boolean whiteTurn) {
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

		return board;		
	}
	/*
	@Override
	public Piece[][] notAttacking(Piece[][] board, int[] move, boolean whiteTurn) {
		// TODO Auto-generated method stub
		return board;
	}
	*/

}
