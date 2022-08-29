package s.s.Interface.JS_Interfaces;

import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.Interface.Tools.UserInput;
import s.s.JS.FunctionBuilder;
//Create Functoin Interface
public class CFInterface {

    public static void init(WebsiteBuilder web, Scanner scan){
        System.out.println("Please enter the name of the function");
        String name = UserInput.getLine(scan);
        FunctionBuilder fb = new FunctionBuilder(name);
        PFInterface.init(web, scan,fb);
    }
    
}
