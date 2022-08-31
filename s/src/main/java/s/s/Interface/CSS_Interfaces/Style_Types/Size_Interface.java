package s.s.Interface.CSS_Interfaces.Style_Types;

import java.util.Scanner;

import s.s.CSS.CSSElementBuilder;
import s.s.CSS.StyleFactory;
import s.s.Interface.Tools.UserInput;

public class Size_Interface {

    public static void init(Scanner scan, CSSElementBuilder element) {
        boolean run = true;
        while(run){
            System.out.println(
                new StringBuilder()
                .append("Please select what style you would want to add\n")
                .append("  1.Width\n")
                .append("  2.Height\n")
                .append("  3.Min_Width\n")
                .append("  4.Max_Width\n")
                .append("  5.Min_Height\n")
                .append("  6.Max_Height\n")
                .append("0. Go Back")
            );
            int option = UserInput.getIntBewteen(scan, 0, 6);
            if(option == 0)return;
            String value = UserInput.css.getLength(scan);
            element.addStyle(StyleFactory.newSize(option, value));
        }
    }
        
}
