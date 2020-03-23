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
        //String cards;
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

    //返回5张牌中相同牌出现的次数
    //"3Tr", "5Ca", "5Co", "5Tr", "3Co"
    //返回值为[2,3,0,0,0] 3为对子,5出现了3次
    int[] numOfSameCard(Hand hand){
        int count[] =new int[]{0,0,0,0,0};
        for(int i = 0; i < hand.cards.length; i++){
            for(int j = 0; j < hand.cards.length; j++){
                if(j < i && hand.cards[i].toCharArray()[0] == hand.cards[j].toCharArray()[0])break;
                if(hand.cards[i].toCharArray()[0] == hand.cards[j].toCharArray()[0])
                    count[i]++;
            }
            System.out.print(count[i]+" ");
        }
        return count;
    }
    //返回第一张四次牌的位置
    int isCarre(Hand hand){
        int count[]= numOfSameCard(hand);
        for(int i = 0; i < count.length; i++){
            if(i == 4)
                return i;
        }
        return -1;
    }
    //返回第一张三次牌的位置
        int isBrelan(Hand hand) {
            int count[] = numOfSameCard(hand);
            int c = -1;
            for (int i = 0; i < count.length; i++) {
                if (i == 2) {
                    c = -1;
                    break;
                }
                if (i == 3)
                    c = i;
                }
            return c;
        }
        //c[0]是第一张三次牌的位置c[1]是第一张对子的位置
        int[] isFull (Hand hand){
            int count[] = numOfSameCard(hand);
            int c[] = new int[]{-1, -1};
            for (int i = 0; i < count.length; i++) {
                if (i == 3)
                    c[0] = i;
                if (i == 2) {
                    c[1] = i;
                }
            }
            if (c[0] == -1 || c[1] == -1)
                return new int[]{-1, -1};
            return c;
        }

                    //返回第一张对子的位置
        int isPaire (Hand hand){
            int count[] = numOfSameCard(hand);
            int c[] = new int[]{-1, -1};
            for (int i = 0; i < count.length; i++) {
                if (i == 2 && c[0] == -1)
                    c[0] = i;
                else if (i == 2) {
                    c[1] = i;
                    return -1;
                }
            }
            return c[0];
        }
                //返回两对对子分别第一次出现的位置
        int[] isDeuxPaires (Hand hand){
            int count[] = numOfSameCard(hand);
            int c[] = new int[]{-1, -1};
            for (int i = 0; i < count.length; i++) {
                if (i == 2 && c[0] == -1)
                    c[0] = i;
                else if (i == 2) {
                    c[1] = i;
                    return c;
                }
            }
            return new int[]{-1, -1};
    }






    String Winner(){
        return "La main" + " gagne avec ";
    }




    public static void main(String[] args){
        Deal deal = new Deal();
        deal.initializeMain();
        deal.numOfSameCard(deal.hands.get(0));
        System.out.println();
        deal.numOfSameCard(deal.hands.get(1));
//        System.out.println(deal.Winner());
    }
}