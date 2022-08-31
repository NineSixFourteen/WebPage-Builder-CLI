package s.s.HTML;

import s.s.JS.Lines.Line;

public class Button {

    private String text; 
    private Line line; 

    public Button(String text,Line line){
        this.text = text;
        this.line = line;
    }

    public Line getLine() {
        return line;
    }

    public String getText() {
        return text;
    }
    
}
