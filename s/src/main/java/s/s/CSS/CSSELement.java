package s.s.CSS;

import java.util.ArrayList;

public class CSSElement {

    private String name; 
    private State state; 
    private Type type; 
    private ArrayList<Style> styles; 

    public CSSElement(String name, Type type){
        this.name = name; 
        this.state = State.None;
        this.styles = new ArrayList<>();
        this.type = type;
    }
    
    public void setState(State state) {
        this.state = state;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public ArrayList<Style> getStyles() {
        return styles;
    }
}
