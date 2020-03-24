import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Color {
    String[] color = new String[5];
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
        boolean legalcard = false;
        switch (color){
            case  "":
                break;
            case  "Spade" :
                legalcard= true;
                break;
            case  "Heart" :
                legalcard= true;
                break;
            case  "Diamond":
                legalcard=true;
                break;
            case  "Club":
                legalcard=true;
                break;

            default:
                legalcard= false;
        }
        return legalcard;
    }
}
