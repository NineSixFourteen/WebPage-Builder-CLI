package s.s.Interface.CSS_Interfaces.Style_Types;

import java.util.Scanner;

import s.s.CSS.CSSElementBuilder;
import s.s.CSS.StyleFactory;
import s.s.Interface.Tools.UserInput;

public class Text_Interface {


    public static void init(Scanner scan, CSSElementBuilder element) {
        System.out.println(
            new StringBuilder()
             .append("What kind of Text Style would you like to set\n")
             .append("  1.Text Transform\n")
             .append("  2.Text Indent\n")
             .append("  3.Text Shadow\n")
             .append("  4.Text Align")
             .append("0. Go Back")
        );
        int option = UserInput.getIntBewteen(scan,0, 4);
        String value;
        switch(option){
            case 1: 
                value = getTransform(scan);
                break;
            case 2:
                value = UserInput.css.getLength(scan);
                break;
            case 3: 
                value = new StringBuilder()
                 .append(UserInput.css.getLength(scan))
                 .append(" ")
                 .append(UserInput.css.getLength(scan))
                 .append(" ")
                 .append(UserInput.css.getColour(scan))
                 .toString();
                break;
            case 4: 
                value = getAlign(scan);
                break;
            default:
                value = "";
                break;
        }
        element.addStyle(StyleFactory.newText(option, value));
    }

    private static String getAlign(Scanner scan) {
        System.out.println(
            new StringBuilder()
             .append("How would you like to align your text\n")
             .append("  1.Left\n")
             .append("  2.Right\n")
             .append("  3.Center\n")
             .append("  4.Justify")
        );
        int option = UserInput.getIntBewteen(scan, 1, 4);
        switch(option){
            case 1: 
                return "left";
            case 2: 
                return "right";
            case 3: 
                return "centre";
            case 4:
                return "justify";
            default:
                return "";
        }
    }

    private static String getTransform(Scanner scan) {
        System.out.println(
            new StringBuilder()
             .append("Please select your transformation\n")
             .append("  1.Uppercase\n")
             .append("  2.Lowercase\n")
             .append("  3.Capitalize")
        );
        int option = UserInput.getIntBewteen(scan, 1, 3);
        switch(option){
            case 1:
                return "uppercase";
            case 2: 
                return "lowercase";
            case 3: 
                return "capitize";
            default:
                return "";
        }
    }
    
}
