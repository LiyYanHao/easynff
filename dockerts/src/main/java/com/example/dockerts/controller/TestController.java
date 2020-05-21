package com.example.dockerts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyh on 2020/5/21
 */
@RestController
@RequestMapping("/docker")
public class TestController {
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello docker !!";
    }

}