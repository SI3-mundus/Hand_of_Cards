import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Color {
    String[] color = new String[5];
    Color(){}
    Color(String[] color){
        this.color = color;
    }
    @Override
    public String toString() {
        String s = "";
        for (String color : color) {
            s+=color+" ";
        }
        return s;
    }
    boolean verifyColor(String color){
        boolean legalcolor = false;
        switch (color){
            case  "":
                break;
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
        return legalcolor;
    }
    int getColor(String color){
        int value =0;
        switch (color){
            case  "":
                break;
            case  "Tr" :
                value=1;
                break;
            case  "Ca" :
                value=2;
                break;
            case  "Co":
                value=3;
                break;
            case  "Pi":
                value=4;
                break;
            default:
                System.out.println("illegal color");
        }
        return value;
    }
}
