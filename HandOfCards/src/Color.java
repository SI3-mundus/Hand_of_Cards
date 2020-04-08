import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Color {
<<<<<<< HEAD
    String color;
    int valueColor;
    Color(String color){
=======
    String[] color;
    Color(String[] color){
>>>>>>> c0588f5405f61daa17a1592cf8e484f922652fb7
        this.color = color;
        valueColor=getValueOfColor(color);
    }

    public String getColor() {
        return color;
    }
    public int getColorValue(){
        return valueColor;
    }

    boolean verifyColor(){
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
    int getValueOfColor(String color){
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
                System.out.println("illegal card");
        }
        return value;
    }
}