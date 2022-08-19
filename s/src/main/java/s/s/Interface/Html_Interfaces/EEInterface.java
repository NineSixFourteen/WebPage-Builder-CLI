package s.s.Interface.Html_Interfaces;

import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.HTML.ElementFactory;
import s.s.HTML.ListBuilder;
import s.s.HTML.PageBuilder;
import s.s.HTML.Table;
import s.s.HTML.TableBuilder;
import s.s.HTML.ElementFactory.Element;
import s.s.Interface.Tools.ElementDisplay;
import s.s.Interface.Tools.UserInput;

// Edit Element Interface
public class EEInterface {

    public static void init(WebsiteBuilder web, Scanner scan) {
        while(true) {
            PageBuilder pb = web.getPb();
            String out = ElementDisplay.allShallowInfo(pb);
            System.out.println("Please enter the number of the element you would like to edit\n or 0 to exit");
            System.out.println(out);
            int option = UserInput.getIntBewteen(scan, 0, pb.getBody().size());
            if(option == 0){
                return;
            }
            Element element = pb.getBody().get(option - 1);
            switch(element.getType()){
                case Div:
                    editDiv(scan, element, web, option - 1);
                    break;
                case Heading:
                    editHeading(scan, element, web, option -1);
                    break;
                case List:
                    editList(scan, element, web, option -1);
                    break;
                case P:
                    editPara(scan, element, web, option - 1);
                    break;
                case Table:
                    editTable(scan, element , web, option - 1);
                    break;
                default:
                    break;

            } 
        }
    }

    private static void editPara(Scanner scan, Element element, WebsiteBuilder web, int ind) {
        ElementFactory EF = new ElementFactory();
        String msg = UserInput.getLine(scan);
        web.getPb().swapElem(ind, 
            EF.newParagraph(msg, element.getId(), element.getClasss())
        );
    }

    private static void editList(Scanner scan, Element element, WebsiteBuilder web, int ind) {
        ElementFactory EF = new ElementFactory();
        String msg = UserInput.getLine(scan);
        web.getPb().swapElem(ind, 
            EF.newParagraph(msg, element.getId(), element.getClasss())
        );
        System.out.println(
            new StringBuilder()
             .append("Would you like to edit \n")
             .append("  1. List Type\n")
             .append("  2. The List\n")
             .append("0. go back ")
        );
        int option = UserInput.getIntBewteen(scan, 0, 2);
        switch(option) {
            case 1: 
            System.out.println(
                new StringBuilder()
                 .append("Please enter the type of list\n")
                 .append("1. Orderderd  2.Unordered  3.Descriptive")
            );
            int type = UserInput.getIntBewteen(scan, 1, 3);
            web.getPb().swapElem(ind, EF.newList( 
                new ListBuilder(type)
                    .addElems(element.getList().getElems().toArray(new String[0]))
                    .Build(),
                element.getId(), element.getClasss())
            );
                break;
            case 2: 
                String[] list = UserInput.getList(scan);
                web.getPb().swapElem(ind, EF.newList(
                    new ListBuilder(element.getList().getType())
                    .addElems(list)
                    .Build(),
                element.getId(), element.getClasss()));
                break;
            case 0:
            default: 
        }
    }

    private static void editHeading(Scanner scan, Element element,WebsiteBuilder web, int ind) {
        ElementFactory EF = new ElementFactory();
        System.out.println(
            new StringBuilder()
             .append("Would you like to edit \n")
             .append("  1. The level\n")
             .append("  2. The message\n")
             .append("0. go back ")
        );
        int option = UserInput.getIntBewteen(scan, 0, 2);
        switch(option) {
            case 1: 
                System.out.println("Please enter the new level of the heading");
                int level = UserInput.getIntBewteen(scan, 1, 3);
                web.getPb().swapElem(ind, EF.newHeading(element.getHeading().getMsg(), level, element.getId(), element.getClasss()));
                break;
            case 2: 
                System.out.println("Please enter the message");
                String msg = UserInput.getLine(scan);
                web.getPb().swapElem(ind, EF.newHeading(msg, element.getHeading().getLevel(), element.getId(), element.getClasss()));
                    break;
            case 0:
            default: 
        }
    }

    private static void editDiv(Scanner scan, Element element, WebsiteBuilder web, int i) {
    }

    private static void editTable(Scanner scan, Element element, WebsiteBuilder web, int ind) {
        System.out.println(
            new StringBuilder()
             .append("Would you like to edit \n")
             .append("  1. The headings\n")
             .append("  2. The rows\n")
             .append("0. go back ")
        );
        int option = UserInput.getIntBewteen(scan, 0, 2);
        switch(option) {
            case 1: 
                editTableHeading(scan, element, ind, web);
                break;
            case 2: 
                editTableRows(scan, element, ind, web);
                break;
            case 0:
            default: 
        }
    }

    private static void editTableRows(Scanner scan, Element element, int ind, WebsiteBuilder web) {
        ElementFactory EF = new ElementFactory();
        StringBuilder sb = new StringBuilder();
        Table tab = element.getTable();
        String[][] body = tab.getContents(); 
        sb.append("The rows contents are \n");
        for(int i = 0; i < body.length; i++){
            sb.append(i).append(".").append("  |");
            for(int l = 0; l < body[i].length;l++ ){
                sb.append(body[i][l])
                 .append(" |");
            }
            sb.append("\n");
        }
        sb.append("Please select the row you would like to edit");
        body = getNewBody(scan, body, sb.toString());
        web.getPb().swapElem(ind, 
            EF.newTable(
            new TableBuilder(0, 0)
             .setTitles(tab.getTitles())
             .setBody(body)
             .build(),
             element.getId(), element.getClasss()
        ));
    }

    private static String[][] getNewBody(Scanner scan, String[][] body, String string) {
        boolean run = true;
        while(run) {
            System.out.println(string);
            int option = UserInput.getIntBewteen(scan, 0, body.length);
            if(option == 0 ){
                return body;
            }
            body[option -1] = changeRow(scan, body[option - 1]); // replaces old row with new
        }
        return body;
    }

    private static void editTableHeading(Scanner scan, Element element,int ind,WebsiteBuilder web) {
        ElementFactory EF = new ElementFactory();
        StringBuilder sb = new StringBuilder().append("The current headings are \n");
        Table tab = element.getTable();
        for(int i = 0; i < tab.getTitles().length; i++){
            sb.append(i+ 1).append(". ").append(tab.getTitles()[i]).append(" ");
        }
        System.out.println(sb);
        String[] headings = changeRow(scan, tab.getTitles());
        web.getPb().swapElem(ind, 
            EF.newTable(
                new TableBuilder(0, 0)
                .setTitles(headings)
                .setBody(element.getTable().getContents())
                .build(), 
                element.getId(), element.getClasss()
            )
        );
    }

    private static String[] changeRow(Scanner scan, String[] old){
        System.out.println("Would you like to 1. Start Fresh 2. Edit Current ones");
        int option = UserInput.getIntBewteen(scan, 1, 2);
        switch(option) {
            case 1: 
                System.out.println("Please enter the new headings seperated by commas");
                return UserInput.getList(scan);
            case 2: 
                return UserInput.getChanges(scan, old);
            default: 
                return new String[0];
        }
    }
}
