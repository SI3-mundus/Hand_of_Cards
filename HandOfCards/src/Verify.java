public class Verify {


    Card theHighestCard(Hand hand) {
        Card theHighestCard = hand.cards.get(0);
        int start = hand.cards.get(0).chiffre.getChiffreValue();
        for (Card e : hand.cards) {
            if (start < e.chiffre.getChiffreValue()) {
                start = e.chiffre.getChiffreValue();
                theHighestCard = e;
            }
        }
        return theHighestCard;
    }
}

    //返回5张牌中相同牌出现的次数
    //"3Tr", "5Ca", "5Co", "5Tr", "3Co"
    //返回值为[2,3,0,0,0] 3为对子,5出现了3次
   /* int[] numOfSameCard(Hand hand){
        int count[] =new int[]{0,0,0,0,0};
        for(int i = 0; i < hand.cards.size(); i++){
            for(int j = 0; j < hand.cards.size(); j++){
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

    public static void main(String[] args){
        Verify verify=new Verify();
        //Hand hand=new Hand();
        System.out.println(verify.theHighestCard(hand));
    }
}

    */

