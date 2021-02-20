package net.nas.chess;

import net.nas.pieces.ChessPiece;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static net.nas.pieces.ChessPiece.*;
import static net.nas.utils.StringUtils.appendNewLine;

/*
    입력 패러미터는 실제 체스판에서의 인덱스를 사용한다.
    예를들면, 실제 체스판에서 랭크의 인덱스는 1부터 8까지이다.
    그래서 흰색 폰의 랭크는 2가 된다.
    하지만 2차원 배열에서의 흰색 폰의 랭크는 1이므로, -1을 해줘야 한다.
    그래서 Board클래스에서 chessCells에 접근할때, 입력패러미터 -1을 해준다.
    ex : return chessCells[rankIdx - 1][fileIdx - 1].getOccupiedPiece();
 */
public class Board {
    public static final int LENGTH_OF_BOARD = 8;

    public static final int RANK_OF_WHITE_KING = 1;
    public static final int RANK_OF_WHITE_PAWNS = 2;
    public static final int RANK_OF_BLANK_1 = 3;
    public static final int RANK_OF_BLANK_2 = 4;
    public static final int RANK_OF_BLANK_3 = 5;
    public static final int RANK_OF_BLANK_4 = 6;
    public static final int RANK_OF_BLACK_PAWNS = 7;
    public static final int RANK_OF_BLACK_KING = 8;

    public static final int FILE_OF_ROOK = 1;
    public static final int FILE_OF_KNIGHT = 2;
    public static final int FILE_OF_BISHOP = 3;
    public static final int FILE_OF_WHITE_QUEEN = 4;
    public static final int FILE_OF_WHITE_KING = 5;
    public static final int FILE_OF_BLACK_QUEEN = 5;
    public static final int FILE_OF_BLACK_KING = 4;

    private final ChessPiece[][] chessCells;
    private int numberOfPieces = 0;

    public Board() {
        chessCells = new ChessPiece[LENGTH_OF_BOARD][LENGTH_OF_BOARD];
    }

    public void initialize() {
        initRanksOfPawns();
        initRanksOfBlank();
        initRanksOfKings();
    }

    private void initRanksOfPawns() {
        for (int i = 1; i <= LENGTH_OF_BOARD; i++) {
            add(createWhitePawn(), RANK_OF_WHITE_PAWNS, i);
            add(createBlackPawn(), RANK_OF_BLACK_PAWNS, i);
        }
    }

    private void initRanksOfBlank() {
        for (int i = 1; i <= LENGTH_OF_BOARD; i++) {
            add(createBlankPiece(), RANK_OF_BLANK_1, i);
            add(createBlankPiece(), RANK_OF_BLANK_2, i);
            add(createBlankPiece(), RANK_OF_BLANK_3, i);
            add(createBlankPiece(), RANK_OF_BLANK_4, i);
        }
    }

    private void initRanksOfKings() {
        initRankOfWhiteKing();
        initRankOfBlackKing();
    }

    private void initRankOfWhiteKing() {
        add(createWhiteRook(), RANK_OF_WHITE_KING, FILE_OF_ROOK);
        add(createWhiteRook(), RANK_OF_WHITE_KING, LENGTH_OF_BOARD - FILE_OF_ROOK + 1);
        add(createWhiteKnight(), RANK_OF_WHITE_KING, FILE_OF_KNIGHT);
        add(createWhiteKnight(), RANK_OF_WHITE_KING, LENGTH_OF_BOARD - FILE_OF_KNIGHT + 1);
        add(createWhiteBishop(), RANK_OF_WHITE_KING, FILE_OF_BISHOP);
        add(createWhiteBishop(), RANK_OF_WHITE_KING, LENGTH_OF_BOARD - FILE_OF_BISHOP + 1);
        add(createWhiteQueen(), RANK_OF_WHITE_KING, FILE_OF_WHITE_QUEEN);
        add(createWhiteKing(), RANK_OF_WHITE_KING, FILE_OF_WHITE_KING);
    }

    private void initRankOfBlackKing() {
        add(createBlackRook(), RANK_OF_BLACK_KING, FILE_OF_ROOK);
        add(createBlackRook(), RANK_OF_BLACK_KING, LENGTH_OF_BOARD - FILE_OF_ROOK + 1);
        add(createBlackKnight(), RANK_OF_BLACK_KING, FILE_OF_KNIGHT);
        add(createBlackKnight(), RANK_OF_BLACK_KING, LENGTH_OF_BOARD - FILE_OF_KNIGHT + 1);
        add(createBlackBishop(), RANK_OF_BLACK_KING, FILE_OF_BISHOP);
        add(createBlackBishop(), RANK_OF_BLACK_KING, LENGTH_OF_BOARD - FILE_OF_BISHOP + 1);
        add(createBlackQueen(), RANK_OF_BLACK_KING, FILE_OF_BLACK_QUEEN);
        add(createBlackKing(), RANK_OF_BLACK_KING, FILE_OF_BLACK_KING);
    }

    public String getRepresentationOfBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = LENGTH_OF_BOARD - 1; i >= 0; i--) {
            sb.append(appendNewLine(getRepresentationOfRank(i)));
        }
        return sb.toString();
    }

    private String getRepresentationOfRank(int rankIdx) {
        return Arrays.stream(chessCells[rankIdx])
                .map(ChessPiece::getRepresentation)
                .collect(Collectors.joining());
    }

    public String getWhitePawnsResult() {
        return getRepresentationOfRank(RANK_OF_WHITE_PAWNS - 1);
    }

    public String getBlackPawnsResult() {
        return getRepresentationOfRank(RANK_OF_BLACK_PAWNS - 1);
    }

    public ChessPiece findPawn(int rankIdx, int fileIdx) {
        if (isInvalidIdx(rankIdx) || isInvalidIdx(fileIdx))
            throw new InvalidParameterException("index exceeded the bounds of the Board");
        return chessCells[rankIdx - 1][fileIdx - 1];
    }

    private boolean isInvalidIdx(int idx) {
        return 1 > idx || idx > LENGTH_OF_BOARD;
    }

    public void add(ChessPiece piece, int rankIdx, int fileIdx) {
        if (piece == null)
            throw new InvalidParameterException("Null value cannot be added in Board");
        if (isInvalidIdx(rankIdx) || isInvalidIdx(fileIdx))
            throw new InvalidParameterException("index exceeded the bounds of the Board");
        chessCells[rankIdx - 1][fileIdx - 1] = piece;
        if (!piece.isBlank())
            numberOfPieces++;
    }

    public int size() {
        return numberOfPieces;
    }
}
