package s.s.HTML;

public class ListBuilder {

    private LList list ; 

    public ListBuilder(int type ){
        list = new LList(type);
    } 

    public ListBuilder addElem(String s){
        list.append(s);
        return this;
    }

    public ListBuilder addElems(String[] elems){
        for(String e : elems){
            list.append(e);
        }
        return this; 
    }

    public LList Build(){
        return list;
    }
    
}
