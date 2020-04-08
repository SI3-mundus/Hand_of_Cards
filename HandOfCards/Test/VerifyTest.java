import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerifyTest {

    private static final Hand A =new Hand(new String[]{"2","2","3","5","7"});
    private static final Hand B =new Hand(new String[]{"2","2","5","5","7"});
    private static final Hand C =new Hand(new String[]{"2","2","2","A","V"});
    private static final Hand D =new Hand(new String[]{"2","2","2","9","9"});
    private static final Hand E =new Hand(new String[]{"2","2","2","2","4"});
    private static final Verify X=new Verify();


    @Test
    void theHighestCard(){
        assertAll(
                () -> assertEquals(6,X.theHighestCard(A)),
                () -> assertNotEquals(5,X.theHighestCard(B))
        );
    }

    @Test
    void isCarre(){
        assertAll(
                ()->assertEquals(0,X.isCarre(E)),
                ()->assertEquals(-1,X.isCarre(A)),
                ()->assertEquals(1,X.isCarre(new Hand(new String[]{"3","5","5","5","5"})))
        );
    }

    @Test
    void isBrelan(){
        assertAll(
                ()->assertEquals(0,X.isBrelan(C)),
                ()->assertEquals(-1,X.isBrelan(D)),
                ()->assertEquals(2,X.isBrelan(new Hand(new String[]{"3","A","5","5","5"})))
        );
    }

    @Test
    void isFull(){
        assertAll(
                ()->assertTrue(Arrays.equals(X.isFull(D),new int []{0,3})),
                ()->assertTrue(Arrays.equals(X.isFull(E),new int []{-1,-1})),
        ()->assertTrue(Arrays.equals(X.isFull(new Hand(new String[]{"2","5","5","5","2"})),new int[]{1,0}))
        );

    }

    @Test
    void isPaire(){
        assertAll(
                ()->assertEquals(0,X.isPaire(A)),
                ()->assertNotEquals(0,X.isPaire(B))
        );
    }

   @Test
    void isDeuxPaire(){
        assertAll(
                ()->assertTrue(Arrays.equals(X.isDeuxPaires(B),new int[]{0,2})),
                ()->assertTrue(Arrays.equals(X.isDeuxPaires(C),new int[]{-1,-1})),
                ()->assertTrue(Arrays.equals(X.isDeuxPaires(new Hand(new String[]{"2","5","5","R","2"})),new int[]{0,1}))
        );
   }

}
