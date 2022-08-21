package s.s.Interface.CSS_Interfaces.Style_Types;

import java.util.Scanner;

import s.s.CSS.CSSElementBuilder;

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
    }
    
}
