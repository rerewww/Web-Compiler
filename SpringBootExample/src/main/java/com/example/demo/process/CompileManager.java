package com.example.demo.process;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by son on 2019-01-08.
 */
public class CompileManager {
    public static String run(final String text) {
        File file = new File("C:\\tmp\\Test.java");
        try {
            FileUtils.writeStringToFile(file, text, Charset.forName("utf-8"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (!file.exists()) {
            System.out.println("파일이 존재하지 않습니다.");
            return "";
        }

        JavaCompiler javaCompiler = new JavaCompiler();
        javaCompiler.compile(file);

        return "success";
    }
}
