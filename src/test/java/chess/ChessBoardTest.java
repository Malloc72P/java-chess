package chess;

import net.nas.chess.board.ChessBoard;
import net.nas.chess.piece.ChessPiece;
import net.nas.chess.piece.ChessPieceColor;
import net.nas.chess.piece.Pawn;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ChessBoardTest {
    ChessBoard chessBoard;
    Pawn[] pawns;
    Object[] errorCase;
    @BeforeEach
    public void initTest(){
        pawns = new Pawn[]{
                new Pawn(ChessPieceColor.white),
                new Pawn(ChessPieceColor.black),
                new Pawn(ChessPieceColor.white),
                new Pawn(ChessPieceColor.black),
                new Pawn()
        };
        errorCase = new Object[]{
                null,
                "errorCase",
                24,
                new Object()
        };
        chessBoard = new ChessBoard();
    }
    @Test
    @DisplayName("체스판에 체스말을 배치할 수 있어야 합니다.")
    public void create() throws Exception{
        for (int i = 0; i < pawns.length; i++) {
            Pawn pawn = pawns[i];
            chessBoard.addChessPiece(pawn);
            assertEquals(i+1, chessBoard.size());
        }
    }
    @Test
    @DisplayName("잘못된 인스턴스가 체스보드의 리스트에 들어가서는 안됩니다")
    public void insertError() throws Exception{
        for(Object piece : errorCase){
            try {
                chessBoard.addChessPiece((ChessPiece) piece);
                assertEquals(0, chessBoard.size());
            }catch (Exception ignored){}
        }
    }
    @Test
    @DisplayName("체스판에서 n번째 폰을 찾을 수 있어야 합니다.")
    public void find() throws Exception{
        for (int i = 0 ; i < pawns.length; i++){
            Pawn pawn = pawns[i];
            chessBoard.addChessPiece(pawn);
            Pawn found = chessBoard.findPawn(i);
            assertEquals(pawn, found);
        }
    }

}
