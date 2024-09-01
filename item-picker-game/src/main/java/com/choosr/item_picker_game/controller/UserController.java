package com.choosr.item_picker_game.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }
}
