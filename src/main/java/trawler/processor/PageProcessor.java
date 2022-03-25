package trawler.processor;

import trawler.Site;
import trawler.model.Page;

public interface PageProcessor {
    void process(Page page);
    Site getSite();
}
