package trawler;

import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trawler.downloader.Downloader;
import trawler.pipeline.ConsolePipeline;
import trawler.pipeline.Pipeline;
import trawler.processor.PageProcessor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Builder
public class Trawler implements Runnable {
    
    protected Downloader downloader;
    protected Scheduler scheduler = new Scheduler();
    protected List<Pipeline> pipelines = new ArrayList<>();
    protected PageProcessor pageProcessor;
    protected List<Request> startRequestList;
    protected Site site;
    protected String uuid;
    protected int threadNum = 1;
    protected AtomicInteger stat = new AtomicInteger(0);
    private Logger logger = LoggerFactory.getLogger(Trawler.class);
    private ReentrantLock newUrlLock = new ReentrantLock();
    private Condition newUrlCondition;
    private final AtomicLong pageCount;
    private LocalDateTime startTime;
    private int emptySleepTime;


    public static Trawler create(PageProcessor pageProcessor){
        return new Trawler(pageProcessor);
    }

    public Trawler(PageProcessor pageProcessor){
        this.newUrlCondition = this.newUrlLock.newCondition();
        this.pageCount = new AtomicLong(0L);
        this.emptySleepTime = 30000;
        this.pageProcessor = pageProcessor;
        this.site = pageProcessor.getSite();
    }


    public String getUUID(){
        if(this.uuid != null){
            return this.uuid;
        } else if (this.site != null){
            return this.site.getDomain();
        } else{
            this.uuid = UUID.randomUUID().toString();
            return this.uuid;
        }
    }
    public void addRequest(Request request){
        this.scheduler.push(request);
    }

    public Trawler addUrl(String ...urls){
        for(String url : urls){
            this.addRequest(new Request(url));
        }
        this.signalNewUrl();
        return this;
    }

    private void signalNewUrl() {
    }

    public Trawler thread(int threadNum){
        if(threadNum <= 0){
            throw new IllegalArgumentException("쓰레드 갯수는 반드시 1개 이상이어야 합니다.");
        }
        this.threadNum = threadNum;
        return this;
    }

    public Trawler addPipeline(Pipeline pipeline){
        this.pipelines.add(pipeline);
        return this;
    }

    public void initComponent(){
        if(this.downloader == null){
            this.downloader = new HttpClientDownloader();
        }

        if(this.pipelines.isEmpty()){
            this.pipelines.add(new ConsolePipeline());
        }
    }
    public void run(){
        this.initComponent();
        this.logger.info("Trawler {} is running", this.getUUID());
    }
}
