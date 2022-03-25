package trawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Scheduler {
    private BlockingQueue<Request> queue = new LinkedBlockingQueue<>();
    private Logger logger = LoggerFactory.getLogger(Scheduler.class);
    private DuplicateUrlRemover duplicateUrlRemover;

    public void push(Request request) {
        this.logger.trace("Url : {}", request.getUrl());
        if(this.duplicateUrlRemover.isDuplicate(request)){
            this.logger.debug("push to queue {}", request.getUrl());
        }
    }
}
