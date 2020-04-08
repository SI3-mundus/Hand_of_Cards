import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deal {
    private List<Hand>hands = new ArrayList<Hand>();

    private List<Card> total=new ArrayList<>();

    void initializeMain(){
        for(int i=0; i<2;i++){
            System.out.println("Vous etes la main"+(i+1));
            hands.add(i,new Hand(scanner()));
        }
        for (Hand e: hands){
            System.out.println(" your cards are :" + e);
        }
    }

    List<Card> scanner(){
        String[] card;
        List<Card> cards=new ArrayList<>();
        Scanner enterCards= new Scanner(System.in);
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



    boolean valideSame(List<Card> cards) {

        for (int i = 0; i <5; i++) {
            int same = 0;
            for (Card c : total) {
                if (c.equals(cards.get(i))) {
                    same++;
                }
                System.out.println(same);

                if (same == 2) {
                    System.out.println("The card has already appeared, it can't apear 2 times.");
                    System.exit(1);
                }
            }

        }
        return true;
    }



    String winner(){
        return "La main" + " gagne avec ";
    }




    public static void main(String[] args){
        Deal deal = new Deal();
        //deal.valideCard("77");
        deal.initializeMain();
        //System.out.println();
    }
}