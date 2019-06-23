import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Crawler {

    private Document document;
    private String text;

    public Crawler(String url) {
        text = "";
        try {
            this.document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public String findAll(){

        for (Element element : document.select("html")) {
            text = element.select("p").text();
        }
        System.out.println(text);
        return text;
    }

    public void save() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HHmm");
        String currentData = sdf.format(new Date());
        try {
            PrintWriter out = new PrintWriter("uniformly"+ currentData +".txt");
            out.println(text);
            out.close();
            out = new PrintWriter("separately"+ currentData +".txt");
            Scanner scanner = new Scanner(text);
            while(scanner.hasNext()){
                out.println(scanner.next());
            }
            out.close();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
