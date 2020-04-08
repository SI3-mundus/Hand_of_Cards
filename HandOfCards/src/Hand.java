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
     List<Card> cards=new ArrayList<>();
    Hand(List<Card> cards){
        this.cards = cards;
    }

    @Override
    public String toString() {
        String s = "";
        for (Card card : cards) {
            s+=card+" ";
        }
        return s;
    }

}
