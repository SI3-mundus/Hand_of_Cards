import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deal {
<<<<<<< HEAD
    private List<Hand>hands = new ArrayList<Hand>();
    private List<Card> total=new ArrayList<>();

=======
    private List<Hand>hands = new ArrayList<Hand>(2);
    private List<String> total=new ArrayList<String>(10);
    Scanner enterCards= new Scanner(System.in);
    private String[] card;
>>>>>>> c0588f5405f61daa17a1592cf8e484f922652fb7
    void initializeMain(){
        for(int i=0; i<2;i++){
            System.out.println("Vous etes la main"+(i+1));
            hands.add(i,new Hand(scanner()));
        }
        for (Hand e: hands){
            System.out.println(" your cards are :" + e);
        }
    }

<<<<<<< HEAD
    List<Card> scanner(){
        String[] card;
        List<Card> cards=new ArrayList<>();
        Scanner enterCards= new Scanner(System.in);
=======
    String[] scanner(){

>>>>>>> c0588f5405f61daa17a1592cf8e484f922652fb7
        System.out.println("Please Enter Your 5 cards");
        String input=enterCards.nextLine();
        card = input.split(" ");
        if (card.length!=5){System.exit(1);}
        System.out.println(Arrays.toString(card)+"/d"+card.length);

        List<Color> colors=new ArrayList<>();
        List<Chiffre> chiffres=new ArrayList<>();
        for (int i = 0; i < card.length; i++) {

            String c=Pattern.compile("[^(a-zA-Z)]").matcher(card[i]).replaceAll("").trim();
            System.out.println();
            colors.add(new Color(c));
            String n=Pattern.compile("[^0-9]").matcher(card[i]).replaceAll("").trim();
            chiffres.add(new Chiffre(n));
        }
        for (int i=0;i<5;i++){
            cards.add(new Card(chiffres.get(i),colors.get(i)));
            if (!cards.get(i).valideCard()){System.exit(1);}
            System.out.println("test");
            total.add(cards.get(i));
            //for(Card e:total){System.out.print(e.toString());}
            //System.out.println("88");
            //for(Card e:cards){System.out.print(e.toString());}
        }
        //System.out.println("end TEST");
        valideSame(cards);
        return cards;
    }


<<<<<<< HEAD

    boolean valideSame(List<Card> cards) {

        for (int i = 0; i <cards.size(); i++) {
            int same = 0;
            for (Card c : total) {
                if (cards.get(i).compareTo(c)==1) {
=======
        while (!cardValide(card1)) {
            System.out.println("You need to entre your card again,  what you enter is illegal.");
            System.out.println("The card should be one of these: 2,3,4,5,6,7,8,9,10,V,D,R,A");
            card1=enterCards.nextLine();
        }

<<<<<<< HEAD
=======
    }

    void valideSame(String[] card){
        int p=0;
        for (int i = 0; i < card.length; i++) {
            int same=0;
            for (String c: total){
                if(card[i].equals(c)){
>>>>>>> c0588f5405f61daa17a1592cf8e484f922652fb7
                    same++;
                }
                System.out.println(same);

<<<<<<< HEAD
                while (same == 2) {
                    System.out.println("The card has already appeared, it can't apear 2 times.");
                    System.exit(1);
=======
            while (same==5){
                System.out.println("The number has already appeared 4 times, it can't apear 5th time.");
                System.out.println("You need to entre your "+(i+1)+"th card again");
                card[i] = enterCards.nextLine();
                while (!cardValide(card[i])) {
                    System.out.println("You need to entre your card again,  what you enter is illegal.");
                    System.out.println("The card should be one of these: 2,3,4,5,6,7,8,9,10,V,D,R,A");
                    card[i]=enterCards.nextLine();
                }
                System.out.println(card[i]);
                total.set(p,card[i]);
                same=0;
                for (String c: total){
                    if(card[i].equals(c)){
                        same++;
                    }
>>>>>>> c0588f5405f61daa17a1592cf8e484f922652fb7
                }

            }

        }
        return true;
    }



>>>>>>> 7789a88acd288d8cb0f050a453544322e6b9ee5d
    String winner(){
        return "La main" + " gagne avec ";
    }




    public static void main(String[] args){
        Deal deal = new Deal();
        deal.valideCard("7");
        //deal.initializeMain();
        //System.out.println();
    }
}