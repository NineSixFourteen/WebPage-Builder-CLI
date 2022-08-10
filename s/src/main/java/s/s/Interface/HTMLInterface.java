package s.s.Interface;

import java.util.Scanner;

import s.s.HTML.PageBuilder;
import s.s.HTML.ElementFactory.Element;

public class HTMLInterface {

    public void init(PageBuilder pb, Scanner scan) {
        boolean run = true; 
        while (run){
            System.out.println(
                new StringBuilder()
                .append("Pleae select an option\n")
                .append("  1.View elements\n")
                .append("  2.Create new element\n")
                .append("  3.return to previous option\n")
            );
            int option = scan.nextInt(); 
            switch(option) {
                case 1: 
                    viewElement(pb,scan);
                    break;
                case 2: 
                    break;
                case 3: 
                    break;
            }
        }
    }

    private void viewElement(PageBuilder pb, Scanner scan) {
        System.out.println("The elements of the page " + pb.getTitle() + "are ");
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < pb.getBody().size();i++){
            sb.append("  ")
             .append(i + 1)
             .append(". ")
             .append(shallowInfo(pb.getBody().get(i)));
        }
    }

    private String shallowInfo(Element element) {
        StringBuilder sb = new StringBuilder();
        sb.append("( id = ")
         .append(element.getId())
         .append(", name = ")
         //name .append()
         .append("type = ");
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
