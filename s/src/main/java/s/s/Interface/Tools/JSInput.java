package s.s.Interface.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.JS.LineFactory;
import s.s.JS.Lines.Line;

public class JSInput {

    /*
     * Fucntion for getting either a Line that will edit a elements style or text 
     * or a Line that calls a function. 
     * Is used when creating a button where you should only either call a function or edit a element
     */
    public Line buttonCreation(WebsiteBuilder web, Scanner scan){
        System.out.println(
            new StringBuilder()
             .append("Please select what you want the button to do\n")
             .append("  1. Edit an element \n")
             .append("  2. Call a Function")
        );
        int option = UserInput.getIntBewteen(scan, 1, 2);
        switch(option){
            case 1: 
                return getEditElem(web,scan);
            case 2: 
                return getFuncCall(web,scan);
            default:
                //Shouldn't be possible due to the function used to get the int
                return null;
        }
    }

    private Line getFuncCall(WebsiteBuilder web, Scanner scan) {
        HashMap<String, Integer> funcNames = web.getFuncNames();
        StringBuilder sb = new StringBuilder("Please select what function you want to use\n");
        int i = 1;
        String[] keys = funcNames.keySet().toArray(new String[0]);
        for(String name : funcNames.keySet()){
            sb.append("  ")
             .append(i++)
             .append('.')
             .append(" ")
             .append(name)
             .append("with ")
             .append(funcNames.get(name))
             .append(" parameters");
        }
        System.out.println(sb);
        //todo make 0 switch bewteen functions
        int option = UserInput.getIntBewteen(scan, 0, funcNames.size());
        String name = keys[option];
        int numOfParams = funcNames.get(name);
        while(true){
            System.out.println("Please enter the parameters");
            keys = UserInput.getList(scan);
            if(keys.length == numOfParams){break;}
            else {System.out.println("Please enter " + numOfParams + " number of elements instead of " + keys.length);}
        }
        ArrayList<String> params = new ArrayList<>();
        for(String param : keys){
            params.add(param);
        }
        return LineFactory.newFuncCall(name, params);
    }

    private Line getEditElem(WebsiteBuilder web , Scanner scan) {
        System.out.println(
            new StringBuilder()
             .append("Would you like to edit\n")
             .append("  1.The Style\n")
             .append("  2.The Text\n")
             .append("0.Switch to FuncCall")
        );
        int option = UserInput.getIntBewteen(scan, 0, 2);
        switch(option){
            default:
                return getFuncCall(web, scan);
            case 1:
                return getEditStyle(web, scan);
            case 2:
                return getEditText(web, scan);
        }
    }

    private Line getEditText(WebsiteBuilder web, Scanner scan) {
        System.out.println("Please enter the id of the element");
        String id = UserInput.getLine(scan);
        System.out.println("Please enter the new text");
        String newValue = UserInput.getLine(scan);
        return LineFactory.newElemChange(id, newValue);
    }

    private Line getEditStyle(WebsiteBuilder web, Scanner scan) {
        System.out.println("Please enter the id of the element");
        String id = UserInput.getLine(scan);
        System.out.println("Pleae enter the style you would like to change");
        String style = UserInput.getLine(scan);
        System.out.println("Please enter the new text");
        String newValue = UserInput.getLine(scan);
        return LineFactory.newStyleChange(id, style,newValue);
    }
    
}
