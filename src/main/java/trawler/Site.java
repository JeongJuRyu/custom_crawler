package trawler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Builder
public class Site {
    private String domain;
    private String userAgent;
    private Map<String, String> defaultCookies = new LinkedHashMap<>();
    private String charset;
    private int sleepTime = 5000;
    private int retryTimes = 0;
    private int cycleRetryTimes = 0;
    private int retrySleepTimes = 0;
    private int timeOut = 5000;
    private static final Set<Integer> DEFAULT_STATUS_CODE_SET = new HashSet<>();
    private Set<Integer> acceptStatCode;
    private Map<String, String> headers;
    private boolean useGzip;
    private boolean disableCookieManagement;

    public Site(){
        this.acceptStatCode = DEFAULT_STATUS_CODE_SET;
        this.headers = new HashMap<>();
        this.useGzip = true;
    }

    public static Site create() { return new Site();}
}
