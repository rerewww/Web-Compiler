package com.example.demo.controller;

import com.example.demo.model.ResultCompile;
import com.example.demo.service.ActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

/**
 * Created by son on 2019-01-08.
 */

@Controller
public class ActController {
    ActService actService;

    @Autowired
    ActController(final ActService actService) {
        this.actService = actService;
    }
    
    @RequestMapping("/")
    public String init() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/compile.action", method = RequestMethod.POST)
    public ResultCompile compile (
            @RequestParam("text") String text,
            @RequestParam("lang") String lang

    ) {
        System.out.println("--------------- 요청된 코드 ---------------");
        System.out.println(text);
        System.out.println("------------------------------------------");
        File workDir = new File("C:\\tmp");
        workDir.mkdirs();

        String result = actService.run(text, lang);

        ResultCompile resultCompile = new ResultCompile();
        resultCompile.setSuccess(!StringUtils.isEmpty(result));
        resultCompile.setMessage("ok");
        resultCompile.setResult(result);
        return resultCompile;
    }

    @RequestMapping("/codingView.action")
    public ModelAndView codingView() {
        ModelAndView mv = new ModelAndView("question");
        mv.addObject("questions", actService.getQuestionsJsonString());
        return mv;
    }

    @RequestMapping(value = "/coding.action")
    public ModelAndView codingView(
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        ModelAndView mv = new ModelAndView("editor");
        mv.addObject("title", title);
        mv.addObject("content", content);

        return mv;
    }
}
