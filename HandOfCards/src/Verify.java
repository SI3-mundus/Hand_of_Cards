public class Verify {


    int theHighestCard(Hand hand){
        String theHighestCard=hand.cards[0];
        int start=getValue(hand.cards[0]);
        for (String e:hand.cards){
            if (start<getValue(e)){
                start=getValue(e);
                theHighestCard=e;
            }
        }
        return getValue(theHighestCard);
    }
    int getValue(String card){
        int value=0;
        switch (card.toCharArray()[0]){
            case  '2' :
                value=1;
                break;
            case  '3' :
                value=2;
                break;
            case  '4':
                value=3;
                break;
            case  '5':
                value=4;
                break;
            case  '6':
                value=5;
                break;
            case  '7':
                value=6;
                break;
            case  '8':
                value=7;
                break;
            case  '9':
                value=8;
                break;
            case  '1':
                value=9;
                break;
            case  'V':
                value=10;
                break;
            case  'D':
                value=11;
                break;
            case  'R':
                value=12;
                break;
            case  'A':
                value=13;
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
            System.out.print(count[i]+" ");
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
                return c;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        Verify verify=new Verify();
        Hand hand=new Hand(new String[]{"2", "4","6","V","7"});
        System.out.println(verify.theHighestCard(hand));
    }
}

