import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class CardTest {
    Color c1=new Color("Tr");
    Color c2=new Color("Ca");
    Color c3=new Color("Co");
    Color c4=new Color("Pi");
    Color c5=new Color("Ak");
    Chiffre n1=new Chiffre("2");
    Chiffre n2=new Chiffre("6");
    Chiffre n3=new Chiffre("V");
    Chiffre n4=new Chiffre("10");
    Chiffre n5=new Chiffre("A");
    Chiffre n6=new Chiffre("1");
    Card card1=new Card(n1,c1);
    Card card2=new Card(n2,c2);
    Card card3=new Card(n3,c3);
    Card card4=new Card(n4,c4);
    Card card5=new Card(n5,c1);
    Card card6=new Card(n5,c3);
    Card card7=new Card(n4,c2);
    Card card8=new Card(n6,c3);//illegal card
    Card card9=new Card(n2,c5);//illegal card
    Card card10=new Card(n6,c5);//illegal card

    @Test
    void constructor() {
        assertAll(
                () -> assertNotNull(card3),
                () -> assertNotNull(card7)
        );
    }
    @Test
    void init(){
        assertAll(
                () -> assertEquals(0,card9.color.getColorValue()),
                () -> assertEquals(0,card8.chiffre.getChiffreValue()),
                () -> assertEquals(3,card6.color.getColorValue()),
                () -> assertEquals(11,card3.chiffre.getChiffreValue()),
                () -> assertEquals(14,card5.chiffre.getChiffreValue()),
                () -> assertEquals("VCo",card3.toString())
        );
    }
    @Test
    void cardvalider(){
        assertAll(
                () -> assertTrue(card2.valideCard()),
                () -> assertTrue(card4.valideCard()),
                () -> assertTrue(!card9.valideCard()),
                () -> assertTrue(!card10.valideCard())
        );
    }

}

