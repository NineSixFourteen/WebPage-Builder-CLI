package s.s.Interface.Tools;

import java.util.ArrayList;
import java.util.Scanner;


public class UserInput {

    public static int getIntBewteen(Scanner scan, int min, int max){
        while(true){
            try {
                int num = scan.nextInt();
                if(num >= min && num <= max){
                    return num;
                } else {
                    System.out.println(
                        new StringBuilder()
                         .append("Error: Number not within range of ")
                         .append(min)
                         .append(", ")
                         .append(max)
                    );
                }
            } catch (Exception e ){
                System.out.println("Error: Non number entered");
                scan.nextLine();
            }
        } 
    }

    public static String[] getChanges(Scanner scan, String[] old){
        while(true){
            System.out.println("Please enter your changes");
            String line = UserInput.getLine(scan);
            try {
                ArrayList<Change> changes = Parser.parseChanges(line);
                for(Change ch : changes){
                    old[ch.getInd() - 1] = ch.getChange();
                }
                return old;
            } catch(Exception e) {
                System.out.println("Error : Format was incorrect please enter in the format\n 1.Yes, 2.No, 3.Something");
            }
        }
    }

    public static String[] getList(Scanner scan){
        scan.nextLine();
        ArrayList<String> items = new ArrayList<>();
        for(String item : scan.nextLine().split(",")){
            items.add(item.strip());
        } 
        return items.toArray(new String[0]);
    }

    public static String[][] getListofList(Scanner scan) {
        boolean run = true;
        ArrayList<String[]> body = new ArrayList<>();
        while(run) {
            System.out.println("Would you like to add another row 1. Yes 2. No");
            int option = UserInput.getIntBewteen(scan, 1, 2);
            switch(option){
                case 1:
                    body.add(getList(scan)); 
                    break;
                case 2: 
                    run = false;
            }
        }
        return body.toArray(new String[0][0]);
    }
    
    public static String getLine(Scanner scan) {
        if(scan.hasNext()) {
            scan.nextLine();
        }
        return scan.nextLine();
    }

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
        return getLine(scan); 
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
        int option = getIntBewteen(scan,1, 4);
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
}
