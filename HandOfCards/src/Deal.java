import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Deal {
    private List<Hand>hands = new ArrayList<Hand>(2);
    private List<String> total=new ArrayList<String>(10);
    void initializeMain(){
        for(int i=0; i<2;i++){
            System.out.println("Vous etes la main"+(i+1));
            hands.add(i,new Hand(scanner()));
//            Hand lHand = new Hand(new String[]{"2Tr", "2Ca", "7Ca", "2Tr", "2Pi"});
 //           Hand rHand = new Hand(new String[]{"3Tr", "5Ca", "5Co", "5Tr", "3Co"});
  //          System.out.println("lHand:"+lHand.toString());
   //         System.out.println("rHand:"+rHand.toString());
    //        hands.add(lHand);
     //       hands.add(rHand);
        }
        for (Hand e: hands){
            System.out.println(" your cards are :" + Arrays.toString(e.cards));
        }
    }

    String[] scanner(){
        Scanner enterCards= new Scanner(System.in);
        String[] card = new String[5];
        System.out.println("Please Enter Your 5 cards");
        for(int i=0; i <card.length;i++){
            System.out.println("Please Enter Your "+(i+1)+" card, and end with enter");
            card[i] = enterCards.nextLine();
            while(!cardValide(card[i])){
                System.out.println("You need to entre your "+(i+1)+" card again,  what you enter is illegal.");
                System.out.println("The card should be one of these: 2,3,4,5,6,7,8,9,10,V,D,R,A");
                card[i] = enterCards.nextLine();
            }
            total.add(card[i]);
            int same=0;
            for (String c: total){
                if(card[i].equals(c)){
                    same++;
                }
            }
            while(same==5){
                System.out.println("The number has already appeared 4 times, it can't apear 5th time.");
                System.out.println("You need to entre your "+(i+1)+" card again");
                card[i] = enterCards.nextLine();
                while(!cardValide(card[i])){
                    System.out.println("You need to entre your "+(i+1)+" card again,  what you enter is illegal.");
                    System.out.println("The card should be one of these: 2,3,4,5,6,7,8,9,10,V,D,R,A");
                    card[i] = enterCards.nextLine();
                }
                total.set(total.size()-1,card[i]);
                same=0;
                for (String c: total){
                    if(card[i].equals(c)){
                        same++;
                    }
                }
            }

        }
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


    String winner(){
        return "La main" + " gagne avec ";
    }




    public static void main(String[] args){
        Deal deal = new Deal();
        deal.initializeMain();
        System.out.println();
    }
}