package s.s.Interface;

import java.util.Scanner;

import s.s.HTML.Page;
import s.s.HTML.PageBuilder;

public class MainInterface {

    public static Page init(){
        PageBuilder pb = new PageBuilder(); 
        System.out.println(
            new StringBuilder()
                .append("Welcome to this thing i built for somereason\n")
                .append("Would you like to \n")
                .append("  1. Create an webpage from scratch\n")
                .append("  2. Parse in an existing Page\n")
                .append("  3. Exit\n")
        );
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch(option){
            case 1: 
                makeBasicPage(pb,scan); 
                break;
            case 2: 
                break; 
            case 3:
                break;
        }
        scan.close();
        return pb.Build();
    }

    private static void makeBasicPage(PageBuilder pb, Scanner scan) {
        System.out.println("Please enter the name of the webpage");
        String name = scan.nextLine();
        pb.setTitle(name);
        fillOutPage(pb, scan);
    }
    
}
