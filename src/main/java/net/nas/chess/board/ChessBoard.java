package net.nas.chess.board;

import net.nas.chess.piece.ChessPiece;
import net.nas.chess.piece.Pawn;

import java.util.ArrayList;
import java.util.Optional;

public class ChessBoard {
    final private ArrayList<ChessPiece> board;
    public ChessBoard(){
        board = new ArrayList<ChessPiece>();
    }
    public void addChessPiece(ChessPiece piece){
        if(!isValidChessPiece(piece))
            return;
        board.add(piece);
    }
    private boolean isValidChessPiece(ChessPiece piece){
        if(piece == null)
            return false;
        return true;
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
