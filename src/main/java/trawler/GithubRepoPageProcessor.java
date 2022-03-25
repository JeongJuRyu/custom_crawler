package trawler;

import trawler.model.Page;
import trawler.pipeline.ConsolePipeline;
import trawler.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {
    private Site site = Site.builder().retryTimes(3).sleepTime(1000).build();
    @Override
    public void process(Page page) {
//        page.addTargetRequests(page.getHtml().links().regex("").all());
//        page.put
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args) {
        Trawler.create(new GithubRepoPageProcessor())
                .addUrl("https://www.naver.com")
                .addPipeline(new ConsolePipeline())
                .thread(5)
                .run();
    }
}
