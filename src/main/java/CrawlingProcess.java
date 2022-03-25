import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CrawlingProcess {
    public static void main(String[] args) throws IOException {
//        trawler.create(new CustomProcessor())
//                .addUrl()
//                .addPipeline(new CustomPipeline())
//                .thread(5)
//                .run
        final String inflearnUrl = "https://www.inflearn.com/courses/it-programming";
        Connection conn = Jsoup.connect(inflearnUrl);
        Document document = conn.get();
        Elements imageUrlElements = document.getElementsByClass("swiper-lazy");
        for(Element element :  imageUrlElements){
            System.out.println(element.attr("abs:src"));
        }
        Elements titleElements = document.select("div.card-content > div.course_title");
        for(int j = 0; j < titleElements.size(); j++){
            final String title = titleElements.get(j).text();
            System.out.println("강의 제목 : " + title);
        }

    }
}