package s.s.Interface.Html_Interfaces;

import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.Interface.Tools.ElementDisplay;
import s.s.Interface.Tools.UserInput;

public class REInterface {

    public static void init(WebsiteBuilder web, Scanner scan) {
        boolean run = true; 
        while(run){
            System.out.println("The elements of the page " + web.getPb().getTitle() + "are ");
            System.out.print(ElementDisplay.allShallowInfo(web.getPb()));
            System.out.println("Please select the element you would like to move or 0 to go back");
            int option = UserInput.getIntBewteen(scan, 0, web.getPb().getBody().size());
            if (option == 0) return;
            System.out.println(
                new StringBuilder()
                 .append("Would you like to\n ")
                 .append("  1. Move the element to place\n")
                 .append("  2. Move the element up or down\n")
                 .append("0. Go Back ")
            );
            int option2 = UserInput.getIntBewteen(scan, 0, 2);
            switch(option2){
                case 0: 
                    run = false; 
                    break;
                case 1: 
                    moveToPlace(web, scan,option);
                    break;
                case 2:  
                    moveUpOrDown(web, scan,option);
            }
        } 
    }

    private static void moveUpOrDown(WebsiteBuilder web, Scanner scan, int option) {
        System.out.println("Would you like to move 1. Up or 2. Down\n 0. Go Back");
        int option2 = UserInput.getIntBewteen(scan, 0, 2);
        System.out.println("By how much to move by");
        int moveTo;  
        int moveBy;
        switch(option2){
            case 1: 
                if(option == 1) System.out.println("You Cannot move this element up anymore");
                moveBy = UserInput.getIntBewteen(scan, 1, option - 1);
                break; 
            case 2: 
                if(option == web.getPb().getBody().size()) System.out.println("You Cannot move this element down anymore");
                moveBy = UserInput.getIntBewteen(scan, 1, web.getPb().getBody().size() - option);
                break;
            default:
                moveBy = 0;
        }
        moveTo = option + moveBy;
        web.getPb().getBody().add(moveTo - 1,web.getPb().getBody().get(option -1));
        if (moveTo > option ) option--;
        web.getPb().getBody().remove(option);
    }

    private static void moveToPlace(WebsiteBuilder web, Scanner scan, int option) {
        System.out.println("Where would you like to move the element to");
        int option2 = UserInput.getIntBewteen(scan, 1, web.getPb().getBody().size());
        web.getPb().getBody().add(option2 - 1,web.getPb().getBody().get(option -1));
        if (option2 > option ) option--;
        web.getPb().getBody().remove(option);
    }
    
}
