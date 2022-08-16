package s.s.Interface;

import java.util.Scanner;

import s.s.Website;
import s.s.HTML.Page;
import s.s.HTML.PageBuilder;
import s.s.Interface.Html_Interfaces.HTMLInterface;
import s.s.Interface.Tools.UserInput;

public class MainInterface {

    public static Website init(){
        Website web = new Website(); 
        System.out.println(
            new StringBuilder()
                .append("Welcome to this thing I built for some reason\n")
                .append("Would you like to \n")
                .append("  1. Create an webpage from scratch\n")
                .append("  2. Parse in an existing Page\n")
                .append("  3. Exit\n")
        );
        Scanner scan = new Scanner(System.in);
        int option = UserInput.getIntBewteen(scan, 1, 3);
        switch(option){
            case 1: 
                makeBasicPage(web,scan); 
                break;
            case 2: 
                break; 
            case 3:
                break;
        }
        scan.close();
        return web;
    }

    private static void makeBasicPage(Website web, Scanner scan) {
        System.out.println("Please enter the name of the webpage");
        String name = UserInput.getLine(scan);
        //pb.setTitle(name);
        fillOutPage(web, scan);
    }

    private static void fillOutPage(Website web, Scanner scan) {
        boolean run = true; 
        while(run){
            System.out.println(
                new StringBuilder()
                 .append("Please select the option you would like to\n")
                 .append("  1. Add an element to the webpage\n")
                 .append("  2. Add Styles to the webpage\n")
                 .append("  3. Add functionality to the webpage\n") 
                 .append("  4. Exit\n")
            );
            int option = UserInput.getIntBewteen(scan, 1, 4);
            switch(option){
                case 1: 
                    HTMLInterface.init(web,scan);
                    break;
                case 2: 
                    break; 
                case 3: 
                    break; 
                case 4:
                    run = false;
                    break;
            }
        }
    }
}
