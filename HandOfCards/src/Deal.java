import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Deal {
    private List<Hand>hands = new ArrayList<Hand>(2);
    void initializeMain(){
        for(int i=0; i<2;i++){
//            System.out.println("Vous etes la main"+(i+1));
//            hands.add(i,new Hand(scanner()));
            Hand lHand = new Hand(new String[]{"2Tr", "2Ca", "7Ca", "2Tr", "2Pi"});
            Hand rHand = new Hand(new String[]{"3Tr", "5Ca", "5Co", "5Tr", "3Co"});
            System.out.println("lHand:"+lHand.toString());
            System.out.println("rHand:"+rHand.toString());
            hands.add(lHand);
            hands.add(rHand);

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
    int isBrelan(Hand hand){
        int count[]= numOfSameCard(hand);
        int c = -1;
        for(int i = 0; i < count.length; i++){
            if(i == 2) {
                c = -1;
                break;
            }
            if(i == 3)
                c = i;
        }
        return c;
    }
    //c[0]是第一张三次牌的位置c[1]是第一张对子的位置
    int[] isFull(Hand hand){
        int count[]= numOfSameCard(hand);
        int c[] = new int[]{-1,-1};
        for(int i = 0; i < count.length; i++){
            if(i == 3)
                c[0] = i;
            if(i == 2) {
                c[1] = i;
            }
        }
        if(c[0] == -1 || c[1] == -1)
            return new int[]{-1,-1};
        return c;
    }
    //返回第一张对子的位置
    int isPaire(Hand hand){
        int count[]= numOfSameCard(hand);
        int c[] = new int[]{-1,-1};
        for(int i = 0; i < count.length; i++){
            if(i == 2 && c[0]==-1)
                c[0] = i;
            else if(i == 2) {
                c[1] = i;
                return -1;
            }
        }
        return c[0];
    }
    //返回两对对子分别第一次出现的位置
    int[] isDeuxPaires(Hand hand){
        int count[]= numOfSameCard(hand);
        int c[] = new int[]{-1,-1};
        for(int i = 0; i < count.length; i++){
            if(i == 2 && c[0]==-1)
                c[0] = i;
            else if(i == 2) {
                c[1] = i;
                return c;
            }
        }
        return new int[]{-1,-1};
    }


    String Winner(){
        return "La main"+" gagne avec ";
    }


    public static void main(String[] args){
        Deal deal= new Deal();
        deal.initializeMain();
        deal.numOfSameCard(deal.hands.get(0));
        System.out.println();
        deal.numOfSameCard(deal.hands.get(1));
//        System.out.println(deal.Winner());
    }
}
