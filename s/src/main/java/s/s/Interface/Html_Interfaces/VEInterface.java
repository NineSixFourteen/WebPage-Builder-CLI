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
                ViewElementsDeep(pb, scan);
                break;
            case 2: 
                EEInterface.init(pb, scan);
            case 3: 
                break;
        }
    }

    private static void ViewElementsDeep(PageBuilder pb, Scanner scan) {
        boolean run = true ; 
        while(run) {
            String out = ElementDisplay.allShallowInfo(pb);
            System.out.println("Please select the element you would like to or 0 to go back or -1 to show the elements again");
            int option = UserInput.getIntBewteen(scan, -1, 5);
            switch(option) {
                case -1:
                    System.out.println(out);
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    if(option - 1  < pb.getBody().size() ){
                        String out2 = ElementDisplay.deepInfo(pb.getBody().get(option - 1)); 
                        System.out.println(out2);
                    } else {
                        System.out.println(
                            new StringBuilder()
                             .append("No element of number ")
                             .append(option)
                             .append("\nPlease enter a number bewteen 1 and")
                             .append(pb.getBody().size() + 1)
                        );
                    }
                    break;
            }
        }
    }
}


