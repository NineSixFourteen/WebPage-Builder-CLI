package s.s.Interface.JS_Interfaces;

import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.Interface.Tools.UserInput;
import s.s.JS.FunctionBuilder;
// Populate Function Interface
public class PFInterface {

    public static void init(WebsiteBuilder web, Scanner scan, FunctionBuilder fb) {
        boolean run = true; 
        while (run){
            System.out.println(
                new StringBuilder()
                .append("What kind of line would you like to add\n")
                .append("  1.Variable Declaration\n")
                .append("  2.Variable Modification\n")
                .append("  3.Condition\n")
                .append("  4.Loop\n")
                .append("  5.Element Modification\n")
                .append("  6.Return Value\n")
                .append("0.Finish function")
            );
            int option = UserInput.getIntBewteen(scan, 0,6); 
            switch(option) {
                case 1: 
                    declareVar(scan, fb);
                    break;
                case 2: 
                    modifyVar(scan, fb);
                    break;
                case 3: 
                    cond(scan, fb);
                    break;
                case 4:
                    loop(scan,fb);
                    break;
                case 5:
                    elemMod(scan,fb);
                    break;
                case 6:
                    ret(scan,fb);
                case 0: 
                    web.addFunction(fb.Build());
                    run = false; 
                    break;
            }
        }
    }

    private static void declareVar(Scanner scan, FunctionBuilder fb) {
        System.out.println("Please enter the name of the variable");
        String name = UserInput.getLine(scan);
        System.out.println("Please enter a value");
        String value = UserInput.getLine(scan);
        fb.addVarDec(name, value);
    }

    private static void modifyVar(Scanner scan, FunctionBuilder fb) {
        System.out.println("Please enter the name of the variable");
        String name = UserInput.getLine(scan);
        System.out.println("Please enter a new value");
        String value = UserInput.getLine(scan);
        fb.addVarDec(name, value);
    }

    private static void cond(Scanner scan, FunctionBuilder fb) {
    }

    private static void loop(Scanner scan, FunctionBuilder fb) {
    }

    private static void elemMod(Scanner scan, FunctionBuilder fb) {
        System.out.println("Would you like to edit \n  1.The text\n  2.The style");
        int option = UserInput.getIntBewteen(scan,1, 2);
        String name;
        String value;
        switch(option){
            case 1: 
                System.out.println("Please enter the id of the element");
                name = UserInput.getLine(scan);
                System.out.println("Please enter the new text");
                value = UserInput.getLine(scan);
                fb.addElemChange(name, value);
                break;
            case 2: 
                System.out.println("Please enter the id of the element");
                name = UserInput.getLine(scan);
                System.out.println("Please enter the name style you would to edit");
                String style = UserInput.getLine(scan);
                System.out.println("Please enter the new value");
                value = UserInput.getLine(scan);
                fb.addStyleChange(name, style, value);
        }

    }

    private static void ret(Scanner scan, FunctionBuilder fb) {
    }

}
