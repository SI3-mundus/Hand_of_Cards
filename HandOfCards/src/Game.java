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
    private List<Hand> hands = new ArrayList<>(2);
    Hand comparetTo(Hand lhand, Hand rhand){
        int l = getNiveau(lhand),r = getNiveau(rhand);
        Verify v = new Verify();
        if(l>r) return lhand;
        if(l<r) return rhand;
        Hand h = new Hand();
        switch (l){
            case 1:
                if(v.getValue(v.theHighestCard(lhand))>v.getValue(v.theHighestCard(rhand))) h=lhand;
                if(v.getValue(v.theHighestCard(lhand))<v.getValue(v.theHighestCard(rhand))) h=rhand;
            case 2:
                if(v.getValue(v.theHighestCard(lhand))>v.getValue(v.theHighestCard(rhand))) h=lhand;
                if(v.getValue(v.theHighestCard(lhand))<v.getValue(v.theHighestCard(rhand))) h=rhand;;
            case 3:
                if(v.getValue(v.theHighestCard(lhand))>v.getValue(v.theHighestCard(rhand))) h=lhand;
                if(v.getValue(v.theHighestCard(lhand))<v.getValue(v.theHighestCard(rhand))) h=rhand;;
            case 4:
                if(v.getValue(v.theHighestCard(lhand))>v.getValue(v.theHighestCard(rhand))) h=lhand;
                if(v.getValue(v.theHighestCard(lhand))<v.getValue(v.theHighestCard(rhand))) h=rhand;;
            case 5:
                ;
            case 6:
                ;
            case 7:
                if(v.getValue(v.theHighestCard(lhand))>v.getValue(v.theHighestCard(rhand))) h=lhand;
                if(v.getValue(v.theHighestCard(lhand))<v.getValue(v.theHighestCard(rhand))) h=rhand;;
            case 8:
                if(v.getValue(v.theHighestCard(lhand))>v.getValue(v.theHighestCard(rhand))) h=lhand;
                if(v.getValue(v.theHighestCard(lhand))<v.getValue(v.theHighestCard(rhand))) h=rhand;;
            case 9:

        }
        return h;
    }
    int getNiveau(Hand hand){
        Verify v = new Verify();
        if(v.isCarre(hand)!=-1)return 8;
        if(v.isFull(hand)[0]!=-1)return 7;
        if(v.isBrelan(hand)!=-1) return 4;
        if(v.isDeuxPaires(hand)[0]!=-1) return 3;
        if(v.isPaire(hand)!=-1) return 2;
        return 1;
    }
}
