package s.s.Interface.CSS_Interfaces.Style_Types;

import java.util.Scanner;

import s.s.CSS.CSSElementBuilder;
import s.s.CSS.StyleFactory;
import s.s.Interface.Tools.UserInput;

public class Margin_Interface {

    public static void init(Scanner scan, CSSElementBuilder element) {
        System.out.println(
            new StringBuilder()
             .append("What kind of margin would you like to set\n")
             .append("  1.Margin Top\n")
             .append("  2.Margin Right\n")
             .append("  3.Margin Bottom\n")
             .append("  4.Margin Left\n")
             .append("  5.Margin\n")
             .append("0. Go Back")
        );
        int option = UserInput.getIntBewteen(scan, 0, 5);
        if(option == 0)return;
        else if(option == 5){
            System.out.println("You can enter more than one this length for margin ex. 10px 5px\n This will have top and bot will have as 10px and right and left are 5px you can enter a max of 4 sizes");
        }
        String value = UserInput.getLength(scan);
        element.addStyle(StyleFactory.newMargin(option, value));
    }

}
