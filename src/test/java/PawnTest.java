import net.nas.chess.ChessPieceColor;
import net.nas.chess.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("생성자에 넣은 색깔대로 폰이 생성되어야 합니다.")
    public void create(){
        for(ChessPieceColor tc : ChessPieceColor.values()){
            verifyPawn(tc);
        }
    }
    @Test
    @DisplayName("기본 생성자로 만들면 white로 설정되어야 합니다")
    public void createDefaultPawn(){
        verifyPawn();
    }

    private void verifyPawn(ChessPieceColor color){
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
    }
    private void verifyPawn(){
        Pawn pawn = new Pawn();
        assertEquals(ChessPieceColor.white, pawn.getColor());
    }
}
