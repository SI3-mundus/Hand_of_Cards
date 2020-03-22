import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Deal {
    private List<Hand>hands = new ArrayList<Hand>(2);

    void initializeMain(){
        for(int i=0; i<2;i++){
            System.out.println("Vous etes la main"+(i+1));
            hands.add(i,new Hand(scanner()));
        }
    }

    String[] scanner(){
        //String cards;
        Scanner enterCards= new Scanner(System.in);
        String[] card = new String[5];
        System.out.println("Please Enter Your 5 cards");
        for(int i=0; i <card.length;i++){
            System.out.println("Please Enter Your "+(i+1)+" card, and end with enter");
           card[i] = enterCards.nextLine();
           while(card[i].isEmpty()||card[i].isBlank()){
               System.out.println("You need to entre your "+(i+1)+" card, it can't be empty.");
               card[i] = enterCards.nextLine();
           }
        }
        System.out.println(" your cards are :" + Arrays.toString(card));
        return card;
    }



    String Winner(){
        return "La main"+" gagne avec ";
    }


    public static void main(String[] args){
        Deal deal= new Deal();
        deal.initializeMain();
        System.out.println(deal.Winner());
    }
}
