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
}
