import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Crawler crawler = new Crawler("https://en.ryte.com/wiki/Crawler");
        crawler.findAll();
        crawler.save();
    }
}
