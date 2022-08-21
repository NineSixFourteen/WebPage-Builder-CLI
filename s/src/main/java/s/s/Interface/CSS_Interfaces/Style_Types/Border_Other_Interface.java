package s.s.Interface.CSS_Interfaces.Style_Types;

import java.util.Scanner;

import s.s.CSS.CSSElementBuilder;
import s.s.CSS.StyleFactory;
import s.s.Interface.Tools.UserInput;

public class Border_Other_Interface {

    public static void init(Scanner scan, CSSElementBuilder element) {
        System.out.println(
            new StringBuilder()
             .append("What kind of margin would you like to set\n")
             .append("  1.Border Radius\n")
             .append("  2.Border Width\n")
             .append("  3.Border Colour\n")
             .append("0. Go Back")
        );
        int option = UserInput.getIntBewteen(scan,0,3);
        String value;
        switch(option){
            case 1: 
                value = UserInput.getLength(scan);
                element.addStyle(StyleFactory.newBorderOther(option, value));
                break;
            case 2:
                value = UserInput.getLength(scan);
                element.addStyle(StyleFactory.newBorderOther(option, value));
                break;
            case 3: 
                value = UserInput.getColour(scan);
                element.addStyle(StyleFactory.newBorderOther(option, value));
                break;
            default:
        }
    }

    
}
