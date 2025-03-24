package com.lhcamposs.config;

import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("com.lhcamposs.controller");
    }
}
