package net.nas.chess;

import net.nas.pieces.Pawn;

public class ChessCell {
    public static final String NONE_REPRESENTATION = ".";
    private Pawn piece = null;

    public void occupy(Pawn newPiece) {
        if (piece != null)
            throw new IllegalStateException("Chess Cell is already occupied by another piece");
        piece = newPiece;
    }

    public Pawn getOccupiedPiece() {
        return piece;
    }

    public String getRepresentation() {
        if (piece == null)
            return NONE_REPRESENTATION;
        else return piece.getRepresentation();
    }
}
