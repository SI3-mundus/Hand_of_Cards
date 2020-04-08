public class Chiffre {

        private String chiffre;
        private int valueChiffre;
        Chiffre(String chiffre){
            this.chiffre=chiffre;
            this.valueChiffre=getValueOfChiffre(chiffre);
        }


        String getChiffre(){
            return chiffre;
        }
        int getChiffreValue(){
            return valueChiffre;
        }

    boolean verifyChiffre(){
        boolean legalcard = false;
        switch (chiffre){
            case  "":
                break;
            case  "2" :
                legalcard= true;
                break;
            case  "3" :
                legalcard= true;
                break;
            case  "4":
                legalcard=true;
                break;
            case  "5":
                legalcard=true;
                break;
            case  "6":
                legalcard=true;
                break;
            case  "7":
                legalcard=true;
                break;
            case  "8":
                legalcard=true;
                break;
            case  "9":
                legalcard=true;
                break;
            case  "10":
                legalcard=true;
                break;
            case  "V":
                legalcard=true;
                break;
            case  "D":
                legalcard=true;
                break;
            case  "R":
                legalcard=true;
                break;
            case  "A":
                legalcard=true;
                break;
            default:
                legalcard= false;
        }
        return legalcard;
    }

    int getValueOfChiffre(String chiffre){
        int value=0;
        switch (chiffre){
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
            case  "10":
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

    }
