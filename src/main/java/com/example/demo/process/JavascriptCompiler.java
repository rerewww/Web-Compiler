package com.example.demo.process;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by son on 2019-01-17.
 */
@Slf4j
public class JavascriptCompiler implements Compiler {
    private static final String PREFIX_NODE = "node";
    @Override
    public File getSrcFile(File file, String text) {
        File srcFile = new File(String.format("%s\\Test.js", file.getAbsolutePath()));
        try {
            FileUtils.writeStringToFile(srcFile, text, Charset.forName("utf-8"));
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
        }

        return srcFile;
    }

    @Override
    public String compile(File file) {
        StringBuilder result = new StringBuilder();
		try {
			// Make Class file
			result = this.executeCommand(new String[]{ PREFIX_NODE, file.getAbsolutePath() });
		} catch (IOException e) {
            log.warn(e.getMessage(), e);
		}

		return result.toString();
    }

    @Override
    public StringBuilder executeCommand(String[] command) throws IOException {
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
            log.warn(e.getMessage(), e);
        }
        process.destroy();
        return result;
    }
}
