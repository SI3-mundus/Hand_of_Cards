import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class DealTest {
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
    private Hand Main1;
    private Hand Main2;
    private Hand Main3;
    private List<Hand>hands=new ArrayList<>();
    private Deal deal;


    @BeforeEach
    void setUp() {
        // assigns a very small 2-card deck to each player
        Card card1=new Card(n1,c1);
        Card card2=new Card(n2,c2);
        Card card3=new Card(n3,c3);
        Card card4=new Card(n4,c4);
        /*Card card5=new Card();
        Card card6=new Card();
        Card card7=new Card();
        Card card8=new Card();
        Card card9=new Card();
        Card card10=new Card();
        Card card11=new Card();
        Card card12=new Card();
        Card card13=new Card();

         */
        Card card14=new Card(n6,c3);//illegal card
        Card card15=new Card(n2,c5);//illegal card

        hands.add(Main1);
        hands.add(Main2);
        hands.add(Main3);
        deal=new Deal();
    }




}
