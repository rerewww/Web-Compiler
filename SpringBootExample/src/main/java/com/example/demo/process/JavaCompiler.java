package com.example.demo.process;

import org.apache.commons.io.FilenameUtils;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * Created by son on 2019-01-08.
 */
public class JavaCompiler implements Compiler {
    private static final String PREFIX_JAVA = "java";
    private static final String PREFIX_JAVAC = "javac";

    @Override
    public String compile(final File file) {
        try {
            // Make Class file
            this.executeCommand(new String[]{ PREFIX_JAVAC, file.getAbsolutePath() });
            // Run Class file
            if (new File(file.getAbsolutePath().replace("java", "class")).exists()) {
                System.out.println("클래스 파일을 만들었습니다. ");
            }

            System.out.println("클래스 파일 실행 중. . .");
            StringBuilder result = this.executeCommand(new String[]{ PREFIX_JAVA, FilenameUtils.getBaseName(file.getName())});

            if (StringUtils.isEmpty(result.toString())) {
                System.out.println("결과가 빈 값이거나 NULL입니다.");
                System.out.println("콘솔 스트림을 가져오지 못하는듯..");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "";
    }

    @Override
    public StringBuilder executeCommand(final String[] command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
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
        }
        process.destroy();
        return result;
    }
}
