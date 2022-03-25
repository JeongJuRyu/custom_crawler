package trawler.model;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Html {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Document document;

    public Html(String text, String url){
        try{
            this.document = Jsoup.parse(text, url);
        } catch (Exception e){
            this.document = null;
            this.logger.warn("parse document error ", e);
        }
    }


}
