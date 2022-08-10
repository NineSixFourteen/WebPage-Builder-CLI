package s.s.Interface.Html_Interfaces;

import java.awt.Desktop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import s.s.HTML.Page;
import s.s.HTML.PageBuilder;
import s.s.Interface.Tools.UserInput;


public class HTMLInterface {

    public static void init(PageBuilder pb, Scanner scan) {
        boolean run = true; 
        while (run){
            System.out.println(
                new StringBuilder()
                .append("Pleae select an option\n")
                .append("  1.View elements\n")
                .append("  2.Create new element\n")
                .append("  3.View Page in browser")
                .append("  4.return to previous option\n")
            );
            int option = UserInput.getIntBewteen(scan, 1,4); 
            switch(option) {
                case 1: 
                    VEInterface.init(pb, scan);
                    break;
                case 2: 
                    CEInterface.init(pb, scan);
                    break;
                case 3: 
                    loadPageInBrowser(pb);
                    break;
                case 4: 
                    run = false; 
                    break;
            }
        }
    }

    private static void loadPageInBrowser(PageBuilder pb) {
        Page p = pb.Build();
        String page = p.toString();
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

   