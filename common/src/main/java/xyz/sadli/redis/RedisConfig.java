package xyz.sadli.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import xyz.sadli.common.Constants;

import java.time.Duration;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/11/26 17:30.
 * Editored:
 */
@Configuration
public class RedisConfig {

//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;

//    @Bean
//    public RedisTemplate<String, String> redisTemplate() {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        //序列化时允许非常量字段均输出类型，即redis序列化后带有类型
//        //objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)方法已从2.10.0开始标记@Deprecated，使用下面方法代替
//        //参考：https://segon.cn/jackson-objectmapper-enabledefaulttyping-deprecated.html
//        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//        //redis key的序列化
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        //redis value的序列化
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        return redisTemplate;
//    }


    /**
     * 修改redis缓存管理器中key和value的序列化方式，若不修改，则使用的是默认的jdk序列化，存储到redis里面查看是乱码
     * @param factory
     * @return
     */
    @Bean
    public RedisCacheManager redisCacheManager(LettuceConnectionFactory factory) {
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMillis(Constants.REDIS_CACHE_ENTRY_TTL))
                .computePrefixWith(name -> name + ":")//redis2.x版本中，保存缓存时默认会在cacheNames后面加上双冒号，使用该配置改为单冒号
                .disableCachingNullValues()//禁止缓存null值
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return RedisCacheManager.builder(factory).cacheDefaults(configuration).build();
    }


//    @Bean
//    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory factory){
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }
}
