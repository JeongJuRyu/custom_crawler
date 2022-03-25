package trawler.model;

import trawler.Request;

public class Page {
    private Request request;
    private ResultItems resultItems = new ResultItems();
    private Html html;
    private Json json;
    private String rawText;
    private final int statusCode = 200;
    private boolean downloadSuccess = true;
    private byte[] bytes;
}
