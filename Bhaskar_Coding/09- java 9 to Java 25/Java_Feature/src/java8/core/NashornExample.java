package java8.core;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {
    public static void main() {
        // Create a Nashorn script engine
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        // JavaScript code as a string
        String script = "var greeting = 'Hello, Nashorn!'; greeting";

        // Execute the script
        try {
            Object result = engine.eval(script);
            System.out.println(result); // Output: Hello, Nashorn!
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
