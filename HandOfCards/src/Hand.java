/**
 * Copyright (C), 2015-2020, ZHAOYUQIAO
 * FileName: Hand
 * Author:   yuqiao
 * Date:     2020/3/12 11:36
 * Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 
 * @author yuqiao
 * @version 2020/3/12
 */
public class Hand {
<<<<<<< HEAD
     List<Card> cards=new ArrayList<>();
    Hand(List<Card> cards){
=======
    String[] cards = new String[5];
    Hand(String[] cards){
>>>>>>> c0588f5405f61daa17a1592cf8e484f922652fb7
        this.cards = cards;
    }
    Hand(){}

    @Override
    public String toString() {
        String s = "";
        for (Card card : cards) {
            s+=card+" ";
        }
        return s;
    }

}
