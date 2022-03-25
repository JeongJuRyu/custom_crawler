package trawler.pipeline;

import trawler.Task;

public interface Pipeline {
    void process(ResultValue resultValue, Task task);

}
