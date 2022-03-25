package trawler.pipeline;

import lombok.NoArgsConstructor;
import trawler.Task;

import java.util.Iterator;

import static java.util.Map.*;

@NoArgsConstructor
public class ConsolePipeline implements Pipeline {

    @Override
    public void process(ResultValue resultValue, Task task) {
//        System.out.println("get page : " + resultValue.getRequest().getUrl());
        Iterator itr = resultValue.getAll().entrySet().iterator();

        while(itr.hasNext()){
            Entry<String, Object> entry = (Entry)itr.next();
            System.out.println((String)entry.getKey() + ":\t" + entry.getValue());
        }
    }
}
