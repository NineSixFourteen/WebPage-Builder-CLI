package s.s.Interface.CSS_Interfaces.Style_Types;

import java.util.Scanner;

import s.s.CSS.CSSElementBuilder;
import s.s.CSS.StyleFactory;
import s.s.Interface.Tools.UserInput;

public class Border_Style_Interface {

    public static void init(Scanner scan, CSSElementBuilder element) {
        System.out.println(
            new StringBuilder()
             .append("What kind of margin would you like to set\n")
             .append("  1.Boder Style Top\n")
             .append("  2.Boder Style Right\n")
             .append("  3.Boder Style Bottom\n")
             .append("  4.Boder Style Left\n")
             .append("  5.Boder Style\n")
             .append("0. Go Back")
        );
        int option = UserInput.getIntBewteen(scan, 0, 5);
        if(option == 0)return;
        else if(option == 5){
            System.out.println("You can enter more than one this length for Boder Style ex. 10px 5px\n This will have top and bot will have as 10px and right and left are 5px you can enter a max of 4 sizes");
        }
        String value = UserInput.getLength(scan);
        element.addStyle(StyleFactory.newBorderStyle(option, value));
    }
}
