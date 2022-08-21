package s.s.Interface.CSS_Interfaces.Style_Types;

import java.util.Scanner;

import s.s.CSS.CSSElementBuilder;
import s.s.CSS.StyleFactory;
import s.s.Interface.Tools.UserInput;

public class Border_Interface {

    public static void init(Scanner scan, CSSElementBuilder element) {
        System.out.println(
            new StringBuilder()
             .append("What kind of margin would you like to set\n")
             .append("  1.Border Top\n")
             .append("  2.Border Right\n")
             .append("  3.Border Bottom\n")
             .append("  4.Border Left\n")
             .append("  5.Border\n")
             .append("0. Go Back")
        );
        int option = UserInput.getIntBewteen(scan, 0, 5);
        if(option == 0)return;
        else if(option == 5){
            System.out.println("You can enter more than one this length for Border ex. 10px 5px\n This will have top and bot will have as 10px and right and left are 5px you can enter a max of 4 sizes");
        }
        String value = UserInput.getLength(scan);
        element.addStyle(StyleFactory.newBorder(option, value));
    }
    
}
