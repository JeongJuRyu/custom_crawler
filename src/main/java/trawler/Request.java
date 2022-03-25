package trawler;

import lombok.Getter;
import trawler.model.HttpRequestBody;

import java.io.Serializable;

@Getter
public class Request implements Serializable {
    private static final long serialVersionUID = 2062192774891352043L;
    private String url;
    private String method;
    private HttpRequestBody httpRequestBody;

    public Request(String url) {
        this.url = url;
    }
}
