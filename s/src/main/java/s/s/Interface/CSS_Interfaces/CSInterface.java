package s.s.Interface.CSS_Interfaces;

import java.util.Scanner;

import s.s.CSS.CSSPageBuilder;
import s.s.Interface.Tools.UserInput;

//Create Style Interface
public class CSInterface {

    public static void init(CSSPageBuilder cpb, Scanner scan) {
        System.out.println(
                new StringBuilder()
                .append("Would you like to add style to\n")
                .append("  1.Elements\n")
                .append("  2.Id\n")
                .append("  3.Classes\n")
                .append("  4.Go back")
            );
        int option = UserInput.getIntBewteen(scan, 1,4); 
        switch(option) {
            case 1: 
               
                break;
            case 2: 
               
                break;
            case 3: 
                
                break;
            case 4: 
                
                break;
        }
    }
    
}
