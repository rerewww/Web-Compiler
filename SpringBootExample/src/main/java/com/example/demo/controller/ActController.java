package com.example.demo.controller;

import com.example.demo.model.ResultCompile;
import com.example.demo.process.Compiler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by son on 2019-01-08.
 */

@Controller
public class ActController {

    @RequestMapping("/")
    public String init() {
        return "index";
    }

    @RequestMapping("/compile.action")
    public ResultCompile compile (
            @RequestParam("text") String text
    ) {
        System.out.println(text);
        String result = Compiler.compile(text);
        return new ResultCompile(true, "ok", result);
    }

    @RequestMapping("/codingView.action")
    public String codingView() {
        return "editor";
    }
}
