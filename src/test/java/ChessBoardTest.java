import net.nas.chess.ChessBoard;
import net.nas.chess.ChessPieceColor;
import net.nas.chess.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ChessBoardTest {
    @Test
    @DisplayName("체스판에 체스말을 배치할 수 있어야 합니다.")
    public void create() throws Exception{
        ChessBoard chessBoard = new ChessBoard();
        Pawn[] pawns = createPawns();
        for (int i = 0; i < pawns.length; i++) {
            Pawn pawn = pawns[i];
            chessBoard.addChessPiece(pawn);
            assertEquals(i+1, chessBoard.size());
        }
    }
    @Test
    @DisplayName("체스판에서 n번째 폰을 찾을 수 있어야 합니다.")
    public void find() throws Exception{
        ChessBoard chessBoard = new ChessBoard();
        Pawn[] pawns = createPawns();
        for (int i = 0 ; i < pawns.length; i++){
            Pawn pawn = pawns[i];
            chessBoard.addChessPiece(pawn);
            Pawn found = chessBoard.findPawn(i);
            assertEquals(pawn, found);
        }
    }
    private Pawn[] createPawns(){
        return new Pawn[]{
                new Pawn(ChessPieceColor.white),
                new Pawn(ChessPieceColor.black),
                new Pawn(ChessPieceColor.white),
                new Pawn(ChessPieceColor.black),
                new Pawn()
        };
    }
}
