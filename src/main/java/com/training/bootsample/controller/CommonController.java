package com.training.bootsample.controller;

import com.training.bootsample.model.NgrinderParam;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
public class CommonController {

    @GetMapping("favicon.ico")
    void ignoreFavicon() {
    }

    @GetMapping("/language")
    public Map<String, Object> chinesesTest(HttpServletResponse httpServletResponse) {
//        httpServletResponse.addHeader("Content-Type", "application/json;charset=UTF-8");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> greetings = new HashMap<>();

        greetings.put("힌국어", "안녕하세요");
        greetings.put("영어", "Hello");
        greetings.put("일본어", "今日は");
        greetings.put("중국어", "你好吗");
        greetings.put("아라비아", "السلام عليكم");
        greetings.put("러시아", "ДРАВСТВУЙТЕ");
        greetings.put("프랑스", "Allô");
        greetings.put("베트남", "A lô");
        greetings.put("태국", "ฮัลโหล");

        response.put("Status", 200);
        response.put("Greetings", greetings);

        return response;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void jsonBody(@RequestBody NgrinderParam ngrinderParam) {
        System.out.println(ngrinderParam);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void formBody(NgrinderParam ngrinderParam) {
        System.out.println(ngrinderParam);
    }

    @GetMapping("/")
    public void queryString(@RequestParam(required = false) String name,
                            @RequestParam(required = false) int age) {
        System.out.println(name + ", " + age);
    }

    @PatchMapping("/")
    public void patchApi(@RequestBody NgrinderParam ngrinderParam) {
        System.out.println(ngrinderParam);
    }

    @RequestMapping(value = "/", method = RequestMethod.HEAD)
    public void headApi(@RequestParam(required = false) String name) {
        System.out.println(name);
    }

}
