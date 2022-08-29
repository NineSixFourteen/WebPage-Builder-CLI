package s.s.JS;

import java.util.ArrayList;

import s.s.JS.Lines.Line;

public class Function {

    String name; 
    ArrayList<String> params;
    ArrayList<Line> Lines;
    
    public Function(String name){
        Lines = new ArrayList<>();
        params = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<Line> getLines() {
        return Lines;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getParams() {
        return params;
    }
}
