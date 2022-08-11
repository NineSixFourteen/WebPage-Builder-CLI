package s.s.HTML;

public class Heading {

    private int level; 
    private String msg; 

    public Heading(int level, String msg) {
        this.level = level; 
        this.msg = msg; 
    }

    public int getLevel() {
        return level;
    }
    
    public String getMsg() {
        return msg;
    }
}
