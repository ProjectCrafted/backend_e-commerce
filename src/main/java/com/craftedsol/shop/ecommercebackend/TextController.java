package com.craftedsol.shop.ecommercebackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
