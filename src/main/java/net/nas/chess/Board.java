package net.nas.chess;

import java.util.ArrayList;

public class Board {
    ArrayList<Pawn> pieceList;

    public Board() {
        pieceList = new ArrayList<Pawn>();
    }

    public Pawn findPawn(int idx) {
        return pieceList.stream()
                .skip(idx)
                .findFirst()
                .orElse(null);
    }

    public void add(Pawn piece) {
        pieceList.add(piece);
    }
}
