public class Card {


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

}
