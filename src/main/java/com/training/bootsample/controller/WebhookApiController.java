package com.training.bootsample.controller;

import com.training.bootsample.model.WebhookPayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/webhook")
public class WebhookApiController {

    @PostMapping(value="/", consumes = APPLICATION_JSON_VALUE)
    public void webhook(@RequestBody Map<String, Object> payload) {
        System.out.println("webhook called");
        System.out.println(payload);
    }

//    @PostMapping(value="/form", consumes = APPLICATION_FORM_URLENCODED_VALUE)
//    public void webhookForm(@RequestBody MultiValueMap<String, Object> payload) {
//        System.out.println("webhook form called");
//        System.out.println(payload);
//    }

    @PostMapping(value="/form", consumes = APPLICATION_FORM_URLENCODED_VALUE)
    public void webhookForm(WebhookPayload payload) {
        System.out.println("webhook form called");
        System.out.println(payload.toString());
    }
}
