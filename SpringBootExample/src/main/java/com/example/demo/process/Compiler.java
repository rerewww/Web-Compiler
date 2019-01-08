package com.example.demo.process;

import java.io.File;
import java.io.IOException;

/**
 * Created by son on 2019-01-08.
 */
public interface Compiler {
    public String compile(final File file);
    public StringBuilder executeCommand(final String[] command) throws IOException;
}
