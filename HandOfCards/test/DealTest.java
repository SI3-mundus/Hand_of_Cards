import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DealTest {
    String card1="R";
    String card2="15";
    String card3="7";
    String[] cardlist1=new String[]{"2","5","A","10","V"};
    String[] cardlist2=new String[]{"1","5","7","10","V"};
    String[] cardlist3=new String[]{"3","3","3","3","3"};
    private Hand Main1;
    private Hand Main2;
    private Hand Main3;
    private List<Hand>hands;
    private Deal deal;

    @BeforeEach
    void setUp() {
        // assigns a very small 2-card deck to each player
        Main1 = new Hand(cardlist1);
        Main2 = new Hand(cardlist2);
        Main3 = new Hand(cardlist3);
        deal=new Deal();
    }

    @Test
    void cardvalider(){
        assertAll(
                () -> assertTrue(deal.cardValide(card1)),
                () -> assertTrue(!deal.cardValide(card2)),
                () -> assertTrue(deal.cardValide(card3))
        );
    }


}
