package com.nashorn;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Test1 {

	static String fun1(String name) {
		System.out.format("Hi there from Java, %s", name);
		return "greetings from java";
	}

	public static void main(String[] args) {

		try {

			ScriptEngine engine = new ScriptEngineManager()
					.getEngineByName("nashorn");
			engine.eval(new FileReader("src/script.js"));

			Invocable invocable = (Invocable) engine;

			Object result = invocable.invokeFunction("fun1", "Peter Parker");
			System.out.println(result);
			System.out.println(result.getClass());

			invocable.invokeFunction("fun2", new Date());
			// [object java.util.Date]

			invocable.invokeFunction("fun2", LocalDateTime.now());
			// [object java.time.LocalDateTime]

			invocable.invokeFunction("fun2", new Person("Nanda", 25));
			// [object com.winterbe.java8.Person]

		} catch (Exception e) {

		}

	}

}
