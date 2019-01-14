package com.example.demo.process;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by son on 2019-01-11.
 */
public class PythonCompiler implements Compiler {
	private static final String PREFIX_PYTHON = "python";

	@Override
	public File getSrcFile(String text) {
		File srcFile = new File("C:\\tmp\\Test.py");
		try {
			FileUtils.writeStringToFile(srcFile, text, Charset.forName("utf-8"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return srcFile;
	}

	@Override
	public String compile(final File file) {
		StringBuilder result = new StringBuilder();
		try {
			// Make Class file
			result = this.executeCommand(new String[]{ PREFIX_PYTHON, file.getAbsolutePath() });
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
