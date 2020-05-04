package com.training.bootsample.controller;

import com.training.bootsample.common.CommonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.System.identityHashCode;

@Slf4j
@RestController
@RequestMapping("/api")
public class BeanScopeTestControllerSlave {

    private final CommonObject prototypeBean;

    private final CommonObject singletonBean;

    public BeanScopeTestControllerSlave(@Qualifier("prototypeBean") CommonObject prototypeBean,
                                        @Qualifier("singletonBean") CommonObject singletonBean) {
        this.prototypeBean = prototypeBean;
        this.singletonBean = singletonBean;
    }

    @GetMapping("/slave/bean/prototype")
    public int testPrototypeScope() {
        return identityHashCode(prototypeBean);
    }

    @GetMapping("/slave/bean/singleton")
    public int testSingletonScope() {
        return identityHashCode(singletonBean);
    }
}
