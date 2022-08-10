package s.s.Interface.Html_Interfaces;

import java.util.Scanner;

import dnl.utils.text.table.TextTable;
import s.s.HTML.LList;
import s.s.HTML.PageBuilder;
import s.s.HTML.Table;
import s.s.HTML.ElementFactory.Element;

//View Element Interface 
public class VEInterface {

    public static void init(PageBuilder pb, Scanner scan){
        System.out.println("The elements of the page " + pb.getTitle() + "are ");
        String out = allShallowInfo(pb);
        System.out.println(out);
        System.out.println(
            new StringBuilder()
             .append("Would you like to")
             .append("  1. View an element in more detail")
             .append("  2. Go Back")
            );
        int option = scan.nextInt();
        switch(option) {
            case 1: 
                ViewElementsDeep(pb, scan);
                break;
            case 2: 
                init(pb,scan);
                break;
        }
    }

    private static void ViewElementsDeep(PageBuilder pb, Scanner scan) {
        boolean run = true ; 
        while(run) {
            System.out.println("Please select the element you would like to or 0 to go back or -1 to show the elements again");
            int option = scan.nextInt(); 
            switch(option) {
                case -1:
                    String out = allShallowInfo(pb);
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
         .append("Name : ")
         .append("TODO\n")
         .append("ID : ")
         .append("TODO\n")
         .append("Type : ");
         switch(element.getId()){
            case Div:
                sb.append("Div");
                sb.append("TODO");
                break;
            case Heading:
                sb.append("Heading\n")
                 .append("Message : ")
                 .append(element.getString());
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
                break;
            default:
                break;
         }
         
         return sb.toString();
    }

    private static String allShallowInfo(PageBuilder pb) {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < pb.getBody().size();i++){
            sb.append("  ")
             .append(i + 1)
             .append(". ")
             .append(shallowInfo(pb.getBody().get(i)));
        }
        return sb.toString();
    }

    private static String shallowInfo(Element element) {
        StringBuilder sb = new StringBuilder();
        sb.append("( id = ")
         .append("TODO")
         .append(", name = ")
         .append( "TODO")
         .append(", type = ");
        switch(element.getId()){
            case Div:
                sb.append("Div, Number of elements : ")
                .append(element.getElements().size())
                .append(" )\n");
                break;
            case Heading:
                sb.append("Heading, Starts with ")
                .append(element.getString().split(" ")[0])
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


