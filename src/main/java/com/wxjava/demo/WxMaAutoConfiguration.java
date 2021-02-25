package com.wxjava.demo;

import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaRedissonConfigImpl;
import com.binarywang.spring.starter.wxjava.miniapp.properties.WxMaProperties;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class WxMaAutoConfiguration {

    private final WxMaProperties wxMaProperties;

    @Bean
    public WxMaConfig wxMaConfig(RedissonClient redissonClient) {
        WxMaRedissonConfigImpl config = new WxMaRedissonConfigImpl(redissonClient);

        config.setAppid(StringUtils.trimToNull(this.wxMaProperties.getAppid()));
        config.setSecret(StringUtils.trimToNull(this.wxMaProperties.getSecret()));
        config.setToken(StringUtils.trimToNull(this.wxMaProperties.getToken()));
        config.setAesKey(StringUtils.trimToNull(this.wxMaProperties.getAesKey()));
        config.setMsgDataFormat(StringUtils.trimToNull(this.wxMaProperties.getMsgDataFormat()));
        return config;
    }
}