package com.training.bootsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CommonController {

    @GetMapping("favicon.ico")
    @ResponseBody
    void ignoreFavicon() {
    }
}
