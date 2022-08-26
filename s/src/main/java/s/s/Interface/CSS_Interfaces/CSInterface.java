package s.s.Interface.CSS_Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.CSS.CSSElementBuilder;
import s.s.CSS.Type;
import s.s.Interface.Tools.UserInput;

//Create Style Interface
public class CSInterface {

    public static void init(WebsiteBuilder web, Scanner scan) {
        System.out.println(
                new StringBuilder()
                .append("Would you like to add style to\n")
                .append("  1.Elements\n")
                .append("  2.Id\n")
                .append("  3.Classes\n")
                .append("0.Go back")
            );
        int option = UserInput.getIntBewteen(scan, 0,3); 
        switch(option) {
            case 1: 
                addStyles(web, web.getElems(), scan, Type.ELEM);
                break;
            case 2: 
                addStyles(web,new ArrayList<>(web.getIds()), scan, Type.ID);
                break;
            case 3: 
                addStyles(web, new ArrayList<>(web.getClasses()), scan,Type.CLASS);
                break;
            default:
        }
    }

    private static void addStyles(WebsiteBuilder web, List<String> list, Scanner scan, Type type) {
        StringBuilder sb = new StringBuilder()
         .append("What would you like to add a style to\n");
        int i = 1;
        for(String st : list){
            sb.append("  ")
             .append(i++)
             .append(".")
             .append(st)
             .append("\n");
        }
        System.out.println(sb.append("0. to go back"));
        int option = UserInput.getIntBewteen(scan, 0, list.size());
        String name = list.get(option - 1);
        CSSElementBuilder element = new CSSElementBuilder(name,type);
        PEInterface.init(web, scan, element);
        web.addElem(element.build());
    }

    
}
