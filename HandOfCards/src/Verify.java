public class Verify {


    String theHighestCard(Hand hand){
        String theHighestCard=hand.cards[0];
        int start=getValue(hand.cards[0]);
        for (String e:hand.cards){
            if (start<getValue(e)){
                start=getValue(e);
                theHighestCard=e;
            }
        }
        return theHighestCard;
    }

    int getValue(String card){
        int value=0;
        switch (card){
            case  "":
                break;
            case  "2" :
                value= 1;
                break;
            case  "3" :
                value= 2;
                break;
            case  "4":
                value=3;
                break;
            case  "5":
                value=4;
                break;
            case  "6":
                value=5;
                break;
            case  "7":
                value=6;
                break;
            case  "8":
                value=7;
                break;
            case  "9":
                value=8;
                break;
            case  "10":
                value=9;
                break;
            case  "V":
                value=10;
                break;
            case  "D":
                value=11;
                break;
            case  "R":
                value=12;
                break;
            case  "A":
                value=13;
                break;
            default:
                System.out.println("illegal card");
        }
        return value;
    }

    public static void main(String[] args){
        Verify verify=new Verify();
        Hand hand=new Hand(new String[]{"2", "4","6","V","7"});
        System.out.println(verify.theHighestCard(hand));
    }
}

