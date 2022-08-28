package s.s.Interface.CSS_Interfaces.Style_Types;

import java.util.Scanner;


import s.s.CSS.CSSElementBuilder;
import s.s.CSS.StyleFactory;
import s.s.Interface.Tools.CSSInput;
import s.s.Interface.Tools.UserInput;

public class Font_Interface {

    public static void init(Scanner scan, CSSElementBuilder element) {
        System.out.println(
            new StringBuilder()
             .append("Please select the Font option\n")
             .append("  1.Font Family\n")
             .append("  2.Font Size\n")
             .append("  3.Font Weight\n")
             .append("  4.Font Varuant\n")
             .append("0. Go Back")
        );
        int option = UserInput.getIntBewteen(scan,0,4);
        String value; 
        switch(option){
            case 1: 
                System.out.println("Plese enter the Font you want to use");
                value = UserInput.getLine(scan);
            case 2: 
                value = getFontSize(scan);
            case 3: 
                System.out.println("Please enter your Font Weight");
                value = UserInput.getLine(scan);
            case 4: 
                System.out.println("Please enter your Font Variant");
                value = UserInput.getLine(scan);
            default:
                value = "";
        }
        element.addStyle(StyleFactory.newText(option, value));
    }

    private static String getFontSize(Scanner scan) {
        System.out.println(
            new StringBuilder()
             .append("How would you like to enter the font size\n")
             .append("  1.As Size i.e. Small, Meduim, Large\n")
             .append("  2.As Percantage i.e 200%, 50%\n")
             .append("  3.As Units i.e. mm, cm,px ")
        );
        int option = UserInput.getIntBewteen(scan, 1, 3);
        switch(option) {
            case 1: 
                return UserInput.getLine(scan);
            case 2: 
                return UserInput.getLine(scan);
            case 3: 
                return CSSInput.getLength(scan);
            default:
                return "";
        }
    }
    
}
