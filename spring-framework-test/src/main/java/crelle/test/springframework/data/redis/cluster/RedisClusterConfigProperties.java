package crelle.test.springframework.data.redis.cluster;


import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:crelle
 * @className:RedisClusterConfigProperties
 * @version:1.0.0
 * @date:2020/9/30
 * @description:XX
 **/
@Component
@ConfigurationProperties(prefix = "redis.cluster")
public class RedisClusterConfigProperties {
    /**
     * master nodes
     */
    private List<String> nodes;

    /**
     * max redirects
     */
    private Integer maxRedirects = 3;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public Integer getMaxRedirects() {
        return maxRedirects;
    }

    public void setMaxRedirects(Integer maxRedirects) {
        this.maxRedirects = maxRedirects;
    }
}
