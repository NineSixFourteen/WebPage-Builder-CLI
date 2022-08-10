package s.s.Interface.Html_Interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import s.s.HTML.ListBuilder;
import s.s.HTML.PageBuilder;

// Create Element Interface
public class CEInterface {
    
    public static void init(PageBuilder pb, Scanner scan){
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
                .append("Or type 0 to go back")
            );
            scan.nextLine();
            int option = scan.nextInt();
            switch(option){
                case 0: 
                    run = false;
                    break;
                case 1:
                    addHeading(pb,scan);
                    break; 
                case 2:
                    addList(pb, scan);
                    break;
                case 3: 
                    addParagraph(pb,scan);
                    break;
                case 4:
                    break; 
                case 5:
                    break; 
            }
        }
    }

    private static void addParagraph(PageBuilder pb, Scanner scan) {
        System.out.println("Please enter your message");
        String msg = scan.next();
        pb.addParagraph(msg);
    }

    private static void addHeading(PageBuilder pb, Scanner scan) {
        System.out.println("Please enter the level of the heading you want bewteen 1 - 3");
        int level = scan.nextInt();
        System.out.println("Please enter the text for the heading");
        String msg = scan.next();
        pb.addHeading(msg, level);
    }

    private static void addList(PageBuilder pb, Scanner scan){
        System.out.println(
            new StringBuilder()
             .append("Please enter the type of list\n")
             .append("1. Orderderd  2.Unordered  3.Descriptive")
        );
        int type = scan.nextInt();
        System.out.println("Please enter the items in yout list seperated by a comma");
        ArrayList<String> items = new ArrayList<>();
        scan.nextLine();
        for(String item : scan.nextLine().split(",")){
            items.add(item.strip());
        } 
        pb.addList(
            new ListBuilder(type)
             .addElems(items.toArray(new String[0]))
             .Build()
            );
    }

}
