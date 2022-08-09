package s.s.HTML;

public class Page {

    StringBuilder sb;

    public Page() {
        this.sb = new StringBuilder();
    } 

    public Page append(String s){
        sb.append(s);
        return this;
    }
    
}
