/**
 * Copyright (C), 2015-2020, ZHAOYUQIAO
 * FileName: Hand
 * Author:   yuqiao
 * Date:     2020/3/12 11:36
 * Description:
 */

/**
 * Description: 
 * @author yuqiao
 * @version 2020/3/12
 */
public class Hand {
    private String[] cards = new String[5];
    Hand(String cards){
        this.cards = cards.split(" " );
    }
}
