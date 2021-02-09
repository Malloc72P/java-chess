package net.nas.chess;

public abstract class ChessPiece {
    ChessPieceColor color;

    public ChessPiece(ChessPieceColor color) {
        this.color = color;
    }

    public ChessPieceColor getColor() {
        return color;
    }
}
