package s.s.Interface.Tools;

import java.util.Scanner;

public class CSSInput {

    public static String getLength(Scanner scan) {
        System.out.println(
            new StringBuilder()
             .append("Please enter the length in one of these unit types\n")
             .append("  cm\n")
             .append("  mm\n")
             .append("  in\n")
             .append("  px\n")
             .append("  pt\n")
             .append("  pc\n")
             .append("Example 10cm")
        );
        return UserInput.getLine(scan); 
    }

    public static String getColour(Scanner scan) {
        System.out.println(
            new StringBuilder()
             .append("Would you like to choose your colour by\n")
             .append("  1.Name\n")
             .append("  2.RGB\n")
             .append("  3.Hexadecimal\n")
             .append("  4.HSL\n")
        );
        int option = UserInput.getIntBewteen(scan,1, 4);
        StringBuilder sb;
        switch(option){
            case 1:
                System.out.println("Please enter the name of the colour");
                return UserInput.getLine(scan);
            case 2:
                System.out.println("Please enter the red value "); 
                sb = new StringBuilder("rgb(")
                 .append(UserInput.getIntBewteen(scan, 0, 255)).append(", ");
                System.out.println("Please enter the green value "); 
                sb.append(UserInput.getIntBewteen(scan, 0, 255)).append(", ");
                System.out.println("Please enter the blue value "); 
                sb.append(UserInput.getIntBewteen(scan, 0, 255)).append(")");
                return sb.toString();
            case 3:
                System.out.println("Please enter the Hexadecimal Value of the colour");
                return new StringBuilder("#").append(UserInput.getLine(scan)).toString();
            case 4:
                System.out.println("Please enter the Hue value "); 
                sb = new StringBuilder("hsl(")
                .append(UserInput.getIntBewteen(scan, 0, 360)).append(", ");
                System.out.println("Please enter the saturation value "); 
                sb.append(UserInput.getIntBewteen(scan, 0, 100)).append("%, ");
                System.out.println("Please enter the lightness value "); 
                sb.append(UserInput.getIntBewteen(scan, 0, 100)).append("%)");
                return sb.toString();
            default:return "";
        }
    }

    public static String getStyle(Scanner scan) {
        System.out.println(
            new StringBuilder()
             .append("Please choose the style type\n")
             .append("  1.dotted\n")
             .append("  2.dashed\n")
             .append("  3.solid\n")
             .append("  4.double\n")
             .append("  5.groove \n")
             .append("  6.ridge \n")
             .append("  7.inset\n")
             .append("  8.outset \n")
             .append("  9.none \n")
             .append("  10.hidden  \n")
        );
        int option = UserInput.getIntBewteen(scan, 0, 10);
        switch(option){
            case 1:return "dotted";
            case 2:return "dashed";
            case 3:return "solid";
            case 4:return "double";
            case 5:return "groove";
            case 6:return "ridge";
            case 7:return "inset";
            case 8:return "outset";
            case 9:return "none";
            case 10:return "hidden";
            default:return "";
        }
    }
    
}
