package trawler;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DuplicateUrlRemover {
    private Set<String> urls = Collections.newSetFromMap(new ConcurrentHashMap<>());
    public boolean isDuplicate(Request request){
        return !this.urls.add(request.getUrl());
    }
}
