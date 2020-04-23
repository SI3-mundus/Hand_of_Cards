import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private String[] cardlist1=new String[]{"2Co","5Pi","APi","10Tr","VCa"};
    private String[] cardlist2=new String[]{"1Ca","5Ca","7Ca","10Ca","VCa"};
    private String[] cardlist3=new String[]{"3Pi","3Tr","3Co","3Cr","4Pi"};
    private Hand Main1;
    private Hand Main2;
    private Hand Main3;
    private List<Hand> hands=new ArrayList<>();
    private Verify verify;
    private Game game;

    @BeforeEach
    void setUp() {
        // assigns a very small 2-card deck to each player
        Main1 = new Hand(cardlist1);
        Main2 = new Hand(cardlist2);
        Main3 = new Hand(cardlist3);
        hands.add(Main1);
        hands.add(Main2);
        hands.add(Main3);
        verify=new Verify();
        game =new Game();
    }

    @Test
    void comparetTo(){
        assertAll(
                () -> assertSame(Main2, game.comparetTo(Main1, Main2)),
                () -> assertSame(Main3, game.comparetTo(Main2, Main3)),
                () -> assertSame(Main2, game.comparetTo(Main2, new Hand(new String[]{"4Tr", "5Tr", "6Tr", "7Tr", "9Tr"})))
        );
    }


    @Test
    void getNiveau(){
        assertAll(
                () -> assertEquals(1,game.getNiveau(Main1)),
                () -> assertEquals(6,game.getNiveau(Main2)),
                () -> assertEquals(8,game.getNiveau(Main3))
        );
    }




}
