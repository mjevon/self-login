package cn.leon.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * authrization-server(授权服务器)
 */
@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter {


    /**
     * JwtAccessTokenConverter用于编码或解码
     * 使用同一个密钥来编码 JWT 中的  OAuth2 令牌
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        /*设置签名*/
        accessTokenConverter.setSigningKey("smallsnail");
        return accessTokenConverter;
    }

    /**
     * 密码（password）授权类型
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory redisConnection;

    @Autowired
    private DataSource dataSource;

    /**
     * jdbc获取已注册的客户端详情
     *
     * @return
     */
    @Bean
    public ClientDetailsService clientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    /**
     * 配置授权类型（Grant Types）
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        /*redis存储token*/
        /*endpoints.authenticationManager(authenticationManager).tokenStore(new MyRedisTokenStore(redisConnection));*/
        /*jwt方式*/
		/*endpoints.accessTokenConverter(jwtAccessTokenConverter());
		endpoints.authenticationManager(authenticationManager).tokenStore(new JwtTokenStore(jwtAccessTokenConverter()));*/
        /*jwt方式+redis存储token*/
        endpoints
                .tokenStore(new MyRedisTokenStore(redisConnection))
                .accessTokenConverter(jwtAccessTokenConverter())
                .authenticationManager(authenticationManager);
    }

    /**
     * 配置客户端详情（Client Details）
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
    }


}
