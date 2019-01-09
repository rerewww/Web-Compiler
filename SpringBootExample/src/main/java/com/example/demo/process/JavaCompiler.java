package com.example.demo.process;

import org.apache.commons.io.FilenameUtils;

import java.io.*;

/**
 * Created by son on 2019-01-08.
 */
public class JavaCompiler implements Compiler {
    private static final String PREFIX_JAVA = "java";
    private static final String PREFIX_JAVAC = "javac";
    private static final String PREFIX_JAVA_CLASS_PATH = "-cp";

    @Override
    public String compile(final File file) {
	    StringBuilder result = new StringBuilder();
        try {
            // Make Class file
            this.executeCommand(new String[]{ PREFIX_JAVAC, file.getAbsolutePath() });
            // Run Class file
            if (new File(file.getAbsolutePath().replace("java", "class")).exists()) {
                System.out.println("클래스 파일을 만들었습니다. ");
            }

            System.out.println("클래스 파일 실행 중. . .");
            result = this.executeCommand(new String[]{ PREFIX_JAVA, PREFIX_JAVA_CLASS_PATH,
                    file.getParent(), FilenameUtils.getBaseName(file.getName())});
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
        process.destroy();
        return result;
    }
}
