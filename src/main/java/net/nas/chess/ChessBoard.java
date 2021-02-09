package net.nas.chess;

import java.util.ArrayList;
import java.util.Optional;

public class ChessBoard {
    final private ArrayList<ChessPiece> board;
    public ChessBoard(){
        board = new ArrayList<ChessPiece>();
    }
    public void addChessPiece(ChessPiece piece){
        board.add(piece);
    }
    public int size(){
        return board.size();
    }
    public Pawn findPawn(int i){
        Optional<Pawn> optionalPawn = board.stream()
                .filter((piece)-> piece instanceof Pawn)
                .skip(i)
                .map(obj->(Pawn)obj)
                .findFirst();
        return optionalPawn.orElse(null);
    }
}
