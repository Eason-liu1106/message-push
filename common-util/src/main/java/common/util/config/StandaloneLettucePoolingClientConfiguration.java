package common.util.config;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.ReadFrom;
import io.lettuce.core.resource.ClientResources;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;

import java.time.Duration;
import java.util.Optional;

/**
 * @author wangcanfeng
 * @description 单机版具有连接池的配置信息
 * @Date Created in 14:50-2019/4/1
 */
public class StandaloneLettucePoolingClientConfiguration implements LettucePoolingClientConfiguration {

    /**
     * 客户端配置对象
     */
    private final LettuceClientConfiguration clientConfiguration;
    /**
     * 连接池配置对象
     */
    private final GenericObjectPoolConfig poolConfig;
    /**
     * 单机版配置对象
     */
    private final RedisStandaloneConfiguration standaloneConfiguration;

    /**
     * 功能描述: 单机版配置类的构造函数
     *
     * @param poolConfig 连接池信息
     * @param host       主机地址
     * @param port       主机端口
     * @param timeout    连接超时时间
     * @return:
     * @since: v1.0
     * @Author:
     * @Date:
     */
    public StandaloneLettucePoolingClientConfiguration(GenericObjectPoolConfig poolConfig,
                                                       String host, Integer port, Duration timeout) {
        this.poolConfig = poolConfig;
        this.clientConfiguration = LettuceClientConfiguration.builder().commandTimeout(timeout).build();
        this.standaloneConfiguration = new RedisStandaloneConfiguration(host, port);
    }

    public RedisStandaloneConfiguration getStandaloneConfiguration() {
        return standaloneConfiguration;
    }


    @Override
    public GenericObjectPoolConfig getPoolConfig() {
        return poolConfig;
    }


    @Override
    public boolean isUseSsl() {
        return clientConfiguration.isUseSsl();
    }


    @Override
    public boolean isVerifyPeer() {
        return clientConfiguration.isVerifyPeer();
    }


    @Override
    public boolean isStartTls() {
        return clientConfiguration.isStartTls();
    }


    @Override
    public Optional<ClientResources> getClientResources() {
        return Optional.empty();
    }


    @Override
    public Optional<ClientOptions> getClientOptions() {
        return Optional.empty();
    }

    /**
     * @return the optional client name to be set with {@code CLIENT SETNAME}.
     * @since 2.1
     */
    @Override
    public Optional<String> getClientName() {
        return Optional.empty();
    }

    /**
     * Note: Redis is undergoing a nomenclature change where the term replica is used synonymously to slave.
     *
     * @return the optional {@link ReadFrom} setting.
     * @since 2.1
     */
    @Override
    public Optional<ReadFrom> getReadFrom() {
        return Optional.empty();
    }

    @Override
    public Duration getCommandTimeout() {
        return clientConfiguration.getCommandTimeout();
    }

    @Override
    public Duration getShutdownTimeout() {
        return clientConfiguration.getShutdownTimeout();
    }
}