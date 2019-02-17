package com.example.demo.process;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by son on 2019-01-09.
 */
@Slf4j
public class JavaCompilerTest {
	JavaCompiler javaCompiler = new JavaCompiler();
	private static final String TEST_PREFIX_JAVA = "java";
	private static final String TEST_PREFIX_JAVA_CLASS_PATH = "-cp";

	@Test
	public void executeCommandTest() throws IOException {
		File file = new File("C:\\tmp\\Test.class");

		if (!file.exists()) {
			log.warn("클래스 파일이 존재하지 않습니다.");
			return;
		}

		StringBuilder result = javaCompiler.executeCommand(new String[]{TEST_PREFIX_JAVA, TEST_PREFIX_JAVA_CLASS_PATH,
				file.getParent(), FilenameUtils.getBaseName(file.getName()) });
	}
}
