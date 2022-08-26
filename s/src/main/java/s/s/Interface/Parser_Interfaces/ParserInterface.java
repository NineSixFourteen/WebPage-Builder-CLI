package s.s.Interface.Parser_Interfaces;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.CSS.CSSPageBuilder;
import s.s.HTML.PageBuilder;
import s.s.Interface.Tools.UserInput;
import s.s.Parser.CSSParser.CSSParser;
import s.s.Parser.HTMLParser.HTMLParser;

public class ParserInterface {

    public static WebsiteBuilder init(Scanner scan){
        System.out.println("Please enter the name of the document you would like to parse");
        String fileName = UserInput.getLine(scan);
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName  + ".html")));
            String CSS = new String(Files.readAllBytes(Paths.get(fileName  + ".css")));
            PageBuilder pb = HTMLParser.parsePage(content).setTitle(fileName);
            CSSPageBuilder cpb = CSSParser.parsePage(CSS);
            return new WebsiteBuilder(pb, cpb);
        } catch(Exception e){
            e.printStackTrace();
            throw new Error("DIDNT WORK ");
        }
    }
    
}
