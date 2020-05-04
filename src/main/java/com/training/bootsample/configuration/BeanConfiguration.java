package com.training.bootsample.configuration;

import com.training.bootsample.common.CommonObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;
import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;
import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;

@Configuration
public class BeanConfiguration {

    @Bean("singletonBean")
    public CommonObject getSingletonScopeBean() {
        return new CommonObject();
    }

    @Bean("prototypeBean")
    @Scope("prototype")
    public CommonObject getPrototypeScopeBean() {
        return new CommonObject();
    }

    @Bean("requestBean")
    @RequestScope
    //@Scope(value = SCOPE_REQUEST, proxyMode = TARGET_CLASS)
    public CommonObject getRequestScopeBean() {
        return new CommonObject();
    }

    @Bean("sessionBean")
    @SessionScope
    //g@Scope(value = SCOPE_SESSION, proxyMode = TARGET_CLASS)
    public CommonObject getSessionScopeBean() {
        return new CommonObject();
    }
}
