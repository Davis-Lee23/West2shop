package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月19日 14:26
 */
@RestController
public class DemoController {

    @GetMapping(value = "/wf")
    public String test(){
        return "123";
    }
}
