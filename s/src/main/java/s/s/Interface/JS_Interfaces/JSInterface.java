package s.s.Interface.JS_Interfaces;

import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.Interface.Tools.UserInput;

public class JSInterface {

    public static void init(WebsiteBuilder web, Scanner scan){
        boolean run = true; 
        while (run){
            System.out.println(
                new StringBuilder()
                .append("Pleae select an option\n")
                .append("  1.View Functions\n")
                .append("  2.Create new Function\n")
                .append("  3.View Page in browser\n")
                .append("  4.return to previous option")
            );
            int option = UserInput.getIntBewteen(scan, 1,4); 
            switch(option) {
                case 1: 
                   
                    break;
                case 2: 
                    CFInterface.init(web, scan);
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
