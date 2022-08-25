package s.s;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import s.s.CSS.CSSPageBuilder;
import s.s.HTML.PageBuilder;
import s.s.Interface.MainInterface;
import s.s.Interface.CSS_Interfaces.CSS_Interface;
import s.s.Interface.Html_Interfaces.HTMLInterface;
import s.s.Interface.Tools.UserInput;
import s.s.Parser.CSSParser.CSSParser;
import s.s.Parser.HTMLParser.HTMLParser;

public class App 
{ 
  public static void main( String[] args ) throws IOException {
    //MainInterface.init();
    WebsiteBuilder web ;
    String content = new String(Files.readAllBytes(Paths.get("LSL.html")));
    String CSSContent = new String(Files.readAllBytes(Paths.get("LSL.css")));
    PageBuilder page = HTMLParser.parsePage(content);
    CSSPageBuilder csspage = CSSParser.parsePage(CSSContent);
    web = new WebsiteBuilder(page, csspage);
    web.getPb().setTitle("LSL");
    Scanner scan = new Scanner(System.in);
    fillOutPage(web, scan);
  }

  private static void fillOutPage(WebsiteBuilder web, Scanner scan) {
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
                CSS_Interface.init(web, scan);
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
