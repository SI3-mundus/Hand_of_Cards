public class Card implements Comparable<Card>{


    Color color;
    Chiffre chiffre;

    Card(Chiffre chiffre,Color color){
        this.chiffre=chiffre;
        this.color=color;
    }

    boolean valideCard(){
        if (chiffre.verifyChiffre()==false){
            return false;
        }else if (color.verifyColor()==false){
            return false;
        }else {return true;}
    }

    public String toString() {
        String s=chiffre.getChiffre()+color.getColor();
        return s;
    }

    @Override
    public int compareTo(Card card) {
        if(this.chiffre.getChiffreValue()!=card.chiffre.getChiffreValue()){
            return 0;
        }else if (this.color.getColorValue()!=card.color.getColorValue()){
            return 0;
        }else {
            return 1;
        }
    }
}
