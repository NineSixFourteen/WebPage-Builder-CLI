package s.s.Interface.Html_Interfaces;

import java.util.Scanner;


import s.s.HTML.PageBuilder;
import s.s.Interface.Tools.ElementDisplay;
import s.s.Interface.Tools.UserInput;

//View Element Interface 
public class VEInterface {

    public static void init(PageBuilder pb, Scanner scan){
        System.out.println("The elements of the page " + pb.getTitle() + "are ");
        String out = ElementDisplay.allShallowInfo(pb);
        System.out.print(out);
        System.out.println(
            new StringBuilder()
             .append("Would you like to")
             .append("  1. View an element in more detail")
             .append("  2. Edit an Element")
             .append("  3. Go Back")
            );
        int option = UserInput.getIntBewteen(scan, 1, 3);
        switch(option) {
            case 1: 
                ElementDisplay.ViewElementsDeep(pb, scan);
                break;
            case 2: 
                EEInterface.init(pb, scan);
            case 3: 
                break;
        }
    }
}


