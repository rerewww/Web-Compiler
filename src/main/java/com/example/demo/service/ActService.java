package com.example.demo.service;

import com.example.demo.config.CompilerFactory;
import com.example.demo.model.UserVO;
import com.example.demo.process.CompileManager;
import com.example.demo.process.Compiler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by son on 2019-01-11.
 */
@Slf4j
@Service
public class ActService {
	CompilerFactory compilerFactory;
	CompileManager compileManager;
    ClassLoader classLoader;

	@Value("${admin.user.id}")
	private String userId;

	@Autowired
	ActService(final CompilerFactory compilerFactory, final CompileManager compileManager) {
		this.compilerFactory = compilerFactory;
		this.compileManager = compileManager;
		classLoader = getClass().getClassLoader();
	}

	public boolean checkLogin() {
		return true;
	}

	public List<Boolean> run(final String text, final String lang, final int number) {
		Compiler compiler = compilerFactory.getCompiler(lang);
		String uuid = UUID.randomUUID().toString();

		File parentFile = new File(String.format("C:\\tmp\\%s", uuid));
		parentFile.mkdirs();

		File jsonFile = new File(classLoader.getResource("questions.json").getFile());

		String code = "";
		List<Boolean> results = new ArrayList<>();
		try {
			JSONArray jsonArray = new JSONArray(FileUtils.readFileToString(jsonFile, Charset.forName("utf-8")));
            JSONObject jsonObject = (JSONObject) jsonArray.get(number);
			JSONArray step = (JSONArray) jsonObject.get("step");

			for (int i = 0; i < step.length(); i++) {
				JSONObject item = (JSONObject) step.get(i);
				code = (String) jsonObject.get("code");
				code = code.replace("replace_parameter", (String)item.get("parameter"));
				code = code.replace("replace_code", text);

				File srcFile = compiler.getSrcFile(parentFile, code);
				String result = compileManager.run(compiler, srcFile);
                String answer = (String) item.get("answer");

                results.add(answer.equals(result));

				try {
					FileUtils.forceDelete(srcFile.getParentFile());
				} catch (IOException e) {
                    log.warn(e.getMessage(), e);
				}
			}

		} catch (IOException e) {
            log.warn(e.getMessage(), e);
		}

		return results;
	}

	public String getQuestionsJsonString() {
		File jsonFile = new File(classLoader.getResource("questions.json").getFile());
		String questions = "";
		try {
			questions = FileUtils.readFileToString(jsonFile, Charset.forName("utf-8"));
		} catch (IOException e) {
            log.warn(e.getMessage(), e);
		}

		return questions;
	}
}
