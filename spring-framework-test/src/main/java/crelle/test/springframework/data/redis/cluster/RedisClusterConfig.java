package crelle.test.springframework.data.redis.cluster;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author:crelle
 * @className:RedisClusterConfig
 * @version:1.0.0
 * @date:2020/9/30
 * @description:XX
 **/
@SpringBootConfiguration
public class RedisClusterConfig {
    @Autowired
    private RedisClusterConfigProperties clusterProperties;

    @Bean
    public RedisClusterConfiguration getClusterConfig() {
        RedisClusterConfiguration rcc = new RedisClusterConfiguration(clusterProperties.getNodes());
        rcc.setMaxRedirects(clusterProperties.getMaxRedirects().intValue());
        return rcc;
    }

    @Bean
    @Primary
    public JedisConnectionFactory getConnectionFactory(RedisClusterConfiguration cluster) {
        return new JedisConnectionFactory(cluster);
    }

    @Bean
    public RedisTemplate getRedisTemplate(JedisConnectionFactory factory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate getStringRedisTemplate( RedisConnectionFactory factory) {
        StringRedisTemplate stringTemplate = new StringRedisTemplate();
        stringTemplate.setConnectionFactory(factory);
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        stringTemplate.setKeySerializer(redisSerializer);
        stringTemplate.setHashKeySerializer(redisSerializer);
        stringTemplate.setValueSerializer(redisSerializer);
        return stringTemplate;
    }
}