package s.s.Interface.CSS_Interfaces;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.HTML.Page;
import s.s.HTML.PageBuilder;
import s.s.HTML.PageMaker;
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
                    loadPageInBrowser(web.getPb());
                    break;
                case 4: 
                    run = false; 
                    break;
            }
        }
    }

    private static void loadPageInBrowser(PageBuilder pb) {
        Page p = pb.Build();
        String page = new PageMaker(p).toString();
        try {
            FileWriter myWriter = new FileWriter(p.getTitle() + ".html");
            myWriter.write(page);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try{
            File htmlFile = new File(p.getTitle() + ".html");
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
