package s.s;

import s.s.HTML.PageBuilder;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        PageBuilder pb = new PageBuilder();
        pb.addParagraph("Hello world");
        
    }
}
