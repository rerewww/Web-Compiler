package com.example.demo.config;

import com.example.demo.process.Compiler;
import com.example.demo.process.JavaCompiler;
import com.example.demo.process.JavascriptCompiler;
import com.example.demo.process.PythonCompiler;
import org.springframework.stereotype.Service;

/**
 * Created by son on 2019-01-11.
 */
@Service
public class CompilerFactory {

	public Compiler getCompiler(final String lang) {
		switch (lang) {
			case "java":
				return new JavaCompiler();
			case "python":
				return new PythonCompiler();
			case "javascript":
				return new JavascriptCompiler();
			default:
				throw new IllegalAccessError();
		}
	}
}
