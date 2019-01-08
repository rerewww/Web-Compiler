package com.example.demo.controller;

import com.example.demo.model.ResultCompile;
import com.example.demo.process.CompileManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

/**
 * Created by son on 2019-01-08.
 */

@Controller
public class ActController {
    @RequestMapping("/")
    public String init() {
        return "index";
    }

    @RequestMapping(value = "/compile.action", method = RequestMethod.POST)
    public ResultCompile compile (
            @RequestParam("text") String text
    ) {
        System.out.println(text);
        File workDir = new File("C:\\tmp");
        workDir.mkdirs();

        String result = CompileManager.run(text);
        return new ResultCompile(true, "ok", result);
    }

    @RequestMapping("/codingView.action")
    public String codingView() {
        return "editor";
    }
}
