package com.example.demo.process;

import java.io.File;
import java.io.IOException;

/**
 * Created by son on 2019-01-08.
 */
public interface Compiler {
    File getSrcFile(final File file, final String text);
    String compile(final File file);
    StringBuilder executeCommand(final String[] command) throws IOException;
}