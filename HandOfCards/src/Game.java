/**
 * Copyright (C), 2015-2020, ZHAOYUQIAO
 * FileName: Game
 * Author:   yuqiao
 * Date:     2020/3/25 15:48
 * Description:
 */

import java.util.ArrayList;
import java.util.Arrays;
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
            case 5: {
                for(int i = v.getSortedValues(lhand.cards).size()-1; i >= 0 ; i--){
                    if(v.getSortedValues(lhand.cards).get(i)>v.getSortedValues(rhand.cards).get(i)) {h = lhand;break;}
                    if(v.getSortedValues(lhand.cards).get(i)<v.getSortedValues(rhand.cards).get(i)) {h = rhand;break;}
                }
                break;
            }
            case 6: {
                if (v.isBrelan(lhand) != -1 && v.isBrelan(rhand) == -1) {h = lhand;break;}
                if (v.isBrelan(rhand) != -1 && v.isBrelan(lhand) == -1) {h = rhand;break;}
                if (v.isBrelan(rhand) != -1 && v.isBrelan(lhand) != -1) {
                    if (v.getValue(lhand.cards[v.isBrelan(lhand)]) > v.getValue(rhand.cards[v.isBrelan(rhand)])) {h = lhand;break;}
                else if (v.getValue(lhand.cards[v.isBrelan(lhand)]) < v.getValue(rhand.cards[v.isBrelan(rhand)])) {h = rhand;break;}
                }
                if (v.isDeuxPaires(lhand)[0] != -1 && v.isDeuxPaires(rhand)[0] == -1) {h = lhand;break;}
                if (v.isDeuxPaires(rhand)[0] != -1 && v.isDeuxPaires(lhand)[0] == -1) {h = rhand;break;}
                if (v.isDeuxPaires(rhand)[0] != -1 && v.isDeuxPaires(lhand)[0] != -1) {
                    if (v.getValue(lhand.cards[v.isDeuxPaires(lhand)[0]]) > v.getValue(rhand.cards[v.isDeuxPaires(rhand)[0]])) {h = lhand;break;}
                    else if (v.getValue(lhand.cards[v.isDeuxPaires(lhand)[0]]) < v.getValue(rhand.cards[v.isDeuxPaires(rhand)[0]])) {h = rhand;break;}
                    else if (v.getValue(lhand.cards[v.isDeuxPaires(lhand)[1]]) > v.getValue(rhand.cards[v.isDeuxPaires(rhand)[1]])) {h = lhand;break;}
                    else if (v.getValue(lhand.cards[v.isDeuxPaires(lhand)[1]]) < v.getValue(rhand.cards[v.isDeuxPaires(rhand)[1]])) {h = rhand;break;}
                }
                if (v.isPaire(lhand) != -1 && v.isPaire(rhand) == -1) {h = lhand;break;}
                if (v.isPaire(rhand) != -1 && v.isPaire(lhand) == -1) {h = rhand;break;}
                if (v.isPaire(rhand) != -1 && v.isPaire(lhand) != -1) {
                    if (v.getValue(lhand.cards[v.isPaire(lhand)]) > v.getValue(rhand.cards[v.isPaire(rhand)])) {h = lhand;break;}
                    else if (v.getValue(lhand.cards[v.isPaire(lhand)]) < v.getValue(rhand.cards[v.isPaire(rhand)])) {h = rhand;break;}
                }
                for(int i = v.getSortedValues(lhand.cards).size()-1; i >= 0 ; i--){
                    if(v.getSortedValues(lhand.cards).get(i)>v.getSortedValues(rhand.cards).get(i)) {h = lhand;break;}
                    if(v.getSortedValues(lhand.cards).get(i)<v.getSortedValues(rhand.cards).get(i)) {h = rhand;break;}
                }
                break;
            }
            case 2: {
                if (v.getValue(lhand.cards[v.isPaire(lhand)]) > v.getValue(rhand.cards[v.isPaire(rhand)])) {h = lhand;break;}
                else if (v.getValue(lhand.cards[v.isPaire(lhand)]) < v.getValue(rhand.cards[v.isPaire(rhand)])) {h = rhand;break;}
                List<String> values_l = new ArrayList<>(Arrays.asList(lhand.cards));
                List<String> values_r = new ArrayList<>(Arrays.asList(rhand.cards));
                for (int i = values_l.size()-1; i >=0; i--) {
                    if (v.getValue(lhand.cards[v.isPaire(lhand)]) == v.getValue(values_l.get(i))) { values_l.remove(i);}
                    if (v.getValue(rhand.cards[v.isPaire(rhand)]) == v.getValue(values_r.get(i))) { values_r.remove(i);}
                }
                for(int i = v.getSortedValues(values_l).size()-1; i >= 0 ; i--){
                    if(v.getSortedValues(values_l).get(i)>v.getSortedValues(values_r).get(i)) {h = lhand;break;}
                    if(v.getSortedValues(values_l).get(i)<v.getSortedValues(values_r).get(i)) {h = rhand;break;}
                }
                break;
            }
            case 3: {
                int[] ln = v.isDeuxPaires(lhand), rn = v.isDeuxPaires(rhand);
                if (v.getValue(lhand.cards[v.isDeuxPaires(lhand)[0]]) > v.getValue(rhand.cards[v.isDeuxPaires(rhand)[0]])) {h = lhand;break;}
                else if (v.getValue(lhand.cards[v.isDeuxPaires(lhand)[0]]) < v.getValue(rhand.cards[v.isDeuxPaires(rhand)[0]])) {h = rhand;break;}
                else if (v.getValue(lhand.cards[v.isDeuxPaires(lhand)[1]]) > v.getValue(rhand.cards[v.isDeuxPaires(rhand)[1]])) {h = lhand;break;}
                else if (v.getValue(lhand.cards[v.isDeuxPaires(lhand)[1]]) < v.getValue(rhand.cards[v.isDeuxPaires(rhand)[1]])) {h = rhand;break;}
                List<String> values_l = new ArrayList<>(Arrays.asList(lhand.cards));
                List<String> values_r = new ArrayList<>(Arrays.asList(rhand.cards));
                for (int i = values_l.size()-1; i >=0; i--) {
                    if (v.getValue(lhand.cards[v.isDeuxPaires(lhand)[0]]) == v.getValue(values_l.get(i))) { values_l.remove(i); }
                    if (v.getValue(lhand.cards[v.isDeuxPaires(lhand)[1]]) == v.getValue(values_l.get(i))) { values_l.remove(i); }
                    if (v.getValue(rhand.cards[v.isDeuxPaires(rhand)[0]]) == v.getValue(values_r.get(i))) { values_r.remove(i); }
                    if (v.getValue(rhand.cards[v.isDeuxPaires(rhand)[1]]) == v.getValue(values_r.get(i))) { values_r.remove(i); }
                }
                for(int i = v.getSortedValues(values_l).size()-1; i >= 0 ; i--){
                    if(v.getSortedValues(values_l).get(i)>v.getSortedValues(values_r).get(i)) {h = lhand;break;}
                    if(v.getSortedValues(values_l).get(i)<v.getSortedValues(values_r).get(i)) {h = rhand;break;}
                }
                break;
            }
            case 4: {
                if (v.getValue(lhand.cards[v.isBrelan(lhand)]) > v.getValue(rhand.cards[v.isBrelan(rhand)])) {h = lhand;break;}
                else if (v.getValue(lhand.cards[v.isBrelan(lhand)]) < v.getValue(rhand.cards[v.isBrelan(rhand)])) {h = rhand;break;}
                List<String> values_l = new ArrayList<>(Arrays.asList(lhand.cards));
                List<String> values_r = new ArrayList<>(Arrays.asList(rhand.cards));
                for (int i = values_l.size()-1; i >=0; i--) {
                    if (v.getValue(lhand.cards[v.isBrelan(lhand)]) == v.getValue(values_l.get(i))) { values_l.remove(i); }
                    if (v.getValue(rhand.cards[v.isBrelan(rhand)]) == v.getValue(values_l.get(i))) { values_l.remove(i); }
                }
                for(int i = v.getSortedValues(values_l).size()-1; i >= 0 ; i--){
                    if(v.getSortedValues(values_l).get(i)>v.getSortedValues(values_r).get(i)) {h = lhand;break;}
                    if(v.getSortedValues(values_l).get(i)<v.getSortedValues(values_r).get(i)) {h = rhand;break;}
                }
                break;
            }
            case 7: {
                int[] ln1 = v.isFull(lhand), rn1 = v.isFull(rhand);
                if (v.getValue(lhand.cards[ln1[0]]) > v.getValue(rhand.cards[rn1[0]])) h = lhand;
                else if (v.getValue(lhand.cards[ln1[0]]) < v.getValue(rhand.cards[rn1[0]])) h = rhand;
                else if (v.getValue(lhand.cards[ln1[1]]) > v.getValue(rhand.cards[rn1[1]])) h = lhand;
                else if (v.getValue(lhand.cards[ln1[1]]) < v.getValue(rhand.cards[rn1[1]])) h = rhand;
                break;
            }
            case 8: {
                if (v.getValue(lhand.cards[v.isCarre(lhand)]) > v.getValue(rhand.cards[v.isCarre(rhand)])) {h = lhand;break;}
                else if (v.getValue(lhand.cards[v.isCarre(lhand)]) < v.getValue(rhand.cards[v.isCarre(rhand)])) {h = rhand;break;}
                List<String> values_l = new ArrayList<>(Arrays.asList(lhand.cards));
                List<String> values_r = new ArrayList<>(Arrays.asList(rhand.cards));
                for (int i = values_l.size()-1; i >=0; i--) {
                    if (v.getValue(lhand.cards[v.isCarre(lhand)]) == v.getValue(values_l.get(i))) { values_l.remove(i); }
                    if (v.getValue(rhand.cards[v.isCarre(rhand)]) == v.getValue(values_l.get(i))) { values_l.remove(i); }
                }
                for(int i = v.getSortedValues(values_l).size()-1; i >= 0 ; i--){
                    if(v.getSortedValues(values_l).get(i)>v.getSortedValues(values_r).get(i)) {h = lhand;break;}
                    if(v.getSortedValues(values_l).get(i)<v.getSortedValues(values_r).get(i)) {h = rhand;break;}
                }
                break;
            }
            case 9: {
                if (v.getValue(lhand.cards[v.isQuinteFlush(lhand)]) > v.getValue(rhand.cards[v.isQuinteFlush(rhand)])) h = lhand;
                else if (v.getValue(lhand.cards[v.isQuinteFlush(lhand)]) < v.getValue(rhand.cards[v.isQuinteFlush(rhand)])) h = rhand;
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

//    ATr ACa VCa 4Tr 9Pi
//    APi ACo DCa 4Co 8Tr