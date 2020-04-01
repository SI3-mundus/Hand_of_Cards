import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Deal {
    private List<Hand>hands = new ArrayList<Hand>(2);
    private List<String> total=new ArrayList<String>(10);
    Scanner enterCards= new Scanner(System.in);
    private String[] card;
    void initializeMain(){
        for(int i=0; i<2;i++){
            System.out.println("Vous etes la main"+(i+1));
            hands.add(i,new Hand(scanner()));
        }
        for (Hand e: hands){
            System.out.println(" your cards are :" + Arrays.toString(e.cards));
        }
    }

    String[] scanner(){

        System.out.println("Please Enter Your 5 cards");
        String input=enterCards.nextLine();
        card = input.split(" ");
        //System.out.println(Arrays.toString(card)+card.length);
        //for (int i=0;i<card.length;i++){System.out.println(card[i]);}
        while(card.length!=5){
            System.out.println("Please Enter Your 5 cards");
            input=enterCards.nextLine();
            card = input.split(" ");
        }
        for (int i = 0; i < card.length; i++) { valideCard(card[i]);}
        for(int i = 0; i < card.length; i++){total.add(card[i]);}
        valideSame(card);
        return card;
    }

    boolean cardValide(String card){
        boolean legalcard = false;
        switch (card){
            case  "":
                break;
            case  "2" :
                legalcard= true;
                break;
            case  "3" :
                legalcard= true;
                break;
            case  "4":
                legalcard=true;
                break;
            case  "5":
                legalcard=true;
                break;
            case  "6":
                legalcard=true;
                break;
            case  "7":
                legalcard=true;
                break;
            case  "8":
                legalcard=true;
                break;
            case  "9":
                legalcard=true;
                break;
            case  "10":
                legalcard=true;
                break;
            case  "V":
                legalcard=true;
                break;
            case  "D":
                legalcard=true;
                break;
            case  "R":
                legalcard=true;
                break;
            case  "A":
                legalcard=true;
                break;
            default:
                legalcard= false;
        }
        return legalcard;
    }

    void valideCard(String card1) {

        while (!cardValide(card1)) {
            System.out.println("You need to entre your card again,  what you enter is illegal.");
            System.out.println("The card should be one of these: 2,3,4,5,6,7,8,9,10,V,D,R,A");
            card1=enterCards.nextLine();
        }

    }

    void valideSame(String[] card){
        int p=0;
        for (int i = 0; i < card.length; i++) {
            int same=0;
            for (String c: total){
                if(card[i].equals(c)){
                    same++;
                }
                if(same==5){
                    p=total.indexOf(c);
                }
            }

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
                }
            }
        }

    }



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