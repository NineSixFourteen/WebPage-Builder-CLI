package s.s;

import s.s.CSS.CSSPageBuilder;
import s.s.HTML.PageBuilder;

public class Website {

    PageBuilder pb; 
    CSSPageBuilder cpb; 

    public Website(){
        pb = new PageBuilder();
        cpb = new CSSPageBuilder();
    }

    public CSSPageBuilder getCpb() {
        return cpb;
    }
    
    public PageBuilder getPb() {
        return pb;
    }
}
