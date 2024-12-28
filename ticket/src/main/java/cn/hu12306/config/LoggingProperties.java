package cn.hu12306.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hcc
 */
@Component
@ConfigurationProperties(prefix = "logging")
public class LoggingProperties {

    private List<String> includePaths;

    public List<String> getIncludePaths() {
        return includePaths;
    }

    public void setIncludePaths(List<String> includePaths) {
        this.includePaths = includePaths;
    }

}
