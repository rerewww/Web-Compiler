package com.example.demo.process;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by son on 2019-01-08.
 */
@Slf4j
public class JavaCompiler implements Compiler {
    private static final String PREFIX_JAVA = "java";
    private static final String PREFIX_JAVAC = "javac";
    private static final String PREFIX_JAVA_CLASS_PATH = "-cp";

    @Override
    public File getSrcFile(File parentFile, String text) {
        File srcFile = new File(String.format("%s\\Test.java", parentFile.getAbsolutePath()));
        try {
            FileUtils.writeStringToFile(srcFile, text, Charset.forName("utf-8"));
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
        }

        return srcFile;
    }

    @Override
    public String compile(final File file) {
	    StringBuilder result = new StringBuilder();
        try {
            // Make Class file
            this.executeCommand(new String[]{ PREFIX_JAVAC, file.getAbsolutePath() });
            // Run Class file
            if (new File(file.getAbsolutePath().replace("java", "class")).exists()) {
                log.info("Created a class file");
            }

            log.info("Running is class file");
            result = this.executeCommand(new String[]{ PREFIX_JAVA, PREFIX_JAVA_CLASS_PATH,
                    file.getParent(), FilenameUtils.getBaseName(file.getName())});
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
        }

        return result.toString();
    }

    @Override
    public StringBuilder executeCommand(final String[] command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
	    processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "MS949"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                result.append(line);
                line = bufferedReader.readLine();
            }
            process.waitFor();
        } catch (InterruptedException e) {
            log.warn(e.getMessage());
        }
        process.destroy();
        return result;
    }
}
