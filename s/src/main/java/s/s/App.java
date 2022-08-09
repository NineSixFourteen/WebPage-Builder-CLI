package s.s;

import java.awt.Desktop;
import java.io.File;
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import s.s.HTML.ListBuilder;
import s.s.HTML.Page;
import s.s.HTML.PageBuilder;
import s.s.HTML.TableBuilder;

public class App 
{

    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        TableBuilder tb = new TableBuilder(2, 3);
        PageBuilder pb = new PageBuilder();
        Page p = pb
         .addParagraph("Hello world")
         .addTable(
            tb
             .setTitle(0, "Ding")
             .setTitle(1, "Dong")
             .setTitle(2, "Bong")
             .setRow(0, new String[]{"1","2","3"})
             .setRow(1, new String[]{"3","4","5"})
             .build()
        ).addDiv(
            new PageBuilder()
            .addParagraph("Goodbye World!")
            .addParagraph("LMAO")
            .Build().getBody() 
        ).addList(
          new ListBuilder(0)
           .addElems(new String[]{"init","nini","bili"})
           .Build()
        ).addList(
          new ListBuilder(2)
           .addElems(new String[]{"Book","has words","man","has pepe"})
           .Build()
        ).Build();
        System.out.println(p.toString());
        String page = 
            new StringBuilder()
            .append("<!DOCTYPE html>\n")
            .append("<html lang=\"en\"\n")
            .append("<head>\n")
            .append("<title>Page Title</title>\n")
            .append("<meta charset=\"UTF-8\">\n")
            .append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n")
            .append("</head>\n")
            .append("<body\n")
            .append(p.toString())
            .append("</body>\n")
            .append("</html>")
            .toString();
            try {
                FileWriter myWriter = new FileWriter("test1.html");
                myWriter.write(page);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
            File htmlFile = new File("test1.html");
            Desktop.getDesktop().browse(htmlFile.toURI());
    }
}
