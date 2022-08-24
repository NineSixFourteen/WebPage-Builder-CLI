package s.s.Interface.Parser_Interfaces;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import s.s.HTML.PageBuilder;
import s.s.Interface.Tools.UserInput;
import s.s.Parser.HTMLParser;

public class ParserInterface {

    public static PageBuilder init(Scanner scan){
        System.out.println("Please enter the name of the document you would like to parse");
        String fileName = UserInput.getLine(scan) + ".html";
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            return HTMLParser.parsePage(content);
        } catch(Exception e){
            e.printStackTrace();
            throw new Error("DIDNT WORK ");
        }
    }
    
}
