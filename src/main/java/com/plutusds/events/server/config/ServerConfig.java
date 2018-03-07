package com.plutusds.events.server.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Component
@Data
@Slf4j
public class ServerConfig {
    public String profile;

    public ServerConfig() {
        Properties properties = System.getProperties();

    }

    @PostConstruct
    public void init(){
        log.info("[CONFIG] {}", "hello");
    }



}
