package s.s.Interface.CSS_Interfaces.Style_Types;

import java.util.Scanner;


import s.s.CSS.CSSElementBuilder;
import s.s.CSS.StyleFactory;
import s.s.Interface.Tools.UserInput;

public class Outline_Interface {


    public static void init(Scanner scan, CSSElementBuilder element) {
        System.out.println(
            new StringBuilder()
             .append("What kind of margin would you like to set\n")
             .append("  1.Outline Style\n")
             .append("  2.Outline colour\n")
             .append("  3.Outline Width\n")
             .append("  4.Outline Offset")
             .append("  5.Outline")
             .append("0. Go Back")
        );
        int option = UserInput.getIntBewteen(scan,0,3);
        String value;
        switch(option){
            case 1: 
            case 2:
            case 3: 
            case 4: 
                value = UserInput.css.getLength(scan);
                element.addStyle(StyleFactory.newBorderOther(option, value));
                break;
            case 5: 
                System.out.println(
                    new StringBuilder()
                     .append("Please enter the following info seperated by spaces\n")
                     .append("  1.Style\n")
                     .append("  2.Colour\n")
                     .append("  3.Width\n")
                     .append("  4.Offset\n")
                );
                value = UserInput.getLine(scan);
                element.addStyle(StyleFactory.newBorderOther(option, value));
            break;
            default:
        }
    }
    
}
