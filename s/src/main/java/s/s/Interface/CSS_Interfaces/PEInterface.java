package s.s.Interface.CSS_Interfaces;

import java.util.Scanner;

import s.s.WebsiteBuilder;
import s.s.CSS.CSSElementBuilder;
import s.s.Interface.CSS_Interfaces.Style_Types.Border_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Border_Other_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Border_Style_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Colour_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Font_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Letter_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.List_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Margin_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Other_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Outline_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Padding_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Size_Interface;
import s.s.Interface.CSS_Interfaces.Style_Types.Text_Interface;
import s.s.Interface.Tools.UserInput;

//Populate Element Interafce 
public class PEInterface {

    public static void init(WebsiteBuilder web, Scanner scan, CSSElementBuilder element) {
        boolean run = true;
        while(run){
            System.out.println(
                new StringBuilder()
                .append("What type of style would you like to add\n")
                .append("  1.Size\n")
                .append("  2.Colour\n")
                .append("  3.Margin\n")
                .append("  4.Paddding\n")
                .append("  5.Border\n")
                .append("  6.Border Style\n")
                .append("  7.Border Other\n")
                .append("  8.Outline\n")
                .append("  9.Text\n")
                .append("  10.Letter\n")
                .append("  11.Font\n")
                //.append("  12.List\n")
                //.append("  13.Other\n")
                .append("0. Go Back")
            );
            int option = UserInput.getIntBewteen(scan, 0, 11);
            switch(option) {
                case 1: 
                    Size_Interface.init(scan,element);
                    break;
                case 2: 
                    Colour_Interface.init(scan,element);
                    break;
                case 3:  
                    Margin_Interface.init(scan,element);
                    break;
                case 4: 
                    Padding_Interface.init(scan,element);
                    break;
                case 5:  
                    Border_Interface.init(scan,element);
                    break;
                case 6: 
                    Border_Style_Interface.init(scan,element);
                    break;
                case 7: 
                    Border_Other_Interface.init(scan,element);
                    break;
                case 8:
                    Outline_Interface.init(scan,element);
                    break;
                case 9: 
                    Text_Interface.init(scan,element);
                    break;
                case 10:  
                    Letter_Interface.init(scan,element);
                    break;
                case 11: 
                    Font_Interface.init(scan,element);
                    break;
                case 12: 
                    List_Interface.init(scan,element);
                    break;
                case 13: 
                    Other_Interface.init(scan,element);
                    break;
                default:
                    run = false;
            }
        }
    }

}

    