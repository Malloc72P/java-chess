package net.nas.chess;

import java.util.ArrayList;

public class ChessBoard {
    private ArrayList<ChessPiece> board;
    public ChessBoard(){
        board = new ArrayList<ChessPiece>();
    }
    public void addChessPiece(ChessPiece piece){
        board.add(piece);
    }
}
