/**
 * Copyright (C), 2015-2020, ZHAOYUQIAO
 * FileName: Game
 * Author:   yuqiao
 * Date:     2020/3/25 15:48
 * Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * @author yuqiao
 * @version 2020/3/25
 */
public class Game {
    private Deal deal = new Deal();

    Hand comparetTo(Hand lhand, Hand rhand){
        int l = getNiveau(lhand),r = getNiveau(rhand);
        Verify v = new Verify();
        if(l>r) return lhand;
        if(l<r) return rhand;
        Hand h = null;
        switch (l){
            case 1:
            case 6: {
                if(v.getValue(v.theHighestCard(lhand))>v.getValue(v.theHighestCard(rhand))) h=lhand;
                else if(v.getValue(v.theHighestCard(lhand))<v.getValue(v.theHighestCard(rhand))) h=rhand;
                break;
            }
            case 2: {
                if (v.getValue(lhand.cards[v.isPaire(lhand)]) > v.getValue(lhand.cards[v.isPaire(rhand)])) h = lhand;
                else if (v.getValue(lhand.cards[v.isPaire(lhand)]) < v.getValue(lhand.cards[v.isPaire(rhand)])) h = rhand;
                break;
            }
            case 3: {
                int[] ln = v.isDeuxPaires(lhand), rn = v.isDeuxPaires(rhand);
                if (v.getValue(lhand.cards[ln[0]]) > v.getValue(lhand.cards[rn[0]])) h = lhand;
                else if (v.getValue(lhand.cards[ln[0]]) < v.getValue(lhand.cards[rn[0]])) h = rhand;
                else if (v.getValue(lhand.cards[ln[1]]) > v.getValue(lhand.cards[rn[1]])) h = lhand;
                else if (v.getValue(lhand.cards[ln[1]]) < v.getValue(lhand.cards[rn[1]])) h = rhand;
                break;
            }
            case 4: {
                if (v.getValue(lhand.cards[v.isBrelan(lhand)]) > v.getValue(lhand.cards[v.isBrelan(rhand)])) h = lhand;
                else if (v.getValue(lhand.cards[v.isBrelan(lhand)]) < v.getValue(lhand.cards[v.isBrelan(rhand)])) h = rhand;
                break;
            }
            case 5: {
                if (v.getValue(lhand.cards[v.isSuite(lhand)]) > v.getValue(lhand.cards[v.isSuite(rhand)])) h = lhand;
                else if (v.getValue(lhand.cards[v.isSuite(lhand)]) < v.getValue(lhand.cards[v.isSuite(rhand)])) h = rhand;
                break;
            }
            case 7: {
                int[] ln1 = v.isFull(lhand), rn1 = v.isFull(rhand);
                if (v.getValue(lhand.cards[ln1[0]]) > v.getValue(lhand.cards[rn1[0]])) h = lhand;
                else if (v.getValue(lhand.cards[ln1[0]]) < v.getValue(lhand.cards[rn1[0]])) h = rhand;
                else if (v.getValue(lhand.cards[ln1[1]]) > v.getValue(lhand.cards[rn1[1]])) h = lhand;
                else if (v.getValue(lhand.cards[ln1[1]]) < v.getValue(lhand.cards[rn1[1]])) h = rhand;
                break;
            }
            case 8: {
                if (v.getValue(lhand.cards[v.isCarre(lhand)]) > v.getValue(lhand.cards[v.isCarre(rhand)])) h = lhand;
                else if (v.getValue(lhand.cards[v.isCarre(lhand)]) < v.getValue(lhand.cards[v.isCarre(rhand)])) h = rhand;
                break;
            }
            case 9: {
                if (v.getValue(lhand.cards[v.isQuinteFlush(lhand)]) > v.getValue(lhand.cards[v.isQuinteFlush(rhand)])) h = lhand;
                else if (v.getValue(lhand.cards[v.isQuinteFlush(lhand)]) < v.getValue(lhand.cards[v.isQuinteFlush(rhand)])) h = rhand;
                break;
            }
        }
        return h;
    }

    int getNiveau(Hand hand){
        Verify v = new Verify();
        if(v.isQuinteFlush(hand)!=-1)return 9;
        if(v.isCarre(hand)!=-1)return 8;
        if(v.isFull(hand)[0]!=-1)return 7;
        if(v.isSameColor(hand)!=-1)return 6;
        if(v.isSuite(hand)!=-1)return 5;
        if(v.isBrelan(hand)!=-1) return 4;
        if(v.isDeuxPaires(hand)[0]!=-1) return 3;
        if(v.isPaire(hand)!=-1) return 2;
        return 1;
    }
    
    void start(){
        deal.initializeMain();
        if(comparetTo(deal.getHands().get(0),deal.getHands().get(1)) == deal.getHands().get(0)){
            System.out.println("La main 1" + " gagne avec "+deal.getHands().get(0).toString());
        }else if(comparetTo(deal.getHands().get(0),deal.getHands().get(1)) == deal.getHands().get(1)){
            System.out.println( "La main 2" + " gagne avec "+deal.getHands().get(1).toString());
        }
        else {
            System.out.println( "C'est un match nul");
        }
    }

    public static void main(String[] args){
        Game g = new Game();
        g.start();
    }
}

//    2Tr 3Ca 4Ca 5Tr 6Pi
//    3Tr 5Ca 9Ca DCo RCo