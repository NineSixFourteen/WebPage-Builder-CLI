package s.s.HTML;

import java.util.ArrayList;

public class LList {

    private int type; // 0 = unorderd // 1 = Ordered // 2 = Descriptive // else ERROR 
    private ArrayList<String> elems ;

    public LList(int ty){
        type = ty; 
        elems = new ArrayList<>();
    }

    public int getType() {
        return type;
    }

    public ArrayList<String> getElems() {
        return elems;
    }

    public LList append(String s){
        elems.add(s);
        return this;
    }

}