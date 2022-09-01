package s.s.Interface.Html_Interfaces;

import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.HTML.Button;
import s.s.HTML.ListBuilder;
import s.s.HTML.TableBuilder;
import s.s.Interface.Tools.UserInput;

// Create Element Interface
public class CEInterface {
    
    public static void init(WebsiteBuilder web, Scanner scan){
        boolean run = true; 
        while(run){
            System.out.println(
                new StringBuilder()
                .append("Please select the element that you would like to \n")
                .append("  1. Heading\n")
                .append("  2. Paragraph\n")
                .append("  3. List\n")
                .append("  4. Table\n")
                .append("  5. Div\n")
                .append("  6.Button\n")
                .append("Or type 0 to go back")
            );
            int option = UserInput.getIntBewteen(scan, 0, 6);
            switch(option){
                case 0: 
                    run = false;
                    break;
                case 1:
                    addHeading(web,scan);
                    break; 
                case 2:
                    addParagraph(web,scan);
                    break;
                case 3: 
                    addList(web, scan);
                    break;
                case 4:
                    addTable(web, scan);
                    break; 
                case 5:
                    break; 
                case 6:
                    addButon(web,scan);
            }
        }
    }

    private static void addButon(WebsiteBuilder web, Scanner scan) {
        System.out.println("Please enter the message for your button");
        String msg = UserInput.getLine(scan);
        String id = getId(scan);
        String classs = getClasss(scan);
        web.addButon(new Button(msg, UserInput.js.buttonCreation(web, scan)), id, classs);
    }

    private static void addTable(WebsiteBuilder web, Scanner scan) {
        System.out.println("Please enter the Headings for your list seperated by a comma");
        String[] headings = UserInput.getList(scan);
        String[][] body = UserInput.getListofList(scan);
        String id = getId(scan);
        String classs = getClasss(scan);
        web.addTable(
            new TableBuilder(body.length, headings.length)
             .setTitles(headings)
             .setBody(body)
             .build()
             , id, classs
        );
    }

    private static void addParagraph(WebsiteBuilder web, Scanner scan) {
        System.out.println("Please enter your message");
        String msg = UserInput.getLine(scan);
        String id = getId(scan);
        String classs = getClasss(scan);
        web.addParagraph(msg, id, classs);
    }

    private static void addHeading(WebsiteBuilder web, Scanner scan) {
        System.out.println("Please enter the level of the heading you want bewteen 1 - 6");
        int level = UserInput.getIntBewteen(scan, 1, 6);
        System.out.println("Please enter the text for the heading");
        String msg = UserInput.getLine(scan);
        String id = getId(scan);
        String classs = getClasss(scan);
        web.addHeading(msg, level, id, classs);
    }

    private static void addList(WebsiteBuilder web, Scanner scan){
        System.out.println(
            new StringBuilder()
             .append("Please enter the type of list\n")
             .append("1. Orderderd  2.Unordered  3.Descriptive")
        );
        int type = UserInput.getIntBewteen(scan, 1, 3);
        System.out.println("Please enter the items in yout list seperated by a comma");
        String[] items = UserInput.getList(scan);
        String id = getId(scan);
        String classs = getClasss(scan);
        web.addList(
            new ListBuilder(type)
             .addElems(items)
             .Build()
            , id, classs 
            );
    }

    private static String getClasss(Scanner scan) {
        System.out.println("Would you like this element a class\n  1.Yes  2.No");
        int option = UserInput.getIntBewteen(scan, 1, 2);
        switch(option){
            case 1: 
                return UserInput.getLine(scan);
            default:
                return "";
        }
    }

    private static String getId(Scanner scan) {
        System.out.println("Would you like this element an id \n  1.Yes  2.No");
        int option = UserInput.getIntBewteen(scan, 1, 2);
        switch(option){
            case 1: 
                return UserInput.getLine(scan);
            default:
                return "";
        }
    }

}
