import java.util.Arrays;
import java.util.Scanner;

public class Deal {
    Hand hand;
    void  Scanner(){
        //String cards;
        Scanner enterCards= new Scanner(System.in);
        String[] card = new String[5];
        System.out.println("Please Enter Your 5 cards");
        for(int i=0; i <card.length;i++){
            System.out.println("ScannerTest, Please Enter Your "+(i+1)+" card, and end with enter");
           card[i] = enterCards.nextLine();
           if(card[i].isEmpty()||card[i].isBlank()){
               System.out.println("You need to entre your card, it can't be empty.");
               card[i] = enterCards.nextLine();
           }
        }
        hand=new Hand(card);
        System.out.println(" your cards are :" + Arrays.toString(hand.cards));

    }
    
    public static void main(String[] args){
        Deal deal= new Deal();
        deal.Scanner();
    }
}
