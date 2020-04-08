
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Deal {
    private List<Hand> hands = new ArrayList<Hand>(2);
    private List<String> total=new ArrayList<String>(10);
    private String[] cards;
    void initializeMain(){
        for(int i=0; i<2;i++){
            System.out.println("Vous etes la main"+(i+1));
            hands.add(i,new Hand(scanner()));
        }
        for (Hand e: hands){
            System.out.println(" your cards are :" + Arrays.toString(e.cards));
        }
    }

    String[] scanner(){
        Scanner enterCards= new Scanner(System.in);
        System.out.println("Please Enter Your 5 cards");
        String input=enterCards.nextLine();
        cards = input.split(" ");
        if(cards.length!=5){
            System.out.println("what you enter is illegal.");
            System.exit(1);
        }
        for (int i = 0; i < cards.length; i++) { valideCard(cards[i]);}
        total.addAll(Arrays.asList(cards));
        valideSame(cards);
        return cards;
    }
    boolean numValide(String card){
        boolean legalnum = false;
        switch (card.substring(0,1)){
            case  "2" :
                legalnum= true;
                break;
            case  "3" :
                legalnum= true;
                break;
            case  "4":
                legalnum=true;
                break;
            case  "5":
                legalnum=true;
                break;
            case  "6":
                legalnum=true;
                break;
            case  "7":
                legalnum=true;
                break;
            case  "8":
                legalnum=true;
                break;
            case  "9":
                legalnum=true;
                break;
            case  "1":
                if(card.substring(0,2).equals("10")) legalnum=true;
                break;
            case  "V":
                legalnum=true;
                break;
            case  "D":
                legalnum=true;
                break;
            case  "R":
                legalnum=true;
                break;
            case  "A":
                legalnum=true;
                break;
            default:
                legalnum= false;
        }
        return legalnum;
    }
    boolean colorValide(String card){
        boolean legalcolor = false;
        if(card.substring(0,1).equals("1")){
            switch (card.substring(2,4)){
                case  "Tr" :
                    legalcolor= true;
                    break;
                case  "Ca" :
                    legalcolor= true;
                    break;
                case  "Co":
                    legalcolor=true;
                    break;
                case  "Pi":
                    legalcolor=true;
                    break;
                default:
                    legalcolor= false;
            }
        }else{
            switch (card.substring(1,3)){
                case  "Tr" :
                    legalcolor= true;
                    break;
                case  "Ca" :
                    legalcolor= true;
                    break;
                case  "Co":
                    legalcolor=true;
                    break;
                case  "Pi":
                    legalcolor=true;
                    break;
                default:
                    legalcolor= false;
            }
        }
        return legalcolor;
    }
    boolean cardValide(String card){
        if(!numValide(card)) return false;
        return colorValide(card);
    }
    void valideCard(String card) {
        while (!cardValide(card)) {
            System.out.println("what you enter is illegal.");
            System.exit(1);
        }

    }

    void valideSame(String[] cards){
        Scanner scanner=new Scanner(System.in);
        int p=0;
        for (String card : cards) {
            int same = 0;
            for (String c : total) {
                if (card.equals(c)) {
                    same++;
                }
            }
            if (same > 1) {
                System.out.println("The card has already appeared, it can't apear 2 times.");
                System.exit(1);
            }

        }

    }

    List<Hand> getHands(){return hands;}






    public static void main(String[] args){
        Deal deal = new Deal();
        //deal.valideCard("77");
        deal.initializeMain();
        //System.out.println();
    }
}