package com.training.bootsample.controller;

import com.training.bootsample.common.CommonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Integer.toHexString;
import static java.lang.System.identityHashCode;

@Slf4j
@RestController
@RequestMapping("/api")
public class BeanScopeTestControllerMaster {

    private final CommonObject prototypeBean;

    private final CommonObject singletonBean;

    private final CommonObject requestBean;

    private final CommonObject sessionBean;

    public BeanScopeTestControllerMaster(@Qualifier("prototypeBean") CommonObject prototypeBean,
                                         @Qualifier("singletonBean") CommonObject singletonBean,
                                         @Qualifier("requestBean") CommonObject requestBean,
                                         @Qualifier("sessionBean") CommonObject sessionBean) {
        this.prototypeBean = prototypeBean;
        this.singletonBean = singletonBean;
        this.requestBean = requestBean;
        this.sessionBean = sessionBean;
    }

    @GetMapping("/master/bean/prototype")
    public int testPrototypeScope() {
        return identityHashCode(prototypeBean);
    }

    @GetMapping("/master/bean/singleton")
    public int testSingletonScope() {
        return identityHashCode(singletonBean);
    }

    @GetMapping("/master/bean/request")
    public String testRequestScope() {
        return toHexString(requestBean.hashCode()) + ":" + requestBean.toString();
    }

    @GetMapping("/master/bean/session")
    public String testSessionScope() {
        return sessionBean.toString();
    }
}
