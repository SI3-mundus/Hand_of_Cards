import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
class VerifyTest {
    String[] cardlist1=new String[]{"2Co","5Pi","APi","10Tr","VCa"};
    String[] cardlist2=new String[]{"1Ca","5Ca","7Ca","10Ca","VCa"};
    String[] cardlist3=new String[]{"3Pi","3Tr","3Co","3Cr","4Pi"};
    private Hand Main1;
    private Hand Main2;
    private Hand Main3;
    private List<Hand> hands=new ArrayList<>();
    private Verify verify;




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


    }
    @Test
    void theHighestCard() {
        assertEquals("APi", verify.theHighestCard(cardlist1));
        assertEquals("VCa",verify.theHighestCard(cardlist2));
    }

    @Test
    void getValue() {
        assertEquals(10,verify.getValue(cardlist1[3]));
    }

    @Test
    void numOfSameCard(){
        String[] cardlist = new String[]{"3Tr", "5Ca", "5Co", "5Tr", "3Co"};
        int count[] =verify.numOfSameCard(new Hand(cardlist));
        assertEquals(2,count[0]);
    }

    @org.junit.jupiter.api.Test
    void isCarre() {
        assertEquals(0,verify.isCarre(Main3));
    }

    @org.junit.jupiter.api.Test
    void isBrelan() {
        String[] cardlist=new String[]{"2Co","5Pi","5Pi","5Tr","VCa"};
        assertEquals(1,verify.isBrelan(new Hand(cardlist)));
    }

    @org.junit.jupiter.api.Test
    void isFull() {
        String[] cardlist = new String[]{"3Tr", "5Ca", "5Co", "5Tr", "3Co"};
        int count[]=verify.isFull(new Hand(cardlist));
        assertEquals(1,count[0]);
    }

    @org.junit.jupiter.api.Test
    void isPaire() {
        String[] cardlist = new String[]{"3Tr", "3Ca", "5Co", "6Tr", "7Co"};
        int count[]=verify.isFull(new Hand(cardlist));
        assertEquals(-1,count[1]);
    }

    @org.junit.jupiter.api.Test
    void isDeuxPaires() {
        String[] cardlist = new String[]{"3Tr", "3Ca", "5Co", "5Tr", "9Co"};
        int count[]=verify.isFull(new Hand(cardlist));
        assertEquals(-1,count[0]);
    }

}