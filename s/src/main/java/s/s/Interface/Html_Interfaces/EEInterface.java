package s.s.Interface.Html_Interfaces;

import java.util.Scanner;

import s.s.HTML.ElementFactory;
import s.s.HTML.PageBuilder;
import s.s.HTML.Table;
import s.s.HTML.TableBuilder;
import s.s.HTML.ElementFactory.Element;
import s.s.Interface.Tools.ElementDisplay;
import s.s.Interface.Tools.UserInput;

public class EEInterface {

    public static void init(PageBuilder pb, Scanner scan) {
        while(true) {
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
                    editDiv(scan, element);
                    break;
                case Heading:
                    editHeading(scan, element);
                    break;
                case List:
                    editList(scan, element);
                    break;
                case P:
                    editPara(scan, element);
                    break;
                case Table:
                    editTable(scan, element , pb, option - 1);
                    break;
                default:
                    break;

            } 
        }
    }

    private static void editTable(Scanner scan, Element element, PageBuilder pb, int ind) {
        ElementFactory EF = new ElementFactory();
        System.out.println(
            new StringBuilder()
             .append("Would you like to edit \n")
             .append("  1. The headings\n")
             .append("  2. The rows\n")
             .append("0. go back ")
        );
        int option = UserInput.getIntBewteen(scan, 1, 2);
        switch(option) {
            case 1: 
                String[] headings;
                StringBuilder sb = new StringBuilder().append("The current headings are \n");
                Table tab = element.getTable();
                for(int i = 0; i < tab.getTitles().length; i++){
                    sb.append(i+ 1).append(". ").append(tab.getTitles()[i]).append(" ");
                }
                sb.append("\nWould you like to 1. Start Fresh 2. Edit Current ones");
                option = UserInput.getIntBewteen(scan, 1, 2);
                switch(option) {
                    case 1: 
                        System.out.println("Please enter the new headings seperated by commas");
                        headings = UserInput.getList(scan);
                        break;
                    case 2: 
                        headings = UserInput.getChanges(scan, tab.getTitles());
                        break; 
                    default: 
                        headings = new String[0];
                }
                pb.swapElem(ind, 
                    EF.newTable(
                        new TableBuilder(0, 0)
                        .setTitles(headings)
                        .setBody(element.getTable().getContents())
                        .build(), 
                        element.getId(), element.getClasss()
                    )
                );
                break;
            case 2: 
                break;
            default: 
        }
    }

    private static void editPara(Scanner scan, Element element) {
    }

    private static void editList(Scanner scan, Element element) {
    }

    private static void editHeading(Scanner scan, Element element) {
    }

    private static void editDiv(Scanner scan, Element element) {
    }
    
}
