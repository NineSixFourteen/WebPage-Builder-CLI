package s.s.Interface.Tools;

import java.util.ArrayList;

public class Parser {

    public static ArrayList<Change> parseChanges(String line){
        ArrayList<Change> changes = new ArrayList<>();
        String[] elems = line.split(",");
        for(String elem : elems){
            elem = elem.strip();
            int ind = Integer.parseInt(elem.charAt(0) + "");
            String change = elem.substring(2);
            changes.add(new Change(ind, change));
        }
        return changes;
    }
    
}
