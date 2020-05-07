package com.training.bootsample.controller;

import com.training.bootsample.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionTestController {

    private final MemberService memberService;

    @GetMapping("")
    public String testTransaction() {
        try {
            memberService.testTransaction();
        } catch (Exception e) {
            // NoOp
        }
        return "success";
    }
}
