package com.example.demo.process;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by son on 2019-01-08.
 */
@Slf4j
@Service
public class CompileManager {
    @Setter Compiler compiler;

    public String run(final Compiler compiler, final File srcFile) {
        if (!srcFile.exists()) {
            log.warn("파일이 존재하지 않습니다.");
            return "";
        }
        return compiler.compile(srcFile);
    }
}
