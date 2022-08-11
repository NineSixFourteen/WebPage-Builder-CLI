package s.s.Interface.Tools;

import java.util.Scanner;

import dnl.utils.text.table.TextTable;
import s.s.HTML.Heading;
import s.s.HTML.LList;
import s.s.HTML.PageBuilder;
import s.s.HTML.Table;
import s.s.HTML.ElementFactory.Element;

public class ElementDisplay {


    public static String allShallowInfo(PageBuilder pb) {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < pb.getBody().size();i++){
            sb.append("  ")
             .append(i + 1)
             .append(". ")
             .append(shallowInfo(pb.getBody().get(i)));
        }
        return sb.toString();
    }

    public static void ViewElementsDeep(PageBuilder pb, Scanner scan) {
        boolean run = true ; 
        while(run) {
            String out = allShallowInfo(pb);
            System.out.println("Please select the element you would like to or 0 to go back or -1 to show the elements again");
            int option = UserInput.getIntBewteen(scan, -1, 5);
            switch(option) {
                case -1:
                    System.out.println(out);
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    if(option - 1  < pb.getBody().size() ){
                        String out2 = deepInfo(pb.getBody().get(option - 1)); 
                        System.out.println(out2);
                    } else {
                        System.out.println(
                            new StringBuilder()
                             .append("No element of number ")
                             .append(option)
                             .append("\nPlease enter a number bewteen 1 and")
                             .append(pb.getBody().size() + 1)
                        );
                    }
                    break;
            }
        }
    }

    private static String deepInfo(Element element) {
        StringBuilder sb =  new StringBuilder()
         .append("Class : ")
         .append(element.getClasss())
         .append("\nID : ")
         .append(element.getId())
         .append("\nType : ");
         switch(element.getType()){
            case Div:
                sb.append("Div");
                sb.append("TODO");
                break;
            case Heading:
                sb.append("Heading\n")
                 .append("Message : ");
                Heading heading = element.getHeading();
                sb.append(heading.getMsg())
                 .append("\n Level : ")
                 .append(heading.getLevel());
                break;
            case List:
                sb.append("List\n");
                sb.append("List Type : ");
                LList list = element.getList();
                switch(list.getType()){
                    case 0:
                        sb.append("Unordered\n");
                        break;
                    case 1:
                        sb.append("Ordered\n");
                        break;
                    case 2:
                        sb.append("Descriptive\n");
                        break;
                    default:
                        break;
                }
                for(String str : list.getElems()){
                    sb.append("  ").append(str).append("\n");
                }
                break;
            case P:
                sb.append("Paragraph\n")
                .append("Message : ")
                .append(element.getString());
                break;
            case Table:
                sb.append("Table\n");
                Table t = element.getTable();
                TextTable tt = new TextTable(t.getTitles(), t.getContents());                                                         
                tt.printTable(); 
                System.out.println("");
                break;
            default:
                break;
         }
         
         return sb.toString();
    }


    public static String shallowInfo(Element element) {
        StringBuilder sb = new StringBuilder();
        sb.append("( id = ")
         .append(element.getId())
         .append(", class = ")
         .append(element.getClasss())
         .append(", type = ");
        switch(element.getType()){
            case Div:
                sb.append("Div, Number of elements : ")
                .append(element.getElements().size())
                .append(" )\n");
                break;
            case Heading:
                sb.append("Heading, Starts with ")
                .append(element.getHeading().getMsg().split(" ")[0])
                .append(" )\n");
                break;
            case List:
                sb.append("List, first item is ")
                .append(element.getList().getElems().get(0))
                .append(" )\n");
                break;
            case P:
                sb.append("Paragraph, Starts with is ")
                .append(element.getString().split(" ")[0])
                .append(" )\n");
                break;
            case Table:
                sb.append("Table, Headings are ");
                for(String title : element.getTable().getTitles()){
                    sb.append(title).append(" ");
                }
                sb.append(" )\n");
                break;
            default:
                break;

        }
        return sb.toString();
    }
    
}
