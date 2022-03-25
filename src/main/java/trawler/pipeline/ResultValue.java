package trawler.pipeline;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trawler.Request;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class ResultValue {
    private Map<String, Object> fields = new LinkedHashMap<>();
    private Request request;
    private boolean skip;

    public <T> T get(String key){
        Object o = this.fields.get(key);
        return o == null ? null : (T) this.fields.get(key);
    }

    public Map<String, Object> getAll(){ return this.fields;}

    public boolean isSkip(){return this.skip;}

    public ResultValue setSkip(boolean skip){
        this.skip = skip;
        return this;
    }

}
