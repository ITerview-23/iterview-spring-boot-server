package com.iterview.iterviewspringbootserver.controller;

import com.iterview.iterviewspringbootserver.service.IterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class IterviewController {

    private final IterviewService iterViewService;
    @GetMapping("/parse")
    public ArrayList<String> parse(@RequestParam String input) {
        return iterViewService.parse(input);
    }
}
