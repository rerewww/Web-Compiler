package com.example.demo.service;

import com.example.demo.config.CompilerFactory;
import com.example.demo.process.CompileManager;
import com.example.demo.process.Compiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

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
		File srcFile = compiler.getSrcFile(text);

		return compileManager.run(compiler, srcFile);
	}
}
