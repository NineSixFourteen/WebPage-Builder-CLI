package s.s.Interface.CSS_Interfaces.Style_Types;

import java.util.Scanner;

import s.s.CSS.CSSElementBuilder;
import s.s.CSS.StyleFactory;
import s.s.Interface.Tools.CSSInput;
import s.s.Interface.Tools.UserInput;

public class Colour_Interface {

    public static void init(Scanner scan, CSSElementBuilder element) {
        System.out.println(
            new StringBuilder()
             .append("Would you like to set the Background or the text colour\n")
             .append("  1.Text\n")
             .append("  2.Background")
             .append("0.Go Back")
        );
        int option = UserInput.getIntBewteen(scan, 0, 2);
        if(option ==0)return;
        String value = CSSInput.getColour(scan);
        element.addStyle(StyleFactory.newColour(option, value));
    }
    
}
