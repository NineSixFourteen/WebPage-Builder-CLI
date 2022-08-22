package s.s.Interface.CSS_Interfaces;

import java.util.Scanner;

import s.s.WebsiteBuilder;

import s.s.Interface.Tools.UserInput;

public class CSS_Interface {
    
    public static void init(WebsiteBuilder web, Scanner scan){
        boolean run = true;
        while(run) {
            System.out.println(
                    new StringBuilder()
                    .append("Pleae select an option\n")
                    .append("  1.Create new style\n")
                    .append("  2.Edit an elements style\n")
                    .append("  3.View Page in browser\n")
                    .append("  4.return to previous option")
                );
            int option = UserInput.getIntBewteen(scan, 1,4); 
            switch(option) {
                case 1: 
                    CSInterface.init(web, scan);
                    break;
                case 2: 
                    
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
