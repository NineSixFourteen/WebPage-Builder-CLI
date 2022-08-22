package s.s.Interface.Html_Interfaces;

import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.Interface.Tools.UserInput;

public class HTMLInterface {

    public static void init(WebsiteBuilder web, Scanner scan) {
        boolean run = true; 
        while (run){
            System.out.println(
                new StringBuilder()
                .append("Pleae select an option\n")
                .append("  1.View elements\n")
                .append("  2.Create new element\n")
                .append("  3.View Page in browser\n")
                .append("  4.return to previous option")
            );
            int option = UserInput.getIntBewteen(scan, 1,4); 
            switch(option) {
                case 1: 
                    VEInterface.init(web, scan);
                    break;
                case 2: 
                    CEInterface.init(web, scan);
                    break;
                case 3: 
                    web.make();
                    break;
                case 4: 
                    run = false; 
                    break;
            }
        }
    }

}

   