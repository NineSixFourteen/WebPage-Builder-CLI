package s.s.HTML;

public class Table {

    private String[] titles; 
    private String[][] contents; 
    private int columnsLength; 

    public Table(int rows, int columns ){
        titles = new String[columns];
        contents = new String[rows][columns];
        columnsLength = columns;
    }

    public String[] getTitles() {
        return titles;
    }

    public String[][] getContents(){
        return contents;
    }

    public Table setTitle(int num, String title) {
        titles[num] = title;
        return this;
    }

    public Table setContent(int num, int num2, String content) {
        contents[num][num2] = content;
        return this;
    }

    public int noOfRows(){
        return titles.length;
    }

    public int noOfColumns() {
        return columnsLength;
    }

}
