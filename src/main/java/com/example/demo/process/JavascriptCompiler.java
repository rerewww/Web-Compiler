package com.example.demo.process;

import java.io.File;
import java.io.IOException;

/**
 * Created by son on 2019-01-17.
 */
public class JavascriptCompiler implements Compiler {
    private static final String PREFIX_NODE = "node";
    @Override
    public File getSrcFile(File file, String text) {
        File srcFile = new File(String.format("%s\\Test.js", parentFile.getAbsolutePath()));
        try {
            FileUtils.writeStringToFile(srcFile, text, Charset.forName("utf-8"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
			System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
        process.destroy();
        return result;
    }
}
