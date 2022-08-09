package s.s.HTML;

public class TableBuilder {

    public Table tab;

    public TableBuilder(int row, int column){
        tab = new Table(row, column);
    }

    public TableBuilder setTitle(int r, String title) {
        tab.setTitle(r, title);
        return this;
    }

    public TableBuilder setContent(int r, int c, String cont) {
        tab.setContent(r, c, cont);
        return this;
    }

    public TableBuilder setRow(int r, String[] conts) {
        for(int i = 0; i < conts.length;i++){
            tab.setContent(r, i, conts[i]);
        }
        return this;
    }

    public TableBuilder setColumn(int col, String[] conts){
        for(int i = 0; i < conts.length; i++) {
            tab.setContent(i, col, conts[i]);
        }
        return this;
    }

    public Table build(){
        return tab;
    }
    
}
