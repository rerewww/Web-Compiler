package com.example.demo.service;

import com.example.demo.config.CompilerFactory;
import com.example.demo.process.CompileManager;
import com.example.demo.process.Compiler;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by son on 2019-01-11.
 */
@Service
public class ActService {
	CompilerFactory compilerFactory;
	CompileManager compileManager;

	@Autowired
	ActService(final CompilerFactory compilerFactory, final CompileManager compileManager) {
		this.compilerFactory = compilerFactory;
		this.compileManager = compileManager;
	}

	public String run(final String text, final String lang) {
		Compiler compiler = compilerFactory.getCompiler(lang);
		String uuid = UUID.randomUUID().toString();

		File parentFile = new File(String.format("C:\\tmp\\%s", uuid));
		parentFile.mkdirs();
		File srcFile = compiler.getSrcFile(parentFile, text);

		String result = compileManager.run(compiler, srcFile);
		try {
			FileUtils.forceDelete(srcFile.getParentFile());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
