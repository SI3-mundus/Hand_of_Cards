import java.util.ArrayList;

import java.util.List;

public class Verify {


    String theHighestCard(String[] cards){
        String theHighestCard = cards[0];
        int start = getValue(cards[0]);
        for (String e:cards){
            if (start<getValue(e)){
                start=getValue(e);
                theHighestCard=e;
            }

        }
        return theHighestCard;
    }

    List<Integer> getSortedValues(String[] cards){
        List<Integer> nums = new ArrayList<>();
        for (String i : cards){
            nums.add(getValue(i));
        }
        nums.sort(Integer::compareTo);
        return nums;
    }

    List<Integer> getSortedValues(List<String> cards){
        List<Integer> nums = new ArrayList<>();
        for (String i : cards){
            nums.add(getValue(i));
        }
        nums.sort(Integer::compareTo);
        return nums;
    }

    int getColor(String color){
        int value =0;
        switch (color){
            case  "Tr" :
                value=1;
                break;
            case  "Ca" :
                value=2;
                break;
            case  "Co":
                value=3;
                break;
            case  "Pi":
                value=4;
                break;
        }
        return value;
    }
    int getColorValue(String card){
        if(getValue(card.substring(0,1)) == 10){
            return getColor(card.substring(2,4));
        }
        return getColor(card.substring(1,3));
    }
    //返回值从2开始
    int getValue(String card){
        int value=0;
        switch (card.substring(0,1)){
            case  "":
                break;
            case  "2" :
                value= 2;
                break;
            case  "3" :
                value= 3;
                break;
            case  "4":
                value=4;
                break;
            case  "5":
                value=5;
                break;
            case  "6":
                value=6;
                break;
            case  "7":
                value=7;
                break;
            case  "8":
                value=8;
                break;
            case  "9":
                value=9;
                break;
            case  "1":
                value=10;
                break;
            case  "V":
                value=11;
                break;
            case  "D":
                value=12;
                break;
            case  "R":
                value=13;
                break;
            case  "A":
                value=14;
                break;
            default:
                System.out.println("illegal card");
        }
        return value;
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

        }
        return count;
    }
    //返回第一张四次牌的位置
    int isCarre(Hand hand){
        int count[]= numOfSameCard(hand);
        for(int i = 0; i < count.length; i++){
            if(count[i] == 4)
                return i;
        }
        return -1;
    }
    //返回第一张三次牌的位置
    int isBrelan(Hand hand) {
        int count[] = numOfSameCard(hand);
        int c = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                c = -1;
                break;
            }
            if (count[i] == 3)
                c = i;
        }
        return c;
    }
    //c[0]是第一张三次牌的位置c[1]是第一张对子的位置
    int[] isFull (Hand hand){
        int count[] = numOfSameCard(hand);
        int c[] = new int[]{-1, -1};
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 3)
                c[0] = i;
            if (count[i] == 2) {
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
            if (count[i] == 2 && c[0] == -1)
                c[0] = i;
            else if (count[i] == 2) {
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
            if (count[i] == 2 && c[0] == -1)
                c[0] = i;
            else if (count[i] == 2) {
                c[1] = i;
                if(getValue(hand.cards[c[0]]) < getValue(hand.cards[c[1]])){
                    c[1] = c[0];
                    c[0] = i;
                }
            }
        }
        return new int[]{-1, -1};
    }
    //返回顺子中的最大的那一张的位置
    int isSuite (Hand hand){
        List<Integer> nums = new ArrayList<>();
        for (String i : hand.cards){
            nums.add(getValue(i));
        }
        nums.sort(Integer::compareTo);
        for(int i = 1; i < nums.size();i++){
            if(nums.get(i)-nums.get(i-1) != 1) return -1;
        }
        for (int i = 0; i < hand.cards.length; i++){
            if(getValue(hand.cards[i]) == nums.get(nums.size()-1))
                return i;
        }
        return -1;
    }
    //返回同花的颜色
    int isSameColor(Hand hand){
        int c = getColorValue(hand.cards[0]);
        for (int i = 0; i < hand.cards.length; i++) {
            if(c != getColorValue(hand.cards[i])) return -1;
        }

        return c;
    }
    //返回同花顺的最大的那一张的位置
    int isQuinteFlush(Hand hand){
        if(isSameColor(hand)==-1)return -1;
        return isSuite(hand);
    }
    public static void main(String[] args){
        Verify verify=new Verify();
        Hand hand=new Hand(new String[]{"8","10","D","V","9"});
        System.out.println(verify.theHighestCard(hand.cards));
        System.out.println(verify.getValue(verify.theHighestCard(hand.cards)));
    }
}

